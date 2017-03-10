package com.chitfund.PersonArrayList;

import java.util.ArrayList;
import java.util.HashMap;

import com.chitfund.Person.PersonBean;

public class PersonArrayListBean {
	ArrayList<PersonBean> PbAL=new ArrayList<PersonBean>();
	HashMap<Integer,PersonBean> hmPersonList=new HashMap<Integer, PersonBean>();
	public void sethmPersonList(PersonBean pb)
	{
		hmPersonList.put(pb.getPid(),pb);
	}
	
	
}
