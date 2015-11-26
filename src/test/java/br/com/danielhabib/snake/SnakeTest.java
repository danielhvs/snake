package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SnakeTest extends BaseTest {
	private static final Point RIGHT = Direction.RIGHT.getDirection();

	@Test
	public void equals_InitialCondition_HasOnlyHead() throws Exception {
		Snake snake = newSnake(1, 1);

		assertEquals(newSnake(1, 1), snake);
	}

	@Test
	public void move_OnlyHead_MovesOnePosition() throws Exception {
		Snake snake = newSnake(1, 1).move(new Point(2, 1));

		assertEquals(newSnake(2, 1), snake);
	}

	@Test
	public void move_ManyPieces_MovesAllPieces() throws Exception {
		Snake snake = newSnake(3, 1).addTail(2, 1, RIGHT).addTail(1, 1, RIGHT).addTail(0, 1, RIGHT);

		Snake actual = snake.move(new Point(4, 1));

		Snake expected = newSnake(4, 1).addTail(3, 1, RIGHT).addTail(2, 1, RIGHT).addTail(1, 1, RIGHT);
		assertEquals(expected, actual);
	}

	@Test
	public void getPosition_ManyPieces_ReturnsAllPositions() throws Exception {
		Snake snake = newSnake(3, 1).addTail(2, 1, RIGHT).addTail(1, 1, RIGHT).addTail(0, 1, RIGHT);

		List<Point> point = snake.getPositions();

		assertEquals(new Point(3, 1), point.get(0));
		assertEquals(new Point(2, 1), point.get(1));
		assertEquals(new Point(1, 1), point.get(2));
		assertEquals(new Point(0, 1), point.get(3));
	}

	@Test
	public void addTail_NoParameter_AddsAfterLastTail() throws Exception {
		Snake snake = newSnake(3, 1).addTail(2, 1, RIGHT).addTail(1, 1, RIGHT).addTail();
		Snake expected = newSnake(3, 1).addTail(2, 1, RIGHT).addTail(1, 1, RIGHT).addTail(0, 1, RIGHT);

		assertEquals(expected, snake);
	}

	@Test
	public void addTail_2PiecedSnake_MaintainsDirection() throws Exception {
		Snake snake = new Snake(new Point(0, 0), Direction.LEFT.getDirection()).addTail();

		assertEquals(Direction.LEFT.getDirection(), snake.getTail().getDirection());
	}

	@Test
	public void removeTail_OneHeadedSnake_ReturnsSnakeEnd() throws Exception {
		Snake snake = newSnake(0, 0).removeTail();

		assertEquals(new SnakeEnd(), snake);
	}

	@Test
	public void removeTail_TwoHeadedSnake_ReturnsOneHeaded() throws Exception {
		Snake snake = newSnake(0, 0).addTail(1, 0, RIGHT).removeTail();

		assertEquals(newSnake(0, 0), snake);
	}

	@Test
	public void revert_RevertsSnakePosition() throws Exception {
		Snake snake = newSnake(0, 0).revert();

		assertEquals(Direction.LEFT.getDirection(), snake.getDirection());
	}

	@Test
	public void revert_2PiecedSnake_RevertsSnakePosition() throws Exception {
		Snake expected = new Snake(new Point(0, 0), Direction.LEFT.getDirection()).addTail();

		Snake snake = newSnake(1, 0).addTail().revert();

		assertEquals(expected, snake);
	}

	@Test
	public void revert_ManyPiecedSnake_RevertsSnakeAndTailPosition() throws Exception {
		Snake expected = new Snake(new Point(0, 0), Direction.LEFT.getDirection()).addTail().addTail().addTail();

		Snake snake = newSnake(3, 0).addTail().addTail().addTail().revert();

		assertEquals(expected, snake);
	}

}
