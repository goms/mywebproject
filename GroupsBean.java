package com.chitfund.Groups;

import java.util.ArrayList;
import java.util.HashMap;

import com.chitfund.Person.PersonBean;

public class GroupsBean {
	
	int gid;
	
	//HashMap<Integer,HashMap<Integer,ArrayList<PersonBean>>> totalGroup=new HashMap<Integer,HashMap<Integer,ArrayList<PersonBean>>>();
	
	HashMap<Integer, Integer> groupHeads=new HashMap<Integer,Integer>();
	public HashMap<Integer, Integer> getGroupHeads() {
		return groupHeads;
	}
	
	ArrayList<PersonBean> group1Members=new ArrayList<PersonBean>();
	ArrayList<PersonBean> group2Members=new ArrayList<PersonBean>();
	ArrayList<PersonBean> groupMembers=new ArrayList<PersonBean>();
	HashMap<Integer,ArrayList<PersonBean>> hmGroup=new HashMap<Integer, ArrayList<PersonBean>>();
	HashMap<Integer,Integer> hmGroupMembers=new HashMap<Integer, Integer>();
	
	public GroupsBean()
	{
		groupHeads.put(1, 0);
		groupHeads.put(2, 0);
	}
}
