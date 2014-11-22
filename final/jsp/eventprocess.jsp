<%-- 
    Document   : eventprocess
    Created on : 21 Nov, 2014, 3:14:40 AM
    Author     : sreejith
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="src.Event"%>
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
} %>
<% String Name = request.getParameter("Name");
    String Sd = request.getParameter("StartDate");
    String Ed = request.getParameter("EndDate");
    String Activityno = request.getParameter("activityno");
    Date Sdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(Sd);
    Date Edate = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH).parse(Ed);
    Event newone= new Event(Name,Sdate,Edate);
    String ActivityName,date;
    Date Actdate;
    String pos;
    for(int i=1;i<=Integer.parseInt(Activityno);i++)
    {    pos=Integer.toString(i);
         ActivityName=request.getParameter("activity"+pos);
         date=request.getParameter("activitydate"+pos);
          Actdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date);
         out.println(ActivityName+" "+Actdate);
         %><br><%
         newone.AddActivity(ActivityName,Actdate);
    }
    boolean done=newone.registerEvent();
    if(done)
        { out.println("Registered"); }
    else
        out.println("Dates clash with already present dates");
    
       
%>



<html>
    <head>
        <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EventResult</title>
    </head>
    <body>
        <h1></h1>
    </body>
</html>
