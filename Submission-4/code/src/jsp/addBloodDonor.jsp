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
<%@ page import="nirmaan.Designation,nirmaan.BloodDonor,java.util.Date" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title>Add a Blood Donor - Nirmaan</title>

    
    <link href="css/bootstrap-min.css" rel="stylesheet">

    
    <link href="css/signin.css" rel="stylesheet">

   
    
  </head>

  <body>
    <%
      String name = request.getParameter("name");
      String contact = request.getParameter("contact");
      String bloodGroup = request.getParameter("bloodGroup");
      String sdate = request.getParameter("date");
      //
      String message ="";
      
      if(name != null && contact!=null) {
      String[] dates = sdate.split("-");
      Date date = new Date(Integer.parseInt(dates[0]),Integer.parseInt(dates[1]),Integer.parseInt(dates[2]));
    BloodDonor bloodDonor = new BloodDonor(bloodGroup,date,name,contact);
    bloodDonor.addBloodDonor();
    message = "Registered"; 
  }

      if(name == null) {
      name = "";
      bloodGroup = ""; }
      if(contact == null) {
        contact = "";
      }
    
    

    %>
   
    <div class="container">

      <form class="form-signin" role="form" method="post" action="/addBloodDonor.jsp">
        <h1 style="margin-left:10px"> New BloodDonor </h1>
        
        
       
        <input name="name" type="text" class="form-control" placeholder="Name" value="<%=name%>" >
        <input name="contact" type="text" class="form-control" placeholder="Contact Details" value="<%=contact%>" > 
        <input name="bloodGroup" type="text" class="form-control" placeholder="Blood Type" value="<%=bloodGroup%>" >
       <input name="date" type="date" class="form-control"  min="2014-09-09" placeholder="Date mm/dd/yyyy"> 
        <span style="color:red"><%=message%></span>
      
        
       
        
        
        <button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top:10px">Register</button>
      </form>

    </div> 


    
  </body>
</html>