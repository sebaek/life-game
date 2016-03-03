package lifegame;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JCell extends JPanel {
	private Cell cell;
	private Color colorOfDead = Color.WHITE;
	private Color colorOfLive = Color.BLACK;

	public JCell() {
		super();
		cell = new Cell(Cell.State.Dead);
		rePaintBackground();
		addMouseListener(new JCellMouseListener());
	}

	public void setState(Cell.State liveOrDead) {
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
			if (isAlive()) {
				setState(Cell.State.Dead);
			} else {
				setState(Cell.State.Live);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

	}
}
