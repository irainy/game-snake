import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Grid extends JPanel implements KeyListener, ActionListener {

	private final int GRID_SIZE = 30;
	private final int CELL_SIZE = 20;
	private Snake snake;
	private boolean isDeath = false;
	private int curDir = 0;
	private int[][] grid = new int[GRID_SIZE][GRID_SIZE];

	final int EMPTY = 0;
	final int WALL = -1;
	final int SNAKE = -2;

	private Timer timer;
	public Grid() {
		// intialize
		// ...

		snake = new Snake();
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				if (i == 0 || j == 0 || i == GRID_SIZE - 1
						|| j == GRID_SIZE - 1) {
					grid[i][j] = -1;// wall
				} else if (j == snake.head.object.y
						&& i > snake.head.object.x + 2) {// preset foods
					grid[i][j] = 1;
				} else {
					if (Math.random() > 0.99)
						grid[i][j] = (int) (Math.random() * 10);
					else
						grid[i][j] = 0;// empty
				}
			}
		}

		// install key listener and obtain focus
		addKeyListener(this);
		setFocusable(true);
		requestFocus();
		
		step();
		timer = new Timer(200, this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw each grid element
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				int cell = grid[i][j];

				g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
				if (cell == WALL || cell == SNAKE) {// WALL & SNAKE
					g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE,
							CELL_SIZE);
				} else if (cell > EMPTY) {// FOOD
					g.drawString("" + cell, i * CELL_SIZE, (j + 1) * CELL_SIZE);
				}
			}

		}
	}

	/**
	 * let the snake make a step
	 */
	void step() {
		// ...
		Point dir = snake.getDirection();
		int nextCell = grid[snake.head.object.x + dir.x][snake.head.object.y
				+ dir.y];
		if (nextCell < EMPTY) {
			isDeath = true;
		} else {
			if (nextCell > EMPTY)
				snake.eat(nextCell);
			isDeath = false;

			if (snake.food == 0)
				grid[snake.tail.object.x][snake.tail.object.y] = EMPTY;

			snake.step();
			// System.out.print("Draw snake again! " + snake.head.object.x +
			// ", "
			// + snake.head.object.y + "\n");

			int len = snake.size;
			snake.cur = snake.head;
			while (len > 0) {
				grid[snake.cur.object.x][snake.cur.object.y] = SNAKE;
				snake.cur = snake.cur.next;
				len--;
			}
			repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// inspect e.getKeycode()
		// arrow key codes: KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
		// KeyEvent.VK_RIGHT
		int x = 0, y = 0, d = 0;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			x = 0;
			y = -1;
			d = 1;
			break;
		case KeyEvent.VK_DOWN:
			x = 0;
			y = 1;
			d = -1;
			break;
		case KeyEvent.VK_LEFT:
			x = -1;
			y = 0;
			d = 2;
			break;
		case KeyEvent.VK_RIGHT:
			x = 1;
			y = 0;
			d = -2;
			break;
		}
		if (d + this.curDir != 0) {
			snake.setDirection(x, y);
			this.curDir = d;
			isDeath = false;
			
			timer.start();
		} else {
			System.out.println("You cannot turn back!");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // called on Timer event
		// ...

		if (!isDeath) {
			step();
		} else {
			System.out.println("Game over!");
		}
	}
}