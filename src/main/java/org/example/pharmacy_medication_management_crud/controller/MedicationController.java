package org.example.pharmacy_medication_management_crud.controller;

import org.example.pharmacy_medication_management_crud.models.Medication;
import org.example.pharmacy_medication_management_crud.repository.DataBaseConnection;
import org.example.pharmacy_medication_management_crud.repository.MedicationRepository;
import java.util.Scanner;

public class MedicationController {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    MedicationRepository medicationRepository = new MedicationRepository(dataBaseConnection);

    Scanner sc = new Scanner(System.in);

    public void testSaveMethod () {
        System.out.print("Enter the name of your Medication: ");
        String name = sc.nextLine();

        System.out.print("\nEnter the quantity of your Medication: ");
        int quantity = sc.nextInt();

        System.out.print("\nEnter the batch number of your Medication: ");
        int batch = sc.nextInt();

        System.out.print("\nEnter the unity price of your Medication: ");
        double unityPrice = sc.nextDouble();

        sc.nextLine();

        Medication medication = new Medication(name, quantity, batch, unityPrice);
        medicationRepository.save(medication);
    } // end of save method body

    public void testDeleteMethod () {
        System.out.print("Enter the id of the Medication you want to delete: ");
        Long id = sc.nextLong();
        sc.nextLine();
        medicationRepository.delete(id);
    } // end of delete method body

    public void testSearchMethod () {
        System.out.print("Enter the name of the Medication you want to search: ");
        String name = sc.nextLine();
        medicationRepository.search(name);
    } // end of search method body

    public void testListAllMethod () {
        medicationRepository.findAll();
    }
}
