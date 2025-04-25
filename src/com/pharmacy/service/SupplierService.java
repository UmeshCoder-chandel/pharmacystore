package com.pharmacy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.SupplierDao;
import com.pharmacy.model.Supplier;

public class SupplierService {
private SupplierDao supplierdao;

public SupplierService() {
	this.supplierdao = new SupplierDao();
}

public void addAllSupplier(Supplier supp) {
	supplierdao.InsertSupplier(supp);
}
public List<Supplier> fetchAllSupplier(){
	return supplierdao.getAllSupplier();
}

public void updateSupplier(Supplier supp)  {
	supplierdao.updateSupplier(supp);
}

public void cancelSupplier(int id) {
	supplierdao.deleteSupplier(id);
}

public static void AboutSupplier(Scanner sc) {
	int sup;
	 while(true)  {
		 SupplierService supplierservice=new SupplierService();
		 System.out.println("1. add supplier");
		 System.out.println("2. view supplier");
		 System.out.println("3. update supplier");
		 System.out.println("4. delete supplier");
		 System.out.println("5. go to menu");
		 if (sc.hasNextInt()) {
		        sup = sc.nextInt();
		     } else {
		         System.out.println("Please enter a valid choice");
		         sc.next(); // Clear the invalid input
		         continue;
		     }
		 switch(sup) {
		 case 1: 
			 try {
			 sc.nextLine();
			 System.out.println("enter name of supplier");
			 String name=sc.nextLine();
			 System.out.println("enter email of supplier");
			 String email=sc.nextLine();
			 System.out.println("enter phone of supplier");
			 String phone=sc.nextLine();
			 Supplier supp=new Supplier(1,name,email,phone);
			 supplierservice.addAllSupplier(supp);
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		 case 2:
			 List<Supplier> suppl=supplierservice.fetchAllSupplier();
			 System.out.println("Supplier Id  |  Supplier Name  | Supplier Email  | Supplier Phone");
			 for(Supplier s1:suppl) {
				 System.out.println(s1.getSupplierId()+" | "+s1.getSupplierName()+" | "+s1.getSEmail()+" | "+s1.getSphone());
			 }
			 break;
		 case 3: 
			 try{
				 sc.nextLine();
	     System.out.println("enter name of supplier");
		 String nam=sc.nextLine();
		 System.out.println("enter email of supplier");
		 String emai=sc.nextLine();
		 System.out.println("enter phone of supplier");
		 String phon=sc.nextLine();
		 System.out.println("enter id");
		 int id=sc.nextInt();
		 sc.nextLine();
		 Supplier update=new Supplier(id, nam, emai, phon);
		 supplierservice.updateSupplier(update);
			 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 break;
		 case 4:
			 try{  System.out.println("enter id");
		 int id1=sc.nextInt();
		 sc.nextLine();
		 supplierservice.cancelSupplier(id1);
			 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 break;
		 case 5:
			 return;
			 default:System.out.println("input invailed");
		 }
	 }
	
}



}
