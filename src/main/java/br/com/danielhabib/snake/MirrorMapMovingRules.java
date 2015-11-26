package br.com.danielhabib.snake;

public class MirrorMapMovingRules extends AMovingRules {

	private AMovingRules movingRules;
	private int lastX;
	private int lastY;

	public MirrorMapMovingRules(AMovingRules movingRules, int lastX, int lastY) {
		this.movingRules = movingRules;
		this.lastX = lastX;
		this.lastY = lastY;
	}

	@Override
	public Snake update(Snake snake) {
		Snake nextSnake = movingRules.update(snake);
		Point nextPosition = nextSnake.getPosition();
		if (nextPosition.getX() > lastX) {
			return snake.move(new Point(0, snake.getPosition().getY()));
		} else if (nextPosition.getX() < 0) {
			return snake.move(new Point(lastX, snake.getPosition().getY()));
		} else if (nextPosition.getY() > lastY) {
			return snake.move(new Point(snake.getPosition().getX(), 0));
		} else if (nextPosition.getY() < 0) {
			return snake.move(new Point(snake.getPosition().getX(), lastY));
		}
		return nextSnake;
	}

}
