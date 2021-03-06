package lifegame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import static lifegame.Cell.CellState;

public class JCell extends JPanel {
	private Cell cell;
	private Color colorOfDead = Color.WHITE;
	private Color colorOfLive = Color.BLACK;

	public JCell() {
		super();
		setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
//		cell = new Cell(CellState.Dead);
		cell = new Cell(getRandomState());
		rePaintBackground();
		addMouseListener(new JCellMouseListener());
	}
	
	private CellState getRandomState() {
		Random random = new Random(System.currentTimeMillis());
		if (random.nextInt(5) == 0) {
			return CellState.Live;
		}
		
		return CellState.Dead;
	}

	public void setState(CellState liveOrDead) {
		this.cell.setState(liveOrDead);
		rePaintBackground();
	}
	
	public boolean isAlive() {
		return cell.isAlive();
	}

	private void rePaintBackground() {
		if (isAlive()) {
			setBackground(colorOfLive);
		} else {
			setBackground(colorOfDead);
		}
	}

	private class JCellMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (isAlive()) {
				setState(CellState.Dead);
			} else {
				setState(CellState.Live);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (!isAlive()) {
				setBackground(Color.GRAY);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!isAlive()) {
				setBackground(colorOfDead);
			}
		}

	}
}
