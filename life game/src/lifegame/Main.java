package lifegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Main {
	
	final static private int numberOfBoardRow = 21;
	final static private int gapOfCell = 2; 
//	final static private Border borderOfCell = BorderFactory.createLineBorder(Color.gray);

	static private List<List<JComponent>> cells = new ArrayList<>();

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}

	private static void createAndShowGUI() {
		
		
		JFrame frame = new JFrame("Life Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel board = new JPanel(new GridLayout(numberOfBoardRow, numberOfBoardRow, gapOfCell, gapOfCell));
		board.setBackground(Color.GRAY);
		
		
		for (int i = 0; i < numberOfBoardRow; i++) {
			cells.add(new ArrayList<>());
			for (int j = 0; j < numberOfBoardRow; j++) {
				JCell cell = new JCell();
				cell.setState(Cell.State.Live);
				cell.setPreferredSize(new Dimension(10, 10));
				cells.get(i).add(cell);
				board.add(cell);
			}
		}
		
		frame.getContentPane().add(board);
		
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private static Cell.State getRandomSate() {
		int state = (int) (Math.random() * 3);
		if (state == 0) {
			return Cell.State.Live;
		} else {
			return Cell.State.Death;
		}
	}
}
