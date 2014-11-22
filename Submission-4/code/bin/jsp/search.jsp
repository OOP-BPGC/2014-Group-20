<%-- 
    Document   : searchjsp
    Created on : 20 Nov, 2014, 11:20:06 PM
    Author     : sreejith
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	boolean approve = false;
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie: cookies) {
	if(cookie.getName().equals("username")) {
		if(!(cookie.getValue().equals(""))&&cookie.getValue()!=null)
			approve = true;

	}
}
	if(!approve) {
	response.sendRedirect("login.jsp");
}
	


%>
<html>
    <head>
        <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
           <link href="css/bootstrap-min.css" rel="stylesheet">
<link href="css/navbar-static-top.css" rel="stylesheet">
    
    <link href="css/signin.css" rel="stylesheet">
    </head>
    <body>
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
        <div>
            
            <div class="container">

            <form class="form-signin" action="searchfile.jsp">
             <h1>Search Query</h1>
            <p>Enter your Search Query</p>  
            <p> <input type="search" class="form-control" name="searchfor" required autofocus >
                 
              <p> Faculty<input class="form-control" type="radio" name="Thing" value="faculty.ser">   Volunteer<input class="form-control" type="radio" name="Thing" value="volunteers.ser">  
                  BloodDonor<input class="form-control" type="radio" name="Thing" value="donors.ser">  Institution<input class="form-control" type="radio" name="Thing" value="institutions.ser">
                      Market<input class="form-control" type="radio" name="Thing" value="markets.ser">  SHGworker<input class="form-control" type="radio" name="Thing" value="workers.ser">
              </p>
               <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Search</button>
      
            </form>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="css/bootstrap.min.js"></script>
    </body>
</html>
