package edu.neu.csye7374;

import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Facade.PharmacyFacade;
import edu.neu.csye7374.Strategy.EmployeeDiscount;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(){

        Pharmacy pharmacy = new Pharmacy("My Pharmacy");
        // Add some medicines
        Medicine paracetamol = new MedicineBuilder(1, "Paracetamol",
                10.0, MedicineCategory.OverTheCounter, "ABC Pharma")
                .buildObject();
        Medicine amoxicillin = new MedicineBuilder(2,"Amoxicillin", 20.0,
                MedicineCategory.Prescription, "XYZ Pharma")
                .buildObject();
        pharmacy.itemList.add(paracetamol);
        pharmacy.itemList.add(amoxicillin);

        // Add some employees
        Pharmacist alice = new Pharmacist(1, 30, "Alice", "Smith", 5000.0);
        pharmacy.personList.add(alice);

        // Print out pharmacy details
        System.out.println("Pharmacy Name: " + pharmacy.name);
        System.out.println("Medicines:");
        for (Medicine medicine : pharmacy.itemList) {
            System.out.println(medicine.medicineName + " (" + medicine.medicineCategory + ")");
        }
        System.out.println("Employees:");
        for (Person person : pharmacy.personList) {
            if (person instanceof Pharmacist) {
                Pharmacist pharmacist = (Pharmacist) person;
                System.out.println(pharmacist.getFirstName() + " " + pharmacist.getLastName() + " (Pharmacist)");
            }
        }
        PharmacyFacade pharmacyFacade = new PharmacyFacade("My Pharmacy");
        MedicineBuilder medicineBuilder = new MedicineBuilder(1, "Paracetamol",
                10.0, MedicineCategory.OverTheCounter, "ABC Pharma");
        pharmacyFacade.addMedicine(medicineBuilder);

        MedicineBuilder medicineBuilder1 = new MedicineBuilder(2,"Amoxicillin", 20.0,
                MedicineCategory.Prescription, "XYZ Pharma");
        pharmacyFacade.addMedicine(medicineBuilder1);

        PharmacistBuilder pharmacistBuilder = new PharmacistBuilder(1, "John",
                "Doe", 25, 50000);
        pharmacyFacade.addPharmacist(pharmacistBuilder);

        PharmacistBuilder pharmacistBuilder1 = new PharmacistBuilder(2, "Alisha",
                "Mary>", 27, 100000);
        pharmacyFacade.addPharmacist(pharmacistBuilder1);
        pharmacyFacade.sortMedicines(pharmacyFacade.pharmacy);
        pharmacyFacade.sortEmployees();

        //142

        List<Medicine> medicinelist = new ArrayList<>();

        //Test for builder pattern - using factory and singleton

        //Test for prototype pattern

        //Test for adapter pattern

        //Test for facade pattern and decorator pattern

        //Test for command pattern
        //creating medicine list before testing
        Medicine ciplox = new Medicine();
        ciplox.setMedicineName("ciplox");
        ciplox.setMedicinePrice(11);

        Medicine aspirin = new Medicine();
        aspirin.setMedicineName("Aspirin");
        aspirin.setMedicinePrice(12);

        medicinelist.add(ciplox);
        medicinelist.add(aspirin);
        Invoker invoker = new Invoker();
        invoker.placeOrder(medicinelist);
        invoker.subscribeOrder(medicinelist);


//        MedicineStore cvs = new MedicineStore("CVS");
//        EmployeeBuilder emploee = new EmployeeBuilder(vals);

        //Test for State Pattern

        //Test for Strategy Pattern


    }
}
