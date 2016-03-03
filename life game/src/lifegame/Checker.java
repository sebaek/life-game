package lifegame;

import java.util.List;

public class Checker {

	public static Cell.State getNextState(JCell cell, JCell[] aroundCells) {

		
		int numberOfAlivedAroundCells = countAlivedCells(aroundCells);
		
		Cell.State nextState;
		
		if (numberOfAlivedAroundCells == 3) {
			nextState = Cell.State.Live;
		} else if (numberOfAlivedAroundCells == 2){
			if (cell.isAlive()) {
				nextState = Cell.State.Live;
			} else {
				nextState = Cell.State.Dead;
			}
		} else  {
			nextState = Cell.State.Dead;
		}
		
		return nextState;

	}

	private static int countAlivedCells(JCell[] cells) {
		int numberOfAlivedCells = 0;
		for (JCell cell : cells) {
			if (cell.isAlive()) {
				numberOfAlivedCells++;
			}
		}

		return numberOfAlivedCells;
	}
}
