import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

/**
 * This class handles the game running.
 * 
 * @author ggounot
 * 
 */
public class Game extends JPanel implements MouseMotionListener {
	private static final long serialVersionUID = 1L;
	/** The player's paddle. */
	private Paddle mPlayerPaddle;
	/** The ball. */
	private Ball mBall;

	/**
	 * Game constructor.
	 * 
	 * @param width
	 *            The display width.
	 * @param height
	 *            The display height.
	 */
	public Game(int width, int height) {
		addMouseMotionListener(this);
		setSize(width, height);
		setPreferredSize(getSize());
	}

	/**
	 * Draws the court.
	 * 
	 * @param backgroundColor
	 *            The background color.
	 * @param linesColor
	 *            The lines color.
	 */
	public void drawCourt(Color backgroundColor, Color linesColor) {
		setBackground(backgroundColor);
	}

	/**
	 * Creates the player's paddle.
	 * 
	 * @param length
	 *            The paddle length.
	 * @param thickness
	 *            The paddle thickness.
	 * @param color
	 *            The paddle color.
	 */
	public void addPlayerPaddle(int length, int thickness, Color color) {
		/* The paddle is positioned 20px from the left and centered in height. */
		mPlayerPaddle = new Paddle(20, getHeight() / 2 - length / 2, length,
				thickness, color);
	}

	/**
	 * Creates the ball.
	 * 
	 * @param radius
	 *            The ball radius.
	 * @param color
	 *            The ball color.
	 */
	public void addBall(int radius, Color color) {
		/* The ball is centered in width and height. */
		mBall = new Ball(getWidth() / 2 - radius, getHeight() / 2 - radius,
				radius, color);
	}

	/**
	 * Starts the game loop.
	 */
	public void startGame() {
		new Thread() {
			public void run() {
				while (true) {
					mBall.move();
					handleEventualCollision();
					repaint();
					try {
						Thread.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	/**
	 * Paints the components.
	 * 
	 * @param g
	 *            The graphics to be painted.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		mPlayerPaddle.draw(g);
		mBall.draw(g);
	}

	/**
	 * Detects an eventual collision and changes the ball direction according to
	 * the collision.
	 */
	private void handleEventualCollision() {
		Vector2D ballDirection = mBall.getDirection();
		/* Collision on player's paddle. */
		if (mBall.getY() + mBall.getRayon() >= mPlayerPaddle.getY()
				&& mBall.getY() + mBall.getRayon() <= mPlayerPaddle.getY()
						+ mPlayerPaddle.getLength()
				&& mBall.getX() <= mPlayerPaddle.getX()
						+ mPlayerPaddle.getThickness()) {
			determinePaddleBounce();
		}
		/* Collision on north or south wall. */
		if ((mBall.getY() <= 0)
				|| (mBall.getY() >= getHeight() - mBall.getRayon() * 2)) {
			ballDirection.setY(-ballDirection.getY());
		}
		/* Collision on east or west wall. */
		if ((mBall.getX() <= 0)
				|| (mBall.getX() >= getWidth() - mBall.getRayon() * 2)) {
			ballDirection.setX(-ballDirection.getX());
		}
	};

	/**
	 * Changes the ball direction according to the impact point.
	 */
	private void determinePaddleBounce() {
		Vector2D ballDirection = mBall.getDirection();
		ballDirection.setX(1);
		ballDirection.setY(((float) mBall.getY() + mBall.getRayon()
				- mPlayerPaddle.getY() - (mPlayerPaddle.getLength() / 2))
				/ ((float) mPlayerPaddle.getLength() / 2));
		ballDirection.normalize();
	}

	/**
	 * Moves the player's paddle according to the mouse movement.
	 * 
	 * @param e
	 *            The mouse event.
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		mPlayerPaddle.setY(e.getY() - mPlayerPaddle.getLength() / 2);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}
}
