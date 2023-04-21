package edu.neu.csye7374.Facade;

import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.Person;
import edu.neu.csye7374.Pharmacist;
import edu.neu.csye7374.Pharmacy;

public class PharmacyFacade {
    public Pharmacy pharmacy;

    public PharmacyFacade(String name) {
        pharmacy = new Pharmacy(name);
    }
    public void addMedicine(MedicineBuilder medicineBuilder) {
        Medicine medicine = new Medicine(medicineBuilder);
        pharmacy.itemList.add(medicine);
    }

    public void addPharmacist(PharmacistBuilder pharmacistBuilder) {
        Person person = new Pharmacist(pharmacistBuilder);
        pharmacy.personList.add(person);
    }
    public void sortMedicines(Pharmacy pharmacy) {
        pharmacy.sortMedicines();
    }

    public void sortEmployees() {
        pharmacy.sortEmployees();
    }
}
