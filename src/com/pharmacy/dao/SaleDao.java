package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pharmacy.dbconnection.dbconnection;
import com.pharmacy.model.Sale;

public class SaleDao {

	
    public void addSalesRecord(Sale sales)  {
        // First, check if the user exists in the user table.
        String userCheckSQL = "SELECT COUNT(*) FROM user WHERE id = ?";
        try (Connection con = dbconnection.getConnection();
             PreparedStatement pstCheck = con.prepareStatement(userCheckSQL)) {
             
            pstCheck.setInt(1, sales.getUserId());
            ResultSet rsCheck = pstCheck.executeQuery();
            
            if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                // The user exists, now insert the sales record.
                String sql = "INSERT INTO sales (userId, medicineId, quantity, amount, saledate) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setInt(1, sales.getUserId());
                    pst.setInt(2, sales.getMedicineId());
                    pst.setInt(3, sales.getQuantitySold());
                    pst.setDouble(4, sales.getTotalAmount());
                    pst.setString(5, sales.getSaleDate());
                    pst.executeUpdate();
                    System.out.println("Sales record added successfully.");
                }
            } else {
                // Handle error: User with the specified ID doesn't exist
                System.out.println("Error: User with ID " + sales.getUserId() + " does not exist.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
    public List<Sale> getAllsale() {
    	List<Sale> supp=new ArrayList<>();
    	try {
    	String sql="select * from sales";
    	Connection con=dbconnection.getConnection();
    	Statement st=con.createStatement();
    	ResultSet rst=st.executeQuery(sql);
    	  while (rst.next()) {
              // Use column names instead of indices for better readability and reliability
              int saleId = rst.getInt("saleId");
              int userId = rst.getInt("userId");
              int medicineId = rst.getInt("medicineId");
              int quantitySold = rst.getInt("quantity");
              double totalAmount = rst.getDouble("amount");
              String saleDate = rst.getString("saleDate");

              Sale s1 = new Sale(saleId, userId, medicineId, quantitySold, totalAmount, saleDate);
              supp.add(s1);
    	}
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	return supp;
	
    }

}
