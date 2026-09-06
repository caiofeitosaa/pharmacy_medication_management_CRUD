package org.example.pharmacy_medication_management_crud;

import javafx.application.Application;
import org.example.pharmacy_medication_management_crud.controller.MedicationController;

import java.util.Locale;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        // Application.launch(CrudApplication.class, args);
        Locale.setDefault(Locale.US);
        Scanner scannerChoice = new Scanner(System.in);
        MedicationController medicationController = new MedicationController();

        int choice = 0;
        while (choice != 5) {
            System.out.println("=========================");
            System.out.println("1 - Save Medication");
            System.out.println("2 - Delete Medication");
            System.out.println("3 - Search Medication");
            System.out.println("4 - List All Medication");
            System.out.println("5 - QUIT");
            System.out.println("========================");
            choice = scannerChoice.nextInt();

            if (choice == 1) {
                medicationController.testSaveMethod();
            }

            if (choice == 2) {
                medicationController.testDeleteMethod();
            }

            if (choice == 3) {
                medicationController.testSearchMethod();
            }

            if (choice == 4) {
                medicationController.testListAllMethod();
            }
        } // end of while structure
    } // end of main structure
} // end of class structure