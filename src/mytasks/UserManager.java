package mytasks;

import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import javafx.event.ActionEvent;

public class UserManager {
	private Stage primaryStage;
	UserManager(Stage stg) {
		primaryStage = stg;
	}
	
	public void promptLogin() throws IOException {
		double xOffset = 0;
	    double yOffset = 0;
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent p = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
		
		Scene s = new Scene(p);
		
		s.getStylesheets().add(getClass().getResource("loginForm.css").toExternalForm());
		
		
		
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	
	
	
}
