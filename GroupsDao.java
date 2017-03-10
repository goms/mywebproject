package com.chitfund.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.chitfund.DBMS.DBMSDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.Person.PersonDao;
import com.chitfund.PersonArrayList.PersonArrayListDao;

public class GroupsDao {
	GroupsBean gb=new GroupsBean();
	DBMSDao dd=new DBMSDao();
	public int checkType(PersonBean pb) {
		// TODO Auto-generated method stub
		int gid=pb.getGid();
		if(dd.insertIntoGroupHead(gid,pb.getPid()))
		{
			pb.setType(2);
			//dd.insertIntoGroupHead(gid,pb.getPid());
			return pb.getType();
		}
		if(gid==1)
			gid=2;
		else
			gid=1;
		if(dd.insertIntoGroupHead(gid,pb.getPid()))
		{
			pb.setType(2);
			pb.setGid(gid);
			//dd.insertIntoGroupHead(gid,pb.getPid());
			return pb.getType();
		}
		else
		{
			pb.setType(1);
		}
		return pb.getType();
}
	public void insertMember(PersonBean pb) {
		if(pb.getGid()==1)
		{
			gb.group1Members.add(pb);
			ArrayList<PersonBean> g1=gb.group1Members;
			gb.hmGroup.put(pb.getGid(),g1);
		}
		else
		{
			gb.group2Members.add(pb);
			ArrayList<PersonBean> g2=gb.group2Members;
			gb.hmGroup.put(pb.getGid(),g2);
		}
		
		
	}

	public void displayMembers(PersonArrayListDao pbal, PersonBean temp) {
		Set<Entry<Integer, ArrayList<PersonBean>>> gmSet=gb.hmGroup.entrySet();
		Iterator<Entry<Integer, ArrayList<PersonBean>>> gmIt=gmSet.iterator();
		PersonDao pd=new PersonDao();
		while(gmIt.hasNext())
		{
			Entry<Integer, ArrayList<PersonBean>> gmEntry=gmIt.next();
			if(gmEntry.getKey()==temp.getGid())
			{
				ArrayList<PersonBean> gmDetails=gmEntry.getValue();
				Iterator<PersonBean> pIt=gmDetails.iterator();
				while(pIt.hasNext())
				{
					PersonBean pbTemp=(PersonBean) pIt.next();
					pd.display(pbTemp);
				}
			}
			
		}
		
	}

	public  PersonBean establishHead(PersonArrayListDao pbal, PersonBean temp) {
		// TODO Auto-generated method stub
			temp=pbal.returnMember(temp);
			return temp;
			
	}


	public ArrayList<PersonBean> populateMembers(PersonBean pb) {
		// TODO Auto-generated method stub
		gb.groupMembers.add(pb);
		return gb.groupMembers;
	}

	public void displayGroupMembers(ArrayList<PersonBean> alpb) {
		// TODO Auto-generated method stub
		Iterator<PersonBean> aiT=alpb.iterator();
		PersonDao pd=new PersonDao();
		while(aiT.hasNext())
		{
			PersonBean pbTemp=(PersonBean) aiT.next();
			pd.display(pbTemp);
		}
		
	}
	
}
	


