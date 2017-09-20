package designed.state.impl;

import designed.state.Context;
import designed.state.State;

public class YellowState extends State {

	@Override
	public void getcolor() {
		System.out.println("yellow");
	}

	@Override
	public void handlepull(Context c) {
		c.setState(new BlueState());
	}

	@Override
	public void handlepush(Context c) {
		c.setState(new RedState());
	}

}
