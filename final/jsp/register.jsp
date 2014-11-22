<!DOCTYPE html>
<% 
	boolean approve = false;
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie: cookies) {
	if(cookie.getName().equals("designation")) {
		if(cookie.getValue().equals("PRESIDENT"))
			approve = true;

	}
}
	if(!approve) {
	response.sendRedirect("login.jsp");
}
	


%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Registration - Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    <link href="css/navbar-static-top.css" rel="stylesheet">

    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
  <%@ page import="nirmaan.Designation,nirmaan.Member,java.io.File" %>
  	 <nav class="navbar navbar-default navbar-static-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">NIRMAAN</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="main.jsp">Home</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Events<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="events.jsp">Add Event</a></li>
                <li><a href="calendar.jsp">View Calendar</a></li>
                <li><a href="approveevents.jsp">Approve Event</a></li>
                
               
              </ul>
            </li>
            <li><a href="search.jsp">Search</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Add<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="register.jsp">Member</a></li>
                <li><a href="addinstitution.jsp">Institution</a></li>
                <li><a href="addVolunteer.jsp">Volunteer</a></li>
                <li><a href="addBloodDonor.jsp">Blood Donor</a></li>
                <li><a href="addStudent.jsp">Student</a></li>
                <li><a href="addmarket.jsp">Market</a></li>
                 <li><a href="AddFaculty.jsp">Faculty</a></li>
                <li><a href="AddSHGworker.jsp">SHG Worker</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Transaction <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="addFunds.jsp">Add Funds</a></li>
                <li><a href="addTransaction.jsp">Make Transaction</a></li>
                <li><a href="approve.jsp">Approve Transactions</a></li>
                <li><a href="viewTransactions.jsp">View Transactions</a></li>
               
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
           
            <li><a href="logout.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
	
	<%	
		File file = new File("members.ser");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confpassword");
		String name = request.getParameter("name");
		boolean pass = true;
		String trial ="";
		String message = "";
		String contact = request.getParameter("contact");
		String item = request.getParameter("designation");
		if(password!=null && confpassword!=null) {
		if(!password.equals(confpassword)) {

			message = "Passwords should match!"; 
			pass= false;}
	}
	
		  if(name == null) {
		
      	name = "";
      }
      
      if(username == null) {
      	username = "";
      }
     	 if(contact == null) {
        contact = "";
       }
       if(item == null) {
       	item = "";
   }
		Designation designation;
			if(item.equals("president")) {
				designation = Designation.PRESIDENT;
			}
			else if(item.equals("prhead")) {
				designation = Designation.PRHEAD;
			}
			else if(item.equals("treasurer")) {
				designation = Designation.TREASURER;
				
			}
			else {
				designation = Designation.GENERAL;
			}
		if(name != null && username != null && password !=null && pass) {
		
		Member member = new Member(name,contact,username,password,designation);
		boolean status = member.register();
		String registered="";
		if(!status) {
		message= "Try Again! Username already registered.";
	}
		else {
	
		message = "You have been registered";
	}}
	%>
	



    <div class="container">

      <form class="form-signin" role="form" method="post" action="/register.jsp">
       	<h1 style="margin-left:70px"> Nirmaan </h1>
       	
        <input name="username" type="text" class="form-control" placeholder="Username" value="<%=username%>" required autofocus>
        <input name="password" type="password" class="form-control" placeholder="Password">
        <input name="confpassword" type="password" class="form-control" placeholder="Confirm Password">
        <input name="name" type="text" class="form-control" placeholder="Name" value="<%=name%>">
        <input name="contact" type="text" class="form-control" placeholder="Contact Details" value="<%=contact%>"> 
        <select name ="designation" class="form-control">
	   		<option value="president">President</option>
  	   		<option value="prhead">PR Head</option>
       		<option value="member">Member</option>
        	<option value="treasurer">Treasurer</option>
       </select>
       <br>

       <span style="color:red"><%=message%></span>
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Register</button>
      </form>

    </div> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="css/bootstrap.min.js"></script>
    
  </body>
</html>