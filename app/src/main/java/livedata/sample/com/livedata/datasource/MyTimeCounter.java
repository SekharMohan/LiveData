package livedata.sample.com.livedata.datasource;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;

public class MyTimeCounter extends CountDownTimer {
	private static MyTimeCounter myTimeCounter;

	private static int TOTAL_TIME = 1000 * 60 * 30;
	private static int TIME_INTERVAL = 1000;
	private MutableLiveData<Long> timeLiveData;

	/**
	 * @param millisInFuture    The number of millis in the future from the call
	 *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
	 *                          is called.
	 * @param countDownInterval The interval along the way to receive
	 *                          {@link #onTick(long)} callbacks.
	 */
	public MyTimeCounter(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		timeLiveData = new MutableLiveData<Long>();


	}

	public static MyTimeCounter init() {

		if (myTimeCounter == null) {
			myTimeCounter = new MyTimeCounter(TOTAL_TIME, TIME_INTERVAL);
		}
		return myTimeCounter;
	}

	@Override
	public void onTick(long millisUntilFinished) {
		timeLiveData.setValue(millisUntilFinished);

	}

	@Override
	public void onFinish() {

	}

	public LiveData<Long> getDataSource() {
		return timeLiveData;
	}


}
