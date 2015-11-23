package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;

public class HoleMovingRules extends AMovingRules {

	private Hole hole;

	public HoleMovingRules(Snake snake, Hole hole) {
		super(snake);
		this.hole = hole;
	}

	@Override
	public AMovingRules move() {
		if (snake.getPosition().equals(hole.getInitialPoint())) {
			Snake teleportedSnake = snake.move(hole.getFinalPoint());
			return new HoleMovingRules(teleportedSnake, hole);
		} else {
			Snake futureSnake = snake.move(snake.getPosition().add(snake.getDirection()));
			return new HoleMovingRules(futureSnake, hole);
		}
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point direction) {
		return new HoleMovingRules(new Snake(snake, direction), hole);
	}

	@Override
	public void draw(Graphics g) {
		Point initialPoint = hole.getInitialPoint();
		Point finalPoint = hole.getFinalPoint();

		g.setColor(Color.BLACK);
		g.fillRect(initialPoint.getX() * 16, initialPoint.getY() * 16, 16, 16);
		g.fillRect(finalPoint.getX() * 16, finalPoint.getY() * 16, 16, 16);
		super.draw(g);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((hole == null) ? 0 : hole.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		HoleMovingRules other = (HoleMovingRules) obj;
		if (hole == null) {
			if (other.hole != null) {
				return false;
			}
		} else if (!hole.equals(other.hole)) {
			return false;
		}
		return true;
	}

	@Override
	public Snake update(Snake snake) {
		return snake.getPosition().equals(hole.getInitialPoint()) ? snake.move(hole.getFinalPoint()) : snake.move();
	}

}
