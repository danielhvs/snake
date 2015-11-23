package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PoisonedFruitRuleTest {
	@Test
	public void update_ThereIsAPoisonedFruit_RemovesSnakeTail() throws Exception {
		IRule rules = new PoisonedFruitRule(new Point(0, 0));

		Snake snake = rules.update(new Snake(0, 0).addTail());

		assertEquals(new Snake(0, 0), snake);

	}
}
