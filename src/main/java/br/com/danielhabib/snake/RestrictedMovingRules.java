package br.com.danielhabib.snake;

import java.util.List;

public class RestrictedMovingRules extends AMovingRules {

	@Override
	public Snake update(Snake snake) {
		Point direction = snake.getDirection();
		Snake futureSnake = snake.move(snake.getPosition().add(direction));
		List<Point> positions = futureSnake.getPositions();
		for (int i = 1; i < positions.size(); i++) {
			if (positions.get(i).equals(futureSnake.getPosition())) {
				return snake;
			}
		}

		return futureSnake;
	}

}
