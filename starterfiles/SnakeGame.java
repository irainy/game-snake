import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SnakeGame extends JFrame {
	// DoublyLinkedList<Point> snake = new DoublyLinkedList<Point>();

	SnakeGame() {
		// SnakeGame frame = new SnakeGame();
		Grid grid = new Grid();

		// add grid to frame
		add(grid, BorderLayout.CENTER);

		setTitle("Snake");
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// start snake
		// Timer timer = new Timer(500, grid);
		// timer.start();
	}

	public static void main(String[] a) {
		new SnakeGame();
	}
}