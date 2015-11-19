package br.com.danielhabib.snake;

public class RandomMovingRules extends AMovingRules {

	@Override
	public AMovingRules move() {
		return new RandomMovingRules(snake.move(snake.getX() + movingOffset.getX(), snake.getY() + movingOffset.getY()),
				movingOffset);
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point point) {
		return new RandomMovingRules(snake, point);
	}

	private RandomMovingRules(Snake snake, Point point) {
		super(snake, point);
	}

	public RandomMovingRules(Snake aiSnake) {
		super(aiSnake);
	}

	@Override
	public AMovingRules turnLeft() {
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
}
