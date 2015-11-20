package br.com.danielhabib.snake;

import org.junit.Assert;
import org.junit.Test;

public class RestrictedMovingRulesTest {

	@Test
	public void move_ThereIsTailInTheWay_DoesntMove() throws Exception {
		AMovingRules rules = new RestrictedMovingRules(snakeSize5())
		.turnLeft().move()
		.turnLeft().move()
		.turnLeft().move();

		Assert.assertEquals(new Point(4, -1), rules.getSnake().getPosition());
	}

	private Snake snakeSize5() {
		return new Snake(5, 0).addTail(4, 0).addTail(3, 0).addTail(2, 0).addTail(1, 0);
	}
}
