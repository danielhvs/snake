package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PieceTest {
	@Test
	public void itRepresentsAPointAndADirection() throws Exception {
		Piece piece = new Piece(new Point(0, 0), Direction.RIGHT);

		assertEquals(Direction.RIGHT, piece.getDirection());
		assertEquals(new Point(0, 0), piece.getPoint());
	}

	@Test
	public void move_MovesTowardsDirection() throws Exception {
		Piece piece = new Piece(new Point(0, 0), Direction.RIGHT);
		Piece moved = piece.move();

		assertEquals(new Point(1, 0), moved.getPoint());
	}

	@Test
	public void itCanMoveToSpecificPoint() throws Exception {
		Piece piece = new Piece(new Point(0, 0), Direction.RIGHT);
		Piece moved = piece.move(new Point(10, 0));
		assertEquals(new Point(10, 0), moved.getPoint());
	}

	@Test
	public void itCanChangeTheDirection() throws Exception {
		Piece piece = new Piece(new Point(0, 0), Direction.RIGHT);
		Piece turned = piece.turn(Direction.UP);
		assertEquals(Direction.UP, turned.getDirection());
	}
}
