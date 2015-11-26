package br.com.danielhabib.snake;

import java.util.List;

public class MapMovingRules extends AMovingRules {

	private AMovingRules movingRules;
	private List<Point> map;

	public MapMovingRules(AMovingRules movingRules, List<Point> map) {
		this.movingRules = movingRules;
		this.map = map;
	}

	@Override
	public Snake update(Snake snake) {
		Snake nextPositionSnake = movingRules.update(snake);
		return map.contains(nextPositionSnake.getPosition()) ? snake : nextPositionSnake;
	}

}
