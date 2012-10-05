package broker;

import java.io.Serializable;

import javax.persistence.Id;

public abstract class PersonData implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8078060217475949512L;

	protected  @Id  String id; // unique ID for person
    protected String name; // person's name
    protected String password; // person's password (unencrypted :-)

    protected String action; // submit button value

	public PersonData()
	{
	}

	public PersonData(String id, String name, String password)
	{
	    this.id = id;
	    this.name = name;
	    this.password = password;
	}

	public String getID()
    // returns person's name
    {
        return id;
    }
	
    public void setID(String id)
    // set ID value - should only use when adding new person record
    {
        this.id = id;
    }

    public String getName()
    // returns person's name
    {
        return name;
    }

    public void setName(String name)
    // updates person's name
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean matchesPassword(String password)
    {
        if(this.password.equals(password))
            return true;
        else
            return false;
    }

    public String getAction()
    {
    	return action;
    }

    public void setAction(String action)
    {
		this.action = action;
    }

}
