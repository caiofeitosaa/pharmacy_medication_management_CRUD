package org.example.pharmacy_medication_management_crud.repository;

import org.example.pharmacy_medication_management_crud.models.Medication;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MedicationRepository {
    private DataBaseConnection dataBaseConnection; // for dependency injection

    public MedicationRepository (DataBaseConnection dataBaseConnection) { // dependency injection
        this.dataBaseConnection = dataBaseConnection;
    } // end of constructor

    PreparedStatement statement = null; //  prepared statement for using it to apply the sql

    Medication medication;

    public void save (Medication medication) {

       String saveStatement = "INSERT INTO medication (name, quantity, batch, unityPrice) " + "VALUES ( ?, ?, ?, ?);";

       try {
           statement = dataBaseConnection.connect().prepareStatement(saveStatement);
           statement.setString(1, medication.getName()); // each index is correponding to the "?"
           statement.setInt(2, medication.getQuantity());
           statement.setInt(3, medication.getBatch());
           statement.setDouble(4, medication.getUnityPrice());
           statement.executeUpdate(); // for INSERT, DELETE, UPDATE use executeUpdate(), but for SELECT methods use executeQuery(), because SELECT returns data.
       } // end of try structure

       catch (SQLException error) {
           throw new RuntimeException("Error in saving medication.", error);
       } // end of catch structure
    } // end of save method

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

    public void update (String newName, int newQuantity, int newBatch, double newPrice) {

        String updateStatement = "UPDATE medication SET name = ?, quantity = ?, batch = ?, unityPrice = ? " + "WHERE id = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(updateStatement);
            statement.setString(1, newName);
            statement.setInt(2, newQuantity);
            statement.setInt(3, newBatch);
            statement.setDouble(4, newPrice);
            statement.setLong(5, medication.getId());
            statement.executeUpdate();
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in updating medication.", error);
        } // end of catch structure
    } // end of update method

    // receive medication or id for argument?
    public void search (Long id) {

        String searchStatement = "SELECT * FROM medication " + "WHERE id = ?;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(searchStatement);
            statement.setLong(1, id);
            statement.executeQuery();
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in searching for medication.", error);
        } // end of catch structure
    }

    // list all method is void for now, but it needs to return a Medication list
    public void findAll () {

        String findAllStatement = "SELECT * FROM medication;";

        try {
            statement = dataBaseConnection.connect().prepareStatement(findAllStatement);
            statement.executeQuery();
        } // end of try structure

        catch (SQLException error) {
            throw new RuntimeException("Error in searching for all medications.", error);
        } // end of catch structure
    } // end of listAll method
} // end of class structure