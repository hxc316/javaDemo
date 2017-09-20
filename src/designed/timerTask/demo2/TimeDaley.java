package designed.timerTask.demo2;

import java.util.Date;

public class TimeDaley implements TimerNext{

	@Override
	public Date nextDate() {
		return new Date();
	}

}
