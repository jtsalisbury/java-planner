package mytasks;

import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

public class UserManager {
	private Stage primaryStage;
	UserManager(Stage stg) {
		primaryStage = stg;
	}
	
	public void promptLogin() throws IOException {
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent p = FXMLLoader.load(getClass().getResource("loginForm.fxml"));
		
		Scene s = new Scene(p);
		
		//s.getStylesheets().add(getClass().getResource("loginForm.css").toExternalForm());
		
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
