package edu.neu.csye7374;

import edu.neu.csye7374.Bridge.BrandedMedicineDispenser;
import edu.neu.csye7374.Bridge.GenericMedicineDispenser;
import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Facade.PharmacyFacade;
import edu.neu.csye7374.Observer.Order;
import edu.neu.csye7374.Strategy.DiscountAPI;
import edu.neu.csye7374.Strategy.DiscountStrategy;
import edu.neu.csye7374.Strategy.EmployeeDiscount;


import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(){
        //Builder design pattern for medicines
        System.out.println("******************* Builder design pattern******************* ");
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
        Pharmacist pharmacist1 = new PharmacistBuilder(1,  "Alice", "Smith",30, 5000.0);
        pharmacy.personList.add(pharmacist1);

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
        //Facade design pattern
        System.out.println("******************* Facade design pattern******************* ");
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
                "Mary", 27, 100000);
        pharmacyFacade.addPharmacist(pharmacistBuilder1);
        //Sorting the added medicines and employees
        pharmacyFacade.sortMedicines(pharmacyFacade.pharmacy);
        pharmacyFacade.sortEmployees();

        //Bridge design pattern
        System.out.println("******************* Bridge design pattern******************* ");
        Medicine paracetamol1 = new MedicineBuilder(1, "Paracetamol",
                10.0, MedicineCategory.OverTheCounter, "ABC Pharma")
                .buildObject();
        Medicine amoxicillin1 = new MedicineBuilder(2,"Amoxicillin", 20.0,
                MedicineCategory.Prescription, "XYZ Pharma")
                .buildObject();
        Pharmacist pharmacist = new Pharmacist();
        MedicalService brandedDispenser = new BrandedMedicineDispenser(paracetamol1, pharmacist);
        brandedDispenser.dispenseMedicine();
        MedicalService genericDispenser = new GenericMedicineDispenser(amoxicillin1, pharmacist);
        genericDispenser.dispenseMedicine();




        List<Medicine> medicinelist = new ArrayList<>();

        //Test for builder pattern - using factory and singleton

        //Test for prototype pattern

        //Test for adapter pattern

        //Test for facade pattern and decorator pattern

        //Test for command pattern
        System.out.println("******************* Command Design Pattern *******************");
        //creating medicine list before testing
        System.out.println("******Command design pattern********");
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


        Pharmacy cvs = new Pharmacy("CVS");

//        EmployeeBuilder emploee = new EmployeeBuilder(vals);

        //Test for State Pattern
        System.out.println("******************* State Design Pattern *******************");
        //Dummy order
        Order order = new Order();
        order.orderConfirmed();
        order.orderDelivered();
        order.orderDispatched();
        order.orderDelivered();
        order.closeOrder();


        //Test for Strategy Pattern
        System.out.println("******************* Strategy Design Pattern *******************");

        System.out.println("Medicine \""+ciplox.getMedicineName()+"\" price before discount "+ciplox.getMedicinePrice());
        double price =0;
        for(DiscountStrategy strategy : Pharmacy.getStrategyAPIMap().keySet()){
            cvs.setStrategy(strategy);
            price= ((Medicine)ciplox).runStrategy();
            System.out.println("Price of \""+ciplox.getMedicineName()+"\" after "+strategy+" :"+price);
        }

    }
}
