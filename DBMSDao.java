package com.chitfund.DBMS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import oracle.sql.DATE;

import com.chitfund.Account.AccountBean;
import com.chitfund.ConnectionManager.ConnectionManager;
import com.chitfund.Groups.GroupsDao;
import com.chitfund.Person.PersonBean;
import com.chitfund.PersonArrayList.PersonArrayListDao;
import com.chitfund.Transaction.TransactionBean;
import com.chitfund.Transaction.TransactionDao;

public class DBMSDao {
	PersonBean pBean=new PersonBean();
	public PersonBean getPersonBean()
	{
		return pBean;
	}

	public void insertIntoPersonDetails(PersonBean pb) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO Personetails VALUES( ? , ? , ? , ? , ? , ? , ? )";
		try
		{
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1,pb.getPid());
			stmt.setString(2, pb.getUsername());
			stmt.setString(3, pb.getName());
			stmt.setString(4, pb.getPassword());
			stmt.setInt(5, pb.getType());
			stmt.setString(6, pb.getMobileNo());
			stmt.setInt(7,pb.getGid());
			stmt.executeQuery();
		}
		catch (SQLException e) {
			
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

	public boolean getLoginDetails(PersonBean temp) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		boolean check=true;
		new PersonBean();
		String searchQuery = "SELECT *  from  Personetails where PID = ?  ";
		PersonArrayListDao pald=new PersonArrayListDao();
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, temp.getPid());
			resultset = stmt.executeQuery();	
			
			while(resultset.next()) {
				
				pBean.setPid(resultset.getInt(1));
				pBean.setUsername(resultset.getString(2));
				pBean.setName(resultset.getString(3));
				pBean.setPassword(resultset.getString(4));
				int type=resultset.getInt(5);
				pBean.setType(type);
				pBean.setMobileNo(resultset.getString(6));
				pBean.setGid(resultset.getInt(7));
				 check=pald.verify(pBean,temp);	
				 return check;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			
		return false;
		
		
	}

	public AccountBean getAccountDetails(PersonBean personBean) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from  accountdetail where pid = ?  ";
		AccountBean ab = null;
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, personBean.getPid());
			resultset = stmt.executeQuery();	
			
			while(resultset.next())
			{
				ab=new AccountBean();
				
				ab.setBalance(resultset.getInt(1));
				ab.setBankname(resultset.getString(2));
				int pid=resultset.getInt(3);
				ab.setAccountNumber(resultset.getString(4));
				ab.setPersondetails(personBean);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		return ab;
	}

	public boolean insertIntoAccountDetail(AccountBean ab) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		boolean flags;
		String searchQuery = "INSERT INTO accountdetail VALUES( ? , ? , ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,ab.getBalance());
				stmt.setString(2, ab.getBankname());
				PersonBean pb=ab.getPersondetails();
				stmt.setInt(3, ab.getPersondetails().getPid());
				stmt.setString(4, ab.getAccountNumber());
				stmt.executeQuery();
				flags=true;
				int gid=pb.getGid();
				if(pb.getType()==2)
					updateGroupAccountNumber(gid,ab.getAccountNumber());
				return true;
			}
			catch (SQLException e) {
				return false;
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
					}
			}
		
		
		
	}

	public boolean isAccountNumberPresent(String accno) {
		// TODO Auto-generated method stub
		boolean check=false;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "select * from accountdetail where accnum = ? ";
		try
		{
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1,accno);
			resultset=stmt.executeQuery();
			if(resultset!=null)
			{
				check=true;
			}
		}
		catch (SQLException e) {
			
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
		
		return check;
	}

	public void addToGroup(int gid,int pid) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO groupPersonDetail VALUES( ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,gid);
				stmt.setInt(2, pid);
				stmt.executeQuery();
			}
			catch (SQLException e) {
				
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
					}
			}
		
		
		
		
	}

	public ArrayList<PersonBean> getGroupMembers(PersonBean temp) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from  groupPersonDetail where gid = ?  ";
		ArrayList<PersonBean> alpb=new ArrayList<PersonBean>();
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, temp.getGid());
			resultset = stmt.executeQuery();	
			
			while(resultset.next()) {
				int gid=resultset.getInt(1);
				int pid=resultset.getInt(2);
				PersonBean pb=getPersonDetails(pid);
				alpb.add(pb);
			}			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
			return alpb;
		
		
	}

	public PersonBean getPersonDetails(int pid) {
		// TODO Auto-generated method stub
		PersonBean pTemp=new PersonBean();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from  Personetails where PID = ?  ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, pid);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				pTemp.setPid(resultset.getInt(1));
				pTemp.setUsername(resultset.getString(2));
				pTemp.setName(resultset.getString(3));
				pTemp.setPassword(resultset.getString(4));
				pTemp.setType(resultset.getInt(5));
				pTemp.setMobileNo(resultset.getString(6));
				pTemp.setGid(resultset.getInt(7));
				
			}
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return pTemp;
	}

	public void updateGroupAccountNumber(int gid, String acc) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO groupTable VALUES( ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,gid);
				stmt.setString(2, acc);
				stmt.executeQuery();
			}
			catch (SQLException e) {
				
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
					}
			}
		
		
		
	}


	public boolean isAmountAvailable(String fromaccountnumber, int amount) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from accountdetail where accnum = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, fromaccountnumber);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				
				int balance=resultset.getInt(1);
				String bname=resultset.getString(2);
				int pid=resultset.getInt(3);
				String acc=resultset.getString(4);
				if(balance>amount)
				{
					return true;
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return false;
	}

	public String getGroupAccountNumber(int gid) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String toAcc = null;
		String searchQuery = "SELECT * from groupTable where gid =  ?  ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, gid);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				
				toAcc=resultset.getString("groupaccountnumber");
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		
		return toAcc;
	}
	public void insertIntoTransactionTable(int tno, String fromaccountnumber,
			String toAcc, int amount) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO transactionDetail VALUES( ? , ? , ? , ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,tno);
				stmt.setString(2, fromaccountnumber);
				stmt.setString(3, toAcc);
				stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				stmt.setInt(5, amount);
				stmt.executeQuery();
			}
			catch (SQLException e) {
				
				//e.printStackTrace();
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
					}
			}	
	}

	public void updateFromAmount(String fromaccountnumber, int amount) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		int balance=getAmount(fromaccountnumber);
		balance=balance-amount;
		String searchQuery = "update accountdetail set balance = ? where accnum = ? ";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,balance);
				stmt.setString(2, fromaccountnumber);
				stmt.executeQuery();
			}
			catch (SQLException e) {
				
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
					}
			}	
		
		
		
	}

	public int getAmount(String fromaccountnumber) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from accountdetail where accnum = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, fromaccountnumber);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				
				int balance=resultset.getInt(1);
				String bname=resultset.getString(2);
				int pid=resultset.getInt(3);
				String acc=resultset.getString(4);
				return balance;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		return 0;
	}

	public void updateToAmount(String fromaccountnumber, int amount) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		int balance=getAmount(fromaccountnumber);
		balance=balance+amount;
		String searchQuery = "update accountdetail set balance = ? where accnum = ? ";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,balance);
				stmt.setString(2, fromaccountnumber);
				stmt.executeQuery();
			}
			catch (SQLException e) {
				
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
					}
			}		
	}
	
	
	public String getAccountNumber(PersonBean pb) {
		// TODO Auto-generated method stub
		//boolean check=false;
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "select * from accountdetail where pid = ? ";
		try
		{
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1,pb.getPid());
			resultset=stmt.executeQuery();
			while(resultset.next())
			{
				int balance=resultset.getInt(1);
				String bname=resultset.getString(2);
				int pid=resultset.getInt(3);
				String acc=resultset.getString(4);
				return acc;
			}
		}
		catch (SQLException e) {
			
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
		
		return "notpresent";
	}

	public AccountBean getAccountDetails(String accNo) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from  accountdetail where accnum = ?  ";
		AccountBean ab = null;
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, accNo);
			resultset = stmt.executeQuery();	
			
			while(resultset.next())
			{
				ab=new AccountBean();
				
				ab.setBalance(resultset.getInt(1));
				ab.setBankname(resultset.getString(2));
				int pid=resultset.getInt(3);
				PersonBean pb=getPersonDetails(pid);
				ab.setPersondetails(pb);
				ab.setAccountNumber(resultset.getString(4));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return ab;
	}

	public ArrayList<TransactionBean> getFromTransactionDetails(String fromaccountnumber) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmts = null;
		ResultSet resultset = null;
		TransactionBean tb=new TransactionBean();
		TransactionDao td=new TransactionDao();
		ArrayList<TransactionBean> al=new ArrayList<TransactionBean>();
		String searchQuery = "SELECT * from transactionDetail where fromAccount = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, fromaccountnumber);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				tb.setTno(resultset.getInt(1));
				tb.setFromAccount(resultset.getString(2));
				tb.setToAccount(resultset.getString(3));
				tb.setDate(resultset.getTimestamp(4));
				tb.setAmount(resultset.getInt(5));
				al.add(tb);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();
				if(stmts != null)					
					stmts.close();	
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return al;
		
		
		
		
		
		
		
		
		
		
		
	}

	public ArrayList<PersonBean> getMembers(PersonBean temp) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT *  from  groupPersonDetail where gid = ?  ";
		GroupsDao gd=new GroupsDao();
		ArrayList<PersonBean> alpb=new ArrayList<PersonBean>();
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, temp.getGid());
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				int gid=resultset.getInt(1);
				int pid=resultset.getInt(2);
				PersonBean pb=getPersonDetails(pid);
				alpb.add(pb);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			return null;
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
			return alpb;
	}

	public boolean isHeadPresent(int gid) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		boolean check=false;
		String searchQuery = "SELECT *  from  groupHead where gid = ?  ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, gid);
			resultset = stmt.executeQuery();	
			if(resultset!=null)
			{
				check=true;
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
				 
				}
		}
		return check;
	}

	public boolean insertIntoGroupHead(int gid, int pid) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO groupHead VALUES( ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,gid);
				stmt.setInt(2,pid);
				stmt.executeQuery();
				return true;
			}
			catch (SQLException e) {
				
				return false;
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
	public String getAccountNumberPID(int pid)
	{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		ResultSet resultset = null;
		String searchQuery = "select * from accountdetail where pid = ? ";
		try
		{
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1,pid);
			resultset=stmt.executeQuery();
			while(resultset.next())
			{
				int balance=resultset.getInt(1);
				String bname=resultset.getString(2);
				int pids=resultset.getInt(3);
				String acc=resultset.getString(4);
				return acc;
			}
		}
		catch (SQLException e) {
			
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
		
		return "notpresent";
	}

	public ArrayList<TransactionBean> getToTransactionDetails(String acc) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmts = null;
		ResultSet resultset = null;
		//TransactionBean tb=new TransactionBean();
		ArrayList<TransactionBean> al=new ArrayList<TransactionBean>();
		String searchQuery = "SELECT * from transactionDetail where toAccount = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setString(1, acc);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {
				TransactionBean tb=new TransactionBean();
				tb.setTno(resultset.getInt(1));
				tb.setFromAccount(resultset.getString(2));
				tb.setToAccount(resultset.getString(3));
				tb.setDate(resultset.getTimestamp(4));
				tb.setAmount(resultset.getInt(5));
				//System.out.println(tb.getTno());
				al.add(tb);
			}
			Iterator<TransactionBean> it=al.iterator();
			while(it.hasNext())
			{
				TransactionBean t=it.next();
				System.out.println(t.getTno());
			}
			
			return al;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();
				if(stmts != null)					
					stmts.close();	
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return al;
		
		
	}

	public void insertIntoSelectedMember(PersonBean pb) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO selectedMember VALUES( ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,pb.getGid());
				stmt.setInt(2,pb.getPid());
				stmt.executeQuery();
				insertIntoSelectedMemberHistory(pb.getGid(),pb.getPid());
			}
			catch (SQLException e) {
				
				
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
					 //e.printStackTrace();
					 
					}
			}	
		
	}
	public PersonBean getSelectedMember(int gid)
	{
		PersonBean pSel=new PersonBean();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmts = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from selectedMember where gid = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, gid);
			pSel.setPid(00);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {	
				pSel.setGid(resultset.getInt(1));
				int n=resultset.getInt(2);
				pSel=getPersonDetails(n);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();
				if(stmts != null)					
					stmts.close();	
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return pSel;
		
	}
	public boolean isSelMember(int gid)
	{
		//PersonBean pSel=new PersonBean();
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		PreparedStatement stmts = null;
		ResultSet resultset = null;
		String searchQuery = "SELECT * from selectedMember where gid = ? ";
		try {
			stmt = conn.prepareStatement(searchQuery);
			stmt.setInt(1, gid);
			//pSel.setPid(00);
			resultset = stmt.executeQuery();	
			while(resultset.next()) {	
				//pSel.setGid(resultset.getInt(1));
				int gidt=resultset.getInt(1);
				int pid=resultset.getInt(2);
				//pSel=getPersonDetails(n);
				return true;
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		finally{
			try {
				
				if(stmt != null)					
				stmt.close();
				if(stmts != null)					
					stmts.close();	
				conn.commit();
				if(conn != null)
				conn.close();
			}			
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return false;
		
	}

	public void updateIntoSelectedMember(PersonBean pb) {
		// TODO Auto-generated method stub
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "update selectedMember set pid = ? where gid = ? ";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,pb.getPid());
				stmt.setInt(2,pb.getGid());
				stmt.executeQuery();
				insertIntoSelectedMemberHistory(pb.getGid(),pb.getPid());
			}
			catch (SQLException e) {
				
				
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
					 //e.printStackTrace();
					 
					}
			}	
		
		
	}
	public void insertIntoSelectedMemberHistory(int gid,int pid) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement stmt = null;
		String searchQuery = "INSERT INTO selMemHist VALUES( ? , ? , ? )";
			try
			{
				stmt = conn.prepareStatement(searchQuery);
				stmt.setInt(1,gid);
				stmt.setInt(2,pid);
				stmt.setTimestamp(3,new java.sql.Timestamp(System.currentTimeMillis()));
				stmt.executeQuery();
				
			}
			catch (SQLException e) {
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
					 //e.printStackTrace();
					 
					}
			}	
		
	}


	


	
	
}
