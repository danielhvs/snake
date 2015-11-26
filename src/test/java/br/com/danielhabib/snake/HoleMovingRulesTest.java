package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoleMovingRulesTest extends BaseTest {

	@Test
	public void move_ThereIsAHoleInSnakeFront_TeleportsToTheEndOfTheHole() throws Exception {
		Snake finalSnakePosition = newSnake(10, 0);

		Snake snake = new Snake(new Point(0, 0), RIGHT);

		AMovingRules rules = new HoleMovingRules(new Hole(new Point(1, 0), new Point(10, 0)));

		Snake finalPosition = rules.update(snake);
		finalPosition = rules.update(finalPosition);

		Snake expected = new Snake(finalSnakePosition, RIGHT);
		assertEquals(expected, finalPosition);
	}

}
