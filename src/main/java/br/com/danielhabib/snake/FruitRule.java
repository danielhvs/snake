package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;

// Stateful rule!
public class FruitRule {

	private Point fruitPosition;

	public FruitRule(Point fruitPosition) {
		this.fruitPosition = fruitPosition;
	}

	// Ideia: externalize snake and make this update() method to return a
	// FruitRule (FruitlessRule, for instance, when there are no fruits anymore).
	// That way the state is removed.
	public Snake update(Snake snake) {
		return snake.getPosition().equals(fruitPosition) ? consumesFruit(snake) : snake;
	}

	private Snake consumesFruit(Snake snake) {
		fruitPosition = new Point(-1, -1); // NOP: state change!
		return snake.addTail();
	}

	public void draw(Graphics g) {
		if (fruitPosition.getX() >= 0) {
			g.setColor(Color.ORANGE);
			g.fillOval(fruitPosition.getX() * 16, fruitPosition.getY() * 16, 16, 16);
		}
	}
}
