package lifegame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Main {
	
	final static private int numberOfBoardRow = 10;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(() -> createAndShowGUI());
	}

	private static void createAndShowGUI() {
		
		
		JFrame frame = new JFrame("Life Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JBoard board = new JBoard(numberOfBoardRow);
		
		frame.getContentPane().add(board);
		board.addEventListener();
		
		frame.pack();
		frame.setVisible(true);
	}


}
