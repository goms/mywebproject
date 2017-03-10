<%@page import="com.chitfund.DBMS.DBMSDao"%>
<%@page import="com.Servlets.AccountRegister"%>
<%@page import="com.chitfund.Account.AccountBean"%>
<%@page import="com.chitfund.Account.AccountDao"%>
<%@page import="com.chitfund.Person.PersonBean"%>
<%@page import="com.chitfund.Transaction.TransactionBean"%>
<%@page import="com.chitfund.Transaction.TransactionDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
  function sendSuccess()
  {
		alert("Money Sent");
		return true;
  }
  </script>
  <link rel="stylesheet" href="FirstPage.css">
<title>Online Chit Fund</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="FirstPage.html">Online Chit Fund</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a>Login</a></li>
        <li><a>Register</a></li>
        <li><a href="<%=request.getContextPath()%>/ULogOut">Log Out</a></li>
      </ul>
    </div>
  </div>
</nav> 
 <div class="container">
 <div class="row">
 <h3>Welcome...</h3> 
 <%	
 		PersonBean pp=(PersonBean)session.getAttribute("person");
		int gid=pp.getGid();
		int pid=pp.getPid();
		int type=pp.getType();
		DBMSDao ddAcc=new DBMSDao();
		String accNo=ddAcc.getAccountNumberPID(pid);
		AccountBean abc=ddAcc.getAccountDetails(accNo);
		String bname=abc.getBankname();
		int balance=abc.getBalance();
		String fAcc=accNo;
		String tAcc=ddAcc.getGroupAccountNumber(gid);
 %>
 </div>
 </div>
 <div class="row2">
 	<ul class="nav nav-pills">
 		<li class="nav-item">
 			<a class=nav-link href="#profile" data-toggle="collapse">Profile</a>
 		</li>
 		<li class="nav-item">
 			<a class=nav-link href="#account" data-toggle="collapse">Account Details</a>
 		</li>
 		<li class="nav-item">
 			<a class=nav-link href="#selMember" data-toggle="collapse">Selected Member</a>
 		</li>
 		<li class="nav-item">
 			<a class=nav-link href="#transferMoney" data-toggle="collapse">Transfer Money</a>
 		</li>
 	</ul>
 </div>
 <div class="rows">
 <div class="col-lg-2">
 </div>
 <div class="col-lg-8">
 	<div id="profile" class="collapse">
 		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th>Group ID</th>
 					<th>Person ID</th>
 					<th>Type</th>
 				</tr>
 			</thead>
 			<tbody>
 				<tr>
 						<td>
 							<%=gid%>
 							
 						</td>
 						<td>
 							<%=pid%>
 						</td>
 						<td>
 							USER
 						</td>
 				</tr>
 			</tbody>
 		</table>
 	</div>
	<div class="collapse" id="account">
		<table class="table table-hover">
			<thead>		
				<tr>
 					<th>Account Number</th>
 					<th>Bank Name</th>
 					<th>Balance</th>
 				</tr>
			</thead>
			<tbody>
				<tr>
 						<td>
 							<%=accNo %>
 						</td>
 						<td>
 							<%=bname %>
 						</td>
 						<td>
 							<%=balance %>
 						</td>
 				</tr>
 				<tr>
					<td colspan="3" align="center">
						<a href="#transactiontable" data-toggle="collapse">
							<button type="button" class="btn btn-outline">Transactions</button>
						</a>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="collapse" id="selMember">
		<table class="table table-hover">
			<thead>		
				<tr>
 					<th>Account Number</th>
 					<th>PID</th>
 					<th>Name</th>
 					
 				</tr>
			</thead>
			<tbody>
			<% PersonBean pSel=ddAcc.getSelectedMember(gid);
				if(pSel.getPid()==00)
				{
				}
				else
				{%>
					<tr>
						<td><%=tAcc %></td>
	 				
						<td><%=pSel.getPid() %></td>
					
						<td><%=pSel.getUsername() %></td>
					</tr>
				<%}
			%>
				
			</tbody>
		</table>
	</div>
	<div class="collapse" id="transactiontable">
			<table class="table table-hover table-striped">
				<thead>		
					<tr>
 					<th>Transaction No</th>
 					<th>From Account</th>
 					<th>To Account</th>
 					<th>Amount</th>
 					<th>Date</th>
 					</tr>
				</thead>
				<tbody>
					<% 	
						TransactionDao td=new TransactionDao();
						ArrayList<TransactionBean> alFrom=ddAcc.getFromTransactionDetails(accNo);
						Iterator<TransactionBean> itF=alFrom.iterator();
						ArrayList<TransactionBean> alTo=ddAcc.getToTransactionDetails(accNo);
						Iterator<TransactionBean> itT=alTo.iterator();
						%>
							<% 	while(itF.hasNext()) 
								{
								TransactionBean tb=itF.next();%>
								<tr>
								<td><%=tb.getTno() %></td>
								<td><%=tb.getFromAccount() %></td>
								<td><%=tb.getToAccount() %></td>
								<td><%=tb.getAmount() %></td>
								<td><%=tb.getDate() %></td>
								</tr>
								<% } %>
							<% 	while(itT.hasNext()) 
								{
									TransactionBean tb=itT.next();%>
								<tr>
								<td><%=tb.getTno() %></td>
								<td><%=tb.getFromAccount() %></td>
								<td><%=tb.getToAccount() %></td>
								<td><%=tb.getAmount() %></td>
								<td><%=tb.getDate() %></td>
								</tr>
								<% } %>	
				</tbody>
			</table> 
	</div>
	<div class="collapse" id="transferMoney">
			<div class="row">
				<form method="post" action="UTransferMoney" id="sendMoney" onsubmit="return sendSuccess()"> 
					<div class="col-lg-4">
					</div>
					<div class="col-lg-4" align="center">
						<div class="form-group">
							<label for="fAcc">From Account</label>
							<div class="input-group">
								<input type="text" id="fAcc" value="<%=fAcc %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="TAcc">To Account</label>
							<div class="input-group">
								<input type="text" id="TAcc" value="<%=tAcc %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="Tamount">Enter Amount</label>
							<div class="input-group">
								<input type="number" id="Tamount" min=100 max=<%=tAcc %> name="Tamount"> 
							</div>
						</div>
						<div id="form-group">
							<input type="submit" value="SendMoney" class="btn btn-default float-xs-right"> 
						</div>
					</div>
					<div class="col-lg-4">
					</div>
				</form>
			</div>
		</div>
	<div class="col-lg-2">
	</div> 	
 </div>
 </div>
</body>
</html>