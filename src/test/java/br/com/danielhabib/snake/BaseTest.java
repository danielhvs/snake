package br.com.danielhabib.snake;

import java.util.Stack;

public class BaseTest {
	protected final Point RIGHT = Direction.RIGHT.getDirection();

	protected Snake newSnake(int x, int y) {
		return newSnake(x, y, Direction.RIGHT);
	}

	protected Snake newSnake(Point point, Direction direction) {
		return newSnake(point.getX(), point.getY(), direction);
	}

	protected Snake newSnake(int x, int y, Direction direction) {
		Stack<Piece> pieces = new Stack<Piece>();
		pieces.push(new Piece(new Point(x, y), direction));
		return new Snake(pieces);
	}
}
