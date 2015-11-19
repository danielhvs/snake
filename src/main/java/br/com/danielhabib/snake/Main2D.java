package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JApplet;

public class Main2D extends JApplet {

	private static final long serialVersionUID = -3688474214568402581L;
	private AMovingRules rules;
	private List<AMovingRules> list;

	public Main2D(AMovingRules rules, List<AMovingRules> list) {
		this.rules = rules;
		this.list = list;
	}

	@Override
	public void init() {
		setBackground(Color.WHITE);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		rules.draw(g);
		draw(g, rules.getSnake());
		// AI
		for (AMovingRules rule : list) {
			draw(g, rule.getSnake());
		}

	}

	private void draw(Graphics g, Snake snake) {
		List<Point> positions = snake.getPositions();
		g.setColor(Color.BLUE);
		for (Point point : positions) {
			g.fillOval(point.getX() * 16, point.getY() * 16, 16, 16);
		}
	}

	public AMovingRules getRules() {
		return rules;
	}

	public void updateRules(AMovingRules rules) {
		this.rules = rules.move();
		List<AMovingRules> updatedList = new ArrayList<AMovingRules>();
		for (AMovingRules rule : list) {
			updatedList.add(rule.turnLeft().move());
		}
		this.list = updatedList;
		repaint();
	}
}
