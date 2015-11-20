package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoleMovingRulesTest {
	private static final Point LEFT = new Point(1, 0);

	@Test
	public void move_ThereIsAHoleInSnakeFront_TeleportsToTheEndOfTheHole() throws Exception {
		Snake snake = new Snake(0, 0);
		Snake finalSnakePosition = new Snake(10, 0);

		AMovingRules rules = new HoleMovingRules(new Snake(snake, LEFT), new Hole(new Point(1, 0), new Point(10, 0)));
		AMovingRules finalPosition = rules.move().move();

		AMovingRules expected = new HoleMovingRules(new Snake(finalSnakePosition, LEFT), new Hole(new Point(1, 0), new Point(10, 0)));
		assertEquals(expected, finalPosition);
	}

}
