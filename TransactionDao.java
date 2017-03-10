package com.chitfund.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Person.PersonBean;

public class TransactionDao {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	DBMSDao dd=new DBMSDao();
	Random rand=new Random();
	public void transferAmount(PersonBean personBean,String amount) {
		// TODO Auto-generated method stub
					int tno=rand.nextInt(10000);
					String fromaccountnumber=dd.getAccountNumber(personBean);
					int gid=personBean.getGid();			
					String toAcc=dd.getGroupAccountNumber(gid);
					int amt=Integer.parseInt(amount);
					dd.insertIntoTransactionTable(tno,fromaccountnumber,toAcc,amt);
					dd.updateFromAmount(fromaccountnumber,amt);
					dd.updateToAmount(toAcc,amt);
	}

	public ArrayList<TransactionBean> getFTrans(String acc)
	{
		ArrayList<TransactionBean> al=dd.getFromTransactionDetails(acc);
		return al;
		
	}
	public ArrayList<TransactionBean> getTTrans(String acc)
	{
		ArrayList<TransactionBean> al=dd.getToTransactionDetails(acc);
		return al;
		
	}
	public void displayTransactionDetails(TransactionBean tb) {
		// TODO Auto-generated method stub
		System.out.println(tb.getTno()+"				"+tb.getFromAccount()+"			"+tb.getToAccount()+"			"+tb.getAmount()+"			"+tb.getDate());
		
		
	}
	
	
	
	
	
}
