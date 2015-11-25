package br.com.danielhabib.snake;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

public abstract class AMovingRules implements IRule {

	@Override
	public abstract Snake update(Snake snake);

	@Override
	public void draw(Graphics g) {
	}

	public Snake turnLeft(Snake snake) {
		Map<Point, Point> leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap = new HashMap<Point, Point>();
		leftTurningOffsetMap.put(new Point(1, 0), new Point(0, -1));
		leftTurningOffsetMap.put(new Point(0, -1), new Point(-1, 0));
		leftTurningOffsetMap.put(new Point(-1, 0), new Point(0, 1));
		leftTurningOffsetMap.put(new Point(0, 1), new Point(1, 0));

		return snake.turn(leftTurningOffsetMap.get(snake.getDirection()));
	}

	public Snake turnRight(Snake snake) {
		Map<Point, Point> rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap = new HashMap<Point, Point>();
		rightTurningOffsetMap.put(new Point(1, 0), new Point(0, 1));
		rightTurningOffsetMap.put(new Point(0, 1), new Point(-1, 0));
		rightTurningOffsetMap.put(new Point(-1, 0), new Point(0, -1));
		rightTurningOffsetMap.put(new Point(0, -1), new Point(1, 0));

		return snake.turn(rightTurningOffsetMap.get(snake.getDirection()));
	}

}
