package br.com.alcemirsantos.tictactoe.exceptions;

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {

	public InvalidPositionException(String message){
		super(message);
	}
}
