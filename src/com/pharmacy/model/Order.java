package com.pharmacy.model;

import java.util.List;

public class Order {
	    private int orderId;
	    private int userId;
	    private List<Medicine> medicines; 
	    private double totalAmount;
		public Order(int orderId, int userId, List<Medicine> medicines, double totalAmount) {
			super();
			this.orderId = orderId;
			this.userId = userId;
			this.medicines = medicines;
			this.totalAmount = totalAmount;
		}
	

		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public List<Medicine> getMedicines() {
			return medicines;
		}
		public void setMedicines(List<Medicine> medicines) {
			this.medicines = medicines;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}


}
