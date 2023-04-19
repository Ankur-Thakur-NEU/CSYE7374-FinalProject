package edu.neu.csye7374.Strategy;

//20% discount
public class StudentDiscount implements DiscountAPI {
    double percentage=0.20;
    @Override
    public double calculatePrice(double price) {
        return price * (1-percentage);
    }
}
