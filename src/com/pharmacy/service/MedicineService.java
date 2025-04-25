package com.pharmacy.service;

import java.util.List;
import java.util.Scanner;

import com.pharmacy.dao.MedicineDao;
import com.pharmacy.model.Medicine;

public class MedicineService {
private MedicineDao medicinedao;

public MedicineService() {
	this.medicinedao = new MedicineDao();
}
public void addMedicine(Medicine me)  {
try {
	medicinedao.InsertMedicine(me);
} catch (Exception e ) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
}
public List<Medicine> fetchallMedicine() {
    try {
        List<Medicine> medicines = medicinedao.getAllMedicine();
        if (medicines == null || medicines.isEmpty()) {
            System.out.println("No medicines found in DAO!");
        } else {
            System.out.println("Successfully fetched " + medicines.size() + " medicines from DAO.");
        }
        return medicines;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
	
}
public void updateMedicine(int id ,String name,String description,double price,int quanity){
	try {
	medicinedao.updateMedicine(id , name, description, price, quanity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void cancelMedicine(int id)  {
	try {
	medicinedao.deleteMedicine(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public Medicine fetchMedicineById(int medicineId)  {
	try {
    return medicinedao.fetchMedicineById(medicineId);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}


public static void AboutMedicine(Scanner sc)  {
	int med;
while(true) {
	MedicineService medicineservice=new MedicineService();
	 System.out.println("1. add medicine");
	 System.out.println("2. view  medicine");
	 System.out.println("3. update medicine");
	 System.out.println("4. delete medicine");
	 System.out.println("5. go to menu");
	 if (sc.hasNextInt()) {
	        med = sc.nextInt();
	     } else {
	         System.out.println("Please enter a valid choice");
	         sc.next(); // Clear the invalid input
	         continue;
	     }
	 switch(med) {
	 case 1: 
		 try{   sc.nextLine();
		 System.out.println("enter medicine name");
		 String name=sc.nextLine();
		 System.out.println("enter medicine decreption");
		 String dec=sc.nextLine();
		 System.out.println("enter medicine price ");
		 double price=sc.nextDouble();
		 sc.nextLine();
		 System.out.println("enter medicine quntity");
		 int quntity=sc.nextInt();
		 sc.nextLine();
		 System.out.println("enter medicine expiration date ");
		 String date=sc.nextLine();
		 System.out.println("enter medicine supplier id ");
		 int suppl=sc.nextInt();
		 sc.nextLine();
		 Medicine medic=new Medicine(1, name, dec, price, quntity, date, suppl);
		 medicineservice.addMedicine(medic);
		 }
		 catch (Exception e) {
			// TODO: handle exception
		}
		 break;
	 case 2: 
		 List<Medicine> medici=medicineservice.fetchallMedicine();
		 System.out.println("================================= All Medicine List=====================");
		 System.out.println("Medicine Id"+"  |  "+"Medicine Name"+"  |  "+"Description"+"   |  "+"Price"+"   |  "+"Quantiy"+"   |  "+"Expiered"+"   |  "+"Supplier Id");
		 
		 for(Medicine m:medici) {
			 System.out.println("-------------------------------------------------------------------------");
			 System.out.println(m.getMedicineID()+"    |    "+m.getMedicinename()+"    |   "+m.getDescription()+"    |   "+m.getPrice()+"    |   "+m.getQuantity()+"    |    "+m.getExpiration()+"     |  "+m.getSupplierId());		 
		 }
		 break;
	 case 3:  sc.nextLine();
	 System.out.println("enter medicine name");
	 String name1=sc.nextLine();
	 System.out.println("enter medicine decreption");
	 String dec1=sc.nextLine();
	 System.out.println("enter medicine price ");
	 double price1=sc.nextDouble();
	 sc.nextLine();
	 System.out.println("enter medicine quntity");
	 int quntity1=sc.nextInt();
	 sc.nextLine();
	 System.out.println("enter medicine id");
	 int id1=sc.nextInt();
	 sc.nextLine();
	 medicineservice.updateMedicine(id1, name1, dec1, price1, id1);
		 break;
	 case 4: System.out.println("enter id for delete");
	 int id=sc.nextInt();
	 medicineservice.cancelMedicine(id);
		
	 break;
	 case 5:
		 return;
		 default:System.out.println("input invaild");
	 }
	
}
}

public double calculateTotal(List<Medicine> medicines) {
    double total = 0;
    for (Medicine med : medicines) {
        total += med.getPrice(); 
    }
    return total;
}


}
