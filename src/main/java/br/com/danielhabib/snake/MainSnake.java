package br.com.danielhabib.snake;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class MainSnake {

	static JApplet applet;
	private static Main2D gui;

	public static void main(String[] args) {
		int size = 2;
		Snake snake = new Snake(size, 14);
		for (int i = size - 1; i >= 1; i--) {
			snake = snake.addTail(i, 14);
		}
		AMovingRules initial = new HoleMovingRules(new Hole(new Point(5, 10), new Point(30, 27)));
		Snake aiSnake = snake.move();
		AMovingRules random = new RandomMovingRules();

		JFrame frame = buildFrame();
		gui = new Main2D(snake, initial, aiSnake, random, new FruitRule(new Point(10, 7)));
		setupFrame(gui, frame);
		setupCommands(frame);
	}

	protected static JFrame buildFrame() {
		JFrame f = new JFrame("Snake");
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		return f;
	}

	protected static void setupFrame(JApplet applet, JFrame frame) {
		frame.getContentPane().add("Center", applet);
		applet.init();
		frame.pack();
		frame.setSize(new Dimension(640, 480));
		frame.setVisible(true);
	}

	protected static void setupCommands(JFrame frame) {
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				switch (keyChar) {
				case 'a':
					gui.left();
					break;
				case 'd':
					gui.right();
					break;
				case 'm':
					gui.updateRules();
					break;
				case 'q':
					System.exit(0);
					break;
				}
			}
		});
	}
}
