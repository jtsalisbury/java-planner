package mytasks;

import java.io.IOException;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UserManager {
	private Stage primaryStage;
	UserManager(Stage stg) {
		primaryStage = stg;
	}
	
	double xOffset = 0;
    double yOffset = 0;
	
	
	public void promptLogin() throws IOException {
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		//Parent p = FXMLLoader.load(getClass().getResource("loginForm.fxml"));		
		
		GridPane root = new GridPane();
			root.setHgap(10);
			root.setVgap(10);
			root.setPrefHeight(230);
			root.setPrefWidth(400);
			root.getStyleClass().add("root");
			
			root.setOnMousePressed(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent ev) {
					xOffset = ev.getSceneX();
					yOffset = ev.getSceneY();
				}
			});
			root.setOnMouseDragged(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent ev) {
					primaryStage.setX(ev.getScreenX() - xOffset);
					primaryStage.setY(ev.getScreenY() - yOffset);
				}
			});
		
		Scene s = new Scene(root);
		
		GridPane header = new GridPane();
			header.setPrefHeight(46);
			header.setPrefWidth(400);
			header.setHgap(10);
			header.setVgap(10);
			header.getStyleClass().add("header");
		
			Label headerText = new Label("MyTasks");
				header.add(headerText, 1, 1);
				header.getStyleClass().add("headerText");
				header.setColumnSpan(headerText, 10);
			
			Button minimize = new Button("-");
				minimize.getStyleClass().add("minimizeButton");
				minimize.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent ev) {
						Node source = (Node) ev.getSource();
						Stage stage =  (Stage) source.getScene().getWindow();
						
						stage.setIconified(true);
					}
				});
				header.add(minimize, 34, 1);
			
			Button close = new Button("x");
				close.getStyleClass().add("closeButton");
				close.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent ev) {
						System.exit(0);
					}
				});
				header.add(close, 35, 1);
			
		Label actionText = new Label("Please login");
			actionText.getStyleClass().add("subheaderText");
			root.add(actionText, 1, 1);
		
		TextField username = new TextField();
			username.setPromptText("Username");
			username.setPrefHeight(40);
			username.setPrefWidth(380);
			username.getStyleClass().add("usernameField");
			root.add(username, 1, 2);
		
		PasswordField password = new PasswordField();
			password.setPromptText("Password");
			password.setPrefHeight(40);
			password.setPrefWidth(380);
			password.getStyleClass().add("passwordField");
			root.add(password, 1, 3);
		
		Button doLogin = new Button("Login");
			doLogin.setPrefHeight(40);
			doLogin.getStyleClass().add("loginButton");
			root.add(doLogin, 1, 4);
		
		root.add(header, 0, 0);
		root.setColumnSpan(header, 3);
		
		s.getStylesheets().add(getClass().getResource("loginForm.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}
	
	
	
	
}
