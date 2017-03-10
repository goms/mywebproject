package com.chitfund.Person;

import java.util.Random;

public class PersonBean {
	private String username,password,name,mobileNo;
	private int pid,type,gid;
	Random rand=new Random();
	public PersonBean()
	{
		gid=2;
		type=1;
		pid=100;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int generatePID()
	{
		this.pid=((1+rand.nextInt(2))*10000)+rand.nextInt(10000);
				//rand.nextInt(100);
		//((1+rand.nextInt(2))*10000)+rand.nextInt(10000)
		return this.pid;
	}
	public void generateGID() {
		// TODO Auto-generated method stub
		if(getPid()%2==0)
		{
			setGid(1);
		}
		else
			setGid(2);
		
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

	
	
	
}
