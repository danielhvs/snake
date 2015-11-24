package br.com.danielhabib.snake;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SnakeEnd extends Snake {

	public SnakeEnd() {
		initNOP();
	}

	@Override
	public Snake addTail(int x, int y) {
		return new Snake(x, y);
	}

	@Override
	public void draw() {
		System.out.println();
	}

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public String toString() {
		return ".";
	}

	@Override
	public Snake move(Point point) {
		return this;
	}

	@Override
	public List<Point> getPositions() {
		return new ArrayList<Point>();
	}

	@Override
	public Snake removeTail() {
		return this;
	}

	@Override
	public Snake move() {
		return this;
	}

	@Override
	public Snake turn(Point direction) {
		return this;
	}

	@Override
	public Snake addTail() {
		return this;
	}

	private void initNOP() {
		this.position = new Point(-1, -1);
		this.direction = new Point(0, 0);
	}

}
