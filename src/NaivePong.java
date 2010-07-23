import java.awt.Color;

import javax.swing.JFrame;

/**
 * Naive Pong game class of the main function.
 * 
 * @author ggounot
 * 
 */
public class NaivePong {
	/**
	 * Main function. Starts a game with a paddle and a ball.
	 * 
	 * @param args
	 *            Arguments.
	 */
	public static void main(String[] args) {
		Game mGame = new Game(400, 300);
		mGame.drawCourt(Color.BLACK, Color.WHITE);
		mGame.addPlayerPaddle(40, 10, Color.WHITE);
		mGame.addBall(5, Color.WHITE);

		JFrame frame = new JFrame();
		frame.setTitle("Naive Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(mGame);
		frame.pack();
		frame.setVisible(true);

		/* Sleeping 2 seconds before that the ball starts moving. */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		mGame.startGame();
	}
}
