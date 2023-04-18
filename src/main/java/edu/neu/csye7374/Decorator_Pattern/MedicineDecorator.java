package edu.neu.csye7374.Decorator_Pattern;

import edu.neu.csye7374.MedicineAPI;

public abstract class MedicineDecorator implements MedicineAPI {

    protected MedicineAPI decoratorMedicine;

    public MedicineDecorator(MedicineAPI decoratorMedicine) {
        this.decoratorMedicine = decoratorMedicine;
    }

    @Override
    Public String medicineDescription() {
        return decoratorMedicine.medicineDescription;
    }
}
