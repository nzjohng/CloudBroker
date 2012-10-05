package broker;



import java.io.Serializable;

import objectify.CustomerManagerObjectifyImp;

 

public class CustomerInterface2 implements Serializable {

  public CustomerInterface2() {
  }

  private CustomerManager customer_manager = BrokerFactory.getInstance().getCustomerManager();

  public void processRequest(CustomerData customer_data)
  {

    if(customer_data.getAction() == null) {
      setMessage("");
      return;
    }

    if(customer_data.getAction().equals("find"))
      doFind(customer_data);
    else if(customer_data.getAction().equals("new"))
      doNew(customer_data);
    else if(customer_data.getAction().equals("add"))
      doAdd(customer_data);
    else if(customer_data.getAction().equals("update"))
      doUpdate(customer_data);
    else if(customer_data.getAction().equals("delete"))
      doDelete(customer_data);
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

  public void doFind(CustomerData customer_data)
  {
    if(customer_data.getID() == null)
		setMessage("ENTER A CUSTOMER ID");
	else {
          try {
		CustomerData c2 = customer_manager.findCustomer(customer_data.getID());
		if(c2 == null)
			setMessage("Customer with ID "+customer_data.getID()+" not found");
		else
			setMessage("Found customer");

		if(c2 != null) {
			customer_data.setID(c2.getID());
			customer_data.setName(c2.getName());
			customer_data.setPassword(c2.getPassword());
			customer_data.setEmailaddress(c2.getEmailaddress());
			customer_data.setCreditcard(c2.getCreditcard()); 
		}
            } catch (Exception e) {
              setMessage("Can't do selectCustomer() - error: "+e.toString());
            }
	}
  }

  public void doNew(CustomerData customer_data)
  {
    customer_data.setID("");
    customer_data.setName("");
    customer_data.setPassword("");
    customer_data.setEmailaddress(""); 
    customer_data.setCreditcard("");
  }

  public void doAdd(CustomerData customer_data)
  {
	String bad = "";

	if(customer_data.getID() == null)
		bad = "ID";
	if(customer_data.getName() == null)
		bad = "Name";

	if(!bad.equals(""))
		setMessage("Please enter a value for "+bad);
	else {
          try {
		if(customer_manager.findCustomer(customer_data.getID()) != null)
			setMessage("Customer with ID "+customer_data.getID()+" already exists!");
		else {
			customer_manager.insertCustomer(customer_data);
                }
          } catch (Exception e) {
            setMessage("An error occurred: "+e.toString());
          }
	}
    }

  public void doUpdate(CustomerData customer_data)
  {
    	String bad = "";

	if(customer_data.getID() == null)
		bad = "ID";
	if(customer_data.getName() == null)
		bad = "Name";

	if(!bad.equals(""))
		setMessage("Please enter a value for "+bad);
	else {
                try {
		if(customer_manager.findCustomer(customer_data.getID()) == null)
			setMessage("No customer with ID "+customer_data.getID()+" already exists!");
		else
                  customer_manager.updateCustomer(customer_data);
                } catch (Exception e) {
                  setMessage("An error occurred: "+e.toString());
                }
	}

  }

  public void doDelete(CustomerData customer_data)
  {
  }

}
