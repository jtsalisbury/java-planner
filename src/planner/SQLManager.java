package planner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager {
	public Connection link = null;
	private Statement stmt = null;
	
	private static String url = "";
	private static Integer port = 0000;
	private static String dbName = "";
	private static String user = "";
	private static String pass = "";
	
	SQLManager() throws Exception {
		connect();
	}
	
	public void connect() throws Exception {
		try {
			link = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "/" + dbName, user, pass);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public PreparedStatement prep(String sql) throws Exception {
		return link.prepareStatement(sql);
	}
	
	public ResultSet query(String sql) throws SQLException {
		stmt = link.createStatement();
		return stmt.executeQuery(sql);
	}
	
	public void close() {
		try {
			if (link != null) {
				link.close();
			}
		} catch (Exception e) {
			
		}
	}
	
}
