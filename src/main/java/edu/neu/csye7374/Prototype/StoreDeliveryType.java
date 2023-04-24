package edu.neu.csye7374.Prototype;

public abstract class StoreDeliveryType implements Cloneable {
    private int deliveryId;
    private String deliveryType;
    private double deliveryCost;


    public StoreDeliveryType(int deliveryId, String deliveryType, double deliveryCost) {
        super();
        this.deliveryId = deliveryId;
        this.deliveryType = deliveryType;
        this.deliveryCost = deliveryCost;
    }

    abstract String delivertDescription();

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
