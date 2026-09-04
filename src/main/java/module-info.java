module org.example.pharmacy_medication_management_crud {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;


    opens org.example.pharmacy_medication_management_crud to javafx.fxml;
    exports org.example.pharmacy_medication_management_crud;
}