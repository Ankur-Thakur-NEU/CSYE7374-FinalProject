package edu.neu.csye7374.Prototype;

public class HomeStoreDelivery extends StoreDeliveryType {

    public HomeStoreDelivery(int deliveryId, String deliveryType, double deliveryCost) {
        super(deliveryId, deliveryType, deliveryCost);
        // TODO Auto-generated constructor stub
    }

    @Override
    public HomeStoreDelivery clone() {
        return new HomeStoreDelivery(this.getDeliveryId(), this.getDeliveryType(), this.getDeliveryCost());
    }

    @Override
    String delivertDescription() {
        // TODO Auto-generated method stub
        return "Your order will be delivered to home";
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Delivery Type: ")
                .append(getDeliveryType()).append("\t Delivery Cost: ")
                .append(getDeliveryCost()).toString();
    }
}
