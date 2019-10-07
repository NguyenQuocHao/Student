package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerDAO {
	private ArrayList<Player> _playerList= new ArrayList<Player>();


	public void setPlayerList(ArrayList<Player> _playerList) {
		this._playerList = _playerList;
	}

	//Load player from existing file
	public void load() {

		Scanner reader = null;
		try {
			File fileDescriptor = new File("player_data.txt");
			reader = new Scanner(fileDescriptor);

			_playerList.clear();   // Make sure the array list is empty before loading
			while (reader.hasNext()) {
				// Read the next line from the file
				String record = reader.nextLine();

				// Now split the line into separate fields
				String[] fields = record.split(",");

				String name = fields[0];
				int score = Integer.parseInt(fields[1]);

				// Create a player object and add it to the list
				Player player = new Player(name, score);
				_playerList.add(player);

			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();    // Note this can't recover from the error
		}
		finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

	//Write to save file
	public void save() {
		if (_playerList.size() == 0) {
			return;    // Don't overwrite the file with an empty list
		}
		PrintWriter writer = null;
		try {
			File fileDescriptor = new File("player_data.txt");
			writer = new PrintWriter(fileDescriptor);

			for (int i = 0; i <_playerList.size(); i++){
				Player p = _playerList.get(i);
				writer.println(p.getName() + "," +
						p.getScore()
						);
			}

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();     // Note this can't recover from the error
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

	//	Player lookUp(String playerName){

	public ArrayList<Player> getPlayerList() {
		return _playerList;
	}

	public void set_PlayerList(ArrayList<Player> _playerList) {
		this._playerList = _playerList;
	}




}
