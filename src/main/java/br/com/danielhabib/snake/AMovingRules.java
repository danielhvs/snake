package br.com.danielhabib.snake;

import java.util.HashMap;
import java.util.Map;

public abstract class AMovingRules {
	protected Snake snake;
	protected final Point movingOffset;

	public AMovingRules(Snake snake) {
		this(snake, new Point(1, 0));
	}

	public AMovingRules(Snake snake, Point offset) {
		this.snake = snake;
		this.movingOffset = offset;
	}

	public abstract AMovingRules move();

	protected abstract AMovingRules newInstanceOfMovingRules(Snake snake, Point point);

	public AMovingRules turnLeft() {
		Map<Point, Point> leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap.put(new Point(1, 0), new Point(0, -1));
		leftTurningOffsetMap.put(new Point(0, -1), new Point(-1, 0));
		leftTurningOffsetMap.put(new Point(-1, 0), new Point(0, 1));
		leftTurningOffsetMap.put(new Point(0, 1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, leftTurningOffsetMap.get(movingOffset));
	}

	public AMovingRules turnRight() {
		Map<Point, Point> rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap.put(new Point(1, 0), new Point(0, 1));
		rightTurningOffsetMap.put(new Point(0, 1), new Point(-1, 0));
		rightTurningOffsetMap.put(new Point(-1, 0), new Point(0, -1));
		rightTurningOffsetMap.put(new Point(0, -1), new Point(1, 0));

		return newInstanceOfMovingRules(snake, rightTurningOffsetMap.get(movingOffset));
	}

	public void draw() {
		movingOffset.draw();
		snake.draw();
	}

	public Snake getSnake() {
		return snake;
	}

}
