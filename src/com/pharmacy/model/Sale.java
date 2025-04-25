package com.pharmacy.model;

public class Sale {
	private int saleId;
	private int userId;
    private int medicineId;
    private int quantitySold;
    private double totalAmount;
    private String saleDate;
	public Sale(int saleId,  int userId, int medicineId, int quantitySold, double totalAmount, String saleDate) {
		super();
		this.saleId = saleId;
		this.userId = userId;
		this.medicineId = medicineId;
		this.quantitySold = quantitySold;
		this.totalAmount = totalAmount;
		this.saleDate = saleDate;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public String getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}


}
