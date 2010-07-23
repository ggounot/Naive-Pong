import java.awt.Color;
import java.awt.Graphics;

/**
 * Paddle represents a paddle in the Naive Pong game.
 * 
 * @author ggounot
 * 
 */
public class Paddle {
	/** Abscissa value for left paddle position. */
	private int mX;
	/** Ordinate value for left paddle position. */
	private int mY;
	/** Paddle length. */
	private int mLength;
	/** Paddle thickness. */
	private int mThickness;
	/** Paddle color. */
	private Color mColor;

	/**
	 * Paddle constructor.
	 * 
	 * @param x
	 *            Abscissa paddle position.
	 * @param y
	 *            Ordinate paddle position.
	 * @param length
	 *            Paddle length.
	 * @param thickness
	 *            Paddle thickness.
	 * @param color
	 *            Paddle color.
	 */
	public Paddle(int x, int y, int length, int thickness, Color color) {
		mX = x;
		mY = y;
		mLength = length;
		mThickness = thickness;
		mColor = color;
	}

	/**
	 * Sets the abscissa paddle position.
	 * 
	 * @param x
	 *            The abscissa paddle position.
	 */
	public void setX(int x) {
		mX = x;
	}

	/**
	 * Returns the abscissa paddle position.
	 * 
	 * @return The abscissa paddle position.
	 */
	public int getX() {
		return mX;
	}

	/**
	 * Sets the ordinate paddle position.
	 * 
	 * @param y
	 *            The ordinate paddle position.
	 */
	public void setY(int y) {
		mY = y;
	}

	/**
	 * Returns the ordinate paddle position.
	 * 
	 * @return The ordinate paddle position.
	 */
	public int getY() {
		return mY;
	}

	/**
	 * Returns the paddle thickness.
	 * 
	 * @return The paddle thickness.
	 */
	public int getThickness() {
		return mThickness;
	}

	/**
	 * Returns the paddle length.
	 * 
	 * @return The paddle length.
	 */
	public int getLength() {
		return mLength;
	}

	/**
	 * Draws the paddle.
	 * 
	 * @param g
	 *            Graphics on which the paddle have to be drawn.
	 */
	public void draw(Graphics g) {
		g.setColor(mColor);
		g.fillRect(mX, mY, mThickness, mLength);
	}
}
