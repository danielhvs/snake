package br.com.danielhabib.snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {

	protected Snake tail;
	private Point position;
	private Point direction;

	public Snake() {
	}

	public Snake(Point position, Point direction, Snake tail) {
		this.position = position;
		this.direction = direction;
		this.tail = tail;
	}

	// Tail-less snake
	public Snake(Point position, Point direction) {
		this(position, direction, new SnakeEnd());
	}

	// Tail-less snake
	// TODO: Remove this
	public Snake(int x, int y) {
		this(new Point(x, y), new Point(1, 0), new SnakeEnd());
	}

	public Snake(Snake snake, Point direction) {
		this(new Point(snake.getPosition()), direction, snake.getTail());
	}

	public Snake getTail() {
		return tail;
	}

	public Snake addTail(int x, int y) {
		Snake newTail = tail.addTail(x, y);
		return new Snake(position, direction, newTail);
	}

	public void draw() {
		System.out.print(position);
		tail.draw();
	}

	public Snake move(Point point) {
		return new Snake(point, direction, tail.move(position));
	}

	public List<Point> getPositions() {
		List<Point> points = new ArrayList<Point>();
		points.add(position);
		points.addAll(tail.getPositions());
		return points;
	}

	public Point getPosition() {
		return position;
	}

	public Point getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return position + "-" + tail.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
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
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (tail == null) {
			if (other.tail != null) {
				return false;
			}
		} else if (!tail.equals(other.tail)) {
			return false;
		}
		return true;
	}

}
