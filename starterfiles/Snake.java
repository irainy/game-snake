import java.awt.Point;

public class Snake extends DoublyLinkedList<Point> {
	private Point direction = null;// UP: (0, -1); DOWN: (0, 1); LEFT: (-1, 0);
									// RIGHT: (1, 0)
	public int food = 0;

	private Point next;

	public Snake() {
		// ...
		addFirst(new Point(1, 1));
		setDirection(1, 0);
	}

	public void setDirection(int x, int y) {
		// ...
		direction = new Point(x, y);
	}

	public Point getDirection() {
		// ...
		return direction;
	}

	public void step() {
		// ...
		next = new Point(head.object.x + direction.x, head.object.y
				+ direction.y);
		addFirst(next);
		if (food == 0)
			removeLast();
		else
			food--;
		// System.out.print("head@" + head.object.x + ", " + head.object.y);
	}

	public void eat(int f) {
		food += f;
	}

	// ...
}