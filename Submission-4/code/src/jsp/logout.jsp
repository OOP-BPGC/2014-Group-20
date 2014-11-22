<% 
  boolean approve = false;
  String designation;
  String username ="";
  Cookie[] cookies = request.getCookies();
  for(Cookie cookie: cookies) {
  if(cookie.getName().equals("designation")) {
    if(!cookie.getValue().equals("")) {
      
      cookie.setValue("");
      response.addCookie(cookie);
    }

  }
  if(cookie.getName().equals("username")) {
   cookie.setValue("");
   response.addCookie(cookie);
  }
}

  
  response.sendRedirect("login.jsp");

%>