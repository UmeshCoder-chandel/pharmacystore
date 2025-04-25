package com.pharmacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pharmacy.dbconnection.dbconnection;
import com.pharmacy.model.Admin;
import com.pharmacy.model.User;

public class AdminDao {

	public Admin checkAdmin(String name,String password)  {
		try {
		String sql="select * from admin where adminName=? and adminPassword=?";
		Connection con=dbconnection.getConnection();
		 PreparedStatement pst = con.prepareStatement(sql);
		
			pst.setString(1, name);
			pst.setString(2,password);
		    ResultSet rs = pst.executeQuery();
		    while (rs.next()) {
		        return new Admin(rs.getInt("id"), rs.getString("adminName"), rs.getString("adminPassword"));
		    } 
		}
		    catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}	
	public void register(Admin admin) {
		try{  String sql="insert into Admin(adminName,adminPassword) values(?,?)";
		Connection con=dbconnection.getConnection();
		 PreparedStatement pst = con.prepareStatement(sql);
		 pst.setString(1, admin.getAdminName());
			pst.setString(2, admin.getAdminPassword());
		    pst.executeUpdate();
		    System.out.println("Admin add successfull");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public Admin UpdatePassword(String username,String newpassword)  {
		try {
		String sql="update admin set adminPassword=? where adminName =?";
		Connection con=dbconnection.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, newpassword);
	    pst.setString(2, username);
	   int rat= pst.executeUpdate();
	   if(rat>0) {
		   String sql1=" Select *from admin where adminName=?";
			PreparedStatement pst1=con.prepareStatement(sql1);
			pst1.setString(1, username);
			ResultSet rs=pst1.executeQuery();
		   while (rs.next()) {
		        return new Admin(rs.getInt("id"), rs.getString("adminName"), rs.getString("adminPassword"));
		    }  
		  
	   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	        return null; 
	    }

}
