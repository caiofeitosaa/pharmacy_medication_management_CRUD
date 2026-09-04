package org.example.pharmacy_medication_management_crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CrudApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CrudApplication.class.getResource("/org/example/pharmacy_medication_management_crud/view/crud-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Medication Management");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}