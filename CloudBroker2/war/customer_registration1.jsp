<HTML>
<!--
  Customer Registration1 JSP
-->
<HEAD><TITLE>
Customer Registration
</TITLE></HEAD>

<H3>Customer Registration</H3>

<body bgcolor="white">
<font size = 4 color=black>
<form type=POST action=customer_registration1.jsp>

<%@ page language="java" import="broker.*" %>

<jsp:useBean id='ecoin_interface' scope='session' class='broker.EcoinInterface2' />
<jsp:useBean id="customer_data" scope = 'page' class='broker.CustomerData' />

<jsp:setProperty name="customer_data" property="*" />
<%
 //ecoin_interface.processRequest(request.getParameter("action"),customer_data);


%>
 <font size=4 color=green>Welcome!</font><br>
 <br>
 Your Customer ID is:<b> <font size=4 color=red> <%=request.getParameter("customerID")%></font></b>
 <br><b>Please remenber your customer ID!</b><br><br>
 Name: <%=customer_data.getName()%><br>
 Email Address: <%=customer_data.getEmailaddress()%><br><br>

 You need to go to <b><a href="customer_buyecoins.jsp">Buy Ecoin</a></b> page and buy some ecoins.
</font>
<input type=hidden name=customerID>
</form>
</body>
</HTML>
