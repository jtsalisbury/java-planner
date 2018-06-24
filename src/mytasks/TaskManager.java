package mytasks;

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
	private int targetID = 0;
	private Stage primaryStage = null;
	
	TaskManager(String un, int rID, Stage pm) throws Exception {
		username = username;
		targetID = rID;
		primaryStage = pm;
		
		SQLManager db = new SQLManager();
		ResultSet res = db.query("SELECT * FROM `events` WHERE `creatorID` = " + rID);
		
		openMainWindow(res);
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
