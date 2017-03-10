package com.chitfund.GroupAccount;

import java.util.ArrayList;
import java.util.Random;

import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Person.PersonBean;

public class GroupAccountDao {
	DBMSDao dd=new DBMSDao();
	public PersonBean selectMember(PersonBean temp) {
		ArrayList<PersonBean> alpb=dd.getMembers(temp);
		int size=alpb.size();
		Random rand=new Random();
		int index=rand.nextInt(size)+1;
		PersonBean pb=alpb.get(index);
		return pb;
	}
}
