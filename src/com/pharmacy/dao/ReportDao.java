package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.pharmacy.dbconnection.dbconnection;

public class ReportDao {

	public ResultSet GenerateReportSale()  {
		ResultSet rs=null;
		try {
	//	String sql="select medicineId sum(quantity) as Total_quantity,sum(amount) as total_amount from sales group by medicineId order by total_amount";
		String sql=" SELECT s.medicineId,SUM(s.quantity) AS Total_quantity,SUM(s.amount) AS Total_amount,COUNT(s.saleId) AS Total_sales, MIN(s.saledate) AS First_sale_date,MAX(s.saledate) AS Last_sale_date FROM sales  AS s LEFT JOIN order_medicine AS o ON s.medicineId = o.medicineId GROUP BY s.medicineId ORDER BY Total_amount DESC";
		Connection con=dbconnection.getConnection();
		PreparedStatement psr=con.prepareStatement(sql);
		 rs=psr.executeQuery();
		System.out.println("===================Sales Report===============================");
		System.out.println("Medicine Id"+" | "+"Quantity"+" | "+"Total Amount"+" | "+"Total Sales"+" | "+"First_sale_date"+" | "+"Last_sale_date |");
		while(rs.next()) {
			int m=rs.getInt("medicineId");
			int q=rs.getInt("Total_quantity");
			double a=rs.getDouble("Total_amount");
			int s=rs.getInt("Total_sales");
			String f=rs.getString("First_sale_date");
			String l=rs.getString("Last_sale_date");
			System.out.println(m+"         | "+q+"          | "+a+"        | "+s+"         | "+f+"          | "+l+"         |");
		}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
		return rs;
	}
}
