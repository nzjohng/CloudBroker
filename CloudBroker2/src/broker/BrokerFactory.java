package broker;

import java.util.Calendar;

import objectify.BrokerObjectify;
//import au.edu.swin.ict.dvdstore.mysql.DVDStoreMySQL;

public abstract class BrokerFactory {
	
	static private BrokerFactory instance = null;
	
	public static BrokerFactory getInstance()
	{
	    if(instance == null)
			instance = new BrokerObjectify(); // change to new DVDStoreMySQL();  to use mySQL database!
		
		return instance;
	}
	
	public abstract void init() throws Exception;
	
	public abstract CustomerManager getCustomerManager();
	
	public abstract EcoinManager getEcoinManager();
	
	//public abstract RentalManager getRentalManager();
	
	//public abstract StaffManager getStaffManager();
	
	public static String getTodayDate()
	{
		Calendar c = Calendar.getInstance();
		
		String date = c.get(Calendar.YEAR)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.DAY_OF_MONTH);
		
		return date;
	}
	
}
