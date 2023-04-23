package edu.neu.csye7374.Strategy;

//10% discount
public class MembershipDiscount implements DiscountAPI {
    double percentage=0.10;
    @Override
    public double calculatePrice(double price) {
        return price * (1-percentage);
    }
}
