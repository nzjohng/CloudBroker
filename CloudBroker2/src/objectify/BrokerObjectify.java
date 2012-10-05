package objectify;

import broker.CustomerData;
import broker.CustomerManager;
import broker.EcoinData;
import broker.BrokerFactory;
import broker.EcoinManager;
//import broker.StaffManager;
 
import com.googlecode.objectify.*;

public class BrokerObjectify extends BrokerFactory {
	
	private static boolean registered = false;

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub

		// Initialise google data store Entities...
		//
		System.out.println("++++++"+registered);
		if(registered)
			return;
		
		registered = true;
		Objectify ofy = ObjectifyService.begin();
		
		ObjectifyService.register(CustomerData.class);
		ObjectifyService.register(EcoinData.class);
		
		System.out.println(";;;;;"+registered);
		//ObjectifyService.register(RentalData.class);

		
		//if(getCustomerManager().findCustomer("xiaolingd.dai") == null) {
			//ofy.put(new CustomerData("xiaolingd.dai","sharlene","abc","xiaolingd.dai@gmail.com","123456789"));
		//}
		
		//if(getDVDManager().findDVD(1111) == null) {
			/*ofy.put(new DVDData(1111,"Sleepless in Seattle","Romance",7.0, 7, "PG", 2));
			ofy.put(new DVDData(1234,"Case 39","Horror",4.50, 7, "M", 3));
			ofy.put(new DVDData(1212,"Sheakespeare in Love","Comedy",4.50, 7, "PG", 1));
			ofy.put(new DVDData(9876,"Avatar","SciFi", 4.50, 7, "M", 3));*/
		//}
			
		//getEcoinManager().findEcoin("a","");

	}
	
	public CustomerManager getCustomerManager() {
		return new CustomerManagerObjectifyImp();
	}
	
	public EcoinManager getEcoinManager() {
		return new EcoinManagerObjectifyImp();
	}
	
	/*public RentalManager getRentalManager() {
		return new RentalManagerObjectifyImp();
	}*/
	
	/*public StaffManager getStaffManager() {
		return null;
	}*/

}
