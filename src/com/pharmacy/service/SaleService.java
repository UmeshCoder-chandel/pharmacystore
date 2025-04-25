package com.pharmacy.service;

import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.SaleDao;
import com.pharmacy.model.Sale;

public class SaleService {
private SaleDao saledao;

public SaleService() {
	this.saledao = new SaleDao();
}
public void addSales(Sale sal)  {
	saledao.addSalesRecord(sal);
}
public List<Sale> fetchAllSale(){
	return saledao.getAllsale();
	
}

public void Sale(Scanner sc)  {
	int a;
	while(true) {
    SaleService saleservice=new SaleService();
	System.out.println("1. for add sale");
	System.out.println("2. for view sale");
	System.out.println("3. go back");
	if (sc.hasNextInt()) {
        a = sc.nextInt();
     } else {
         System.out.println("Please enter a valid choice");
         sc.next(); // Clear the invalid input
         continue;
     }
	switch(a) {
	case 1:
		try {
		sc.nextLine();
	System.out.println("enter user id");
	int id=sc.nextInt();
	sc.nextLine();
	System.out.println("enter medicine id");
	int mid=sc.nextInt();
	sc.nextLine();
	System.out.println("enter the quantity");
	int quantity=sc.nextInt();
	sc.nextLine();
	System.out.println("enter the total amount");
	double amount=sc.nextDouble();
	sc.nextLine();
	System.out.println("enter the sale date");
	String date=sc.nextLine();
	Sale s1=new Sale(1,id,mid,quantity,amount,date);
	addSales(s1);
		} catch (Exception e) {
			 // TODO Auto-generated catch block
	        //	e.printStackTrace();
			System.out.println(e.getMessage());
		}
	break;
	case 2: List<Sale> sale=saleservice.fetchAllSale();
	for(Sale s:sale) {
		System.out.println(s.getSaleId()+" | "+s.getUserId()+" | "+s.getMedicineId()+" | "+s.getQuantitySold()+" | "+s.getTotalAmount()+" | "+s.getSaleDate());
	}
	break;
	case 3: 
		return;
	default :
		System.out.println("Invalid Operation");
	}
	}
}

}
