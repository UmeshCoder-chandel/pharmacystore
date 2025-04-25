package com.pharmacy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.pharmacy.dao.UserDao;
import com.pharmacy.model.Admin;
import com.pharmacy.model.Medicine;
import com.pharmacy.model.Order;
import com.pharmacy.model.User;

public class UserService {
private UserDao userdao;

    public UserService() {
	this.userdao =new  UserDao();
}
public void addUserService(User u1)  {
	try {
		userdao.InsertUser(u1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void UpdatePassword(String username,String newpassword) {
	try {
		userdao.UpdatePassword(username, newpassword);
		// System.out.println("Password Update Successfully");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public List<User> getAllUser() {
	try {
		return userdao.getAllUser();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public void DeleteUser(int id)  {
	try {
		userdao.deleteUser(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void registerUser(Scanner sc)  {
	// TODO Auto-generated method stub
try {	
	   sc.nextLine();
	 System.out.println("-------------------------Registration For User-------------------------");
	 System.out.println("Enter username");
	 String user=sc.nextLine();
	 System.out.println("Enter password");
	 String pass=sc.nextLine();
	 System.out.println("Enter name");
	 String name=sc.nextLine();
	 System.out.println("Enter email");
	 String email=sc.nextLine();
	 System.out.println("Enter phone");
	 String phone=sc.nextLine();
	 User u=new User(1, user, pass, name, email, phone);
	 UserService userservice=new UserService();
	 userservice.addUserService(u);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println(e.getMessage());
}
}

public static void loginUser(Scanner sc)  {
	try {
	sc.nextLine();
	System.out.println("-------------------------Login Here-------------------------");
	 System.out.println("enter username");
	 String use=sc.nextLine();
	 System.out.println("enter password");
	 String pas=sc.nextLine();
	 
	 UserDao user1= new UserDao();	 
	 AdminService admin=new AdminService();
	 Admin adm = admin.CheckAdmin(use, pas);
	
	 User userdao=user1.loginUser(use, pas);
	 if(userdao!=null) {
		 System.out.println("-------------------Login successfully You Are User-------------------------------");	 
          		 UserMenu(sc);
       
	 }
	 else if(adm!=null) {
		 System.out.println("-----------------------Login successfully You Are Admin-----------------------------");	 
		 
		 admin.AdminMenu(sc);
	 }
	 else {
		 System.out.println("login failed");
		 System.out.println("1 for Try Again");
		 System.out.println("2 for Forget Password");
		 int ch=sc.nextInt();
		 if(ch==1) {
			 loginUser(sc);
		 }
		 if(ch==2) {
			 sc.nextLine();
			 System.out.println("user name");
			 String name=sc.nextLine();
			 System.out.println("generate OTP");
			 int Otp=(int)(Math.random()*100000);
			 System.out.println("you otp is "+Otp);
			 System.out.println("enter the  otp  ");
			 int userotp=sc.nextInt();
			 sc.nextLine();
			 if(Otp==userotp) {
			//	 System.out.println("Change the password");
				 System.out.println("enter new password");
				 String pass=sc.nextLine();
				 //User u=user1.UpdatePassword(name, pass);
				 UserService userser=new UserService();
				 AdminService adminupdat=new AdminService();
				 userser.UpdatePassword(name,pass);
				 adminupdat.UpdatePassword(name, pass);
				
			 } 
		 }
		 
	 }
	}
	 catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
}
public static void UserMenu(Scanner sc) {
	int ad;
	while(true) {
		System.out.println("------------------------Menu Of User------------------------------------");
	    MedicineService medicineservice=new MedicineService();
	    OrderService order=new  OrderService();
	 System.out.println("1. view medicine");
	 System.out.println("2.  place order ");
	 System.out.println("3. view order");
	 System.out.println("4. generate bill");
	 System.out.println("5. go back");
	 if (sc.hasNextInt()) {
         ad = sc.nextInt();
      } else {
          System.out.println("Please enter a valid choice");
          sc.next(); // Clear the invalid input
          continue;
      }
	//  ad=sc.nextInt();
	 switch(ad) {
	 case 1: System.out.println("All Medicine ");
	            	List<Medicine> medici=medicineservice.fetchallMedicine();
	            		for(Medicine m:medici) {
	            			System.out.println(m.getMedicineID()+" | "+m.getMedicinename()+" | "+m.getDescription()+" | "+m.getPrice()+" | "+m.getQuantity()+" | "+m.getExpiration()+" | "+m.getSupplierId());		 
	            		}
	              break;
	 case 2:   try {
			order.giveOrder(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	 break;
	 case 3:
	 try {
			order.displayOrder(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		 
	       break;
	 case 4:
		try {
			order.generateBill(sc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		     break;
	 case 5:
		 return;
	 }
	 
	}
}
public static void AboutUserAdmin(Scanner sc) {
	int u;
	while(true) {
		UserService user=new UserService();
		System.out.println("1. view all user data");
	   System.out.println("2. delete user data");
	   System.out.println("3. go back");
	   if (sc.hasNextInt()) {
	        u = sc.nextInt();
	     } else {
	         System.out.println("Please enter a valid choice");
	         sc.next(); // Clear the invalid input
	         continue;
	     }
	//int u=sc.nextInt();
	switch (u) {
	case 1: System.out.println("All User ");
	List<User> med=user.getAllUser();
	for(User m:med) {
		System.out.println(m.getUserId()+" | "+m.getUsername()+" | "+m.getPassword()+" | "+m.getName()+" | "+m.getEmail()+" | "+m.getPhoneNumber()+" | ");		 
	}
	break;
	case 2:  
		try{
			System.out.println("enter the id");
		
	           int id=sc.nextInt();
                user.DeleteUser(id);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
                break;
	case 3: 
		return;
	default:
		System.out.println();
		break;
	}
	
	}
	
}
}
