package br.com.danielhabib.snake;

public class RandomMovingRules extends AMovingRules {

	@Override
	public AMovingRules move() {
		return new RandomMovingRules(snake.move(snake.getPosition().add(snake.getDirection())));
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point direction) {
		return new RandomMovingRules(new Snake(snake, direction));
	}

	public RandomMovingRules(Snake snake) {
		super(snake);
	}

	public RandomMovingRules() {
	}

	@Override
	public AMovingRules turnLeft() {
		return turnRight();
	}

	@Override
	public AMovingRules turnRight() {
		double random = Math.random();
		if (random < 0.3) {
			return super.turnLeft();
		} else if (random > 0.8) {
			return super.turnRight();
		} else {
			return this;
		}
	}

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
