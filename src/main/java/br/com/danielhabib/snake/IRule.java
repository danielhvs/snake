package br.com.danielhabib.snake;

import java.awt.Graphics;

public interface IRule {
	public Snake update(Snake snake);

	public void draw(Graphics g);

}
