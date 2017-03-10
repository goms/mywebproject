<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <script>
  	function showSuccess()
  	{
  		$('#successlogin').show();
  	}
  </script>
  
  <script src="js/loginJS.js"></script>
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
        <li><a href="Login.html">Login</a></li>
        <li><a href="Register.html">Register</a></li>
        <li><a>Log Out</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container" id="centered">
    <div class="row">
        <form method="Post" action="">
        	<div class="col-lg-4">
        	</div>
            <div class="col-lg-4">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Required Field</strong></div>
                <div class="form-group">
                    <label for="InputUserName">Enter User ID</label>
                    <div class="input-group">
                        <input type="number" class="form-control" id="InputUserID" name="InputUserID" placeholder="XX123" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="InputPassword">Enter Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="InputPasswords" name="InputPasswords" placeholder="*******" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
                <input type="submit" name="login" id="login" value="Login" class="btn btn-default float-xs-right" onclick="showSuccess();" >
            </div>
            <div class="col-lg-4">
        	</div>
        </form>
    </div>
    <div class="row">
    <div class="alert alert-success fade in collapse" id="successlogin" style="display:none;">
    		<a href="#" class="close" data-dismiss="alert" >&times;</a>
    		<span><strong>Success!</strong> Login Successful!</span>
		</div>
    </div>
    
</div>
</body>


</html>