package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovingRulesTest {
	@Test
	public void move_DefaultDirection_MovesTheSnakeToTheRight() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).move();

		assertEquals(new MovingRules(new Snake(1, 0)), rules);
	}

	@Test
	public void turnLeftThenMove_MovesTheSnakeUp() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).turnLeft().move();

		assertEquals(new MovingRules(new Snake(0, -1), new Point(0, -1)), rules);
	}

	@Test
	public void turnRightThenMove_MovesTheSnakeDown() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).turnRight().move();

		assertEquals(new MovingRules(new Snake(0, 1), new Point(0, 1)), rules);
	}

	@Test
	public void turnLeftAndMove_ManyTimes_MovesTheSnakeAsExpected() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(3, 0)).turnLeft().move().turnLeft().move().turnLeft().move();

		assertEquals(new MovingRules(new Snake(2, 0), new Point(0, 1)), rules);
	}
}
