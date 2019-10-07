package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BoardController {
	@FXML private Button btnRoll;
	@FXML private TextField rollTxt;
	// green pawn images
	@FXML private ImageView greenImg1;
	@FXML private ImageView greenImg2;
	@FXML private ImageView greenImg3;
	@FXML private ImageView greenImg4;
	@FXML private ImageView greenImg5;
	@FXML private ImageView greenImg6;
	@FXML private ImageView greenImg7;
	@FXML private ImageView greenImg8;
	@FXML private ImageView greenImg9;
	@FXML private ImageView greenImg10;
	@FXML private ImageView greenImg11;
	@FXML private ImageView greenImg12;
	@FXML private ImageView greenImg13;
	@FXML private ImageView greenImg14;
	@FXML private ImageView greenImg15;
	@FXML private ImageView greenImg16;
	@FXML private ImageView greenImg17;
	@FXML private ImageView greenImg18;
	@FXML private ImageView greenImg19;
	@FXML private ImageView greenImg20;
	// blue pawn images
	@FXML private ImageView blueImg1;
	@FXML private ImageView blueImg2;
	@FXML private ImageView blueImg3;
	@FXML private ImageView blueImg4;
	@FXML private ImageView blueImg5;
	@FXML private ImageView blueImg6;
	@FXML private ImageView blueImg7;
	@FXML private ImageView blueImg8;
	@FXML private ImageView blueImg9;
	@FXML private ImageView blueImg10;
	@FXML private ImageView blueImg11;
	@FXML private ImageView blueImg12;
	@FXML private ImageView blueImg13;
	@FXML private ImageView blueImg14;
	@FXML private ImageView blueImg15;
	@FXML private ImageView blueImg16;
	@FXML private ImageView blueImg17;
	@FXML private ImageView blueImg18;
	@FXML private ImageView blueImg19;
	@FXML private ImageView blueImg20;

	@FXML private Label playerTurn;
	@FXML private TextArea lastTurn;
	// Array of the pawn images
	private ImageView[] pawn;
	private ImageView[] pawn2;

	int turn=0;
	final int  DEST =19;
	final int  SNAKEA =16;
	final int  SNAKEB =18;
	final int  LADDERA =3;
	final int  LADDERB =8;
	final int  NEW_LOCATION_SNAKEA =9;
	final int  NEW_LOCATION_SNAKEB =5;
	final int  NEW_LOCATION_LADDERA =7;
	final int  NEW_LOCATION_LADDERB =17;
	int roll;

	static String str;
	static String str2;
	static Player player = new Player(str);
	static Player player2 = new Player(str2);
	static Player winner;
	int count;	//use for checking overlapping player name

	private Random rnd = new Random();

	PlayerDAO lol=  new PlayerDAO();	//Create a PlayerDAO object to get the list of player

	@FXML public void initialize() {
		// Access input from previous window
		str = MainController.name1;
		str2 = MainController.name2;
		// Create new players for the match
		player = new Player(str);
		player2 = new Player(str2);

		lol.load();
		playerTurn.setText(player.getName() + " Turn");
		//Check for overlap with existing name then assgin to it
		ArrayList<Player> list = lol.getPlayerList();

		//Check overlapping, if yes, use that player, else create new one
		count=0;
		for(int i=0; i<list.size();i++){
			if (player.getName().equals(list.get(i).getName())){
				System.out.println("Found overlap. Assigning to existing username...");
				player=list.get(i);
				break;
			}
			else{
				count++;
			}
		}
		if (count==list.size()){
			System.out.println("Adding new player...");
			lol.getPlayerList().add(player);
		}
		count=0;
		for(int i=0; i<list.size();i++){

			if (player2.getName().equals(list.get(i).getName())){
				System.out.println("Found overlap. Assigning to existing username...");
				player2=list.get(i);
				break;
			}
			else{
				count++;
			}
		}
		if (count==list.size()){
			System.out.println("Adding new player...");
			lol.getPlayerList().add(player2);
		}

		//Print out all existing players - Just showing
		System.out.println(lol.getPlayerList());

		//Store images of player 1 to an array
		ImageView[] temp ={greenImg1,greenImg2,greenImg3,greenImg4,greenImg5,greenImg6,greenImg7,greenImg8,greenImg9,greenImg10,greenImg11,greenImg12,greenImg13
				,greenImg14,greenImg15,greenImg16,greenImg17,greenImg18,greenImg19,greenImg20};
		pawn = temp;
		//Store images of player 2 to an array
		ImageView[] temp2 = {blueImg1,blueImg2,blueImg3,blueImg4,blueImg5,blueImg6,blueImg7,blueImg8,blueImg9,blueImg10,blueImg11,blueImg12,blueImg13
				,blueImg14,blueImg15,blueImg16,blueImg17,blueImg18,blueImg19,blueImg20};
		pawn2 = temp2;

		//Make all player' pictures invisible
		for (int i=1; i<pawn.length; i++){
			pawn[i].setVisible(false);
		}
		for (int i=1; i<pawn2.length; i++){
			pawn2[i].setVisible(false);
		}
		btnRoll.setOnAction(e -> onRollClick());
	}

	private void onRollClick(){
		// roll
		roll = (rnd.nextInt(6)+1) ;
		rollTxt.setText("" + roll);

		// if turn is an even number its player 1 move
		if (turn%2==0 && player2._location < DEST){
			playerTurn.setText(player2.getName() + " Turn");
			move(player, pawn);
			turn++;
		}
		// if its an odd turn number it is player 2 move
		else if (turn%2==1 && player._location < DEST){
			playerTurn.setText(player.getName() + " Turn");
			move(player2, pawn2);
			turn++;
		}

	}

	//Move method to change player location
	private void move(Player player, ImageView[] pawn){
		for (int i=0; i<pawn.length; i++){
			pawn[i].setVisible(false);
		}
		player._location+=roll;
		lastTurn.setText(player.getName()+" rolled a "+ roll + " moved to tile: "+ (player._location + 1));
		if (player._location<=DEST){
			pawn[player._location].setVisible(true);

			if (player._location == SNAKEA){	//SNAKE= 17 go to 10
				pawn[player._location].setVisible(false);
				player._location = NEW_LOCATION_SNAKEA;
				pawn[player._location].setVisible(true);
				lastTurn.setText(player.getName() + " rolled a "+ roll +" land's on 17 Unlucky! lands on snake moved down to: "+ (player._location + 1));
			}
			else if (player._location == SNAKEB){	//SNAKE= 19 go to 6
				pawn[player._location].setVisible(false);
				player._location = NEW_LOCATION_SNAKEB;
				pawn[player._location].setVisible(true);
				lastTurn.setText(player.getName() +  " rolled a "+ roll +" land's on 19 Unlucky! lands on snake moved down to: "+ (player._location + 1));
			}
			else if (player._location == LADDERA){	//LADDER= 4 go to 8
				pawn[player._location].setVisible(false);
				player._location = NEW_LOCATION_LADDERA;
				pawn[player._location].setVisible(true);
				lastTurn.setText(player.getName() + " rolled a "+ roll +" land's on 4 lucky! up the leader to: " + (player._location + 1));

			}
			else if (player._location == LADDERB){	//LADDER=9 go to 18
				pawn[player._location].setVisible(false);
				player._location = NEW_LOCATION_LADDERB;
				pawn[player._location].setVisible(true);
				lastTurn.setText(player.getName() + " rolled a "+ roll +" land's on 9 goes up the leader to: "+ (player._location + 1));
			}
		}
		if (player._location>=DEST){
			player._location = 19;
			pawn[DEST].setVisible(true);
			player.setScore(player.getScore() + 1);
			winner = player;

			// Get a reference to the stage
			Stage stage = (Stage) btnRoll.getScene().getWindow();
			// Close the window
			stage.close();

			openWindow3();
			lol.save();
			System.out.println(lol.getPlayerList());
		}


	}

	public void openWindow3(){
		try{

			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("LeaderBoard.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage thirdStage = new Stage();
			thirdStage.setScene(scene);
			//	secondStage.initModality(Modality.APPLICATION_MODAL);  // Use this so you have to close the 2nd window to return to main window
			thirdStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
