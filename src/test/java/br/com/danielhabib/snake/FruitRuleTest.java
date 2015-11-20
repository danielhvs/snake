package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FruitRuleTest {
	@Test
	public void update_ThereIsAFruit_GrowsSnake() throws Exception {
		FruitRule rule = new FruitRule(new Point(0, 0));

		Snake snake = rule.update(new Snake(0, 0));

		assertEquals(new Snake(0, 0).addTail(-1, 0), snake);

	}

	@Test
	public void update_ThereIsNoFruit_ReturnsSameSnake() throws Exception {
		FruitRule rule = new FruitRule(new Point(1, 0));

		Snake snake = rule.update(new Snake(0, 0));

		assertEquals(new Snake(0, 0), snake);
	}

	@Test
	public void update_ThereIsAFruit_ConsumesIt() throws Exception {
		FruitRule rule = new FruitRule(new Point(0, 0));

		Snake snakeAte = rule.update(new Snake(0, 0));
		Snake snakeDidntAte = rule.update(new Snake(0, 0));

		assertEquals(new Snake(0, 0).addTail(-1, 0), snakeAte);
		assertEquals(new Snake(0, 0), snakeDidntAte);
	}
}
