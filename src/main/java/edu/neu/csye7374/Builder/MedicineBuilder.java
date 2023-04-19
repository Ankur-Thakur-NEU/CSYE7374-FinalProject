package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineCategory;

public class MedicineBuilder implements BuilderAPI<Medicine>{

	public int medicineId;
	public String medicineName;
	public double medicinePrice;
	private MedicineCategory medicineCategory;
	private String medicineManufacturer;

	public MedicineCategory getBookCategory() {
		return medicineCategory;
	}

	public void setBookCategory(MedicineCategory medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public MedicineBuilder(int medicineId, String medicineName, double medicinePrice, MedicineCategory medicineCategory,String medicineManufacturer) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicinePrice = medicinePrice;
		this.medicineCategory = medicineCategory;
		this.medicineManufacturer=medicineManufacturer;
	}
	
	public MedicineBuilder(String s) {
		String[] tokens=s.split(",");
//		this.medicineId=ConvertUtility.StringToInt(tokens[0]);
//		this.medicineName=tokens[1];
//		this.medicinePrice=ConvertUtility.StringToDouble(tokens[2]);
//		this.medicineCategory=MedicineCategory.getMedicineCategory(tokens[3]);
		this.medicineManufacturer=tokens[4];
	}

	@Override
	public Medicine build() {
		return null;
	}


//	@Override
//	public Medicine build() {
//		// TODO Auto-generated method stub
//		return MedicineFactory.getInstance().getObject(this);
//	}
}
