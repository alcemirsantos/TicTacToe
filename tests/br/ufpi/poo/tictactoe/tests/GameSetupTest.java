package br.ufpi.poo.tictactoe.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.ufpi.poo.tictactoe.models.Game;

public class GameSetupTest {

	private Game g;

	@Before
	public void setup() {
		g = new Game();
	}

	@Test
	public void testEmptyGameAtStart() {
		g.init();
		assertTrue(g.getBoard().isEmpty());
	}

}
