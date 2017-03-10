package com.chitfund.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.chitfund.Account.AccountDao;
import com.chitfund.DBMS.DBMSDao;
import com.chitfund.GroupHead.GroupHeadDao;
import com.chitfund.Groups.GroupsDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.PersonArrayList.PersonArrayListDao;
import com.chitfund.User.UserFunctionalityDao;

public class LoginDao {
	BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	PersonArrayListDao pbal=new PersonArrayListDao();
	GroupsDao ga=new GroupsDao();
	GroupHeadDao gh=new GroupHeadDao();
	UserFunctionalityDao ufd=new UserFunctionalityDao();
	DBMSDao dd=new DBMSDao();
	AccountDao ad=new AccountDao();
	public PersonBean register(String name, String uname, String mobno, String pswd, String types){
		// TODO Auto-generated method stub
		
		PersonBean pb=new PersonBean();
					int type=Integer.parseInt(types);
					int isUser=1;
					pb.setName(name);
					pb.setUsername(uname);
					pb.setPassword(pswd);
					pb.setMobileNo(mobno);
					pb.setType(type);
					pb.generatePID();
					pb.generateGID();
					pbal.insert(pb);
					if(type==2)
					{
						type=ga.checkType(pb);
						if(type==1)
							isUser=1;
						else
							isUser=2;
					}
					ga.insertMember(pb);
					dd.insertIntoPersonDetails(pb);
					/*ad.getAccountDetails(pb);
					dd.addToGroup(pb.getGid(),pb.getPid());*/
					return pb;
		
	}
	
	public void login() {
		// TODO Auto-generated method stub
		PersonBean temp=new PersonBean();
		
		int pid;
		String pswd;
		boolean check=true;
		try {
			System.out.println("Enter User ID : ");
			pid = Integer.parseInt(bf.readLine());
			temp.setPid(pid);
			System.out.println("Enter Password : ");
			pswd=bf.readLine();
			temp.setPassword(pswd);
			check=dd.getLoginDetails(temp);
			if(check==true)
			{
				System.out.println("Login Successful ");
				temp=dd.getPersonBean();
				if(temp.getType()==1)
				{
					System.out.println("User");
					ufd.userFunctions(dd.getPersonBean());
				}
				else
				{
					System.out.println("Admin");
					//gh.groupHeadFunctionality(ga,pbal,temp);
					gh.groupFunctions(temp);
				}
				
			}
			else
			{
				System.out.println("Enter correct credentials");
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
