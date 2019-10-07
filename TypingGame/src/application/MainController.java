package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MainController {
	@FXML private TextField inp;
	@FXML private ProgressBar bar;
	Scene scene = Main.scene;
	//	Word word = Main.word;
	static ArrayList<Word> list = new ArrayList<>();
	static int speed = 5;
	static int score=0;
	static boolean gameOver = false;
	static int n;
	Random rand = new Random();
	Canvas c;
	static boolean correct=false;


	@FXML private void initialize() {
		c= Main.c;
		scene = Main.scene;


		// Obtain a number between [0 - 49].
		n = rand.nextInt(90)+10;
		System.out.println(n);
		list.add(new Word(""+n,rand.nextInt(24),0));

		new AnimationTimer() {
			long lastTick = 0;
			public void handle(long now) {
				if (lastTick == 0) {
					lastTick = now;
					return;
				}
				if (now - lastTick > 1000000000 / speed) { //Update game status continuously
					lastTick = now;
					checkInput(list, ""+n);
				}
			}
		}.start();

		new AnimationTimer() {
			long lastTick = 0;
			public void handle(long now) {
				if (lastTick == 0) {
					lastTick = now;
					return;
				}
				if (now - lastTick > 999999999) { //Update game status continuously
					lastTick = now;
					list.add(new Word(""+rand.nextInt(90)+10,rand.nextInt(24),0));

				}
			}
		}.start();

	}

	public void checkInput(ArrayList<Word> list, String str){
		for (int i=0; i<list.size(); i++){
			if (inp.getText().equals(list.get(i).getSpelling())){
				System.out.println(i+" got emilinated");
				list.remove(i);
				inp.setText("");
				score++;
				System.out.println("Score "+score);

			}
		}
	}


}
