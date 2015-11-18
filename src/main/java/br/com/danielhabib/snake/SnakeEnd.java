package br.com.danielhabib.snake;

public class SnakeEnd extends Snake {

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public Snake addTail(int x, int y) {
		return new Snake(x, y);
	}

	@Override
	public void draw() {
	}
}
