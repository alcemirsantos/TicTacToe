package br.com.alcemirsantos.tictactoe.models;

public class Move {

	private Position position;
	private Character symbol;

	public Move(Character aSymbol, Position aPosition) {
		this.symbol = aSymbol;
		this.position = aPosition;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Character getSymbol() {
		return symbol;
	}

	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return this.symbol+" @ "+this.position;
	}
}
