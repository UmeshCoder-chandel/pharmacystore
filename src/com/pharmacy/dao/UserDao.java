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
import com.pharmacy.model.User;

public class UserDao {

public void InsertUser(User s1)  {
	try {
	String sql="insert into user(username,password,name,email, phonenumber) values(?,?,?,?,?)";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, s1.getUsername());
	pst.setString(2, s1.getPassword());
	pst.setString(3, s1.getName());
	pst.setString(4, s1.getEmail());
	pst.setString(5, s1.getPhoneNumber());
	pst.executeUpdate();
	System.out.println("user add successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
}
public List<User> getAllUser() {
	try {
List<User> supp=new ArrayList<>();
String sql="select * from user";
Connection con=dbconnection.getConnection();
Statement st=con.createStatement();
ResultSet rst=st.executeQuery(sql);
while (rst.next()) {
	User s1=new User(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
supp.add(s1);
}
return supp;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	return null;
}
public User loginUser(String username,String password)  {
	try {
	String sql="Select * from user where username=? and password=?";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, username);
    pst.setString(2, password);
   ResultSet rs= pst.executeQuery();
    while (rs.next()) {
        return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
                         rs.getString("name"), rs.getString("email"),
                        rs.getString("phonenumber"));
    } 
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
        return null; // Login failed
    }

public User UpdatePassword(String username,String newpassword) {
	try {
	String sql="update  user set password=? where username=?";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, newpassword);
    pst.setString(2, username);
   int rat= pst.executeUpdate();
   if(rat>0) {
	   String sql1=" Select *from user where username=?";
		PreparedStatement pst1=con.prepareStatement(sql1);
		pst1.setString(1, username);
		ResultSet rs=pst1.executeQuery();
	   while (rs.next()) {
	        return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
	                        rs.getString("name"), rs.getString("email"),
	                        rs.getString("phonenumber"));
	    }  
   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
        return null; 
    }

	public void deleteUser(int id) {
		try {
		String sql="delete from user where id=?";
		Connection con=dbconnection.getConnection();
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		pst.executeUpdate();
		System.out.println("User was delete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
