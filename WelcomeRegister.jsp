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
  <link rel="stylesheet" href="FirstPage.css">
  <script src="js/Validate.js" type="text/javascript"></script>
  <style type="text/css">
#accountform .has-error .control-label,
#accountform .has-error .help-block,
#accountform .has-error .form-control-feedback {
    color: #f39c12;
}

#accountform .has-success .control-label,
#accountform .has-success .help-block,
#accountform .has-success .form-control-feedback {
    color: #18bc9c;
}
</style>
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
        <li><a>Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="containers">
	<p>
			<h1>
					 Set up your Account 
			</h1>		
</div>

<div class="containerForm" id="centered">
	<div class=row>
		
		<div class="col-lg-12">
		
		<form id="accountform" method="POST" action="ARegister">
		<div class="form-group from-group-lg">
			<label for="accountNumber" class="control-label">Account Number</label>
			<div class="input-group">
			<input type="text" id="accountNumber" placeholder="XXXXXX98" class="form-control" name="accountNumber" required>
			<span class="input-group"></span>
			</div>
		</div>
		<div class="form-group from-group-lg">
			<label for="bankName" class="control-label">BankName </label>
			<div class="input-group">
			<select autofocus class="form-control" id="bankName" name="bankName">
				<option value="icici">ICICI</option>
				<option value="sbi">SBI</option>
				<option value="cub">CUB</option>
				<option value="hdfc">HDFC</option>
			</select>
			</div>
		
		</div>
	<div class="formgroup from-group-lg">
		<input type="submit" id="submitAccount" value="Update" class="btn btn-default float-xs-right">
	</div>
	</form>
		
		</div>
		
	</div>

</div>
</body>
</html>