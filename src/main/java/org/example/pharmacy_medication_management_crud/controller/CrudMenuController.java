package org.example.pharmacy_medication_management_crud.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CrudMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
