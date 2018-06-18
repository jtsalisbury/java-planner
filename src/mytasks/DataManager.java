package mytasks;

public class DataManager {
	private String path;
	
	
	DataManager() {}
	DataManager(String dataPath) {
		path = dataPath;
	}
	
	public void setSourceData(String dataPath) {
		path = dataPath;
	}
	
	public void loadData() {
		
	}
}
