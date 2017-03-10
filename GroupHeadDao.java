package com.chitfund.GroupHead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.chitfund.Account.AccountBean;
import com.chitfund.Account.AccountDao;
import com.chitfund.DBMS.DBMSDao;
import com.chitfund.GroupAccount.GroupAccountDao;
import com.chitfund.Groups.GroupsDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.Person.PersonDao;
import com.chitfund.PersonArrayList.PersonArrayListBean;
import com.chitfund.PersonArrayList.PersonArrayListDao;
import com.chitfund.Transaction.TransactionDao;

public class GroupHeadDao {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	DBMSDao dd=new DBMSDao();
	PersonArrayListDao pal=new PersonArrayListDao();
	PersonDao pd=new PersonDao();
	TransactionDao td=new TransactionDao();
	ArrayList<PersonBean> personAL;
	public void groupFunctions(PersonBean temp) {
		// TODO Auto-generated method stub
		System.out.println("1.Display Group Members 2.Update GroupAccountNumber 3.Group Account Details 4.Group Transfer History 5.Select Member");
		int headChoice;
		String acc;
		try {
			headChoice = Integer.parseInt(bf.readLine());
			if(headChoice==1)
			{
				//pal=dd.getGroupMembers(temp);
			}
			else if(headChoice==2)
			{
				System.out.println("Enter GroupAccountNumber : ");
				acc=bf.readLine();
				dd.updateGroupAccountNumber(temp.getGid(),acc);
			}
			else if(headChoice==3)
			{
				String accNo=dd.getGroupAccountNumber(temp.getGid());
				AccountBean ab=dd.getAccountDetails(accNo);
				AccountDao ad=new AccountDao();
				ad.displayAccountDetails(ab);
			}
			else if(headChoice==4)
			{
				td.diplayTransactions(temp);
			}
			else if(headChoice==5)
			{
				GroupAccountDao gad=new GroupAccountDao();
				PersonBean pb=gad.selectMember(temp);
				System.out.println("Selected Member : ");
				pd.display(pb);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<PersonBean> getMembers(PersonBean temp)
	{
		personAL=dd.getGroupMembers(temp);
		return personAL;
	}
	public PersonBean getSelectedMember(PersonBean temp)
	{
		GroupAccountDao gad=new GroupAccountDao();
		PersonBean pb=gad.selectMember(temp);
		dd.insertIntoSelectedMember(pb);
		return pb;
		
	}
	public PersonBean updateSelMember(PersonBean temp)
	{
		GroupAccountDao gad=new GroupAccountDao();
		PersonBean pb=gad.selectMember(temp);
		dd.updateIntoSelectedMember(pb);
		return pb;
		
	}

}
