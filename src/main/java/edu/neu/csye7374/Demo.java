package edu.neu.csye7374;

import edu.neu.csye7374.Adapter.Manufacturer;
import edu.neu.csye7374.Adapter.ManufacturerObjectAdapter;
import edu.neu.csye7374.Bridge.BrandedMedicineDispenser;
import edu.neu.csye7374.Bridge.GenericMedicineDispenser;
import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Decorator.GiftcardDecorator;
import edu.neu.csye7374.Decorator.HealthKitDecorator;
import edu.neu.csye7374.Facade.DeliveryType;
import edu.neu.csye7374.Facade.PharmacyFacade;
import edu.neu.csye7374.Factory.MedicineFactory;
import edu.neu.csye7374.Observer.Order;
import edu.neu.csye7374.Prototype.HomeStoreDelivery;
import edu.neu.csye7374.Prototype.StoreDeliveryType;
import edu.neu.csye7374.Prototype.StorePickUp;
import edu.neu.csye7374.Strategy.DiscountStrategy;


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

        System.out.println("******************* Decorator Design Pattern *******************");

        // Decortor Design Pattern
        MedicineAPI decoratorMedicine=  new Medicine(101, "Aspirin", 150.0, "Bayer", MedicineCategory.OverTheCounter);
        decoratorMedicine= new GiftcardDecorator(decoratorMedicine);
        System.out.println("Gift card has been added :\n"+decoratorMedicine.medicineDescription());
        decoratorMedicine= new HealthKitDecorator(decoratorMedicine);
        System.out.println("Health Kit has been added:"+decoratorMedicine.medicineDescription());

        //Test for builder pattern - using factory and singleton

        //Test for prototype pattern
        System.out.println("******************* Prototype Design Pattern *******************");
        HomeStoreDelivery homeDelivery = new HomeStoreDelivery(1, "Home Delivery", 10.0);
        System.out.println(homeDelivery.toString());
        HomeStoreDelivery homeDelivery2 = homeDelivery.clone();
        homeDelivery2.setDeliveryType("Home Delivery 2");
        homeDelivery2.setDeliveryCost(40.0);
        System.out.println(homeDelivery2.toString());

        StorePickUp storePickUp = new StorePickUp(1, "Store Pick Up", 0.0);
        System.out.println(storePickUp.toString());
        StorePickUp storePickUp2 = storePickUp.clone();
        storePickUp2.setDeliveryType("Store Pickup 2");
        storePickUp2.setDeliveryCost(0.0);
        System.out.println(storePickUp2.toString());

        //Test for adapter pattern
        System.out.println("******************* Adapter Design Pattern *******************");
        MedicineBuilder medicineBuilder2 = new MedicineBuilder(1, "Dolo", 10, MedicineCategory.OverTheCounter, "abc labs");
        MedicineAPI medicine= MedicineFactory.getInstance().getObject(medicineBuilder2);
        System.out.println(medicine);
        Manufacturer manufacturer = Manufacturer.getInstance().clone();
        manufacturer.setManufacturerName("abc labs")
                .setYearsOfManufacturing(52)
                .setProductsManufactured(10);
        ManufacturerObjectAdapter manufacturerAdapter = new ManufacturerObjectAdapter(manufacturer,medicine);

        System.out.println(medicine);
        System.out.println("*Demonstrating of Adapter pattern to adapt manufacturer legacy class with Medicine Interface and printing their object*");

        System.out.println(manufacturerAdapter);
        System.out.println("***************************************************************************************");

// test observer
        System.out.println("******************* Observer Design Pattern *******************");
        MedicineBuilder medicineBuilder_1 = new MedicineBuilder(1, "Aspirin", 150.0, MedicineCategory.OverTheCounter,"Bayer");
        MedicineAPI medicine1= MedicineFactory.getInstance().getObject(medicineBuilder_1);
        MedicineBuilder medicineBuilder_2  = new MedicineBuilder(2, "Tylenol", 200.0, MedicineCategory.OverTheCounter, "Johnson & Johnson");
        MedicineAPI medicine2= MedicineFactory.getInstance().getObject(medicineBuilder_2);
        MedicineBuilder medicineBuilder_3  = new MedicineBuilder(3, "Advil", 1800.0, MedicineCategory.OverTheCounter, "Pfizer");
        MedicineAPI medicine3= MedicineFactory.getInstance().getObject(medicineBuilder_3);

        // Create a new Order
        Order order = new Order();
        order.setDeliveryType(DeliveryType.Delivery);

        // Add Medicine to the Order
        System.out.println("Adding Medicine1 to the order...");
        order.addMedicine((Medicine)medicine1);
        System.out.println("Order cost: " + order.getOrderCost());
        System.out.println("Order quantity: " + order.getCount());
        System.out.println("Order shipping cost: " + order.getShippingCost());
        System.out.println("Order discount: " + order.getDiscount());
        System.out.println("Order total: " + order.getTotal());

        // Add Medicine2 to the Order
        System.out.println("\nAdding Medicine2 to the order...");
        order.addMedicine((Medicine)medicine2);
        System.out.println("Order cost: " + order.getOrderCost());
        System.out.println("Order quantity: " + order.getCount());
        System.out.println("Order shipping cost: " + order.getShippingCost());
        System.out.println("Order discount: " + order.getDiscount());
        System.out.println("Order total: " + order.getTotal());

        // Add Medicine3 to the Order
        System.out.println("\nAdding Medicine3 to the order...");
        order.addMedicine((Medicine)medicine3);
        System.out.println("Order cost: " + order.getOrderCost());
        System.out.println("Order quantity: " + order.getCount());
        System.out.println("Order shipping cost: " + order.getShippingCost());
        System.out.println("Order discount: " + order.getDiscount());
        System.out.println("Order total: " + order.getTotal());

        System.out.println("*************observer demo  end***************************************");
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
        Order orderForState = new Order();
        orderForState.orderConfirmed();
        orderForState.orderDelivered();
        orderForState.orderDispatched();
        orderForState.orderDelivered();
        orderForState.closeOrder();


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
