package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class SnakeControllerTest {
	@TestWith({ "LEFT", "RIGHT" })
	public void up_SnakeCanGoUp_TurnsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.up(snake);

		assertEquals(Direction.UP.getDirection(), result.getDirection());
	}

	@TestWith({ "UP", "DOWN" })
	public void up_SnakeCannotGoUp_MaintainsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.up(snake);

		assertEquals(direction.getDirection(), result.getDirection());
	}

	@TestWith({ "LEFT", "RIGHT" })
	public void down_SnakeCanGoDown_TurnsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.down(snake);

		assertEquals(Direction.DOWN.getDirection(), result.getDirection());
	}

	@TestWith({ "UP", "DOWN" })
	public void down_SnakeCannotGoDown_MaintainsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.down(snake);

		assertEquals(direction.getDirection(), result.getDirection());
	}

	@TestWith({ "LEFT", "RIGHT" })
	public void left_SnakeCannotGoLeft_MaintainsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.left(snake);

		assertEquals(direction.getDirection(), result.getDirection());
	}

	@TestWith({ "UP", "DOWN" })
	public void left_SnakeCanGoLeft_TurnsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.left(snake);

		assertEquals(Direction.LEFT.getDirection(), result.getDirection());
	}

	@TestWith({ "UP", "DOWN" })
	public void right_SnakeCanGoRight_TurnsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.right(snake);

		assertEquals(Direction.RIGHT.getDirection(), result.getDirection());
	}

	@TestWith({ "LEFT", "RIGHT" })
	public void right_SnakeCannotGoRight_MaintainsDirection(Direction direction) throws Exception {
		SnakeController controller = new SnakeController(new MovingRules());

		Snake snake = new Snake(new Point(0, 0), direction.getDirection());
		Snake result = controller.right(snake);

		assertEquals(direction.getDirection(), result.getDirection());
	}
}
