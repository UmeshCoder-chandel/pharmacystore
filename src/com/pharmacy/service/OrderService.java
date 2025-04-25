package com.pharmacy.service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.OrderDao;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.Order;

public class OrderService {
private OrderDao orderdao;

public OrderService() {
	this.orderdao=new OrderDao();
}
public void addOrderService(Order ord,List<Medicine> medicine)  {
	orderdao.addOrder(ord, medicine);
}
public List<Order> getAllOrder() {
	return orderdao.getAllOrder();
}
public Order viewOrder(int orderId) throws FileNotFoundException {
    Order order = orderdao.fetchOrderById(orderId);
    if (order == null) {
        throw new FileNotFoundException("Order with ID " + orderId + " not found.");
    }
    return order;
}
public void giveOrder(Scanner sc)  {
	MedicineService medicineservice=new MedicineService();
	 System.out.println("Enter your user ID:");
     int userId = sc.nextInt();
     System.out.println("How many medicines would you like to order?");
     int count = sc.nextInt();
     List<Medicine> orderList = new ArrayList<>();

     for (int i = 0; i < count; i++) {
         System.out.println("Enter Medicine ID:");
         int medId = sc.nextInt();
         Medicine medicine = medicineservice.fetchMedicineById(medId); 
         if (medicine != null) {
             System.out.println("Enter quantity:");
             int quantity = sc.nextInt();
             if(quantity<=medicine.getQuantity()) {
             medicine.setQuantity(quantity); // Update quantity for the order
             orderList.add(medicine);
             }else {
                 System.out.println("Insuffernet stock"+medicine.getQuantity());
             }
         } else {
             System.out.println("Medicine not found!");
         }
     }

     double totalAmount = medicineservice.calculateTotal(orderList);
     if(!orderList.isEmpty()) {
    	Order order= new Order(1, userId, orderList, totalAmount);
    	 order.setOrderId(userId);
    	 order.setTotalAmount(totalAmount);
    	 addOrderService(order, orderList);
    	 System.out.println("Order placed successfully! Total Amount: " + totalAmount);
     } else {
         System.out.println("No medicines were added to the order.");
     }

}

public void generateBill(Scanner sc) {
    OrderService orderService = new OrderService();
    try {
        System.out.println("Enter your order ID to generate the bill:");
        int orderId = sc.nextInt();
        // Fix: Use the correct method name "fetchOrderById" here
        Order billOrder = orderService.viewOrder(orderId);

        if (billOrder != null) {
            System.out.println("===== BILL =====");
            System.out.println("Order ID: " + billOrder.getOrderId());
            System.out.println("User ID: " + billOrder.getUserId());
            System.out.println("Medicines Ordered:");
            for (Medicine medicine : billOrder.getMedicines()) {
                System.out.println("- " + medicine.getMedicinename() + " | Quantity: " + medicine.getQuantity() + " | Price: " + medicine.getPrice());
            }
            System.out.println("Total Amount: " + billOrder.getTotalAmount());
            System.out.println("=================");
        } else {
            System.out.println("Order not found!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void displayOrder(Scanner sc) {
	  OrderService orderService = new OrderService();
	    try {
    System.out.println("Enter your order ID :");
    int orderId = sc.nextInt();
    // Fix: Use the correct method name "fetchOrderById" here
    Order order = orderService.viewOrder(orderId);
    System.out.println("Order ID: " + order.getOrderId());
    System.out.println("User ID: " + order.getUserId());
    System.out.println("Medicines:");
    for (Medicine medicine : order.getMedicines()) {
        System.out.println("- Medicine Name: " + medicine.getMedicinename());
        System.out.println("  Quantity: " + medicine.getQuantity());
        System.out.println("  Price: " + medicine.getPrice());
    }
    System.out.println("Total Amount: " + order.getTotalAmount());
}catch (Exception e) {
	// TODO: handle exception
}
}
public void giveOrder(Order order) {
	System.out.println(order.getTotalAmount());
	
}
}