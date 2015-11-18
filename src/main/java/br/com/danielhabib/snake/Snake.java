package br.com.danielhabib.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

	protected Snake tail;
	private int y;
	private int x;

	public Snake() {
	}

	public Snake(int x, int y, Snake tail) {
		this.x = x;
		this.y = y;
		this.tail = tail;
	}

	// Tail-less snake
	public Snake(int x, int y) {
		this(x, y, new SnakeEnd());
	}

	public int getSize() {
		return 1 + tail.getSize();
	}

	public Snake addTail(int x, int y) {
		Snake newTail = tail.addTail(x, y);
		return new Snake(this.x, this.y, newTail);
	}

	public void draw() {
		System.out.print("(" + x + "," + y + ")-");
		tail.draw();
	}

	public Snake move(int x, int y) {
		return new Snake(x, y, tail.move(this.x, this.y));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Snake other = (Snake) obj;
		if (tail == null) {
			if (other.tail != null) {
				return false;
			}
		} else if (!tail.equals(other.tail)) {
			return false;
		}
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	public List<Point> getPositions() {
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(x, y));
		points.addAll(tail.getPositions());
		return points;
	}

	public Point getPosition() {
		return new Point(x, y);
	}

}
