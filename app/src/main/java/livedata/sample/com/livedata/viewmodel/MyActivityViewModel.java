package livedata.sample.com.livedata.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;


public class MyActivityViewModel extends ViewModel {

	private boolean isDataSourceRunning;
	private MutableLiveData<Integer> dataSource = new MutableLiveData<>();
	public LiveData<Integer> getValue() {
		if (!isDataSourceRunning) {
			callDataSource();
		}

		return dataSource;
	}

	private void callDataSource() {
		//Api calls
		new Thread(new Runnable() {
			@Override
			public void run() {
				isDataSourceRunning = true;
				for (int i = 1; i < 500; i++) {
					try {

						dataSource.postValue(i);
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				isDataSourceRunning = false;

			}
		}).start();

	}

}
