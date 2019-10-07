package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
	@FXML private Button btnStart;
	@FXML private Label label;
	@FXML TextField player1;
	@FXML TextField player2;
	@FXML  protected TextField playerAName;
	@FXML protected  TextField playerBName;
	static protected String name1;
	static protected String name2;

	@FXML public void initialize() {
		btnStart.setOnAction(e -> onStartClick());
	}

	private void onStartClick(){
		//Assign input to static variables
		name1 =playerAName.getText();
		name2 =playerBName.getText();
		//Check if player1=player2
		if (name1.equals(name2)){
			label.setVisible(true);
			label.setText("Player 1 can't overlap Player 2. Please re-enter.");
		}

		else if (checkBlankOrComma(name1)==true||checkBlankOrComma(name2)==true){
			label.setVisible(true);
			label.setText("Player name can't be blank or have ','. Please re-enter.");
		}
		else{
			try {
				//Open Window 2
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Board.fxml"));
				Scene scene = new Scene(root,600,600);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage secondStage = new Stage();
				secondStage.setScene(scene);
				secondStage.show();

				// Get a reference to the stage
				Stage stage = (Stage) btnStart.getScene().getWindow();
				// Close the window
				stage.close();
			}

			catch(Exception e) {
				e.printStackTrace();
			}
		}



	}


	//Check Blank Or Comma in player name
	public boolean checkBlankOrComma(String name){
		boolean status=false;
		if (name.equals("")){
			status=true;
		}
		else{
			for(int i=0; i<name.length(); i++){
				if(name.charAt(i)==','){
					status = true;
					break;
				}
			}
		}

		return status;
	}
}
