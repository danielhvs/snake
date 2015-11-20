package br.com.danielhabib.snake;

import java.util.List;

public class RestrictedMovingRules extends AMovingRules {

	public RestrictedMovingRules(Snake snake) {
		super(snake);
	}

	@Override
	public AMovingRules move() {
		Point direction = snake.getDirection();
		Snake futureSnake = snake.move(snake.getPosition().add(direction));
		List<Point> positions = futureSnake.getPositions();
		for (int i = 1; i < positions.size(); i++) {
			if (positions.get(i).equals(futureSnake.getPosition())) {
				return new RestrictedMovingRules(snake);
			}
		}

		return new RestrictedMovingRules(futureSnake);
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point direction) {
		return new RestrictedMovingRules(new Snake(snake, direction));
	}

}
