<HTML>
<!--
  Customer Buy Ecoins2 JSP
-->
<HEAD><TITLE>
Customer Buy Ecoins
</TITLE></HEAD>

<H3>Customer Buy Ecoins</H3>

<body bgcolor="white">
<font size = 4 color=blue>

<%@ page language="java" import="broker.*" %>
<jsp:useBean id="ecoin_data" scope = 'session' class='broker.EcoinData' />
<jsp:useBean id='ecoin_interface' scope='session' class='broker.EcoinInterface2' />

<jsp:setProperty name="ecoin_data" property="*" />



Please remenber your E-coin ID<font size = 4 color=red><b> <%=ecoin_data.getEcoinID()%></font></b>. Thanks!

<br><br>

<a href="mainpage.jsp">Home</a>
</font>
</body>
</HTML>