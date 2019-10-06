package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	@FXML Button btn;
	@FXML private void initialize() {
		// Attach event handler(s)s
		btn.setOnAction( e -> onStartClicked());	//btnStart handler
	}
	public void onStartClicked(){
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Second.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(scene);
			secondStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
