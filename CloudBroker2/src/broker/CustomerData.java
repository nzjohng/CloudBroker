package broker;

import com.googlecode.objectify.*; 

public class CustomerData extends PersonData
{
    protected String password1;
    protected String emailaddress; // customer's email address
    protected String creditcard; // customer's creditcard #
    protected int necoins;
    protected int certificate; // for web-based logins

    // could have other stuff like outstanding fines, preffered status, etc.

	public CustomerData()
	{
	}

    public CustomerData(String id, String name, String password, String emailaddress, String creditcard)
    {
        super(id,name,password);
        this.emailaddress = emailaddress;
        this.creditcard = creditcard;
    }

public String getPassword1()
    {
        return password1;
    }

public void setPassword1(String password1)
    {
        this.password1 = password1;
    }

    public String getEmailaddress()
    // returns customer's emailaddress
    {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress)
    // update customer's emailaddress
    {
        this.emailaddress = emailaddress;
    }

   public String getCreditcard()
    // returns customer's creditcard #
    {
        return creditcard;
    }

    public void setCreditcard(String creditcard)
    // update customer's creditcard #
    {
        this.creditcard = creditcard;
    }
public int getNecoins()
	// getter method for necoins
    {
        return necoins;
    }

    public void setNecoins(int necoins)
    // set necoins value
    {
        this.necoins = necoins;
    }

    public int getCertificate()
    {
      return certificate;
    }

    public void setCertificate(int certificate)
    {
      this.certificate = certificate;
    }

    public boolean authenticateUser(int certificate)
    {
      return (getCertificate() == certificate);
    }
}
