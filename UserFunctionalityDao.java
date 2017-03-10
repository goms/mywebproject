package com.chitfund.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.chitfund.Account.AccountDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.Transaction.TransactionDao;

public class UserFunctionalityDao {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	AccountDao ad=new AccountDao();
	TransactionDao td=new TransactionDao();
	public void userFunctions(PersonBean personBean) {
		// TODO Auto-generated method stub
		System.out.println("1.Display Account Details 2. Transfer 3.checkBalance 4.Transaction Details ");
		try {
			int userChoice=Integer.parseInt(bf.readLine());
			if(userChoice==1)
			{
				ad.displayAccountDetails(personBean);
			}
			else if(userChoice==2)
			{
				td.transferAmount(personBean);
			}
			else if(userChoice==3)
			{
				ad.checkBalance(personBean);
			}
			else if(userChoice==4)
			{
				td.diplayTransactions(personBean);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
