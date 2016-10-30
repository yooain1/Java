import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Odelo extends JFrame implements Runnable {

	final int Width = 400, Empty = 0, Black = 1, White = -1;
	private final int upper = 0, lower = 1, right = 2, left = 3, upperleft = 4,
			upperright = 5, lowerright = 6, lowerleft = 7;
	boolean direction[] = { false, false, false, false, false, false, false, false };
	public int turn;
	public int counter;
	protected int board[][];
	protected int countBlack = 0, countWhite = 0;
	public int current;
	public boolean playerTurn;
	
	Stack<Node> list = new Stack<Node>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Odelo();
	}

	public Odelo() {
		init();
	}

	public void init() {

		board = new int[8][8];

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = Empty;
			}
		}
		board[3][3] = Black;
		board[4][3] = White;
		board[3][4] = White;
		board[4][4] = Black;

		turn = Black;

		setTitle("Odelo Game");
		setBounds(300, 100, 520, 500);
		setResizable(false);
		setVisible(true);

	}

	public void drawBoard(Graphics g) {
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				test1(e);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				test2(e);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				test3(e);
				
			}
		});

		g.setColor(new Color(102,205,170));
		g.fillRect(0, 0, 520, 500);
		g.setColor(Color.DARK_GRAY);
		g.drawLine(0, 20, 0, Width+20);
		g.drawLine(Width, 20, Width, Width+20);
		g.drawLine(0, 20, Width, 20);
		g.drawLine(0, Width+20, Width, Width+20);

		for (int x = 1; x < 8; x++) {
			g.drawLine(Width * x / 8, 20, Width * x / 8, Width+20); // draw column
			g.drawLine(0, Width * x / 8 + 20, Width, Width * x / 8 + 20); // draw row
		}

	}

	public void drawDisc(int col, int row, Graphics g) {
		if (board[col][row] == Black) {
			g.setColor(Color.DARK_GRAY);
		} else if (board[col][row] == White) {
			g.setColor(Color.WHITE);
		}
		g.fillOval(col * Width / 8 + 2, row * Width / 8 + 2 +20, Width / 8 - 3,
				Width / 8 - 3);
	}

	public void test1(MouseEvent e) {
		repaint();
	}

	public void test2(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (e.getButton() == 3) {
			for (x = 0; x < 8; x++) {
				for (y = 0; y < 8; y++)
					if (checkDisc(x, y, turn) == true)
						drawValidDisc(x, y, getGraphics());
			}
		}
	}

	public void test3(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (e.getButton() == 1) {
			mouseUp(null, x, y);
		}
	}
	
	public void paint(Graphics g) {

		drawBoard(g);
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (board[x][y] != 0)
					drawDisc(x, y, g);
			}
		}
		 drawTurn(g);
		 drawCountDisc(g);

		if (countBlack + countWhite == 64 && countBlack + countWhite != 64)
			winner();
	}

	public void drawTurn(Graphics g) {
		String black = "Black ";
		String white = "White ";
		String pTurn = "Player's Turn";

		g.setColor(Color.DARK_GRAY);

		if (turn == Black) {
			g.drawString(black + pTurn, 170, Width + 50);
			g.setColor(Color.DARK_GRAY);
		} else {
			g.drawString(white + pTurn, 170, Width + 50);
			g.setColor(Color.WHITE);
		}
		g.fillOval(150, 440, 15, 15);
	}

	public void drawCountDisc(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillOval(Width + 15, 65, 15, 15);
		g.setColor(Color.WHITE);
		g.fillOval(Width + 15, 105, 15, 15);
		g.setColor(Color.BLACK);
		g.drawString("Black", Width + 35, 75);
		g.drawString("White", Width + 35, 115);
		g.drawString(Integer.toString(countBlack), Width + 70, 75);
		g.drawString(Integer.toString(countWhite), Width + 70, 115);

	}

	public void drawValidDisc(int col, int row, Graphics g) {
		if (board[col][row] == Black) {
			g.setColor(Color.RED);
		} else if (board[col][row] == White) {
			g.setColor(Color.RED);
		}
		g.setColor(Color.RED);
		g.drawOval(col * Width / 8, row * Width / 8, Width / 8, Width / 8);
	}

	public void removeValidDisc(int col, int row, Graphics g) {
		if (board[col][row] == Black) {
			g.setColor(Color.LIGHT_GRAY);
		} else if (board[col][row] == White) {
			g.setColor(Color.LIGHT_GRAY);
		}
		g.setColor(Color.LIGHT_GRAY);
		g.drawOval(col * Width / 8, row * Width / 8, Width / 8, Width / 8);
	}

	public void CountDisc() {
		countBlack = 0;
		countWhite = 0;

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (board[x][y] == Black)
					countBlack++;
				if (board[x][y] == White)
					countWhite++;
			}
		}
		if (countBlack + countWhite == 64) {
			winner();
			init();
		}
	}

	public boolean winner() {
		if (countBlack > countWhite) {
			JOptionPane.showMessageDialog(null, "          Black Wins!!", "WINNER", JOptionPane.PLAIN_MESSAGE);
		} else if (countBlack < countWhite) {
			JOptionPane.showMessageDialog(null, "          White Wins!!", "WINNER",JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Draw Game");
		}
		repaint();
		return true;
	}

	public boolean check(int turn) {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (checkDisc(x, y, turn)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean mouseUp(Event e, int x, int y) {
		int col = (int) (x / (Width / 8));
		int row = (int) (y / ((Width+20) / 8));

		if (turn == Black) {
			if (checkDisc(col, row, turn) == true) {
				turnDisc(col, row, turn);
				turn = -turn;
				CountDisc();
				copyBoard();
				update(getGraphics());
			}
		} else if (turn == White) {
			if (checkDisc(col, row, turn) == true) {
				turnDisc(col, row, turn);
				turn = -turn;
				CountDisc();
				copyBoard();
				update(getGraphics());
			}
		}
		return true;
	}

	public boolean checkDisc(int col, int row, int color) {
		int x, y;

		for (x = 0; x < 8; x++) {
			direction[x] = false;
		}
		if (board[col][row] != 0) {
			return false;
		} else {
			if (col > 1 && board[col - 1][row] == -color) {
				for (x = col - 2; x > 0 && board[x][row] == -color; x--)
					;
				if (board[x][row] == color) {
					direction[left] = true;
				}
			}
			if (col < 6 && board[col + 1][row] == -color) {
				for (x = col + 2; x < 7 && board[x][row] == -color; x++)
					;
				if (board[x][row] == color) {
					direction[right] = true;
				}
			}
			if (row > 1 && board[col][row - 1] == -color) {
				for (y = row - 2; y > 0 && board[col][y] == -color; y--)
					;
				if (board[col][y] == color) {
					direction[upper] = true;
				}
			}
			if (row < 6 && board[col][row + 1] == -color) {
				for (y = row + 2; y < 7 && board[col][y] == -color; y++)
					;
				if (board[col][y] == color) {
					direction[lower] = true;
				}
			}
			if (col > 1 && row > 1 && board[col - 1][row - 1] == -color) {
				for (x = col - 2, y = row - 2; x > 0 && y > 0
						&& board[x][y] == -color; x--, y--)
					;
				if (board[x][y] == color) {
					direction[upperleft] = true;
				}
			}
			if (col < 6 && row > 1 && board[col + 1][row - 1] == -color) {
				for (x = col + 2, y = row - 2; x < 7 && y > 0
						&& board[x][y] == -color; x++, y--)
					;
				if (board[x][y] == color) {
					direction[upperright] = true;
				}
			}
			if (col < 6 && row < 6 && board[col + 1][row + 1] == -color) {
				for (x = col + 2, y = row + 2; x < 7 && y < 7
						&& board[x][y] == -color; x++, y++)
					;
				if (board[x][y] == color) {
					direction[lowerright] = true;
				}
			}
			if (col > 1 && row < 6 && board[col - 1][row + 1] == -color) {
				for (x = col - 2, y = row + 2; x > 0 && y < 7
						&& board[x][y] == -color; x--, y++)
					;
				if (board[x][y] == color) {
					direction[lowerleft] = true;
				}
			}
			for (x = 0; x < 8; x++) {
				if (direction[x] == true) {
					return true;
				}
			}
			return false;
		}
	}

	public void turnDisc(int col, int row, int color) {
		board[col][row] = color;

		int x, y;

		if (direction[left] == true) {
			for (x = col - 1; board[x][row] != color; x--) {
				board[x][row] = -board[x][row];
			}
		}
		if (direction[right] == true) {
			for (x = col + 1; board[x][row] != color; x++) {
				board[x][row] = -board[x][row];
			}
		}
		if (direction[upper] == true) {
			for (y = row - 1; board[col][y] != color; y--) {
				board[col][y] = -board[col][y];
			}
		}
		if (direction[lower] == true) {
			for (y = row + 1; board[col][y] != color; y++) {
				board[col][y] = -board[col][y];
			}
		}
		if (direction[upperleft] == true) {
			for (x = col - 1, y = row - 1; board[x][y] != color; x--, y--) {
				board[x][y] = -board[x][y];
			}
		}
		if (direction[upperright] == true) {
			for (x = col + 1, y = row - 1; board[x][y] != color; x++, y--) {
				board[x][y] = -board[x][y];
			}
		}
		if (direction[lowerright] == true) {
			for (x = col + 1, y = row + 1; board[x][y] != color; x++, y++) {
				board[x][y] = -board[x][y];
			}
		}
		if (direction[lowerleft] == true) {
			for (x = col - 1, y = row + 1; board[x][y] != color; x--, y++) {
				board[x][y] = -board[x][y];
			}
		}
	}

	public void copyBoard() {
		int[][] copy = new int[8][8];
		Node tempGame = new Node(copy);
		list.push(tempGame);

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				copy[x][y] = board[x][y];
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

	public class Node {
		int[][] board1 = new int[8][8];

		public Node(int[][] aBoard1) {
			this.board1 = aBoard1;
		}
	}
}
