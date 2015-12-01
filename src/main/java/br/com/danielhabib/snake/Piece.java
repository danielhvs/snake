package br.com.danielhabib.snake;

public class Piece {

	private Point point;
	private Direction direction;

	public Piece(Point point, Direction direction) {
		this.point = point;
		this.direction = direction;
	}

	public Point getPoint() {
		return point;
	}

	public Direction getDirection() {
		return direction;
	}

	public Piece move() {
		return new Piece(point.add(direction.getDirection()), direction);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
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
		Piece other = (Piece) obj;
		if (direction != other.direction) {
			return false;
		}
		if (point == null) {
			if (other.point != null) {
				return false;
			}
		} else if (!point.equals(other.point)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Piece [" + point + ":" + direction + "]";
	}

	public Piece move(Point finalPoint) {
		return new Piece(finalPoint, direction);
	}

	public Piece turn(Direction newDirection) {
		return new Piece(point, newDirection);
	}

}
