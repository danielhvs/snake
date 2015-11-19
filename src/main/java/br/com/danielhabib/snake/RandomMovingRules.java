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
		if (Math.random() < 0.5)
			return super.turnLeft();
		else
			return super.turnRight();
	}

	@Override
	public AMovingRules turnRight() {
		if (Math.random() < 0.5)
			return super.turnLeft();
		else
			return super.turnRight();
	}
}
