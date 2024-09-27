package fundamentalStructures;

import java.util.Scanner;

public class TictacArray {
	char[][] board = new char[3][3];
	int boardmax = 3;
	
	public TictacArray() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				board[i][j] = '-';
			}
		}
	}
	
	void printBoard() {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(board[i][j]);
			}
			System.out.print('\n');
		}
	}
	
	boolean checkBoard(int x, int y) {
		return (board[x][y] != '-');
	}
	
	boolean checkWin(char xo) {
		
		for (int i=0; i<3; i++) {
			if (board[i][0] == xo && board[i][1] == xo && board[i][2] == xo) {
				return true;
			}
			if (board[0][i] == xo && board[1][i] == xo && board[2][i] == xo) {
				return true;
			}

		}
		// cant be done in a loop i guess
		if (board[0][0] == xo && board[1][1] == xo && board[2][2] == xo) {
			return true;
		}
		if (board[0][2] == xo && board[1][1] == xo && board[2][0] == xo) {
			return true;
		}
		return false;
	}
	
	boolean processInput(String input, int player) {
		int x, y;
		boolean alreadyTaken;
		String[] parts = input.split(",");
		x = Integer.parseInt(parts[0]);
		y = Integer.parseInt(parts[1]);
		if ((x | y) > boardmax) {
			System.out.println("Invalid input!");
			return false;
		}
		alreadyTaken = checkBoard(x, y);
		if (alreadyTaken) {
			System.out.println("Already taken!");
			return false;
		}
		if (player == 1) {
			board[x][y] = 'X';
		} else {
			board[x][y] = 'O';
		}
		return true;
	}
	
	void play(String p1, String p2) {
		boolean done = false;
		String in1, in2;
		Scanner gameScan = new Scanner(System.in);
		System.out.println("Enter coordinates from 1-3 (eg 3,1).");
		while (!done) {
			boolean p1input = false;
			boolean p2input = false;
			printBoard();
			while (!p1input) {
				System.out.println(p1 + ", enter a coordinate.");
				in1 = gameScan.nextLine();
				p1input = processInput(in1, 1);
			}
			printBoard();
			while (!p2input) {
				System.out.println(p2 +", enter a coordinate.");
				in2 = gameScan.nextLine();
				p2input = processInput(in2, 2);
			}
			if (checkWin('X')) {
				System.out.println(p1 + " wins!");
				done = true;
				break;
			}
			if (checkWin('O')) {
				System.out.println(p2 + " wins!");
				done = true;
				break;
			}
		}
		gameScan.close();
	}
	
	public static void main(String[] args) throws Exception {
		String player1, player2;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Player 1's name: ");
		player1 = scan.nextLine();
		System.out.println("Enter Player 2's name: ");
		player2 = scan.nextLine();
		TictacArray game = new TictacArray();
		game.play(player1, player2);
		scan.close();
	}
}