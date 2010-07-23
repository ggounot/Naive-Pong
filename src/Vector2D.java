/**
 * Vector2D represents a 2D Euclidean vector.
 * 
 * @author ggounot
 * 
 */
public class Vector2D {
	/** Vector X component. */
	private double mX;
	/** Vector Y component. */
	private double mY;

	/** Vector2D constructor. */
	public Vector2D(double x, double y) {
		mX = x;
		mY = y;
	}

	/** Normalizes the vector. */
	public void normalize() {
		double length = Math.sqrt(mX * mX + mY * mY);
		mX /= length;
		mY /= length;
	}

	/**
	 * Returns the X component.
	 * 
	 * @return The X component.
	 */
	public double getX() {
		return mX;
	}

	/**
	 * Sets the X component.
	 * 
	 * @param x
	 *            The X component.
	 */
	public void setX(double x) {
		mX = x;
	}

	/**
	 * Returns the Y component.
	 * 
	 * @return The Y component.
	 */
	public double getY() {
		return mY;
	}

	/**
	 * Sets the Y component.
	 * 
	 * @param y
	 *            The Y component.
	 */
	public void setY(double y) {
		mY = y;
	}
}
