package br.com.danielhabib.snake;

public class BaseTest {
	protected final Point RIGHT = Direction.RIGHT.getDirection();

	protected Snake newSnake(int x, int y) {
		return new Snake(x, y, Direction.RIGHT.getDirection());
	}
}
