package com.pharmacy.main;

import java.util.Scanner;

import com.pharmacy.service.UserService;

public class PharmacyApp {
	
public static void main(String[] args) {
	//new LoginSwing().setVisible(true);
	Scanner sc=new Scanner(System.in);
	try {
		int ch;
	 while (true) {
         System.out.println("\n=============PHARMACY MANAGEMENT LOGIN ===============");
         System.out.println("1. Register");
         System.out.println("2. Login");
         System.out.println("3. Log out");
         System.out.print("Choose an option: ");
         if (sc.hasNextInt()) {
            ch = sc.nextInt();
         } else {
             System.out.println("Please enter a valid choice");
             sc.next(); 
             continue;
         }
        // int ch=sc.nextInt();
         switch(ch) {
         case 1: try {
				UserService.registerUser(sc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				continue;
			}
        	     break;
        	 
         case 2 :try {
				UserService.loginUser(sc);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				continue;
			}	 
    			break;  
        
         case 3:System.out.println("Exiting the program good bye");
        	 sc.close();  
        	 default:System.out.println("invalid value");
         }
       }

	}catch (Exception e) {
	     System.out.println(e.getMessage());
	      
	}
	
	
}
}



