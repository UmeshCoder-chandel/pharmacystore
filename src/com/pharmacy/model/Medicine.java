package com.pharmacy.model;

public class Medicine {
private int  MedicineID; 
private String Medicinename;
private String Description;
private double Price;
private int Quantity;
private String Expiration;
private int SupplierId;
public Medicine(int medicineID, String medicinename, String description, double price, int quantity,
		String expiration,int supplierid) {
	super();
	MedicineID = medicineID;
	Medicinename = medicinename;
	Description = description;
	Price = price;
	Quantity = quantity;
	Expiration = expiration;
	SupplierId=supplierid;
}

//public Medicine(int medicineID, String medicinename, double price, int quantity) {
//	super();
//	MedicineID = medicineID;
//	Medicinename = medicinename;
//	Price = price;
//	Quantity = quantity;
//}

public int getMedicineID() {
	return MedicineID;
}
public void setMedicineID(int medicineID) {
	MedicineID = medicineID;
}
public String getMedicinename() {
	return Medicinename;
}
public void setMedicinename(String medicinename) {
	Medicinename = medicinename;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public double getPrice() {
	return Price;
}
public void setPrice(double price) {
	Price = price;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
}
public String getExpiration() {
	return Expiration;
}
public void setExpiration(String expiration) {
	Expiration = expiration;
}
public int getSupplierId() {
	return SupplierId;
}
public void setSupplierId(int supplierId) {
	SupplierId = supplierId;
}


}
