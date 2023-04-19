package edu.neu.csye7374;

public class Medicine implements MedicineAPI {

    public int medicineId;
    public String medicineName;
    public double medicinePrice;

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineManufacturer() {
        return medicineManufacturer;
    }

    public void setMedicineManufacturer(String medicineManufacturer) {
        this.medicineManufacturer = medicineManufacturer;
    }

    public MedicineCategory medicineCategory;

    public MedicineCategory getMedicineCategory() {
        return medicineCategory;
    }

    public void setMedicineCategory(MedicineCategory medicineCategory) {
        this.medicineCategory = medicineCategory;
    }

    public String medicineManufacturer;

    @Override
    public String medicineDescription() {
        return this.medicineName;
    }

    @Override
    public String medicineManufacturer() {
        return null;
    }

    @Override
    public int noOfMedicinesManufactured() {
        return 0;
    }

    @Override
    public double medicinePrice() {
        return 0;
    }

    //Command Pattern
    public String buyMedicine(){
        return this.medicineName+" has been purchased"; //+"\n Price now ="+this.medicinePrice;
    }
    //Command Pattern
    //5% discount on subscribing to a medicine
    public String subscribeMedicine(){
        this.medicinePrice= this.medicinePrice * 0.95;
        return this.medicineName+ " has been added to your subscription list and you will get 5% discount on it from now onwards.";//+"\n Price now ="+this.medicinePrice;
    }
}
