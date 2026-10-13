package org.example.pharmacy_medication_management_crud.service;

import org.example.pharmacy_medication_management_crud.entities.Medication;
import org.example.pharmacy_medication_management_crud.repository.DataBaseConnection;
import org.example.pharmacy_medication_management_crud.repository.MedicationRepository;
import java.util.List;

public class MedicationService {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    MedicationRepository medicationRepository = new MedicationRepository(dataBaseConnection);

    public void saveMethod (String name, Integer quantity, String batch, Double unityPrice) {
        Medication medication = new Medication(name, quantity, batch, unityPrice);
        medicationRepository.save(medication);
    } // end of save method body

    public void deleteMethod (Long id) {
        medicationRepository.delete(id);
    } // end of delete method body

    public void updateMethod (String name, int quantity, String batch, Double unityPrice, Long id) {
        medicationRepository.update(name, quantity, batch, unityPrice, id);
    } // end of update method body

    public int searchQuantity (String name, String batch) {
        return medicationRepository.searchQuantity(name, batch);
    } // end of search quantity body

    public Long searchId (String name, String batch) {
        return medicationRepository.searchId(name, batch);
    } // end of search id body

    public List<Medication> searchMethod (String name, String batch) {
        return medicationRepository.search(name, batch);
    } // end of search method body

    public List<Medication> listAllMethod () {
        return medicationRepository.findAll();
    } // end of list all method body
}
