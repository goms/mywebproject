package com.chitfund.PersonArrayList;

import com.chitfund.Person.PersonBean;
import com.chitfund.Person.PersonDao;

public class PersonArrayListDao {
	
	PersonArrayListBean personArrayList=new PersonArrayListBean();
	public void insert(PersonBean pb) {
		// TODO Auto-generated method stub
		personArrayList.sethmPersonList(pb);
		
	}
	public boolean verify(PersonBean temp) {
		// TODO Auto-generated method stub
		
		
		if(personArrayList.hmPersonList.containsKey(temp.getPid()))
		{
			PersonBean pbtemp=personArrayList.hmPersonList.get(temp.getPid());
					
			if(temp.getPassword().equals(pbtemp.getPassword()))
					{
						return true;
						
					}
					
		}
		return false;
	}
	public void displayDetails(PersonBean temp) {
		// TODO Auto-generated method stub
		if(personArrayList.hmPersonList.containsKey(temp.getPid()))
		{
			PersonBean pbtemp=personArrayList.hmPersonList.get(temp.getPid());
			PersonDao pdao=new PersonDao();
			System.out.println("User Details : ");
			pdao.display(pbtemp);
		}
		
	}
	public PersonBean returnMember(PersonBean temp) {
		// TODO Auto-generated method stub
		if(personArrayList.hmPersonList.containsKey(temp.getPid()))
		{
			PersonBean pbtemp=personArrayList.hmPersonList.get(temp.getPid());
			return pbtemp;
		}
		return null;
	}
	public boolean verify(PersonBean pBean, PersonBean temp) {
		// TODO Auto-generated method stub
		if(pBean.getPid()==temp.getPid())
		{
			if(pBean.getPassword().equals(temp.getPassword()))
			{
				return true;
			}
		}
		return false;
	}
	
	

}
