package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML private Button btnOk;
	@FXML private Button btnCancel;
	@FXML private TextField text;
	@FXML private TextArea area;
	@FXML private Button btnParse;
	@FXML private Label label;



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
		btnParse.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				onParseClicked();    // Always call a method in the outer class
			}
		});



	}
	private void onOkClicked() {
		System.out.println("OK button was clicked");
	}

	private void onCancelClicked() {
		text.setText("ABC");
	}
	private void onParseClicked() {
		try{
			double result=Double.parseDouble(text.getText())+1;
			area.setText(""+result);
		}
		catch (Exception e){
			label.setText("ERROR");
			System.out.println("ERRORRRRRRRRRR");
			Alert alert = new Alert(AlertType.CONFIRMATION,"Are you sure?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {
				// Action to perform when OK is clicked goes here}
			}
		}
	}
}
