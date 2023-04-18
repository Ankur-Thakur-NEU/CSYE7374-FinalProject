package edu.neu.csye7374;

import edu.neu.csye7374.StatePattern.PharmacyStateAPI;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy implements PharmacyStateAPI {

    private String name;
    private List<Medicine> itemList = new ArrayList<>();
    private List<Person> personList = new ArrayList<>();
//    public static DiscountStrategy usingStrategy = DiscountStrategy.NONE;
//    private static final String FILE_NAME = "edu/neu/csye7374/src/inputData/BookDetails.txt";

//    private PharmacyStateAPI openState = new OpenState(this);
//    private PharmacyStateAPI stockState = new StockState(this);
//    private PharmacyStateAPI closeState = new CloseState(this);
    private PharmacyStateAPI state;

//    private static Map<DiscountStrategy,DiscountStrategyAPI> algorithmMap = new HashMap<>();
//    {
////    	algorithmMap.put(DiscountStrategy.NONE, null);
//        algorithmMap.put(DiscountStrategy.StudentDiscount, new StudentDiscount());
//        algorithmMap.put(DiscountStrategy.EmployeeDiscount, new EmployeeDiscount());
//    }
//
    public Pharmacy(String name) {
        super();
        this.name = name;
        //this.state = getOpenState();
    }



    @Override
    public void state_Open() {

    }

    @Override
    public void state_Close() {

    }

    @Override
    public void state_Stock() {

    }
}
