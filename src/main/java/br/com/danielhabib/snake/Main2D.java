package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JApplet;

public class Main2D extends JApplet {

	private static final long serialVersionUID = -3688474214568402581L;
	private AMovingRules rules;

	public Main2D(AMovingRules rules) {
		this.rules = rules;
	}

	@Override
	public void init() {
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLUE);
		Snake snake = rules.getSnake();
		List<Point> positions = snake.getPositions();
		for (Point point : positions) {
			g.fillOval(point.getX() * 16, point.getY() * 16, 16, 16);
		}
		rules.draw();
	}

	public AMovingRules getRules() {
		return rules;
	}

	public void setRules(AMovingRules rules) {
		this.rules = rules;
		repaint();
	}
}
