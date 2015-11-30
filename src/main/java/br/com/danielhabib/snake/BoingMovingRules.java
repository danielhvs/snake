package br.com.danielhabib.snake;

public class BoingMovingRules extends AMovingRules {
	private AMovingRules movingRules;
	private int lastX;
	private int lastY;
	private int firstX;
	private int firstY;

	public BoingMovingRules(AMovingRules movingRules, int firstX, int firstY, int lastX, int lastY) {
		this.movingRules = movingRules;
		this.firstX = firstX;
		this.firstY = firstY;
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
		return nextPosition.getX() > lastX || nextPosition.getX() < firstX || nextPosition.getY() > lastY || nextPosition.getY() < firstY;
	}

}
