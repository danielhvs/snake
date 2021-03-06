package br.com.danielhabib.snake;

public class RandomMovingRules extends AMovingRules {

	@Override
	public Snake turnLeft(Snake snake) {
		return turnRight(snake);
	}

	@Override
	public Snake turnRight(Snake snake) {
		double random = Math.random();
		if (random < 0.3) {
			return super.turnLeft(snake);
		} else if (random > 0.8) {
			return super.turnRight(snake);
		} else {
			return snake;
		}
	}

	@Override
	public Snake update(Snake snake) {
		return snake.move();
	}
}
