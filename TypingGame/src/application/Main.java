package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	// variable
	static int speed = 5;
	static int width = 25;
	static int height = 25;
	static int cornersize = 20;
//	static Word word= new Word("",0,0);
	static boolean gameOver = false;
	static Random rand = new Random();
	static Canvas c = new Canvas(width * cornersize, height * cornersize);
	GraphicsContext gc = c.getGraphicsContext2D();
	static Scene scene;
	static int n;
	static boolean correct=MainController.correct;
	static ArrayList<Word> list = MainController.list;


	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml"));
			root.getChildren().add(c);
			scene = new Scene(root, 700, 500);

			new AnimationTimer() {
				long lastTick = 0;

				public void handle(long now) {
					if (lastTick == 0) {
						lastTick = now;
						tick(gc);
						return;
					}
					if (now - lastTick > 1000000000 / speed) { //Update game status continuously
						lastTick = now;
						tick(gc);
					}
				}
			}.start();


			//If you do not want to use css style, you can just delete the next line.
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("SNAKE GAME");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// tick, update status
	public static void tick(GraphicsContext gc) {
		System.out.println("       "+list.size());

		if (gameOver) {
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("GAME OVER", 100, 100);
			return;
		}

		int y;
		for (int i=0; i<list.size(); i++){
			y=list.get(i).getY();
			y++;
			list.get(i).setY(y);
		}

		for (int i=0; i<list.size(); i++){
			if (list.get(i).getY() > height) {
				gameOver = true;
			}
		}

		// fill
		// background
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, width * cornersize, height * cornersize);

		// score
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 30));
		gc.fillText("Score: " + MainController.score, 10, 30);

		// Paint word
		for (int i=0; i<list.size(); i++){
			gc.setFill(Color.BLACK);
			gc.fillText(""+list.get(i).getSpelling(), list.get(i).getX()*cornersize, list.get(i).getY()*cornersize);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
