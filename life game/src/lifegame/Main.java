package lifegame;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	final static private int numberOfBoardRow = 30;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}

	private static void createAndShowGUI() {
		
		
		JFrame frame = new JFrame("Life Game (Press RightArrow or Space)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JBoard board = new JBoard(numberOfBoardRow);
		
		frame.getContentPane().add(board);
		board.addEventListener();
		
		frame.pack();
		frame.setVisible(true);
	}


}
