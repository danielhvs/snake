package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PointTest {
	@Test
	public void sum_AddsXAndY() throws Exception {
		assertEquals(new Point(4, 6), new Point(1, 2).add(new Point(3, 4)));
	}
}
