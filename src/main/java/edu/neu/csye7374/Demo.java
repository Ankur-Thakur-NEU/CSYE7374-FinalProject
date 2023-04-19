package edu.neu.csye7374;

import edu.neu.csye7374.Command.Invoker;
import edu.neu.csye7374.Strategy.EmployeeDiscount;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(){

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
