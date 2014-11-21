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
<%@ page import="nirmaan.Designation,nirmaan.Institution" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Add a institution - Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
    <%
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      String type = request.getParameter("type");
    
      String message ="";
        if(name != null && address!=null) {
    Institution institution = new Institution(name,address,type);
    institution.addInstitution();
    message = "Registered";
  }
      if(name == null) {
      name = "";
      type = ""; }
      if(address == null) {
        address = "";
      }
    
  


    %>

    <div class="container">

      <form class="form-signin" role="form" method="post" action="/addinstitution.jsp">
       	<h1 style="margin-left:50px"> New institution </h1>
        
        
       
        <input name="name" type="text" class="form-control" placeholder="Name" value="<%=name%>" >
        <input name="address" type="text" class="form-control" placeholder="Address" value="<%=address%>" > 
           <input name="type" type="text" class="form-control" placeholder="Type" value="<%=type%>" ><br>
        <span style="color:red"><%=message%></span>
      
	   		
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Add Institution</button>
      </form>

    </div> 


    
  </body>
</html>