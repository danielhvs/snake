package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;

//Stateful rule!
public class PoisonedFruitRule implements IRule {

	private Point fruitPosition;

	public PoisonedFruitRule(Point fruitPosition) {
		this.fruitPosition = fruitPosition;
	}

	@Override
	public Snake update(Snake snake) {
		return snake.getPosition().equals(fruitPosition) ? consumesFruit(snake) : snake;
	}

	private Snake consumesFruit(Snake snake) {
		fruitPosition = new Point(-1, -1); // NOP: state change!
		return snake.removeTail();
	}

	@Override
	public void draw(Graphics g) {
		if (fruitPosition.getX() >= 0) {
			g.setColor(Color.RED);
			g.fillOval(fruitPosition.getX() * 16, fruitPosition.getY() * 16, 16, 16);
		}
	}
}
