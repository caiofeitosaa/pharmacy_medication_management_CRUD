package org.example.pharmacy_medication_management_crud.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.pharmacy_medication_management_crud.models.Medication;
import org.example.pharmacy_medication_management_crud.service.MedicationService;

import java.util.ArrayList;

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

        String nameTextFieldContent = nameTextField.getText(); // .getText method returns a String typed in the TextField node
        String quantityTextFieldContent =  quantityTextField.getText(); // Intenger.parseInt method transform a String into an int
        String batchTextFieldContent = batchTextField.getText();
        String unityPriceTextFieldContent = unityPriceTextField.getText();

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
                alert.setContentText("Medication Added successfully");
                alert.showAndWait();
            } // end of service calling else body
        } // end of else body
    } // end of add button method
} // end of class body