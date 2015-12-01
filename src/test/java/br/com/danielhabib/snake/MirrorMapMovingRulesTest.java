package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MirrorMapMovingRulesTest extends BaseTest {
	@Test
	public void move_RightLastXPosition_GoesToFirstXPosition() throws Exception {
		AMovingRules rules = new MirrorMapMovingRules(new MovingRules(), 1, 1);

		Snake snake = rules.update(newSnake(1, 0, Direction.RIGHT));

		assertEquals(new Point(0, 0), snake.getPosition());
	}

	@Test
	public void move_DownLastYPosition_GoesToFirstYPosition() throws Exception {
		AMovingRules rules = new MirrorMapMovingRules(new MovingRules(), 1, 1);

		Snake snake = rules.update(newSnake(0, 1, Direction.DOWN));

		assertEquals(new Point(0, 0), snake.getPosition());
	}

	@Test
	public void move_UpLastYPosition_GoesToFirstYPosition() throws Exception {
		AMovingRules rules = new MirrorMapMovingRules(new MovingRules(), 1, 1);

		Snake snake = rules.update(newSnake(0, 0, Direction.UP));

		assertEquals(new Point(0, 1), snake.getPosition());
	}

	@Test
	public void move_LeftLastXPosition_GoesToFirstXPosition() throws Exception {
		AMovingRules rules = new MirrorMapMovingRules(new MovingRules(), 1, 1);

		Snake snake = rules.update(newSnake(0, 0, Direction.LEFT));

		assertEquals(new Point(1, 0), snake.getPosition());
	}
}
