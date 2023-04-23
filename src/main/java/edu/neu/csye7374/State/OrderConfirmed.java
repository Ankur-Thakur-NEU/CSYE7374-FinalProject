package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.Order;

public class OrderConfirmed implements OrderStateAPI{
    private Order order;

    public OrderConfirmed(Order order) {
        this.order = order;
    }

    @Override
    public void orderConfirmed() {
        System.out.println("ERROR! Order is already in CONFIRMED state");
    }

    @Override
    public void orderDispatched() {

    }

    @Override
    public void orderDelivered() {

    }
}
