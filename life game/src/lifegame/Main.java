package lifegame;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Game Of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel board = new JPanel(new GridLayout(10, 10, 2, 2));
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JPanel c = new JPanel();
				c.setPreferredSize(new Dimension(10, 10));
				board.add(c);
			}
		}
		
		
		frame.getContentPane().add(board);
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
}
