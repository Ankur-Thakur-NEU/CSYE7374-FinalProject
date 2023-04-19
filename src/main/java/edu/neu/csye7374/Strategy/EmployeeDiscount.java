package edu.neu.csye7374.Strategy;
//15% discount
public class EmployeeDiscount implements DiscountAPI {
    double percentage=0.15;
    @Override
    public double calculatePrice(double price) {
        return price * (1-percentage);
    }

}
