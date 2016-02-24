package lifegame;

public class Cell {
	public enum State {
		Live, Death, Undetermined
	}
	
	private State state;
	private State nextState;
	
	public Cell(State liveOrDeath) {
		this.state = liveOrDeath;
		this.nextState = State.Undetermined;
	}
	
	public void setNextState(State liveOrDeath) {
		this.nextState = liveOrDeath;
	}
	
	public boolean isAlive() {
		return state.equals(State.Live);
	}
	
	public void goNextState() {
		if (nextState == State.Undetermined) {
			throw new RuntimeException("This cell has undetermined next state.");
		}
		this.state = this.nextState;
		this.nextState = State.Undetermined;
	}
	
	

}
