package br.com.danielhabib.snake;

import java.util.HashMap;
import java.util.Map;

public class MovingRules {

	private Snake snake;
	private final Point offset;

	public MovingRules(Snake snake) {
		this(snake, new Point(1, 0));
	}

	public MovingRules(Snake snake, Point offset) {
		this.snake = snake;
		this.offset = offset;
	}

	public MovingRules move() {
		return new MovingRules(snake.move(snake.getX() + offset.getX(), snake.getY() + offset.getY()), offset);
	}

	public MovingRules turnLeft() {
		Map<Point, Point> leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap = new HashMap<>();
		leftTurningOffsetMap.put(new Point(1, 0), new Point(0, -1));
		leftTurningOffsetMap.put(new Point(0, -1), new Point(-1, 0));
		leftTurningOffsetMap.put(new Point(-1, 0), new Point(0, 1));
		leftTurningOffsetMap.put(new Point(0, 1), new Point(1, 0));

		return new MovingRules(snake, leftTurningOffsetMap.get(offset));
	}

	public MovingRules turnRight() {
		Map<Point, Point> rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap = new HashMap<>();
		rightTurningOffsetMap.put(new Point(1, 0), new Point(0, 1));
		rightTurningOffsetMap.put(new Point(0, 1), new Point(-1, 0));
		rightTurningOffsetMap.put(new Point(-1, 0), new Point(0, -1));
		rightTurningOffsetMap.put(new Point(0, -1), new Point(1, 0));

		return new MovingRules(snake, rightTurningOffsetMap.get(offset));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offset == null) ? 0 : offset.hashCode());
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
		MovingRules other = (MovingRules) obj;
		if (offset == null) {
			if (other.offset != null) {
				return false;
			}
		} else if (!offset.equals(other.offset)) {
			return false;
		}
		if (snake == null) {
			if (other.snake != null) {
				return false;
			}
		} else if (!snake.equals(other.snake)) {
			return false;
		}
		return true;
	}

	public void draw() {
		offset.draw();
		snake.draw();
	}

	public Snake getSnake() {
		return snake;
	}

}
