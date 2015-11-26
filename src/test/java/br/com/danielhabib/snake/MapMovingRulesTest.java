package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MapMovingRulesTest {
	private static final Point ORIGIN = new Point(0, 0);

	@Test
	public void move_ThereIsAWall_DoesntMove() throws Exception {
		List<Point> map = wallNextToSnake();
		AMovingRules rules = new MapMovingRules(new MovingRules(), map);

		Snake snake = rules.update(new Snake(ORIGIN, Direction.RIGHT.getDirection()));

		assertEquals(ORIGIN, snake.getPosition());
	}

	@Test
	public void move_ThereIsNotAWall_Moves() throws Exception {
		List<Point> map = wallAwayFromSnake();
		AMovingRules rules = new MapMovingRules(new MovingRules(), map);

		Snake snake = rules.update(new Snake(ORIGIN, Direction.RIGHT.getDirection()));

		assertEquals(new Point(1, 0), snake.getPosition());
	}

	private List<Point> wallAwayFromSnake() {
		return Arrays.asList(new Point(10, 10));
	}

	private List<Point> wallNextToSnake() {
		return Arrays.asList(new Point(1, 0));
	}
}
