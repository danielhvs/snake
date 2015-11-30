package br.com.danielhabib.snake;

public class BoingMovingRules extends AMovingRules {
	private AMovingRules movingRules;
	private int lastX;
	private int lastY;

	public BoingMovingRules(AMovingRules movingRules, int lastX, int lastY) {
		this.movingRules = movingRules;
		this.lastX = lastX;
		this.lastY = lastY;
	}

	@Override
	public Snake update(Snake snake) {
		Snake nextSnake = movingRules.update(snake);
		Point nextPosition = nextSnake.getPosition();
		return isOutOfBounds(nextPosition) ? snake.revert() : nextSnake;
	}

	@Override
	public Snake turnLeft(Snake snake) {
		return movingRules.turnLeft(snake);
	}

	@Override
	public Snake turnRight(Snake snake) {
		return movingRules.turnRight(snake);
	}

	private boolean isOutOfBounds(Point nextPosition) {
		return nextPosition.getX() > lastX || nextPosition.getX() < 0 || nextPosition.getY() > lastY
				|| nextPosition.getY() < 0;
	}

}
