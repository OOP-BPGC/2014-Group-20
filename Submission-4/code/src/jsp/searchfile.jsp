<%-- 
    Document   : searchfile
    Created on : 20 Nov, 2014, 11:52:41 PM
    Author     : sreejith
--%>

<%@page import="nirmaan.SHGworker"%>
<%@page import="nirmaan.Market"%>
<%@page import="nirmaan.Institution"%>
<%@page import="nirmaan.Volunteer"%>
<%@page import="nirmaan.BloodDonor"%>
<%@page import="nirmaan.Faculty"%>
<%@page import="java.util.ArrayList"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
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
        <h1>Here are the Search results</h1>
        <p>you had searched for <%=request.getParameter("searchfor")%> in <%=request.getParameter("Thing")%>
            <%  
                String Query=request.getParameter("searchfor");
                String File=request.getParameter("Thing");
                ArrayList<Faculty> result = new ArrayList<Faculty>();
                ArrayList<Volunteer> result1 = new ArrayList<Volunteer>();
                ArrayList<BloodDonor> result2 = new ArrayList<BloodDonor>();
                ArrayList<Institution> result3 = new ArrayList<Institution>();
                ArrayList<Market> result4 = new ArrayList<Market>();
                ArrayList<SHGworker> result5 = new ArrayList<SHGworker>();
                
                
                if(File.equals("faculty.ser"))
                {result=Faculty.search(Query);
                    %>
                    <table style="width:100%">
                        <tr>
                         <th>Name</th>
                         <th>PSRN_No</th>
                         <th>Donated</th>
                          </tr>
                          <%
                    for(Faculty f : result)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              <td><%=f.getPSRN_no()%></td>
                              <td><%=f.checkDonationStatus()%></td>
                          </tr>
                          <%}
                }
                else if(File.equals("volunteers.ser"))
                {result1=Volunteer.search(Query);%>
                <table style="width:100%">
                        <tr>
                         <th>Name</th>
                         <th>Contact no</th>
                         
                          </tr>
                          <%
                    for(Volunteer f : result1)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              <td><%=f.getContactNumber()%></td>
                              
                          </tr>
                          <%}
                }
                else if(File.equals("donors.ser"))
                {   result2=BloodDonor.searchdonors(Query);
                %>
                    <table style="width:100%">
                        <tr>
                         <th>Name</th>
                         <th>Contactno</th>
                         <th>Donatedon</th>
                         <th>BloodGroup</th>
                          </tr>
                          <%
                    for(BloodDonor f : result2)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              <td><%=f.getContactNumber()%></td>
                              <td><%=f.getDate()%></td>
                              <td><%=f.getBloodGroup()%></td>
                          </tr>
                          <%}
                }
                else if(File.equals("institutions.ser"))
                {   result3=Institution.search(Query);
                %>
                    <table style="width:100%">
                        <tr>
                         <th>Name</th>
                         <th>Address</th>
                         <th>Type</th>
                          </tr>
                          <%
                    for(Institution f : result3)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              <td><%=f.getAdd()%></td>
                              <td><%=f.getType()%></td>
                          </tr>
                          <%}
                }
                else if(File.equals("markets.ser"))
                {   result4=Market.search(Query);%>
                <table style="width:100%">
                        <tr>
                         <th>Name</th>
                         <th>Address</th>
                         
                          </tr>
                          <%
                    for(Market f : result4)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              <td><%=f.getAdd()%></td>
                              
                          </tr>
                          <%}
                
                }
                else if(File.equals("workers.ser"))
                        {   result5=SHGworker.search(Query);%>
                <table style="width:100%">
                        <tr>
                         <th>Name</th>
                                                
                          </tr>
                          <%
                    for(SHGworker f : result5)
                    { %>
                         
                          <tr>
                              <td><%=f.getName()%></td>
                              
                              
                          </tr>
                          <%}
                        }
                
            
            %>
                
              <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="css/bootstrap.min.js"></script>  
    </body>
</html>
