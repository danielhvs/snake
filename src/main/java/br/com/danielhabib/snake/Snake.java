package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	protected Snake tail;
	protected Point position;
	protected Point direction;

	public Snake() {
	}

	public Snake(Point position, Point direction, Snake tail) {
		this.position = position;
		this.direction = direction;
		this.tail = tail;
	}

	public Snake(Point position, Point direction) {
		this(position, direction, new SnakeEnd());
	}

	public Snake(int x, int y) {
		this(new Point(x, y), new Point(1, 0), new SnakeEnd());
	}

	public Snake(Snake snake, Point direction) {
		this(new Point(snake.getPosition()), direction, snake.getTail());
	}

	public Snake getTail() {
		return tail;
	}

	public Snake addTail(Point position) {
		return addTail(position.getX(), position.getY());
	}

	public Snake addTail(int x, int y) {
		Snake newTail = tail.addTail(x, y);
		return new Snake(position, direction, newTail);
	}

	public Snake addTail() {
		Point lastTailPosition = getLastTailPosition();
		Point newTailPosition = lastTailPosition.subtract(direction);
		Snake newTail = tail.addTail(newTailPosition);
		return new Snake(position, direction, newTail);
	}

	public void draw() {
		System.out.print(position);
		tail.draw();
	}

	public void draw(Graphics g) {
		int x = position.getX();
		int y = position.getY();
		int nextX = x + direction.getX();
		int nextY = y + direction.getY();
		g.drawRect(nextX * 16, nextY * 16, 4, 4);

		g.setColor(Color.BLUE);
		for (Point point : getPositions()) {
			g.fillOval(point.getX() * 16, point.getY() * 16, 16, 16);
		}
	}

	public Snake move(Point point) {
		return new Snake(point, direction, tail.move(position));
	}

	public Snake move() {
		return move(position.add(direction));
	}

	public List<Point> getPositions() {
		List<Point> points = new ArrayList<Point>();
		points.add(position);
		points.addAll(tail.getPositions());
		return points;
	}

	private Point getLastTailPosition() {
		List<Point> positions = getPositions();
		Point lastTailPosition = positions.get(positions.size() - 1);
		return lastTailPosition;
	}

	public Snake removeTail() {
		SnakeEnd snakeEnd = new SnakeEnd();
		return tail.equals(snakeEnd) ? snakeEnd : new Snake(position, direction, tail.removeTail());
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

	public Snake turn(Point direction) {
		return new Snake(position, direction, tail);
	}

}
