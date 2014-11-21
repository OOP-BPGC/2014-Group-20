<!DOCTYPE html>
<% 
	boolean approve = false;
  String designation;
  String username ="";
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie: cookies) {
	if(cookie.getName().equals("designation")) {
		if(!cookie.getValue().equals(""))
			approve = true;
      designation = cookie.getValue();

	}
  if(cookie.getName().equals("username")) {
    username = cookie.getValue();
  }
}

	if(!approve) {
	response.sendRedirect("login.jsp");
}
	


%>
<%@ page import="nirmaan.Designation,nirmaan.Transaction" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Transaction - Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
    <%
      String reason = request.getParameter("reason");
      
      
    
      String message ="";
        if(reason != null ) {
        double amount = Double.parseDouble(request.getParameter("amount"));
        if(amount > 0) {
    Transaction transaction = new Transaction(username,reason,amount);
    transaction.registertransaction();
    message = "Added transaction.";}
  }
      if(reason == null) {
      reason = "";
      }
      
    
  


    %>

    <div class="container">

      <form class="form-signin" role="form" method="post" action="/addTransaction.jsp">
       	<h1 style="margin-left:50px"> Transaction </h1>
        
        
       
        <input name="reason" type="text" class="form-control" placeholder="Reason" value="<%=reason%>" >
        <input name="amount" type="text" class="form-control" placeholder="Amount" " > 
        <br>
        <span style="color:red"><%=message%></span>
      
	   		
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Add Transaction</button>
      </form>

    </div> 


    
  </body>
</html>