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
import com.pharmacy.model.Supplier;

public class SupplierDao {

	
public void InsertSupplier(Supplier s1)  {
	try {
	String sql="insert into supplier(name,email,phone) values(?,?,?)";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, s1.getSupplierName());
	pst.setString(2, s1.getSphone());
	pst.setString(3, s1.getSEmail());
	pst.executeUpdate();
	System.out.println("supplier add successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<Supplier> getAllSupplier() {
	try {
List<Supplier> supp=new ArrayList<>();
String sql="select * from supplier";
Connection con=dbconnection.getConnection();
Statement st=con.createStatement();
ResultSet rst=st.executeQuery(sql);
while (rst.next()) {
Supplier s1=new Supplier(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));
supp.add(s1);
}
return supp;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public void updateSupplier(Supplier sup) {
	try {
	String sql="update supplier set name=?, phone=?, email=? where id=?";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, sup.getSupplierName());
	pst.setString(2, sup.getSphone());
	pst.setString(3, sup.getSEmail());
	pst.setInt(4, sup.getSupplierId());
	pst.executeUpdate();
	System.out.println("supplier update successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void deleteSupplier(int id)  {
	try {
	String sql="delete from supplier where id=?";
	Connection con=dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, id);
	pst.executeUpdate();
	System.out.println("supplier delete successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
