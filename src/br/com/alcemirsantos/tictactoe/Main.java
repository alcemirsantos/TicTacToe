package br.com.alcemirsantos.tictactoe;

import java.util.Map.Entry;
import java.util.Scanner;

import br.com.alcemirsantos.tictactoe.exceptions.InvalidPositionException;
import br.com.alcemirsantos.tictactoe.exceptions.InvalidSymbolException;
import br.com.alcemirsantos.tictactoe.models.Board;
import br.com.alcemirsantos.tictactoe.models.Game;
import br.com.alcemirsantos.tictactoe.models.Move;
import br.com.alcemirsantos.tictactoe.models.Position;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Game g = new Game();
		g.init();

		printHeader();

		for (int round = 1; round <= 9; round++) {
			System.out.println("|=====[ Jogada " + round + " ]=======|");
			printBoard(g.getBoard());

			Position p = askForMove();
			Character c = g.whosNext();
			Move newMove = new Move(c, p);

			try {
				g.add(newMove);
			} catch (InvalidPositionException e) {
				System.err.println("\n[ERROR 1]: " + e.getMessage());
			} catch (InvalidSymbolException e) {
				System.err.println("\n[ERROR 2]: " + e.getMessage());
			}

			if (g.hasWinner())
				break;
		}

		System.out.println("====== Fim de Jogo! ======");
		if (g.hasWinner())
			System.out
					.println("Parabéns! \'" + g.getLastToPlay() + "\' venceu");
		else
			System.out.println("Empate! Tentem novamente!");
		System.out.println("--------------------------");
		printBoard(g.getBoard());
		System.out.println("==========================");
		sc.close();
	}

	private static void printHeader() {
		System.out.println("::::::::::::::::::::::::::");
		System.out.println(":::::: Tic Tac Toe! ::::::");
		System.out.println("::::::::::::::::::::::::::\n");
	}

	private static void printBoard(Board board) {
		Character[][] map = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' },
				{ ' ', ' ', ' ' } };
		for (Entry<Position, Character> e : board.getMap().entrySet()) {
			map[e.getKey().getX()][e.getKey().getY()] = e.getValue();
		}
		System.out.println("\t   0  1  2 ");
		for (int r = 0; r < 3; r++) {
			System.out.println("\t" + r + " [" + map[r][0] + "][" + map[r][1]
					+ "][" + map[r][2] + "]");
		}
	}

	private static Position askForMove() {
		System.out.println("\n::Digite posição da macação!");
		int linha = 99, coluna = 99;
		while (linha==99) {
			System.out.print("Linha:");
			try {
			    linha = Integer.parseInt(sc.nextLine());
			    break;
			} catch (NumberFormatException e) {
				System.err.println("\nLinha inválida! Digite somente (um) número(s)!");
			}
		}
		
		while (coluna==99) {
			System.out.print("Coluna:");
			try {
			    coluna = Integer.parseInt(sc.nextLine());
			    break;
			} catch (NumberFormatException e) {
				System.err.println("\nColuna inválida! Digite somente (um) número(s)!");
			}
		}
		return new Position(linha, coluna);
	}

}
