package lifegame;

import static lifegame.Cell.CellState;

public class Checker {

	public static CellState getNextState(JCell cell, JCell[] aroundCells) {

		
		int numberOfAlivedAroundCells = countAlivedCells(aroundCells);
		
		CellState nextState;
		
		if (numberOfAlivedAroundCells == 3) {
			nextState = CellState.Live;
		} else if (numberOfAlivedAroundCells == 2){
			if (cell.isAlive()) {
				nextState = CellState.Live;
			} else {
				nextState = CellState.Dead;
			}
		} else  {
			nextState = CellState.Dead;
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
