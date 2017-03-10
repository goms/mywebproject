package com.chitfund.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.Person.PersonDao;

public class AccountDao {
	AccountBean ab=new AccountBean();
	DBMSDao ddAcc=new DBMSDao();
	Random rand=new Random();
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	public void displayAccountDetails(PersonBean personBean) {
		// TODO Auto-generated method stub
		ab=ddAcc.getAccountDetails(personBean);
		System.out.println("Account Details : ");
		System.out.println("Bank Name : "+ab.getBankname());
		System.out.println("Account Number : "+ab.getAccountNumber());
		System.out.println("Balance : "+ab.getBalance());
	}
	public boolean getAccountDetails(PersonBean pb, String accno, String bName) {
		// TODO Auto-generated method stub
					boolean check=true;
					boolean flag=false;
					int balance=generatebalance();
					ab.setAccountNumber(accno);
					ab.setBankname(bName);
					ab.setBalance(balance);
					ab.setPersondetails(pb);
					check=ddAcc.isAccountNumberPresent(accno);
					if(check)
					{
						flag=ddAcc.insertIntoAccountDetail(ab);
						ddAcc.addToGroup(pb.getGid(),pb.getPid());
					}
					return flag;
	}
	private int generatebalance() {
		// TODO Auto-generated method stub
		int num=((1+rand.nextInt(3))*10000)+rand.nextInt(10000);
		return num;
	}
	public void checkBalance(PersonBean personBean) {
		// TODO Auto-generated method stub
		String acc=ddAcc.getAccountNumber(personBean);
		int balance=ddAcc.getAmount(acc);
		System.out.println("Balance : " + balance);
	}
	public void displayAccountDetails(AccountBean abc) {
		// TODO Auto-generated method stub
		
		System.out.println("Account Number : " + abc.getAccountNumber());
		System.out.println("Bank Name : " + abc.getBankname());
		System.out.println("Balance : " + abc.getBalance() );
	}
	public AccountBean getAccountDetails(PersonBean pb) {
		// TODO Auto-generated method stub
					AccountBean aBean=ddAcc.getAccountDetails(pb);
					return aBean;
					
	}
	

}
