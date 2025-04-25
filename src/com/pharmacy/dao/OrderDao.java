package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbconnection.dbconnection;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.Order;

public class OrderDao {

public void addOrder(Order order, List<Medicine> medicine)  {
    String orderSql = "INSERT INTO `Orders` (userId, totalAmount) VALUES (?, ?)";
    String medicineSql = "INSERT INTO `order_medicine` (orderId, medicineId, quantity) VALUES (?, ?, ?)";
    String updateStockSql = "UPDATE Medicine SET quantity = quantity - ? WHERE id = ?";

    try (Connection con = dbconnection.getConnection()) {
        // Disable auto-commit for transactional behavior
        con.setAutoCommit(false);

        // Insert the order
        try (PreparedStatement pstOrder = con.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS)) {
            pstOrder.setInt(1, order.getUserId());
            pstOrder.setDouble(2, order.getTotalAmount());
            pstOrder.executeUpdate();

            // Get the generated order ID
            ResultSet rs = pstOrder.getGeneratedKeys();
            int orderId = -1;
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

            // Insert medicine details for the order and update stock
            try (PreparedStatement pstMedicine = con.prepareStatement(medicineSql);
                 PreparedStatement pstUpdateStock = con.prepareStatement(updateStockSql)) {

                for (Medicine medic : medicine) {
                    // Insert order-medicine relation
                    pstMedicine.setInt(1, orderId);
                    pstMedicine.setInt(2, medic.getMedicineID());
                    pstMedicine.setInt(3, medic.getQuantity());
                    pstMedicine.executeUpdate();

                    // Update stock for the medicine
                    pstUpdateStock.setInt(1, medic.getQuantity());
                    pstUpdateStock.setInt(2, medic.getMedicineID());
                    pstUpdateStock.executeUpdate();
                }

                // Commit the transaction
                con.commit();
                System.out.println("Order and medicine stock updated successfully.");
            }
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
            System.out.println("Transaction failed, rolling back.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}   

public List<Order> getAllOrder() {
	try {
	List<Order> order=new ArrayList<>();
	return order;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public Order fetchOrderById(int id) {
    try {
        // SQL query to join orders, order_medicine, and medicine tables
        String sql = "SELECT o.id AS orderId, o.userId, om.medicineId, om.quantity, m.medicinename, m.price, o.totalAmount " +
                     "FROM orders o " +
                     "JOIN order_medicine om ON o.id = om.orderId " +
                     "JOIN medicine m ON om.medicineId = m.id " +
                     "WHERE o.id = ?";

        // Establish the database connection
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            List<Medicine> medicines = new ArrayList<>();
            int orderId = 0, userId = 0;
            double totalAmount = 0.0; // Initialize total amount
             boolean hasResult =false;
            while (rs.next()) {
                // Create a Medicine object from the result set
            	hasResult =true;
            	
            	 orderId = rs.getInt("orderId");
                 userId = rs.getInt("userId");
                 totalAmount = rs.getDouble("totalAmount");


                Medicine medicine = new Medicine(
                    rs.getInt("medicineId"),
                    rs.getString("medicinename"),
                    "",  // Assuming no description or expiration for this method
                    rs.getDouble("price"),
                    rs.getInt("quantity"),
                    "",  // Assuming no expiration or description data
                    id   // The order ID
                );

                medicines.add(medicine);
                totalAmount = rs.getDouble("totalAmount");  // Fetch totalAmount (from the order)
            }

            if (hasResult) {
                // Return the Order object
            	 return new Order(
                         orderId,               // orderId
                         userId,                // userId
                         medicines,             // List of medicines
                         totalAmount             // totalAmount
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;  // Return null if the order was not found
}

private List<Medicine> parseMedicine(String medicinesData) {
	List<Medicine> medi=new ArrayList<>();
	return medi;
}


public void deleteOder(int id)  {
	try {
	String sql="delete from orders where id=?";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	pst.executeUpdate();
	System.out.println("order was delete");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
