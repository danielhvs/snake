package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class SnakeTest {
	@Test
	public void snake_InitialCondition_HasOnlyHead() throws Exception {
		Snake snake = new Snake(1, 1);

		int size = snake.getSize();

		assertEquals(1, size);
	}

	@Test
	public void snake_WithOneTail_HasCorrectSize() throws Exception {
		Snake snake = new Snake(1, 1).addTail(0, 1);

		int size = snake.getSize();

		assertEquals(2, size);
	}

	@Test
	public void snake_WithManyPieces_HasCorrectSize() throws Exception {
		Snake snake = new Snake(3, 1).addTail(2, 1).addTail(1, 1).addTail(0, 1);

		int size = snake.getSize();

		assertEquals(4, size);
	}

	@Test
	public void draw_SnakeWithManyPieces_ShowsRepresentation() throws Exception {
		Snake snake = new Snake(3, 1).addTail(2, 1).addTail(1, 1).addTail(0, 1);

		snake.draw();
	}

	@Test
	public void move_OnlyHead_MovesOnePosition() throws Exception {
		Snake snake = new Snake(1, 1).move(2, 1);

		assertEquals(new Snake(2, 1), snake);
	}

	@Test
	public void move_ManyPieces_MovesAllPieces() throws Exception {
		Snake snake = new Snake(3, 1).addTail(2, 1).addTail(1, 1).addTail(0, 1);

		Snake actual = snake.move(4, 1);

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
