package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

	@FXML private Button btnOk;
	@FXML private Button btnCancel;
	@FXML private TextField text;



	// This method is automatically called when the window opens, after the FXML file has been loaded.
	// You can put startup and initialization code here.
	@FXML private void initialize() {

		// Attach event handler(s)
		btnOk.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onOkClicked();    // Always call a method in the outer class
			}
		});
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onCancelClicked();    // Always call a method in the outer class
			}
		});
	}

	private void onOkClicked() {
		System.out.println("OK button was clicked");
	}
	private void onCancelClicked() {
		text.setText("ABC");
	}

}
