package designed.state.impl;

import designed.state.Context;
import designed.state.State;

public class BlueState extends State {

	@Override
	public void getcolor() {
		System.out.println("blue");
	}

	@Override
	public void handlepull(Context c) {
		c.setState(new YellowState());
	}

	@Override
	public void handlepush(Context c) {
		c.setState(new RedState());
	}

}
