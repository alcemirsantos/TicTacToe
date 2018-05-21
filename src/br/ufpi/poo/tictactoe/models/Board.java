package br.ufpi.poo.tictactoe.models;

import java.util.HashMap;
import java.util.Map;

import br.ufpi.poo.tictactoe.exceptions.InvalidPositionException;

public class Board {

	private Map<Position, Character> map;

	public Board() {
		this.map = new HashMap<Position, Character>();
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	public Map<Position, Character> getMap() {
		return this.map;
	}

	public boolean isFree(Position position) {
		for (Position p : this.map.keySet()) {
			if (p.equals(position))
				return false;
		}
		return true;
	}

	public void mark(Character aSymbol, Position aPosition){
		this.map.put(aPosition, aSymbol);
	}

	public boolean hasMark(Character aSymbol, Position position) {
		for (Position p : this.map.keySet()) {
			if (p.equals(position) && this.map.get(p).equals(aSymbol))
				return true;
		}
		return false;
	}

}
