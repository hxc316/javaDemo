package designed.state;

import designed.state.impl.YellowState;

public class Context {
	
	private State state;
	
	public void setState(State state){
		this.state = state;
	}
	/**
	 * µÆ±äÉ« 
	 */
	public void push(){
		state.handlepull(this);
	}
	public State getState() {
		return state;
	}

	public static void main(String[] args) {
		Context context = new Context();
		context.setState(new YellowState());
		context.push();
		
		context.getState().getcolor();
		
		context.push();
		context.getState().getcolor();
		
		context.push();
		context.getState().getcolor();
		
	}
}
