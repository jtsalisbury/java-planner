package mytasks;

import java.awt.Button;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;

public class FormController {
	private double xOff = 0;
	private double yOff = 0;
	
	@FXML
	public void drag_MousePress(MouseEvent ev) {
		xOff = ev.getSceneX();
		yOff = ev.getSceneY();
	}
	public void onMouseDragged(MouseEvent ev) {
		//primaryStage.setX(ev.getScreenX() - xOff);
		//primaryStage.setY(ev.getScreenY() - yOff);
	}
	
	public void minimizeFrame(ActionEvent ev) {
		Node source = (Node) ev.getSource();
		Stage stage =  (Stage) source.getScene().getWindow();
		
		stage.setIconified(true);
	}
	
	public void closeFrame(ActionEvent ev) {
		System.exit(0);
	}
}
