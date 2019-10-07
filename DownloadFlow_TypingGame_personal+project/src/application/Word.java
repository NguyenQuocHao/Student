package application;

public class Word {
	String spelling="";
	private int x;
	private int y;

	public Word(String spelling, int x, int y) {
		this.spelling = spelling;
		this.x = x;
		this.y = y;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
