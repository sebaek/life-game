package lifegame;

import java.util.List;

public class Checker {

	public static void determineAndSetNextStateOf(Cell cell, List<Cell> aroundCells) {
		
		int numberOfAlivedAroundCells = countAlivedCells(aroundCells);
		
		if (numberOfAlivedAroundCells == 3) {
			cell.setNextState(Cell.State.Live);
		} else if (numberOfAlivedAroundCells == 2){
			if (cell.isAlive()) {
				cell.setNextState(Cell.State.Live);
			} else {
				cell.setNextState(Cell.State.Death);
			}
		} else  {
			cell.setNextState(Cell.State.Death);
		}

	}

	private static int countAlivedCells(List<Cell> cells) {
		int numberOfAlivedCells = 0;
		for (Cell cell : cells) {
			if (cell.isAlive()) {
				numberOfAlivedCells++;
			}

		}

		return numberOfAlivedCells;
	}
}
