package br.com.danielhabib.snake;

import java.util.List;

public class RestrictedMovingRules extends AMovingRules {

	public RestrictedMovingRules(Snake snake, Point offset) {
		super(snake, offset);
	}

	@Override
	public AMovingRules move() {
		Snake futureSnake = snake.move(snake.getPosition().add(movingOffset));
		List<Point> positions = futureSnake.getPositions();
		for (int i = 1; i < positions.size(); i++) {
			if (positions.get(i).equals(futureSnake.getPosition())) {
				return new RestrictedMovingRules(snake, movingOffset);
			}
		}

		return new RestrictedMovingRules(futureSnake, movingOffset);
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point point) {
		return new RestrictedMovingRules(snake, point);
	}

}
