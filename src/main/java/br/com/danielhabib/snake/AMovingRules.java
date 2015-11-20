package br.com.danielhabib.snake;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public abstract class AMovingRules {
	protected Snake snake;

	public AMovingRules(Snake snake) {
		this.snake = snake;
	}

	public abstract AMovingRules move();

	protected abstract AMovingRules newInstanceOfMovingRules(Snake snake, Point direction);

	public AMovingRules turnLeft() {
		Map<Point, Point> leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap.put(new Point(1, 0), new Point(0, -1));
		leftTurningOffsetMap.put(new Point(0, -1), new Point(-1, 0));
		leftTurningOffsetMap.put(new Point(-1, 0), new Point(0, 1));
		leftTurningOffsetMap.put(new Point(0, 1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, leftTurningOffsetMap.get(snake.getDirection()));
	}

	public AMovingRules turnRight() {
		Map<Point, Point> rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap.put(new Point(1, 0), new Point(0, 1));
		rightTurningOffsetMap.put(new Point(0, 1), new Point(-1, 0));
		rightTurningOffsetMap.put(new Point(-1, 0), new Point(0, -1));
		rightTurningOffsetMap.put(new Point(0, -1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, rightTurningOffsetMap.get(snake.getDirection()));
	}

	public void draw(Graphics g) {
		Point position = snake.getPosition();
		Point direction = snake.getDirection();

		int x = position.getX();
		int y = position.getY();
		int nextX = x + direction.getX();
		int nextY = y + direction.getY();
		g.drawRect(nextX * 16, nextY * 16, 4, 4);

		direction.draw();
		snake.draw();
	}

	public Snake getSnake() {
		return snake;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((snake == null) ? 0 : snake.hashCode());
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
		AMovingRules other = (AMovingRules) obj;
		if (snake == null) {
			if (other.snake != null) {
				return false;
			}
		} else if (!snake.equals(other.snake)) {
			return false;
		}
		return true;
	}

	public void setSnake(Snake update) {
		this.snake = update;
	}

}
