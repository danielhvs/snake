package br.com.danielhabib.snake;

public class SnakeController {

	private AMovingRules movingRules;

	public SnakeController(AMovingRules movingRules) {
		this.movingRules = movingRules;
	}

	public Snake up(Snake snake) {
		if (Direction.RIGHT.getDirection().equals(snake.getDirection())) {
			return movingRules.turnLeft(snake);
		} else if (Direction.LEFT.getDirection().equals(snake.getDirection())) {
			return movingRules.turnRight(snake);
		} else {
			return snake;
		}
	}

	public Snake down(Snake snake) {
		if (Direction.RIGHT.getDirection().equals(snake.getDirection())) {
			return movingRules.turnRight(snake);
		} else if (Direction.LEFT.getDirection().equals(snake.getDirection())) {
			return movingRules.turnLeft(snake);
		} else {
			return snake;
		}
	}

	public Snake left(Snake snake) {
		if (Direction.UP.getDirection().equals(snake.getDirection())) {
			return movingRules.turnLeft(snake);
		} else if (Direction.DOWN.getDirection().equals(snake.getDirection())) {
			return movingRules.turnRight(snake);
		} else {
			return snake;
		}
	}

	public Snake right(Snake snake) {
		if (Direction.UP.getDirection().equals(snake.getDirection())) {
			return movingRules.turnRight(snake);
		} else if (Direction.DOWN.getDirection().equals(snake.getDirection())) {
			return movingRules.turnLeft(snake);
		} else {
			return snake;
		}
	}

}
