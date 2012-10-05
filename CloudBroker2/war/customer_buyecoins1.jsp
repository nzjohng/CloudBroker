<HTML>
<!--
  Customer Buy Ecoins1 JSP
-->
<HEAD><TITLE>
Customer Buy Ecoins
</TITLE></HEAD>

<H3>Customer Buy Ecoins</H3>

<body bgcolor="white">
<font size = 3 color="#CC0000">
<form type=POST action=customer_buyecoins1.jsp>
<BR>


<%@ page language="java" import="broker.*" %>
<%@ page import="java.lang.*" %>


<jsp:useBean id="customer_data" scope = "session" class="broker.CustomerData" />
<jsp:useBean id="ecoin_data" scope = "session" class="broker.EcoinData" />
<jsp:useBean id="ecoin_interface" scope="session" class="broker.EcoinInterface2" />

<jsp:setProperty name="customer_data" property="*" /> 
<jsp:setProperty name="ecoin_data" property="*" />


<%

  ecoin_interface.processRequest(request.getParameter("action"),customer_data,ecoin_data);
  if(ecoin_interface.getMessage1().equals("f"))
      {
      ecoin_interface.getMessage1();
   // String namep=Integer.toString(ecoin_data.getEcoinID()-1);
  // String server[]={"ecoinid","host","port","namecom",namep};//,"module","interface1"};
 //  String name=Integer.toString(ecoin_data.getEcoinID());
  // String namecom="EcoinManager";
 //  String ehpn[]={name,"localhost","1051",namecom};

          	try {
           	  getServletConfig().getServletContext().getRequestDispatcher("/customer_buyecoins2.jsp").forward(request, response);
        	} catch (Exception ex) {
            	  ex.printStackTrace ();
        	}
      }
 else if(ecoin_interface.getMessage1().equals("c"))
    {%>
     <jsp:forward page="mainpage.jsp"/>
     <%}%>

 <%=ecoin_interface.getMessage()%>

<br>

<br>

<font size =4 color=blue>
Customer ID:<%=customer_data.getID()%>
<br><br>


Amount of Ecoin: <input type=text name= necoins size=12>
<br>
<INPUT TYPE=submit name="action" value="OK">
 <INPUT TYPE=submit name="action" value="CANCEL">

</font>
</form>
</font>
</body>
</HTML>
