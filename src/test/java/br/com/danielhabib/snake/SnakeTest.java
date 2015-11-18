package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

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
}
