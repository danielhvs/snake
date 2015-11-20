package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SnakeTest {
	@Test
	public void equals_InitialCondition_HasOnlyHead() throws Exception {
		Snake snake = new Snake(1, 1);

		assertEquals(new Snake(1, 1), snake);
	}

	@Test
	public void move_OnlyHead_MovesOnePosition() throws Exception {
		Snake snake = new Snake(1, 1).move(new Point(2, 1));

		assertEquals(new Snake(2, 1), snake);
	}

	@Test
	public void move_ManyPieces_MovesAllPieces() throws Exception {
		Snake snake = new Snake(3, 1).addTail(2, 1).addTail(1, 1).addTail(0, 1);

		Snake actual = snake.move(new Point(4, 1));

		Snake expected = new Snake(4, 1).addTail(3, 1).addTail(2, 1).addTail(1, 1);
		assertEquals(expected, actual);
	}

	@Test
	public void getPosition_ManyPieces_ReturnsAllPositions() throws Exception {
		Snake snake = new Snake(3, 1).addTail(2, 1).addTail(1, 1).addTail(0, 1);

		List<Point> point = snake.getPositions();

		assertEquals(new Point(3, 1), point.get(0));
		assertEquals(new Point(2, 1), point.get(1));
		assertEquals(new Point(1, 1), point.get(2));
		assertEquals(new Point(0, 1), point.get(3));
	}
}
