package mytasks;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
    
    public String hashPassword(String pass, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
    	
    	KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt.getBytes(), 1000, 128);
    	SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    	byte[] hash = f.generateSecret(spec).getEncoded();
    	Base64.Encoder enc = Base64.getEncoder();
    	
    	return enc.encodeToString(hash);
    }
    
    public boolean attemptLogin(String username, String password) throws Exception {
    	System.out.println(username);
    	System.out.println(password);
    	System.out.println(hashPassword(password, "125 176   4 149 135 172 183 245 243 141 142 244 119  25  19 116 "));
    	
    	SQLManager db = new SQLManager();
    	
    	PreparedStatement stmt = db.prep("SELECT * FROM `users` WHERE `username` = ? LIMIT 1");
    	stmt.setString(1, username);
    	
    	ResultSet res = stmt.executeQuery();
    	while (res.next()) {
    		System.out.println(res.getString("email"));
    	}
    		
    	return false;
    }
	
	public void promptLogin() throws IOException {
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
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
				GridPane.setColumnSpan(headerText, 10);
			
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
			doLogin.setOnAction(new EventHandler<ActionEvent>() {
				@Override 
				public void handle(ActionEvent ev) {
					try {
						attemptLogin(username.getText(), password.getText());
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					} catch (InvalidKeySpecException e) {
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			root.add(doLogin, 1, 4);
		
		root.add(header, 0, 0);
		GridPane.setColumnSpan(header, 3);
		
		s.getStylesheets().add(getClass().getResource("loginForm.css").toExternalForm());
		primaryStage.setScene(s);
		primaryStage.show();
	}
}
