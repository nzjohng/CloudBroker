<HTML>
<!--
  Customer Registration JSP
-->
<HEAD><TITLE>
Customer Registration
</TITLE></HEAD>

<H3>Customer Registration</H3>

<body bgcolor="white">
<font size = 3 color="#CC0000"></font>
<form type=POST action=customer_registration.jsp>

<%@ page import="broker.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<jsp:useBean id="ecoin_interface" scope="session" class="broker.EcoinInterface2" />
<jsp:useBean id="customer_data" scope = "page" class="broker.CustomerData" />

<jsp:setProperty name="customer_data" property="*" />

<%
BrokerFactory.getInstance().init();
 
  ecoin_interface.processRequest(request.getParameter("action"),customer_data,null);
 if(ecoin_interface.getMessage1().equals("r")){
   /*
          	try {
           	  getServletConfig().getServletContext().getRequestDispatcher("/war/customer_registration1.jsp").forward(request, response);
        	} catch (Exception ex) {
            	  ex.printStackTrace ();
        	}
     */
%>

<jsp:forward page="customer_registration1.jsp">
  <jsp:param name="customerID" value="<%=customer_data.getID()%>" />
</jsp:forward>

<%}
else if (ecoin_interface.getMessage1().equals("c"))
       {%>
     <jsp:forward page="mainpage.jsp"/>
     <%}%>
 <%=ecoin_interface.getMessage()%>

<br>

Google UserName: <input type=text name=ID size=25 value=
<%= (customer_data.getID() != null) ? "'"+customer_data.getID()+"'" : "" %>>
<br>
Name: <input type=text name=name size=25 value=
<%= (customer_data.getName() != null) ? "'"+customer_data.getName()+"'" : "" %>>
<br>
Password: <input type=password name=password size=20 value=
<%= (customer_data.getPassword() != null) ? "'"+customer_data.getPassword()+"'" : "" %>
>
<br>

ReEnter Password: <input type=password name=password1 size=20 value=
<%= (customer_data.getPassword1() != null) ? "'"+customer_data.getPassword1()+"'" : ""
%>>
<br>

Email Address: <input type=text name= emailaddress size=40 value=
<%= (customer_data.getEmailaddress() != null) ? "'"+customer_data.getEmailaddress()+"'" : "" %>
>
<br>

Credit Card#: <input type=text name=creditcard  size=20 value=
<%= (customer_data.getCreditcard() != null) ? ""+customer_data.getCreditcard() : "" %>
>
<br><br>




<INPUT TYPE=submit name="action" value="Register">

<INPUT TYPE=submit name="action" value="Reset">

<INPUT TYPE=submit name="action" value="Cancel">

</form>

</HTML>

