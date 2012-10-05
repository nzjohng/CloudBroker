package broker;

import java.io.Serializable;

import javax.persistence.Id;

public class EcoinData implements Serializable
{
	private static final long serialVersionUID = 6868805251156731006L;
	
	protected @Id long ID; // unique ID  //protected int ID;
     protected String cID;
    protected String seed;  
    protected String root;
     protected int amount;
    protected String chain;

	public EcoinData()
	{
	}

    public EcoinData(long ID, String cID, String seed, String root, int amount, String chain)
    {

        this.ID = ID;
        this.cID=cID;
        this.seed =seed;
        this.root=root;
        this.amount=amount;
        this.chain=chain;
    }

    public long getEcoinID()
   {
        return ID;
    }

    public void setEcoinID(long ID)
    // update customer's emailaddress
    {
        this.ID = ID;
    }

    public String getCID()
    {
         return cID;
     }

    public void setCID(String cID)
    // update customer's emailaddress
    {
        this.cID = cID;
    }

   public String getSeed()
    // returns customer's creditcard #
    {
        return seed;
    }

    public void setSeed(String seed)
    {
        this.seed = seed;
    }

 public String getRoot()
    {
        return root;
    }

    public void setRoot(String root)
     {
        this.root = root;
    }

  public int getAmount()
     {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }
 public String getChain()
    {
        return chain;
    }

    public void setChain(String chain)
     {
        this.chain = chain;
    }
}
