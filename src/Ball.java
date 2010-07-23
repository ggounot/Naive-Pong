import java.awt.Color;
import java.awt.Graphics;

/**
 * Ball represents a ball in the Naive Pong game.
 * 
 * @author ggounot
 * 
 */
public class Ball {
	/** Abscissa value for left ball position. */
	private int mX;
	/** Ordinate value for top ball position. */
	private int mY;
	/** Ball radius. */
	private int mRadius;
	/** Ball diameter. */
	private int mDiameter;
	/** Ball direction vector. */
	private Vector2D mDirection;
	/** Ball moving velocity. */
	private double mVelocity;
	/** Ball color. */
	private Color mColor;

	/**
	 * Ball constructor.
	 * 
	 * @param x
	 *            Abscissa ball position.
	 * @param y
	 *            Ordinate ball position.
	 * @param radius
	 *            Radius of the ball.
	 * @param color
	 *            Color of the ball.
	 */
	public Ball(int x, int y, int radius, Color color) {
		mX = x;
		mY = y;
		mRadius = radius;
		mDiameter = radius * 2;
		mDirection = new Vector2D(-1, 0.5);
		mDirection.normalize();
		mVelocity = 10;
		mColor = color;
	}

	/**
	 * Sets the abscissa ball position.
	 * 
	 * @param x
	 *            The abscissa ball position.
	 */
	public void setX(int x) {
		mX = x;
	}

	/**
	 * Returns the abscissa ball position.
	 * 
	 * @return The abscissa ball position.
	 */
	public int getX() {
		return mX;
	}

	/**
	 * Sets the ordinate ball position.
	 * 
	 * @param y
	 *            The ordinate ball position.
	 */
	public void setY(int y) {
		mY = y;
	}

	/**
	 * Returns the ordinate ball position.
	 * 
	 * @return The ordinate ball position.
	 */
	public int getY() {
		return mY;
	}

	/**
	 * Returns the ball radius.
	 * 
	 * @return The ball radius.
	 */
	public int getRayon() {
		return mRadius;
	}

	/**
	 * Returns the ball direction vector.
	 * 
	 * @return The ball direction vector.
	 */
	public Vector2D getDirection() {
		return mDirection;
	}

	/**
	 * Sets the ball moving velocity.
	 * 
	 * @param velocity
	 *            The ball moving velocity.
	 */
	public void setVelocity(double velocity) {
		mVelocity = velocity;
	}

	/**
	 * Returns the ball moving velocity.
	 * 
	 * @return The ball moving velocity.
	 */
	public double getVelocity() {
		return mVelocity;
	}

	/**
	 * Computes the next position of the ball according to the direction and the
	 * velocity.
	 */
	public void move() {
		mX += (int) Math.round(mDirection.getX() * mVelocity);
		mY += (int) Math.round(mDirection.getY() * mVelocity);
	}

	/**
	 * Draws the ball.
	 * 
	 * @param g
	 *            Graphics on which the ball has to be drawn.
	 */
	public void draw(Graphics g) {
		g.setColor(mColor);
		g.fillOval(mX, mY, mDiameter, mDiameter);
	}
}
