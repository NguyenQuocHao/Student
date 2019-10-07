package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LeaderBoardController {
	@FXML private Button btnMainMenu;
	@FXML private Button btnReplay;
	@FXML protected Label p1;
	@FXML protected Label p2;
	@FXML protected Label header;
	Player player = BoardController.player;
	Player player2 = BoardController.player2;
	Player winner = BoardController.winner;


	@FXML public void initialize() {
		setAll();

		btnMainMenu.setOnAction(e -> onMainMenuClick());
		btnReplay.setOnAction(e -> onReplayClick());
	}
	private void onMainMenuClick(){
		openWindow1();
		// Get a reference to the stage
		Stage stage = (Stage) btnMainMenu.getScene().getWindow();
		// Close the window
		stage.close();
	}

	private void onReplayClick(){
		openWindow2();
		// Get a reference to the stage
		Stage stage = (Stage) btnReplay.getScene().getWindow();
		// Close the window
		stage.close();
	}

	//Display winner and showing players' total wins
	public void setAll(){
		String abc =winner.getName();
		header.setText( abc + " wins");
		p1.setText(player.getName()+": "+player.getScore());
		p2.setText(player2.getName()+": "+player2.getScore());
	}

	public void openWindow2(){
		try{
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Board.fxml"));
			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(scene);
			secondStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void openWindow1(){
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,567,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
