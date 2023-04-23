package edu.neu.csye7374.Strategy;

@FunctionalInterface
public interface DiscountAPI {
    public double calculatePrice(double price);
}
