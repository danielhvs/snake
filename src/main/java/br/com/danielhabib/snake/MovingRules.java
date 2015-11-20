package br.com.danielhabib.snake;


public class MovingRules extends AMovingRules {

	public MovingRules(Snake snake) {
		super(snake);
	}

	@Override
	public AMovingRules move() {
		return new MovingRules(snake.move(snake.getPosition().add(snake.getDirection())));
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point point) {
		return new MovingRules(new Snake(snake, point));
	}

}
