package lifegame;

import java.awt.Color;

import javax.swing.JPanel;

public class JCell extends JPanel {
	private Cell cell;
	private Color colorOfDeath = Color.BLACK;
	private Color colorOfLive = Color.WHITE;
	
	public JCell() {
		super();
		cell = new Cell(Cell.State.Death);
		rePaintBackgroud();
	}
	
	public void setState(Cell.State liveOrDeath) {
		this.cell.setState(liveOrDeath);
		rePaintBackgroud();
		
	}
	
	private void rePaintBackgroud() {
		if (cell.isAlive()) {
			setBackground(colorOfLive);
		} else {
			setBackground(colorOfDeath);
		}
	}

}
