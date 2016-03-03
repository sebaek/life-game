package lifegame;

public class Cell {
	public enum State {
		Live, Dead
	}
	
	private State state;
	
	public Cell() {
		this(State.Dead);
	}
	
	public Cell(State liveOrDead) {
		this.state = liveOrDead;
	}
	
	public boolean isAlive() {
		return state.equals(State.Live);
	}

	public void setState(State liveOrDead) {
		state = liveOrDead;
		
	}
	
	

}
