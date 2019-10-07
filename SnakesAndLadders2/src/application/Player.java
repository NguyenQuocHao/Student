package application;

public class Player {

	private String _name;
	protected int _location =0;
	private int _score = 0;


	public int getScore() {
		return _score;
	}

	public void setScore(int _score) {
		this._score = _score;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public Player(String name){
		_name = name;

	}
	public Player(String name, int score){
		_name = name;
		_score = score;

	}
	public String toString(){
		return "Player: "+_name+"_"+_score;
	}


}
