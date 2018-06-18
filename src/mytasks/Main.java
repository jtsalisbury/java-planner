package mytasks;

import java.io.File;
import org.json.simple.*;

public class Main {
	public static final String dataFileName = "mytasks_data.txt";
	
	static String workingDir;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		workingDir = System.getProperty("user.dir");
		
		DataManager handler = new DataManager();
		handler.setSourceData(workingDir + "/" + dataFileName);
	
		handler.loadData();
	}
	
}
