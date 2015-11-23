package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

public class Main2D extends JApplet {

	private static final long serialVersionUID = -3688474214568402581L;
	private AMovingRules rules;
	private final FruitRule fruit;
	private Snake snake;
	private Snake ai = new SnakeEnd();
	private AMovingRules random;

	public Main2D(Snake snake, AMovingRules rules, Snake aiSnake, AMovingRules random, FruitRule fruit) {
		this.snake = snake;
		this.rules = rules;
		this.random = random;
		this.ai = aiSnake;
		this.fruit = fruit;
	}

	@Override
	public void init() {
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		rules.draw(g);
		snake.draw(g);
		fruit.draw(g);
		ai.draw(g);
	}

	public AMovingRules getRules() {
		return rules;
	}

	public void left() {
		snake = rules.turnLeft(snake);
		ai = random.turnLeft(ai);
		repaint();
	}

	public void right() {
		snake = rules.turnRight(snake);
		ai = random.turnRight(ai);
		repaint();
	}

	public void updateRules() {
		snake = rules.update(snake);
		snake = fruit.update(snake);
		ai = random.turnLeft(ai);
		ai = random.update(ai);
		repaint();
	}

}
