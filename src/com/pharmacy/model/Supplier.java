package com.pharmacy.model;

public class Supplier {
private int supplierId;
private String supplierName;
private String SEmail;
private String Sphone;
public Supplier(int supplierId, String supplierName, String sEmail, String sphone) {
	super();
	this.supplierId = supplierId;
	this.supplierName = supplierName;
	SEmail = sEmail;
	Sphone = sphone;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
public String getSEmail() {
	return SEmail;
}
public void setSEmail(String sEmail) {
	SEmail = sEmail;
}
public String getSphone() {
	return Sphone;
}
public void setSphone(String sphone) {
	Sphone = sphone;
}

}
