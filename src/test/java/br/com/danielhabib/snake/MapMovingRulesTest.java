package br.com.danielhabib.snake;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MapMovingRulesTest {
	@Test
	public void move_ThereIsAWall_DoesntMove() throws Exception {
		List<Point> map = Arrays.asList(new Point(0, 0));
		AMovingRules rules = new MapMovingRules(new MovingRules(), map);

		Snake snake = rules.update(new Snake(new Point(-1, 0), Direction.RIGHT.getDirection()));

		assertEquals(new Point(-1, 0), snake.getPosition());
	}
}
