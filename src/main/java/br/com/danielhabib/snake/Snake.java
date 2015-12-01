package br.com.danielhabib.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Snake {

	private Stack<Piece> pieces;

	public Snake() {
	}

	public Snake(Stack<Piece> pieces) {
		this.pieces = pieces;
	}

	public Piece getTail() {
		return pieces.get(getTailIndex());
	}

	public Snake addTail(int x, int y) {
		pieces.push(new Piece(new Point(x, y), getTail().getDirection()));
		return new Snake(pieces);
	}

	public Snake addTail() {
		Piece tail = getTail();
		Direction tailDirection = tail.getDirection();
		Piece newTail = new Piece(tail.getPoint().subtract(tailDirection.getDirection()), tailDirection);
		pieces.push(newTail);
		return new Snake(pieces);
	}

	public void draw(Graphics g) {
		int x = getPosition().getX();
		int y = getPosition().getY();
		int nextX = x + getDirection().getDirection().getX();
		int nextY = y + getDirection().getDirection().getY();
		g.drawRect(nextX * 16, nextY * 16, 4, 4);

		g.setColor(Color.BLUE);
		Stack<Piece> allPieces = getPieces();
		while (!allPieces.isEmpty()) {
			Piece piece = allPieces.pop();
			Point point = piece.getPoint();
			g.fillOval(point.getX() * 16, point.getY() * 16, 16, 16);
		}
	}

	public Snake move(Point point) {
		Stack<Piece> newPieces = new Stack<Piece>();
		List<Piece> list = new ArrayList<Piece>(getPieces());
		Point headPoint = point;
		Direction headDirection = list.get(0).getDirection();
		for (int i = 0; i < list.size(); i++) {
			Piece moved = list.get(i).move(headPoint);
			Piece turned = moved.turn(headDirection);
			newPieces.push(turned);
			headPoint = list.get(i).getPoint();
			headDirection = list.get(i).getDirection();
		}
		return new Snake(newPieces);
	}

	public Snake move() {
		return move(getPosition().add(getDirection().getDirection()));
	}

	public Snake removeTail() {
		pieces.pop();
		return new Snake(pieces);
	}

	public Piece getHead() {
		return pieces.get(0);
	}

	private int getTailIndex() {
		return pieces.size() - 1;
	}

	public Point getPosition() {
		return getHead().getPoint();
	}

	public Direction getDirection() {
		return getHead().getDirection();
	}

	@Override
	public String toString() {
		return pieces.toString();
	}

	public Snake turn(Direction direction) {
		Piece newHead = getHead().turn(direction);
		int headIndex = 0;
		pieces.remove(headIndex);
		pieces.insertElementAt(newHead, headIndex);
		return new Snake(pieces);
	}

	public Snake revert() {
		Stack<Piece> newPieces = new Stack<Piece>();
		while (!pieces.isEmpty()) {
			Piece pop = pieces.pop();
			Piece newPiece = new Piece(pop.getPoint(), pop.getDirection().invert());
			newPieces.push(newPiece);
		}
		return new Snake(newPieces);
	}

	public Stack<Piece> getPieces() {
		Stack<Piece> copy = new Stack<Piece>();
		copy.addAll(pieces);
		return copy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pieces == null) ? 0 : pieces.hashCode());
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
		Snake other = (Snake) obj;
		if (pieces == null) {
			if (other.pieces != null) {
				return false;
			}
		} else if (!pieces.equals(other.pieces)) {
			return false;
		}
		return true;
	}

}
