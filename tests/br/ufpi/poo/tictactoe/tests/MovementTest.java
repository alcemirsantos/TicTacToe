package br.ufpi.poo.tictactoe.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufpi.poo.tictactoe.exceptions.InvalidPositionException;
import br.ufpi.poo.tictactoe.exceptions.InvalidSymbolException;
import br.ufpi.poo.tictactoe.models.Game;
import br.ufpi.poo.tictactoe.models.Move;
import br.ufpi.poo.tictactoe.models.Position;

public class MovementTest {

	private Game g;

	@Before
	public void setup() {
		g = new Game();
	}

	@Test
	public void testValidMove00() throws InvalidPositionException,
			InvalidSymbolException {
		// Dado...
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(0, 0);
		Move aMove = new Move(aSymbol, aPosition);
		// quando
		boolean b = g.check(aMove);
		// então
		assertTrue(b);
	}

	@Test
	public void testValidMove01() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(0, 1);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove02() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(0, 2);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove10() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(1, 0);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove11() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(1, 1);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove12() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(1, 2);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove20() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(2, 0);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove21() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(2, 1);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	@Test
	public void testValidMove22() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		Character aSymbol = 'O';
		Position aPosition = new Position(2, 2);
		Move aMove = new Move(aSymbol, aPosition);
		assertTrue(g.check(aMove));
	}

	
	@Test(expected = InvalidPositionException.class)
	public void testInvalidPositionMoveX00() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(0, 0)));

		Character aSymbol = 'X';
		Position aPosition = new Position(0, 0);
		g.check(new Move(aSymbol, aPosition));
	}

	@Test(expected = InvalidSymbolException.class)
	public void testInvalidPlayerMoveX00() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		g.add(new Move('X', new Position(0, 0)));

		Character aSymbol = 'X';
		Position aPosition = new Position(0, 2);
		Move aMove = new Move(aSymbol, aPosition);
		g.check(aMove);
	}

	@Test(expected = InvalidSymbolException.class)
	public void testInvalidPlayerMoveO00() throws InvalidPositionException,
			InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(0, 0)));

		Character aSymbol = 'O';
		Position aPosition = new Position(0, 2);
		Move aMove = new Move(aSymbol, aPosition);
		g.check(aMove);
	}


	@Test(expected = InvalidPositionException.class)
	public void testExceptionInvalidPositionMoveX00()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(0, 0)));

		Character aSymbol = 'X';
		Position aPosition = new Position(0, 0);
		Move aMove = new Move(aSymbol, aPosition);
		g.add(aMove);
	}

	@Test(expected = InvalidPositionException.class)
	public void testExceptionInvalidPositionMoveY()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(2, 3)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testExceptionInvalidPositionMoveX()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(3, 2)));
	}

	@Test(expected = InvalidPositionException.class)
	public void testExceptionInvalidPositionMoveXY()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(3, 3)));
	}

	@Test(expected = InvalidSymbolException.class)
	public void testExceptionInvalidPlayerMoveO00()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('O', new Position(0, 0)));

		Character aSymbol = 'O';
		Position aPosition = new Position(0, 1);
		Move aMove = new Move(aSymbol, aPosition);
		g.add(aMove);
	}

	@Test(expected = InvalidSymbolException.class)
	public void testExceptionInvalidPlayerMoveX00()
			throws InvalidPositionException, InvalidSymbolException {
		g.init();
		g.add(new Move('X', new Position(0, 0)));

		Character aSymbol = 'X';
		Position aPosition = new Position(0, 1);
		Move aMove = new Move(aSymbol, aPosition);
		g.add(aMove);
	}

}
