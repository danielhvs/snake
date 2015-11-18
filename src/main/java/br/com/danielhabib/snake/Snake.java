package br.com.danielhabib.snake;

public class Snake {

	private Snake tail;
	private int y;
	private int x;

	public Snake() {
	}

	public Snake(int x, int y, Snake tail) {
		this.x = x;
		this.y = y;
		this.tail = tail;
	}

	// Tail-less snake
	public Snake(int x, int y) {
		this(x, y, new SnakeEnd());
	}

	public int getSize() {
		return 1 + tail.getSize();
	}

	public Snake addTail(int x, int y) {
		Snake newTail = tail.addTail(x, y);
		return new Snake(this.x, this.y, newTail);
	}

	public void draw() {
		System.out.print("(" + x + "," + y + ")-");
		tail.draw();
	}

}
