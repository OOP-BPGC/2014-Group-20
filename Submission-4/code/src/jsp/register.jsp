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

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
  <%@ page import="nirmaan.Designation,nirmaan.Member,java.io.File" %>

	
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


    
  </body>
</html>