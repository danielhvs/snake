package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MovingRulesTest {
	private static final Point UP = new Point(0, -1);
	private static final Point DOWN = new Point(0, 1);

	@Test
	public void move_DefaultDirection_MovesTheSnakeToTheRight() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).move();

		assertEquals(new MovingRules(new Snake(1, 0)), rules);
	}

	@Test
	public void turnLeftThenMove_MovesTheSnakeUp() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).turnLeft().move();

		assertEquals(new MovingRules(new Snake(new Point(0, -1), UP)), rules);
	}

	@Test
	public void turnRightThenMove_MovesTheSnakeDown() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(0, 0)).turnRight().move();

		assertEquals(new MovingRules(new Snake(new Point(0, 1), DOWN)), rules);
	}

	@Test
	public void turnLeftAndMove_ManyTimes_MovesTheSnakeAsExpected() throws Exception {
		AMovingRules rules = new MovingRules(new Snake(3, 0)).turnLeft().move().turnLeft().move().turnLeft().move();

		assertEquals(new MovingRules(new Snake(new Point(2, 0), DOWN)), rules);
	}
}
