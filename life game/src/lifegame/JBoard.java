package lifegame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.ComponentInputMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class JBoard extends JPanel {
	private static final int gapOfCell = 2;
	private static final Color backgroundColor = Color.GRAY;
	private final int rowCountOfCells;
	private final int columnCountOfCells;
	private Stack<Cell.State[][]> statesStack = new Stack<>();
	
	private JCell[][] cells;
	private Cell.State[][] nextStates;
	
	public JBoard(int rowsAndCols) {
		this(rowsAndCols, rowsAndCols);
	}
	public JBoard(int rows, int cols) {
		super(new GridLayout(rows, cols, gapOfCell, gapOfCell));
		this.rowCountOfCells = rows;
		this.columnCountOfCells = cols;
		setBackground(backgroundColor);
		generateCells();
		
	}
	
	public void addEventListener() {
		JRootPane root = getRootPane();
		InputMap map  = new ComponentInputMap(root);
		
		root.setInputMap(WHEN_IN_FOCUSED_WINDOW, map);
		map.put(KeyStroke.getKeyStroke("RIGHT"), "next");
		map.put(KeyStroke.getKeyStroke("SPACE"), "next");
		
		map.put(KeyStroke.getKeyStroke("LEFT"), "previous");
		map.put(KeyStroke.getKeyStroke("BACK_SPACE"), "previous");
		
		root.getActionMap().put("next", new NextAction());
		root.getActionMap().put("previous", new PreviousAction());

	}
	
	
	private void next() {
		generateNextStates();
		saveCurrentStates();
		changeCellsStates();
	}
	
	private void previous() {
		if (popPreviousStates())
			changeCellsStates();
	}
	
	private void saveCurrentStates() {
		Cell.State[][] currentStates = new Cell.State[rowCountOfCells][columnCountOfCells];
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				if (cells[row][col].isAlive())
					currentStates[row][col] = Cell.State.Live;
				else
					currentStates[row][col] = Cell.State.Dead;
			}
		}
		
		statesStack.push(currentStates);
	}
	
	private boolean popPreviousStates() {
		if (!statesStack.empty()) {
			nextStates = statesStack.pop();
			
			return true;
		} else {
			return false;
		}
	}
	
	
	
	private void generateNextStates() {
		nextStates = new Cell.State[rowCountOfCells][columnCountOfCells];
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				nextStates[row][col] = Checker.getNextState(cells[row][col], aroundCells(row, col));
			}
		}
		
	}
	
	private void changeCellsStates() {
		for (int row = 0; row < cells.length; row++) {
			for (int col = 0; col < cells[row].length; col++) {
				cells[row][col].setState(nextStates[row][col]);
			}
		}
	}
	
	private JCell[] aroundCells(int row, int col) {
		List<Coordinate> coordinates = getAroundCoordinate(row, col);
		JCell[] aroundCells = new JCell[coordinates.size()];
//		System.out.println("row:col:" + row + ":" + col);
		int cellCounter = 0;
		for (Coordinate coordi : coordinates) {
			aroundCells[cellCounter++] = cells[coordi.x][coordi.y];
//			System.out.println("coordi : " + coordi.x + ":" + coordi.y);
//			System.out.println(aroundCells[cellCounter-1]);
		}
		
		return aroundCells;
		
	}
	
	
	
	private List<Coordinate> getAroundCoordinate(int x, int y) {
		ArrayList<Coordinate> coordinates = new ArrayList<>();
		for (int i = x-1; i <= x+1; i++) {
			for (int j = y-1; j <= y+1; j++) {
//				System.out.println("!i:j : " + i + ":" + j);

				if ((0 <= i && i < rowCountOfCells) && (0 <= j && j < columnCountOfCells) && !(i == x && j == y)) {
//					System.out.println("@i:j : " + i + ":" + j);
					coordinates.add(new Coordinate(i, j));
				}
			}
		}
		
		return coordinates;
	}



	private class Coordinate {
		private int x, y;
		private Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	
	private class NextAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			next();
			for (Cell.State[] states : nextStates) {
				for (Cell.State state : states) {
//					System.out.print(state + " ");
				}
//				System.out.println();
			}
//			System.out.println("next key....");
			
		}
		
	}
	
	private class PreviousAction extends AbstractAction {

		@Override
		public void actionPerformed(ActionEvent e) {
			previous();
//			System.out.println("previous key...");
		}
		
	}
	
	private void generateCells() {
		cells = new JCell[rowCountOfCells][columnCountOfCells];
		
		for (int row = 0; row < rowCountOfCells; row++) {
			for (int col = 0; col < columnCountOfCells; col++) {
				cells[row][col] = new JCell();
				this.add(cells[row][col]);
			}
		}
	}
	
}
