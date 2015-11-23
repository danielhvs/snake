package br.com.danielhabib.snake;

public class MovingRules extends AMovingRules {

	public MovingRules(Snake snake) {
		super(snake);
	}

	public MovingRules() {
	}

	@Override
	public AMovingRules move() {
		return new MovingRules(snake.move());
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point direction) {
		return new MovingRules(new Snake(snake, direction));
	}

	@Override
	public Snake update(Snake snake) {
		return snake.move();
	}

}
