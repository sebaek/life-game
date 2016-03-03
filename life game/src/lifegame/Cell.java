package lifegame;

public class Cell {
	public enum CellState {
		Live, Dead
	}
	
	private CellState state;
	
	public Cell() {
		this(CellState.Dead);
	}
	
	public Cell(CellState liveOrDead) {
		this.state = liveOrDead;
	}
	
	public boolean isAlive() {
		return state.equals(CellState.Live);
	}

	public void setState(CellState liveOrDead) {
		state = liveOrDead;
		
	}
	
	

}
