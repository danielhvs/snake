package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoleMovingRulesTest extends BaseTest {

	@Test
	public void move_ThereIsAHoleInSnakeFront_TeleportsToTheEndOfTheHole() throws Exception {
		Snake finalSnakePosition = newSnake(10, 0);

		Snake snake = newSnake(0, 0);

		AMovingRules rules = new HoleMovingRules(new Hole(new Point(1, 0), new Point(10, 0)));

		Snake finalPosition = rules.update(snake);
		finalPosition = rules.update(finalPosition);

		assertEquals(finalSnakePosition, finalPosition);
	}

}
