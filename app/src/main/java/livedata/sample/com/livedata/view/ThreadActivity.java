package livedata.sample.com.livedata.view;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import livedata.sample.com.livedata.R;


public class ThreadActivity extends AppCompatActivity  {

	private MutableLiveData<String> mLiveData;

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);
		init();
		//mLiveData.setValue("sekar");

		startMyWorkerThread();
	}

	private void init() {
		textView = findViewById(R.id.tvName);
		mLiveData = new MutableLiveData<>();
		mLiveData.observe(this, new Observer<String>() {
			@Override
			public void onChanged(@Nullable String text) {
				textView.setText(text);
			}
		});
	}

	private void startMyWorkerThread() {
	new Thread() {

		@Override
		public void run() {
			super.run();
			mLiveData.postValue("Volvo cars!");
		//mLiveData.setValue("volvo Cars!");
		}
	}.start();

	}
}
