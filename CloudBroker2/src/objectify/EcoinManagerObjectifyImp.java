package objectify;

import java.security.MessageDigest;
//import java.util.Vector;
//import java.io.*;
//import java.util.*;

import broker.CustomerData;
import broker.EcoinData;
import broker.EcoinManager;
 
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;

public class EcoinManagerObjectifyImp implements EcoinManager
{

    public EcoinManagerObjectifyImp()
    {
    }
   
    public EcoinData findEcoin(long ID) throws Exception
	{
    	Objectify ofy = ObjectifyService.begin();
    	
    	try {
    		EcoinData e1 = ofy.get(EcoinData.class, ID);
    	
    		return e1;
    	} catch (com.googlecode.objectify.NotFoundException e) {
    		return null;
    	}
    		

	}
    public long generatEcoin(String CID, int necoins) throws Exception

    {
        StringBuffer ecoins= new StringBuffer();
        String arrayOfStrings[]=new String[necoins+1];
        String seed=String.valueOf(Math.random());

        byte[] msg=seed.getBytes();
        MessageDigest md=MessageDigest.getInstance("MD5");

        for(int h=0; h<=necoins;h++){

             md.reset();
             md.update(msg);
             byte[] aMessageDigest=md.digest();
             msg=aMessageDigest;
             arrayOfStrings[h]=convert(aMessageDigest);
             }
        Objectify ofy = ObjectifyService.begin();
        String root=arrayOfStrings[necoins];
        //Vector<EcoinData> result = new Vector<EcoinData>();
               	    
        Query<EcoinData> q;
        long ecoinID=0;
        q = ofy.query(EcoinData.class);
         
        for (EcoinData ecoin: q) {
        	
        	if (ecoin.getEcoinID()>ecoinID)
        		ecoinID=ecoin.getEcoinID();
           // max ecoin ID
        }	
        
        EcoinData data = null;
        data.setEcoinID(ecoinID+1);
        data.setCID(CID);
        data.setSeed(seed);
        data.setRoot(root);
        data.setAmount(necoins);
        
      for (int i=necoins-1; i>=0; i--){
              ecoins=ecoins.append(arrayOfStrings[i]);
              }
        data.setChain(ecoins.toString());
        ofy.put(data);
        return ecoinID+1;
      //db.execute("INSERT INTO ecoin (cid,seed,root,amount) VALUES ("+
        // CID+",'"+seed+"','"+root+"','"+necoins+"')");
    }



   public synchronized String[] generateTandi(String cid) throws Exception
    // locate customer by ID value
    {
    String tandi[]=new String[4];
    long ecoinID=0;
   // Vector<EcoinData> result = new Vector<EcoinData>();
     
    Objectify ofy = ObjectifyService.begin();
   	    
    Query<EcoinData> q;
    
    q = ofy.query(EcoinData.class).filter("cid==", cid);
     
    for (EcoinData ecoin: q) {
    	
    	if (ecoin.getEcoinID()>ecoinID)
    		ecoinID=ecoin.getEcoinID();
       // result.add(ecoin);
    }	
    
	//get the new ecoin ID
       
     try {
		EcoinData e1 = ofy.get(EcoinData.class, ecoinID);
		 //if(rs.next()){
	            tandi[0]=String.valueOf(ecoinID);
	            tandi[1]= e1.getRoot(); //stripTrailing(rs.getString("root"));
	            tandi[2]="1";
	            tandi[3]=e1.getChain();

	            return tandi;
	           
		 
	} catch (com.googlecode.objectify.NotFoundException e) {
		return null;
	}
                  
}

 public synchronized EcoinData selectEcoin(long ID) throws Exception
    // locate customer by ID value
    {
	 if(ID == 0)
 		return null;

 	Objectify ofy = ObjectifyService.begin();
 	
 	try {
 		EcoinData e1 = ofy.get(EcoinData.class, ID);
 	
 		return e1;
 	} catch (com.googlecode.objectify.NotFoundException e) {
 		return null;
 	}
 	/*ResultSet rs = db.executeQuery("SELECT * FROM ecoin WHERE ecoin.ID = "+ID);

        if(rs.next()) {

             ID = rs.getInt("ID");
            int cID =  rs.getInt("cID");
            String seed = stripTrailing(rs.getString("seed"));
            String root = stripTrailing(rs.getString("root"));
            int amount = rs.getInt("amount");
            String chain = stripTrailing(rs.getString("chain"));
            rs.close();

            return new EcoinData(ID,cID,seed,root,amount,chain);
        }

        return null;*/
    }


 public String stripTrailing(String value)
    // strip trailing blanks...
    {
        char cs[] = value.toCharArray();

        int end = cs.length;
        while(end > 0 && cs[end-1] == ' ')
            end--;

        return new String(cs,0,end);
    }

public static String convert(byte bytes[])
  // Convert a type array into a printable format containning a String of hexadecimal digit
  // characters(two per type).
  {
  StringBuffer sb = new StringBuffer(bytes.length*2);
  for (int i=0;i<bytes.length; i++){
     sb.append(convertDigit((int) (bytes[i]>>4)));
    sb.append(convertDigit((int) (bytes[i]&0x0f)));
    }
 return (sb.toString());
 }

 private static char convertDigit(int value)
  {
   value&=0x0f;
   if(value>=10)
       return((char)(value-10+'a'));
   else
      return ((char)(value+'0'));
  }


    public void insertEcoin(EcoinData data) throws Exception
    {
    	ObjectifyService.begin().put(data);
    }

	/*  

    public void deleteDVD(DVDData data) throws Exception
	{
    	ObjectifyService.begin().delete(data);
	}*/

}

