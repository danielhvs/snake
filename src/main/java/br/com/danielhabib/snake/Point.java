package br.com.danielhabib.snake;

public class Point {

	private final int y;
	private final int x;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point point) {
		this.x = point.getX();
		this.y = point.getY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}

	public void draw() {
		System.out.print("point: (" + x + "," + y + "): ");
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public Point add(Point point) {
		return new Point(x + point.getX(), y + point.getY());
	}

	public Point subtract(Point other) {
		return new Point(x - other.getX(), y - other.getY());
	}

	public Point invert() {
		return new Point(-x, -y);
	}

}
