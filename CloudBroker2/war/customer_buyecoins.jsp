<HTML>
<!--
  Customer Buy Ecoins JSP
-->
<HEAD><TITLE>
Customer Buy Ecoins
</TITLE></HEAD>

<H3>Customer Buy Ecoins</H3>

<body bgcolor="white">
 
<form type=POST action=customer_buyecoins.jsp>
<BR>

<%@ page language="java" import="broker.*" %>
<%@ page import="java.util.*" %>

<jsp:useBean id='customer_data' scope = 'session' class='broker.CustomerData' />

<jsp:setProperty name="customer_data" property="*" />

<%

BrokerFactory.getInstance().init();

if(customer_data != null && customer_data.getAction() != null) {
	String bad = "";
	
	CustomerData c2 = BrokerFactory.getInstance().getCustomerManager().findCustomer(customer_data.getID());

	if(customer_data.getID() == "")
		bad = "Enter customer ID";
	else if(customer_data.getPassword() == null)
		bad = "Enter customer password";
	else if(c2 == null)
		bad = "No such Customer ID";
	else if(!c2.matchesPassword(customer_data.getPassword()))
		bad = "Wrong password";

	if(!bad.equals(""))
		out.println(bad);
	else
        	try {
        		
        	  customer_data.setName(c2.getName());
        	  customer_data.setAction(null);
				
           	  getServletConfig().getServletContext().getRequestDispatcher("/customer_buyecoins2.jsp").forward(request, response);
        	} catch (Exception ex) {
            	  ex.printStackTrace ();
        	}
}
	 %>

<br>
Customer ID: <input type=text name=ID size=12>
<br>
Password: <input type=password name=password size=12>
<br>

<br>

<INPUT TYPE=submit name="action" value="Login">
 

</form>

</body>

</HTML>