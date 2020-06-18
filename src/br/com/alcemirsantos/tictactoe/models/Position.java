package br.com.alcemirsantos.tictactoe.models;

public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
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

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		Position other = null;
		if (o instanceof Position)
			other = (Position) o;
		if (this.x == other.getX() && this.y == other.getY())
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
}
