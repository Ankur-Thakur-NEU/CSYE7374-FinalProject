package edu.neu.csye7374.StatePattern;

import edu.neu.csye7374.Strategy.*;

import java.util.HashMap;
import java.util.Map;

public class Pharmacy implements PharmacyStateAPI{
    @Override
    public void state_Open() {

    }

    @Override
    public void state_Close() {

    }

    @Override
    public void state_Stock() {

    }
    private static Map<DiscountStrategy, DiscountAPI> strategyAPIMap= new HashMap<>();
    {
        strategyAPIMap.put(DiscountStrategy.EMPLOYEE_DISCOUNT, new EmployeeDiscount());
        strategyAPIMap.put(DiscountStrategy.MEMBERSHIP_DISCOUNT, new MembershipDiscount());
        strategyAPIMap.put(DiscountStrategy.STUDENT_DISCOUNT, new StudentDiscount());
    }

    public static Map<DiscountStrategy, DiscountAPI> getStrategyAPIMap() {
        return strategyAPIMap;
    }
}
