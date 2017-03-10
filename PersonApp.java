package com.chitfund.Person;

import java.util.Scanner;

public class PersonApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		System.out.print("Enter the Person ID (PID) For Now 112 : ");
		int pid=scan.nextInt();
		System.out.println("Selecting 112...");
		PersonDao.getDetails(pid);
		//System.out.println("5");
		
		 
		System.out.println("Inserting Values..."); 
		PersonDao.setValues(534,"Gomsss534","Gomsss",2);
		PersonDao.display();
		System.out.println("Updating Values..."); 
		PersonDao.updateValues(1,3);
		PersonDao.display();
		System.out.println("Deleting.."); 
		PersonDao.delValues(1);
		PersonDao.display();
		
		System.out.println("Exiting...");
		scan.close();

}
}
