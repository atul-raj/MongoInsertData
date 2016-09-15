import java.util.Random;
import java.util.TimerTask;
import java.util.Date;

// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {

	Date now; // to display current time
	Date last = new Date(2016, 05, 24);
	// Add your task here
	public void run() {
		now = new Date(); // initialize date
		
		
		System.out.println("Time is :" + now); // Display current time
		System.out.println("Last Time is :" + last);
		
		String turbine = "";
		String site = "";
		String customer = "";
		String project = "";
		String status = "" ;
		String power = "";
		int count = 1;
		//for demo only.
		for (int i = 0; i <= 45; i++) {
			System.out.println("Execution in Main Thread...." + i);
			
			MongoInsert moins = new  MongoInsert();
	          turbine = "T" + (i+1) ;
	          site = "S" + count++ ;
	          switch (count) {
	            case 1:  project = "US-North";
	                     customer = "GE-ELECTRIC";
	                     break;
	            case 2:  project = "US-South";
	                     customer = "DTE Energy";
	                     break;
	            case 3:  project = "US-EAST";
	                     customer = "Public Service Elec & Gas";	            
	                     break;
	            case 4:  project = "US-SOUTH";
	                     customer = "Virginia Electric & Power";
	                     break;
	            case 5:  project = "US-CENTRAL";
	                     customer = "Duke Energy Carolinas";
	                      break;
	          }  
	         
	          
	          if (count == 5){
	        	  count = 1; 
	          }
	          Random random = new Random();
	         int power2 = random.nextInt(30);
	         power = Integer.toString(power2);
	          Random random1 = new Random();
	          int status1 = random1.nextInt(8);
	          System.out.println("status1==>"+status1+"  Power==>"+power);
	          if (status1 == 0){
	        	 power = "0";
	        	 status = "0";
	          }else {
	        	  status = "1";
	          }
	        
			moins.insertData(turbine, site,customer, project,status,power);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (now == last) {
				System.out.println("Application Terminates");
				System.exit(0);
			}
		}
	}
}