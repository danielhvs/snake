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
		int size = 10;
		Snake snake = new Snake(size, 1);
		for (int i = size; i >= 1; i--) {
			snake = snake.addTail(i, 1);
		}
		MovingRules initial = new MovingRules(snake);
		JFrame frame = buildFrame();
		gui = new Main2D(initial);
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
					gui.setRules(gui.getRules().turnLeft().move());
					break;
				case 'd':
					gui.setRules(gui.getRules().turnRight().move());
					break;
				case 'm':
					gui.setRules(gui.getRules().move());
					break;
				case 'q':
					System.exit(0);
					break;
				}
			}
		});
	}
}