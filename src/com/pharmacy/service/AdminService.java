package com.pharmacy.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.pharmacy.dao.AdminDao;
import com.pharmacy.dao.UserDao;
import com.pharmacy.model.Admin;
import com.pharmacy.model.User;

public class AdminService {
private AdminDao admindao;

public AdminService() {
	this.admindao = new AdminDao();
}
public void Register(Admin adm) {
	admindao.register(adm);
}
public Admin CheckAdmin(String name,String password) {
	return admindao.checkAdmin(name,password);
}
public void UpdatePassword(String username,String newpassword) {
	admindao.UpdatePassword(username, newpassword);
	 System.out.println("Password Update Successfully");
}
public static void AdminMenu(Scanner sc) {
	try {
		int ad;
	while(true) {
		System.out.println("---------------------------Menu Of Admin-----------------------------");
		UserService userse=new UserService();
		ReportService reportseervice=new ReportService();
		OrderService order=new OrderService();
	SupplierService supp=new SupplierService();
AdminService admin=new AdminService();
	SaleService sale=new SaleService();
	 System.out.println("1. Medicine");
	 System.out.println("2. Sale");
	 System.out.println("3. Supplier");
	 System.out.println("4. User data");
	 System.out.println("5. Report");
	 System.out.println("6. Add Admin");
	 System.out.println("7. View Order");
	 System.out.println("8. Go Back");
	 
	 if (sc.hasNextInt()) {
         ad = sc.nextInt();
      } else {
          System.out.println("Please enter a valid choice");
          sc.next(); // Clear the invalid input
          continue;
      }
	 switch(ad) {
	 case 1: System.out.println("Medicine ");
	             MedicineService.AboutMedicine(sc);
	              break;
	 case 2:sale.Sale(sc);
	 break;
	 case 3: SupplierService.AboutSupplier(sc);
	       break;
	 case 4: UserService.AboutUserAdmin(sc);
	        break;
	 case 5:
		 reportseervice.ViewReportSale();
		 break;
	 case 6: sc.nextLine();
		 System.out.println("enter name for admin");
		 String name=sc.nextLine();
		 System.out.println("enter password or admin");
		 String pass=sc.nextLine();
		 Admin add=new Admin(1, name, pass);
		 admin.Register(add);
		 break;
	 case 7: 
		    order.displayOrder(sc);
		 break;
	 case 8: return;
	 }
	 
	}
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
}


}
