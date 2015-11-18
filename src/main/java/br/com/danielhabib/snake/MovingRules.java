package br.com.danielhabib.snake;


public class MovingRules extends AMovingRules {

	public MovingRules(Snake snake, Point movingOffset) {
		super(snake, movingOffset);
	}

	public MovingRules(Snake snake) {
		super(snake);
	}

	@Override
	public AMovingRules move() {
		return new MovingRules(snake.move(snake.getX() + movingOffset.getX(), snake.getY() + movingOffset.getY()), movingOffset);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movingOffset == null) ? 0 : movingOffset.hashCode());
		result = prime * result + ((snake == null) ? 0 : snake.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MovingRules other = (MovingRules) obj;
		if (movingOffset == null) {
			if (other.movingOffset != null) {
				return false;
			}
		} else if (!movingOffset.equals(other.movingOffset)) {
			return false;
		}
		if (snake == null) {
			if (other.snake != null) {
				return false;
			}
		} else if (!snake.equals(other.snake)) {
			return false;
		}
		return true;
	}

	@Override
	protected AMovingRules newInstanceOfMovingRules(Snake snake, Point point) {
		return new MovingRules(snake, point);
	}

}
