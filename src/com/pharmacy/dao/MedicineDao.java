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

public class MedicineDao {

public void InsertMedicine(Medicine s1) {
	try {
	String sql="insert into Medicine(medicineName,Description,price,quantity,expiration,supplier_id) values(?,?,?,?,?,?)";
	Connection con = dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1, s1.getMedicinename());
	pst.setString(2, s1.getDescription());
	pst.setDouble(3, s1.getPrice());
	pst.setInt(4, s1.getQuantity());
	pst.setString(5, s1.getExpiration());
	pst.setInt(6, s1.getSupplierId());
	pst.executeUpdate();
	System.out.println("medicine add successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<Medicine> getAllMedicine() {
    try {
        List<Medicine> supp = new ArrayList<>();
        String sql = "SELECT * FROM Medicine";
        Connection con = dbconnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(sql);

        while (rst.next()) {
            Medicine s1 = new Medicine(
                rst.getInt(1), 
                rst.getString(2), 
                rst.getString(3), 
                rst.getDouble(4), 
                rst.getInt(5), 
                rst.getString(6), 
                rst.getInt(7)
            );
            supp.add(s1);
        }

        return supp; // Return the list after the loop finishes
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
//public List<Medicine> getAllMedicine() {
//	try {
//List<Medicine> supp=new ArrayList<>();
//String sql="select * from Medicine";
//Connection con = getConnection();
//Statement st=con.createStatement();
//ResultSet rst=st.executeQuery(sql);
//while (rst.next()) {
//	Medicine s1=new Medicine(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4), rst.getInt(5),rst.getString(6),rst.getInt(7));
//supp.add(s1);
//return supp;
//}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	return null;
//}

public void updateMedicine(int id ,String name,String description,double price,int quanity)  {
	try {
	String sql="update Medicine set medicineName=?, Description=?, price=?, quantity =? where id=?";
	Connection con =dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setString(1,name);
pst.setString(2, description);
pst.setDouble(3, price);
pst.setInt(4, quanity);
pst.setInt(5,id);
	pst.executeUpdate();
	System.out.println("medicine update successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void deleteMedicine(int medi)  {
	try {
	String sql="delete from Medicine where id=?";
	Connection con =dbconnection.getConnection();
	PreparedStatement pst=con.prepareStatement(sql);
	pst.setInt(1, medi);
	pst.executeUpdate();
	System.out.println("medicine delete successfully");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public Medicine fetchMedicineById(int medicineId)  {
	try {
    String sql = "SELECT * FROM medicine WHERE id = ?";
    Connection con = dbconnection.getConnection();
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, medicineId);

    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
        return new Medicine(
            rs.getInt("id"),
            rs.getString("medicinename"),
            rs.getString("description"),
            rs.getDouble("price"),
            rs.getInt("quantity"),
            rs.getString("expiration"),
            rs.getInt("supplier_id")
        );
    }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return null; // Return null if no medicine found
}
}
