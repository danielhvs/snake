package br.com.danielhabib.snake;

public class MovingRules extends AMovingRules {

	@Override
	public Snake update(Snake snake) {
		return snake.move();
	}

}
