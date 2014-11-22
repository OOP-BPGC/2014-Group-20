
<%@ page import="nirmaan.Designation,nirmaan.Member" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
  	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message="";
		Designation designation;
		if(username == null) {
     	username = ""; }
      else {
      message="Incorrect username/password.";
    }

		if(password!= null &&(designation = Member.authenticate(username,password)) !=null) {
			Cookie cookie = new Cookie("username",username);
			Cookie cookie2 = new Cookie("designation",designation.toString());
			cookie.setMaxAge(60*60*12);
			cookie2.setMaxAge(60*60*12);
			response.addCookie(cookie);
			response.addCookie(cookie2);
			response.sendRedirect("main.jsp");

		}
		
	%>

    <div class="container">

      <form class="form-signin" role="form" method="post" action="/login.jsp">
       	<h1 > Nirmaan - Login to Continue </h1>
        <input name="username" type="text" class="form-control" placeholder="Username"  value="<%=username%>"required autofocus>
        <input name="password" type="password" class="form-control" placeholder="Password">
        <span style="color:red"><%=message%></span>
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
      </form>

    </div> 


    
  </body>
</html>
