package br.com.danielhabib.snake;

public class Hole {

	private Point initialPoint;
	private Point finalPoint;

	public Hole(Point initialPoint, Point finalPoint) {
		this.initialPoint = initialPoint;
		this.finalPoint = finalPoint;
	}

	public Point getInitialPoint() {
		return initialPoint;
	}

	public Point getFinalPoint() {
		return finalPoint;
	}

	@Override
	public String toString() {
		return initialPoint + " --> " + finalPoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalPoint == null) ? 0 : finalPoint.hashCode());
		result = prime * result + ((initialPoint == null) ? 0 : initialPoint.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hole other = (Hole) obj;
		if (finalPoint == null) {
			if (other.finalPoint != null)
				return false;
		} else if (!finalPoint.equals(other.finalPoint))
			return false;
		if (initialPoint == null) {
			if (other.initialPoint != null)
				return false;
		} else if (!initialPoint.equals(other.initialPoint))
			return false;
		return true;
	}

}
