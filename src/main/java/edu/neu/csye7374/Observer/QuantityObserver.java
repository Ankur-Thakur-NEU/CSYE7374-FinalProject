package edu.neu.csye7374.Observer;

public class QuantityObserver {
    public void updated(Order order) {
        if(order.getDeliveryType()==DeliveryType.Delivery) {
            int count=order.getCount();
            double total = order.getCount();
            if(count<=5) {
                order.setShippingCost(10);
            }else  {
                order.setShippingCost(10 + (count-5)*1.5);
            }
        }
    }
}
