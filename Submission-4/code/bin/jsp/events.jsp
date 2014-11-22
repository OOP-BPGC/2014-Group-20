<%@page import="nirmaan.Event"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>

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
<%  String Name = request.getParameter("Name");
    String Sd = request.getParameter("StartDate");
    String Ed = request.getParameter("EndDate");
    String Activityno = request.getParameter("activityno");
    String message="";
    boolean pass=true;
    if(Name==null)Name="";
    if(Sd==null){Sd="0000-00-00";}
    if(Ed==null){Ed="0000-00-01";}
    if(Activityno==null){Activityno="0";}
    Date Sdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(Sd);
    Date Edate = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(Ed);
    if(Sdate.after(Edate))
    {message="Start date cant be after end date"; pass=false;}
    //out.println(Sdate);
    
    %>
<html lang="en">
  <head>
      <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>EventRequest - Nirmaan</title>

    
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
	
	

    <div class="container">

      <form class="form-signin" role="form" method="post" action="events.jsp">
       	<h1 style="margin-left:70px">Add Event </h1>
       	
        <input name="Name" type="text" class="form-control" placeholder="EventName" value="<%=Name%>" required autofocus></p>
        <input name="StartDate" type="date" class="form-control"  min="2014-11-20" value ="<%=Sd%> "required >
                <input name="EndDate" type="date" class="form-control" min="2014-11-21" value = "<%=Ed%> " required ></p>
        <span style="color:red"><%=message%></span>
        <p>No of activities <input name="activityno" type="range" class="form-control" min="0" max="7" value="<%=Integer.parseInt(Activityno)%>">
            </p>
         <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Add Event</button>
       <br>

       
       <br>
       <br>
        
       <form action="eventprocess.jsp">
          <%for(int i=1;i<=Integer.parseInt(Activityno);i++)
        {
     
        %> <p>Activity<%=i%><input type="text" name="activity<%=i%>">  Date: <input type="date" name="activitydate<%=i%>"> </p>
        <%
        
    }if(!(Integer.parseInt(Activityno)==0)&&pass==true){
          %><p> <input type="submit" formaction="eventprocess.jsp" value="register">
                    
      </form>
          <%
    }
        %>

    </div> 


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="css/bootstrap.min.js"></script>
  </body>
</html>