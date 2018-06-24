package planner;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TaskManager {
	private String username = "";
	private int userid = 0;
	private Stage primaryStage = null;
	
	TaskManager(String un, int rID, Stage pm) {
		username = un;
		userid = rID;
		primaryStage = pm;
			
		//openMainWindow(res);
	}
	
	private ResultSet updateEvents(String target) throws Exception {
		SQLManager db = new SQLManager();
		ResultSet res = db.query("SELECT * FROM `events` WHERE `creatorID` = " + userid + " AND (");
		
		return res;
	}
	
	public void openMainWindow(ResultSet res) {
		
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		
		GridPane root = new GridPane();
			root.setHgap(10);
			root.setVgap(10);
			root.setPrefWidth(bounds.getWidth());
			root.setPrefHeight(bounds.getHeight());
		
			root.getStyleClass().add("root");
			
		Scene s = new Scene(root);
		
			
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	
}
