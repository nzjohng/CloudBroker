
package broker;

import java.util.*;
import java.io.Serializable;
//import com.google.appengine.api.users.User;
//import com.google.appengine.api.users.UserService;
//import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import objectify.CustomerManagerObjectifyImp;
import objectify.EcoinManagerObjectifyImp;

import broker.EcoinManager;
import broker.CustomerManager;
import broker.BrokerFactory;
import broker.EcoinData;
import broker.CustomerData;

//import org.omg.CosNaming.*;
//import org.omg.CosNaming.NamingContextPackage.*;

 

public class EcoinInterface2 implements Serializable
{
	private static final long serialVersionUID = -5190316235621450917L;

	public EcoinInterface2()
	{
	}
	private CustomerManager customer_manager = BrokerFactory.getInstance().getCustomerManager();
	private EcoinManager ecoin_manager = BrokerFactory.getInstance().getEcoinManager();
	
	public CustomerManager getCustomerManager() {
		if(customer_manager == null)
			customer_manager = BrokerFactory.getInstance().getCustomerManager();
		return customer_manager;
	}
	
	public EcoinManager getEcoinManager() {
		if(ecoin_manager == null)
			ecoin_manager = BrokerFactory.getInstance().getEcoinManager();
		return ecoin_manager;
	}

	public void processRequest(String action, CustomerData customer_data, EcoinData ecoin_data)
	{
		  
		  if(action == null)
                 {   setMessage("");
                    setMessage1("m");
			return;}
		
if (customer_data==null){setMessage("customer data is null");return;}

     

if (customer_data!=null){
              setMessage("");
                if(action.equals("Register"))
                   doRegister(customer_data);
                else if(action.equals("Reset"))
                  doReset(customer_data);

               //else if(action.equals("Login"))
                 // doLogin(customer_data);
		else if(action.equals("OK"))
                  doGeneratEcoin(customer_data,ecoin_data);
                  else if(action.equals("Cancel"))
                  doCancel(customer_data);
              }

	}

	private String message = "";

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}

      private String message1 = "";

	public void setMessage1(String message1)
	{
		this.message1 = message1;
	}

	public String getMessage1()
	{
		return message1;
	}

        public void doRegister(CustomerData customer_data)
        {

                //System.out.println("EcoinInterface2.java xxxxxxxxxx 000");
        String bad = "";
        if(customer_data.getID() == null)
		bad = "ID";
        else if(customer_data.getName() == null)
		bad = "Name";
        else if(customer_data.getEmailaddress() == null)
		bad = "Email Address";
         else if(customer_data.getPassword() == null)
         {
            bad = "Password";

          }
        else if(!customer_data.getPassword().equals(customer_data.getPassword1()))
        bad="Re-enter Password ";

         else if(customer_data.getCreditcard() == null)
		bad = "bbb Credit Card #";

	if(!bad.equals(""))
		setMessage("Please enter a value for "+bad);
      else
        try {
                   // System.out.println("EcoinInterface2.java xxxxxxxxxx 1111  "+customer_data);
                        			
        CustomerData c2  = new CustomerData(customer_data.getID(),customer_data.getName(),customer_data.getPassword(), customer_data.getEmailaddress(), customer_data.getCreditcard());
         
        //if(customer_manager.findCustomer(customer_data.getID()) != null)
       	//setMessage("Customer with ID "+customer_data.getID()+" already exists!");
        //else {
        	customer_manager.insertCustomer(c2);
        	              //  }            
          setMessage1("r");
          } catch (Exception e) {
            setMessage("test An error occurred: "+e.toString());
          }

  }

         public void doReset(CustomerData customer_data)
         {String bad = "";
                        customer_data.setName("");
			customer_data.setPassword("");
                        customer_data.setPassword1("");
			customer_data.setEmailaddress("");
			customer_data.setCreditcard("");
         setMessage1("m");
          }



       /* public void doLogin(CustomerData customer_data)
        {
        	String bad = "";
        try {
	CustomerData c2 = customer_manager.findCustomer(customer_data.getID());
      	 
	if(customer_data.getPassword() == null)
		bad = "Enter customer password";
	else if(c2 == null)
		bad = "No such Customer ID";
	else if(!c2.matchesPassword(customer_data.getPassword()))
		bad = "Wrong password";
        } catch (Exception e) {
          bad ="error in doLogin(): "+e.toString();
        }
        if(!bad.equals(""))
	setMessage(bad);
        else
        setMessage1("o");
        }*/

        private String ecoins = "";

	public void setEcoins(String ecoins)
	{
		this.ecoins = ecoins;
	}

	public String getEcoins()
	{
		return ecoins;
	}

 	public void doGeneratEcoin(CustomerData customer_data, EcoinData ecoin_data)
	{
        String bad = "";
	if(customer_data.getNecoins() == 0)
		setMessage("Please enter amount!");
       else

       try {

    	   long ecoinID = ecoin_manager.generatEcoin(customer_data.getID(),customer_data.getNecoins());
                    
     	 //ecoin_manager.vendorhost(ecoinID);

          //setEcoins(ecoins1);
          setMessage1("f");
          } catch (Exception e) {
            setMessage("An error occurred: "+e.toString());
          }


	}

        public void doCancel(CustomerData customer_data)
	{   String bad = "";
        setMessage1("c");
        }

}

