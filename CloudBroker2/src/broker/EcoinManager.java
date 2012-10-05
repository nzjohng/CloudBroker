package broker;

import broker.EcoinData;

public interface EcoinManager
{

	public EcoinData findEcoin(long ID) throws Exception;
	 
    // locate ecoin by ID value
	public long generatEcoin(String CID, int necoins) throws Exception;
    
	public String[] generateTandi(String ID) throws Exception;
	
	public EcoinData selectEcoin(long ID) throws Exception;
	
	public void insertEcoin(EcoinData data) throws Exception;
    // insert new customer record into database

    //public void updateEcoin(EcoinData data) throws Exception;
    // update customer record in database

   // public void deleteCustomer(CustomerData data) throws Exception;
    // delete customer record from database
 
}