package br.com.alcemirsantos.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

import br.com.alcemirsantos.tictactoe.exceptions.InvalidPositionException;
import br.com.alcemirsantos.tictactoe.exceptions.InvalidSymbolException;

public class Game {

	private Board board;
	private List<Move> moves;
	private Character lastToPlay;

	public void init() {
		this.board = new Board();
		this.moves = new ArrayList<Move>();
		this.lastToPlay = null;
	}

	public Board getBoard() {
		return this.board;
	}

	public List<Move> getMoves() {
		return this.moves;
	}


	public Character getLastToPlay() {
		return this.lastToPlay;
	}

	public void add(Move aMove) throws InvalidPositionException,
			InvalidSymbolException {
		check(aMove);
		this.board.mark(aMove.getSymbol(), aMove.getPosition());
		this.moves.add(this.moves.size(), aMove);
		lastToPlay = aMove.getSymbol();
	}

	public boolean check(Move aMove) throws InvalidPositionException,
			InvalidSymbolException {
		try {
			checkBounds(aMove.getPosition());
			checkUsed(aMove.getPosition());
			checkTurn(aMove.getSymbol());
			checkStrangeSysmbol(aMove.getSymbol());
		} catch (InvalidPositionException | InvalidSymbolException e) {
			throw e;
		}
		return true;
	}

	private boolean checkStrangeSysmbol(Character c)
			throws InvalidSymbolException {
		if (!c.equals('X') || !c.equals('O'))
			return true;
		else
			throw new InvalidSymbolException(
					"Invalid Marker! Use \'X\' or \'O\' instead!");
	}

	private boolean checkTurn(Character c) throws InvalidSymbolException {
		if (c.equals(whosNext()))
			return true;
		else
			throw new InvalidSymbolException("Wait" + c
					+ "! Now is the other player turn!");
	}

	public boolean isValidPosition(Move move) throws InvalidPositionException {
		return checkUsed(move.getPosition()) || checkBounds(move.getPosition());
	}

	private boolean checkUsed(Position p) throws InvalidPositionException {
		if (this.board.isFree(p))
			return true;
		else
			throw new InvalidPositionException("The position (" + p.getX()
					+ ", " + p.getY() + ") is already taken!");
	}

	private boolean checkBounds(Position p) throws InvalidPositionException {
		if ((p.getX() <= 2) && (p.getY() <= 2) && (p.getX() >= 0)
				&& (p.getY() >= 0))
			return true;
		else
			throw new InvalidPositionException(
					"The position is out of bounds!\n "
							+ "-> Choose numbers between 0 and 2, inclusive.");

	}

	public Character whosNext() {
		if (moves.isEmpty())
			return 'O';
		else if (moves.get(moves.size() - 1).getSymbol().equals('X'))
			return 'O';
		else
			return 'X';
	}

	public boolean hasWinner() {
		return (checkHorizontals() || checkVerticals() || checkDiagonals());
	}

	private boolean checkHorizontals() {
		return (checkHorizontal(0) || checkHorizontal(1) || checkHorizontal(2));
	}

	private boolean checkHorizontal(int row) {
		return (this.board.hasMark(this.lastToPlay, new Position(row, 0))
				&& this.board.hasMark(this.lastToPlay, new Position(row, 1)) && this.board
					.hasMark(this.lastToPlay, new Position(row, 2)));
	}

	private boolean checkVerticals() {
		return (checkVertical(0) || checkVertical(1) || checkVertical(2));
	}

	private boolean checkVertical(int column) {
		return (this.board.hasMark(this.lastToPlay, new Position(0, column))
				&& this.board.hasMark(this.lastToPlay, new Position(1, column)) && this.board
					.hasMark(this.lastToPlay, new Position(2, column)));
	}

	private boolean checkDiagonals() {
		if (this.board.hasMark(this.lastToPlay, new Position(0, 0))
				&& this.board.hasMark(this.lastToPlay, new Position(1, 1))
				&& this.board.hasMark(this.lastToPlay, new Position(2, 2)))
			return true;
		else if (this.board.hasMark(this.lastToPlay, new Position(2, 0))
				&& this.board.hasMark(this.lastToPlay, new Position(1, 1))
				&& this.board.hasMark(this.lastToPlay, new Position(0, 2)))
			return true;
		else
			return false;
	}

}
