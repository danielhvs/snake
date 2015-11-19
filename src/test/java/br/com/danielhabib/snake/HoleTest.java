package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HoleTest {
	@Test
	public void hole_ConstructorOnly_DefinesInitialAndFinalPosition() throws Exception {
		Hole hole = new Hole(new Point(0, 0), new Point(1, 1));

		assertEquals(new Point(0, 0), hole.getInitialPoint());
		assertEquals(new Point(1, 1), hole.getFinalPoint());
	}
}
