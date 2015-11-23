package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;

public class Main2D extends JApplet {

	private static final long serialVersionUID = -3688474214568402581L;
	private AMovingRules movingRules;
	private Snake snake;
	private Snake ai = new SnakeEnd();
	private AMovingRules random;
	private List<IRule> fruitRules = new ArrayList<IRule>();

	public Main2D(Snake snake, AMovingRules rules, Snake aiSnake, AMovingRules random, FruitRule fruit) {
		this.snake = snake;
		this.movingRules = rules;
		this.random = random;
		this.ai = aiSnake;
		fruitRules.add(fruit);
		fruitRules.add(new PoisonedFruitRule(new Point(5, 8)));
	}

	@Override
	public void init() {
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		movingRules.draw(g);
		snake.draw(g);
		for (IRule fruits : fruitRules) {
			fruits.draw(g);
		}
		ai.draw(g);
	}

	public AMovingRules getRules() {
		return movingRules;
	}

	public void left() {
		snake = movingRules.turnLeft(snake);
		ai = random.turnLeft(ai);
		repaint();
	}

	public void right() {
		snake = movingRules.turnRight(snake);
		ai = random.turnRight(ai);
		repaint();
	}

	public void updateRules() {
		snake = movingRules.update(snake);
		for (IRule fruits : fruitRules) {
			snake = fruits.update(snake);
		}
		ai = random.turnLeft(ai);
		ai = random.update(ai);
		repaint();
	}

}
