package edu.neu.csye7374.Observer;

import edu.neu.csye7374.State.*;

public class Order implements OrderStateAPI {
    private OrderStateAPI state;
    private OrderStateAPI startOrder= new StartOrder(this);
    private OrderStateAPI orderConfirmed = new OrderConfirmed(this);
    private OrderStateAPI orderDispatched = new OrderDispatched(this);
    private OrderStateAPI orderDelivered = new OrderDelivered(this);
    private OrderStateAPI closeOrder = new CloseOrder(this);

    public Order() {
        super();
        this.state = getStartOrder();
    }


    @Override
    public void orderConfirmed() {
        this.state.orderConfirmed();
    }

    @Override
    public void orderDispatched() {
        this.state.orderDispatched();
    }

    @Override
    public void orderDelivered() {
        this.state.orderDelivered();
    }

    @Override
    public void closeOrder() {
        this.state.closeOrder();
    }

    public OrderStateAPI getState() {
        return state;
    }

    public void setState(OrderStateAPI state) {
        this.state = state;
    }

    public OrderStateAPI getStartOrder() {
        return startOrder;
    }

    public void setStartOrder(OrderStateAPI startOrder) {
        this.startOrder = startOrder;
    }

    public OrderStateAPI getOrderConfirmed() {
        return orderConfirmed;
    }

    public void setOrderConfirmed(OrderStateAPI orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    public OrderStateAPI getOrderDispatched() {
        return orderDispatched;
    }

    public void setOrderDispatched(OrderStateAPI orderDispatched) {
        this.orderDispatched = orderDispatched;
    }

    public OrderStateAPI getOrderDelivered() {
        return orderDelivered;
    }

    public void setOrderDelivered(OrderStateAPI orderDelivered) {
        this.orderDelivered = orderDelivered;
    }

    public OrderStateAPI getCloseOrder() {
        return closeOrder;
    }

    public void setCloseOrder(OrderStateAPI closeOrder) {
        this.closeOrder = closeOrder;
    }
}
