package com.chitfund.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.chitfund.ConnectionManager.ConnectionManager;

public class PersonDao {
	
	public static void getDetails(int pid) {
		
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		List<PersonBean> personList = null;
		ResultSet resultset = null;
		
		String searchQuery = "SELECT *  from T_XBBNHDC_PersonDetails where PID = ?  ";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, pid);		
			
			 resultset = stmt.executeQuery();	
			
			 personList = new ArrayList<PersonBean>();
			 
			while(resultset.next()) {
				PersonBean pBean = new PersonBean();
				
				pBean.setPid(resultset.getInt(1));
				pBean.setGid(resultset.getInt(2));
				pBean.setUsername(resultset.getString(3));
				pBean.setName(resultset.getString(4));
				
				
				personList.add(pBean);
				Iterator<PersonBean> itr =  personList.iterator();
				while(itr.hasNext()){
					PersonBean pwBean = itr.next();
					System.out.println(pwBean.getPid()+ " : "+ pwBean.getName()+ "   "+ pwBean.getUsername()+ "   "+ pwBean.getGid());
				
			}
			}
		}
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			try {
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		// TODO Auto-generated method stub
		
	}

	public static void setValues(int i, String string, String string2, int j) {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		
		System.out.println("Inserting.......");
		String searchQuery = "INSERT INTO T_XBBNHDC_PersonDetails VALUES( ? , ? , ? , ? )";
		try {
			 stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, i);
			stmt.setInt(2, j);
			stmt.setString(3, string);
			stmt.setString(4, string2);
			
			stmt.executeQuery();	
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}	
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}

	public static void updateValues(int i, int j) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		try {
			stmt=conn.prepareStatement("update T_XBBNHDC_PersonDetails set gid=? where uid=?");
			stmt.setInt(1, i);
			stmt.setInt(2, j);
			stmt.executeQuery();
			getDetails(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
		
		
		
	}

	public static void display() {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		Statement stmt = null;
		
		List<PersonBean> personList = null;
		ResultSet resultset = null;
		
		String searchQuery = "SELECT *  from T_XBBNHDC_PersonDetails";
		try {
			 stmt = conn.createStatement();
			 resultset = stmt.executeQuery(searchQuery);	
			
			 personList = new ArrayList<PersonBean>();
			 
			while(resultset.next()) {
				PersonBean pBean = new PersonBean();
				
				pBean.setPid(resultset.getInt(1));
				pBean.setGid(resultset.getInt(2));
				pBean.setUsername(resultset.getString(3));
				pBean.setName(resultset.getString(4));
				
				
				personList.add(pBean);
				Iterator<PersonBean> itr =  personList.iterator();
				while(itr.hasNext()){
					PersonBean pwBean = itr.next();
					System.out.println(pwBean.getPid()+ " : "+ pwBean.getName()+ "   "+ pwBean.getUsername()+ "   "+ pwBean.getGid());
				
			}
			}
		}
			 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally{
			try {
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	public static void delValues(int i) {
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String query="delete from T_XBBNHDC_PersonDetails where pid=?";
		try {
			stmt=conn.prepareStatement(query);
			stmt.setInt(1, i);
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				
				if(resultset != null)
				resultset.close();
				if(stmt != null)					
				stmt.close();				
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		// TODO Auto-generated method stub
		
	}

	public void display(PersonBean pbtemp) {
		// TODO Auto-generated method stub
		System.out.println("User Details : ");
		
		System.out.println("User ID : "+pbtemp.getPid());
		System.out.println("Group ID : "+pbtemp.getGid());
		System.out.println("Name : "+pbtemp.getName());
		System.out.println("Mobile Number : "+pbtemp.getMobileNo());
		System.out.println(pbtemp.getType()==2?"Type : Head":"Type : User");
		
	}
	public void getPersonDetails(int userid)
	{
		
	}
	
	
	

}
