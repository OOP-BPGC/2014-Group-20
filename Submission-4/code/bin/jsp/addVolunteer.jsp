<!DOCTYPE html>
<% 
	boolean approve = false;
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie: cookies) {
	if(cookie.getName().equals("designation")) {
		if(!cookie.getValue().equals(""))
			approve = true;

	}
}
	if(!approve) {
	response.sendRedirect("login.jsp");
}
	


%>
<%@ page import="nirmaan.Designation,nirmaan.Volunteer" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Add a Volunteer - Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
    <%
      String name = request.getParameter("name");
      String contact = request.getParameter("contact");
      String name2 = name;
      String message ="";
      if(name != null && contact!=null) {
    Volunteer volunteer = new Volunteer(name,contact);
    volunteer.addVolunteer();
    message = "Registered";
  }

      if(name == null) {
      name = ""; }
      if(contact == null) {
        contact = "";
      }
    
    

    %>

    <div class="container">

      <form class="form-signin" role="form" method="post" action="/addVolunteer.jsp">
       	<h1 style="margin-left:70px"> New Volunteer </h1>
        
        
       
        <input name="name" type="text" class="form-control" placeholder="Name" value="<%=name%>" >
        <input name="contact" type="text" class="form-control" placeholder="Contact Details" value="<%=contact%>" > <br>
        <span style="color:red"><%=message%></span>
      
	   		
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Register</button>
      </form>

    </div> 


    
  </body>
</html>