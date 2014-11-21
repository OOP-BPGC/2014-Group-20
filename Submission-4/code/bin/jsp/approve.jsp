<!DOCTYPE html>
<% 
  boolean approve = false;
  String designation;
  String username ="";
  Cookie[] cookies = request.getCookies();
  for(Cookie cookie: cookies) {
  if(cookie.getName().equals("designation")) {
    if(cookie.getValue().equals("TREASURER"))
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
<%@ page import="nirmaan.Designation,nirmaan.Transaction,java.util.*" %>
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
      
      
    
  

      int j =0;
       ArrayList<Transaction> transi = Transaction.getPending();

      for(Transaction tran: transi) {
       System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
      if(request.getParameter("" + j) != null) {
       System.out.println("AAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBAAAAAAAAAA");
        boolean rem = Transaction.approveTransaction(tran);
        System.out.println("Success:"+rem);
      }
      j++;
    }
    %>

    <div class="container">

      <form  role="form"  action="/approve.jsp">
        <h1 style="margin-left:50px"> Add Funds </h1>
        
        <%
          int i = 0;
          ArrayList<Transaction> trans = Transaction.getPending();
          for(Transaction transaction: trans) {



        %>
       
        <input name="<%=""+ i %>" type="checkbox" class="form-control"  value="<%=i%>" > <%=transaction.getreason()%> <b> <%= transaction.getuser()  %> </b>  <i> <%=  transaction.getamount() %></i>
        
      

        <%i++;}%>
             
        
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Approve</button>
      </form>

    </div> 


    
  </body>
</html>