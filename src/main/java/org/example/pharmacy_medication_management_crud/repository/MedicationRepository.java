package org.example.pharmacy_medication_management_crud.repository;

import org.example.pharmacy_medication_management_crud.models.Medication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicationRepository {

    private final DataBaseConnection dataBaseConnection; // for dependency injection

    public MedicationRepository (DataBaseConnection dataBaseConnection) { // dependency injection, so the repository NEEDS DbConnection to exist
        this.dataBaseConnection = dataBaseConnection;
    } // end of constructor

    PreparedStatement statement = null; //  PreparedStatement interface is used for applying SQL instructions
    ResultSet resultSet = null; // ResultSet interface is used to manipulate acquired DATA after SQL instructions
    ResultSetMetaData metaData = null; // ResultSetMetaData interface is used to get information DATA and COLUMNS acquired in resultSet


    // WORKING FINE
    public void save (Medication medication) {

       String saveStatement = "INSERT INTO medication (name, quantity, batch, unityPrice) " + "VALUES ( ?, ?, ?, ?);"; // remember the space between the Strings

       try {
           statement = dataBaseConnection.connect().prepareStatement(saveStatement);
           statement.setString(1, medication.getName()); // each index is corresponding to the "?"
           statement.setInt(2, medication.getQuantity());
           statement.setString(3, medication.getBatch());
           statement.setDouble(4, medication.getUnityPrice());
           statement.executeUpdate(); // for INSERT, DELETE, UPDATE use executeUpdate(), but for SELECT methods use executeQuery(), because SELECT returns data.
       } // end of try structure

       catch (SQLException error) {
           throw new RuntimeException("Error in saving medication.", error);
       } // end of catch structure
    } // end of save method

    // WORKING FINE
    public void delete (Long id) {

        String deleteStatement = "DELETE FROM medication WHERE id = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(deleteStatement);
            statement.setLong(1, id);
            statement.executeUpdate();
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in deleting medication.", error);
        } // end of catch structure
    } // end of delete method


    public void update (String newName, int newQuantity, String newBatch, double newPrice, Long id) {

        String updateStatement = "UPDATE medication SET name = ?, quantity = ?, batch = ?, unityPrice = ? " + "WHERE id = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(updateStatement);
            statement.setString(1, newName);
            statement.setInt(2, newQuantity);
            statement.setString(3, newBatch);
            statement.setDouble(4, newPrice);
            statement.setLong(5, id);
            int rowsUpdated = statement.executeUpdate(); // executeUpdate returns an Int for the number of Lines updated so:

            if (rowsUpdated == 0) {
                System.out.println("Error in finding medication.");
            } // end of if structure
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in updating medication.", error);
        } // end of catch structure
    } // end of update method

    public int searchQuantity (String name, String batch) {

        String searchQuantityStatement = "SELECT quantity FROM medication " + "WHERE name = ? OR batch = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(searchQuantityStatement);
            statement.setString(1, name);
            statement.setString(2, batch);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("quantity");
            } // end of if body

            return 0;
        } // end of try body

        catch (Exception e) {
            throw new RuntimeException("Error in searching quantity.", e);
        } // end of catch body
    } // end of search quantity method

    public Long searchId (String name, String batch) {

        String searchQuantityStatement = "SELECT id FROM medication " + "WHERE name = ? OR batch = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(searchQuantityStatement);
            statement.setString(1, name);
            statement.setString(2, batch);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getLong("id");
            } // end of if body

            return 0L; // long
        } // end of try body

        catch (Exception e) {
            throw new RuntimeException("Error in searching ID.", e);
        } // end of catch body
    } // end of search id method

    // WORKING FINE
    public ArrayList<Medication> search (String name, String batch) {

        String searchStatement = "SELECT * FROM medication " + "WHERE name = ? OR batch = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(searchStatement);
            statement.setString(1, name);
            statement.setString(2, batch);
            resultSet = statement.executeQuery(); // executeQuery returns DATA so i need to store it in a variable of ResultSet Type
            metaData = resultSet.getMetaData(); // metaData gets the DATA acquired from resultSet

            ArrayList<Medication> medications = new ArrayList<>();

            while (resultSet.next()) {
                Medication medication = new Medication();
                medication.setId(resultSet.getLong("id"));
                medication.setName(resultSet.getString("name"));
                medication.setQuantity(resultSet.getInt("quantity"));
                medication.setBatch(resultSet.getString("batch"));
                medication.setUnityPrice(resultSet.getDouble("unityPrice"));

                medications.add(medication);
            } // end of while structure
            return medications;
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in searching for medication.", error);
        } // end of catch structure
    } // end of search method

    // WORKING FINE
    public List<Medication> findAll () {

        String findAllStatement = "SELECT * FROM medication;";
        ArrayList<Medication> medications = new ArrayList<>();
        try {
            statement = dataBaseConnection.connect().prepareStatement(findAllStatement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Medication medication = new Medication();

                medication.setId(resultSet.getLong("id"));
                medication.setName(resultSet.getString("name"));
                medication.setQuantity(resultSet.getInt("quantity"));
                medication.setBatch(resultSet.getString("batch"));
                medication.setUnityPrice(resultSet.getDouble("unityPrice"));

                medications.add(medication);
            }
            return medications;
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in searching for all medications.", error);
        } // end of catch structure
    } // end of listAll method
} // end of class structure