package designed.state.impl;

import designed.state.Context;
import designed.state.State;

public class RedState extends State {

	@Override
	public void getcolor() {
		System.out.println("red");
	}

	@Override
	public void handlepull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void handlepush(Context c) {
		c.setState(new YellowState());
	}

}
