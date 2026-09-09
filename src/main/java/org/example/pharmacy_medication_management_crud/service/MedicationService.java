package org.example.pharmacy_medication_management_crud.service;

import org.example.pharmacy_medication_management_crud.models.Medication;
import org.example.pharmacy_medication_management_crud.repository.DataBaseConnection;
import org.example.pharmacy_medication_management_crud.repository.MedicationRepository;

import java.util.Scanner;

public class MedicationService {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    MedicationRepository medicationRepository = new MedicationRepository(dataBaseConnection);

    Scanner sc = new Scanner(System.in);

    public void saveMethod (String name, Integer quantity, String batch, Double unityPrice) {
        Medication medication = new Medication(name, quantity, batch, unityPrice);
        medicationRepository.save(medication);
    } // end of save method body

    public void testDeleteMethod () {
        System.out.print("Enter the id of the Medication you want to delete: ");
        Long id = sc.nextLong();
        sc.nextLine();
        medicationRepository.delete(id);
    } // end of delete method body

    public void testUpdateMethod () {
        System.out.print("Enter the id of the Medication you want to update: ");
        Long id = sc.nextLong();
        sc.nextLine();
        System.out.print("Enter the new name for the Medication: ");
        String name = sc.nextLine();
        System.out.print("Enter the new quantity for the Medication: ");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the new batch for the Medication: ");
        int batch = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the new unity price for the Medication: ");
        double unityPrice = sc.nextDouble();
        sc.nextLine();

        medicationRepository.update(name, quantity, batch, unityPrice, id);
    }

    public void testSearchMethod () {
        System.out.print("Enter the name of the Medication you want to search: ");
        String name = sc.nextLine();
        medicationRepository.search(name);
    } // end of search method body

    public void testListAllMethod () {
        medicationRepository.findAll();
    }
}
