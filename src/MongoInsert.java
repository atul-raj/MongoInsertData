
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;



public class MongoInsert {

    public void insertData(String turbineid, String site , String customer , String project, String status, String power) {
        try {
        	
        	System.out.println("Inside insert data method");
        	
            MongoClient mongo = new MongoClient("localhost", 27017);
            DB db = mongo.getDB("contactlist");
            DBCollection collection = db.getCollection("contactlist");
           /* SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String dateString  = dateFormat.format(new Date());
            System.out.println(dateString);*/
            
            
            
            DBObject document1 = new BasicDBObject();
            
         
            document1.put("turbineID", turbineid);
            document1.put("siteName", site);
            document1.put("customerName", customer);
            document1.put("projectName", project);
            document1.put("powerGenerated", power);
            document1.put("status", status);
            document1.put("timeStamp", new Date());
                     
            /*
            List<DBObject> documents = new ArrayList<DBObject>();
            documents.add(document1);*/
          
            collection.insert(document1);
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}