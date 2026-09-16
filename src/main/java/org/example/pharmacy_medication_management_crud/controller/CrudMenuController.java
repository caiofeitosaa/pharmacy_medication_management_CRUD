package org.example.pharmacy_medication_management_crud.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.pharmacy_medication_management_crud.models.Medication;
import org.example.pharmacy_medication_management_crud.service.MedicationService;

import java.util.List;

public class CrudMenuController {

    MedicationService medicationService = new MedicationService();

    // text field variables
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField batchTextField;
    @FXML
    private TextField unityPriceTextField;
    @FXML
    private TextField idTextField;

    // alert class is used to create a popup alert message
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private TableView<Medication> medicationTable;
    @FXML
    private TableColumn<Medication, Long> idCollumn; // <Type of the received object, Type of that object is gonna show>
    @FXML
    private TableColumn<Medication, String> nameCollumn;
    @FXML
    private TableColumn<Medication, Integer> quantityColumn;
    @FXML
    private TableColumn<Medication, String> batchColumn;
    @FXML
    private TableColumn<Medication, Double> priceColumn;

    // WORKING
    @FXML
    public void addButtonMenu (ActionEvent event) { // ActionEvent is a java interface that deals with random events on Scene Builder

        String nameTextFieldContent = nameTextField.getText().trim(); // .getText method returns a String typed in the TextField node
        String quantityTextFieldContent =  quantityTextField.getText().trim(); // Intenger.parseInt method transform a String into an int
        String batchTextFieldContent = batchTextField.getText().trim();
        String unityPriceTextFieldContent = unityPriceTextField.getText().trim();

        if (nameTextFieldContent.isEmpty()) {
            alert.setTitle("Invalid Name");
            alert.setHeaderText(null); // makes the Header Text not appear
            alert.setContentText("Please enter a valid name.");
            alert.showAndWait();
        } // end of name alert if body

        else if (quantityTextFieldContent.isEmpty()) {
            alert.setTitle("Invalid Quantity");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid quantity.");
            alert.showAndWait();
        } // end of quantity alert else if body

        else if (batchTextFieldContent.isEmpty()) {
            alert.setTitle("Invalid Batch");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid batch.");
            alert.showAndWait();
        } // end of batch alert else if body

        else if (unityPriceTextFieldContent.isEmpty()) {
            alert.setTitle("Invalid Price");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid price.");
            alert.showAndWait();
        } // end of price alert else if body

        else { // only happens if none of the options is empty

            int quantity = Integer.parseInt(quantityTextFieldContent); // Intenger.parseInt method transform a String into an int
            double unityPrice = Double.parseDouble(unityPriceTextFieldContent); // Double.parseDouble method transform a String into a double

            if (quantity <= 0) {
                alert.setTitle("Invalid Quantity");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid quantity.");
                alert.showAndWait();
            } // end of second if for quantity

            else if (unityPrice <= 0) {
                alert.setTitle("Invalid Price");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid price.");
                alert.showAndWait();
            } // end of second else if for price

            else {
                medicationService.saveMethod(nameTextFieldContent, quantity, batchTextFieldContent, unityPrice);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Medication added successfully.");
                alert.showAndWait();
            } // end of service calling else body
        } // end of else body
    } // end of add button method

    public void deleteButtonMenu () {
        String idTextFieldContent = idTextField.getText().trim();

        if (idTextFieldContent.isEmpty() || idTextFieldContent == null) {
            alert.setTitle("Invalid ID");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid ID.");
            alert.showAndWait();
        } // end of if body

        else {
            try {
                Long idTextFieldContentInt = Long.parseLong(idTextFieldContent);
                medicationService.deleteMethod(idTextFieldContentInt);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Medication deleted successfully.");
                alert.showAndWait();
            } // end of try body

            catch (NumberFormatException e) {
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("Please enter only numbers for ID.");
                alert.showAndWait();
            } // end of catch body
        } // end of else body
    } // end of delete button method

    @FXML
    public void searchButtonMenu () {
        String nameTextFieldContent = nameTextField.getText();
        String batchTextFieldContent = batchTextField.getText();

        if (nameTextFieldContent == null) {
            nameTextFieldContent = "";
        } // end of if body

        if (batchTextFieldContent == null) {
            batchTextFieldContent = "";
        } // end of if body

        nameTextFieldContent = nameTextFieldContent.trim(); // to make sure theres no space in the empty string
        batchTextFieldContent = batchTextFieldContent.trim();

        if (nameTextFieldContent.isEmpty() && batchTextFieldContent.isEmpty()) {
            alert.setTitle("Invalid Name and Batch");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid name or a valid batch");
            alert.showAndWait();
        } // end of if body

        else {
            List<Medication> medication = medicationService.searchMethod(nameTextFieldContent, batchTextFieldContent);
            ObservableList<Medication> data = FXCollections.observableArrayList(medication);
            medicationTable.setItems(data);
        } // end of else body
    } // end of search button method

    // LIST ALL BUTTON AND BASE TABLEVIEW
    // WORKING
    @FXML
    public void reloadButtonMenu () {
        List<Medication> medications = medicationService.listAllMethod();
        ObservableList<Medication> data = FXCollections.observableArrayList(medications); // allow us to see changes in the database

        medicationTable.setItems(data); // adds the data to the tableview
    } // end of loadMedications body

    // WORKING
    @FXML
    public void initialize () {
        idCollumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId())); // set each column value using CellDataFeatures and Lambda Expressions.

        nameCollumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

        quantityColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getQuantity()));

        batchColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBatch()));

        priceColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getUnityPrice()));

        reloadButtonMenu(); // calls the loadMedication method to show the added data
    } // end of init body

    // WORKING
    @FXML
    public void clearButtonMenu (ActionEvent event) {
        nameTextField.setText(null);
        quantityTextField.setText(null);
        batchTextField.setText(null);
        unityPriceTextField.setText(null);
        idTextField.setText(null);
    } // end of clear button method
} // end of class body