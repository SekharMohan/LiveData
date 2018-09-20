package livedata.sample.com.livedata.view;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import livedata.sample.com.livedata.R;

public class ActivityWithoutViewModel extends AppCompatActivity {
	private TextView tvNum;
	private MutableLiveData<Integer> dataSource = new MutableLiveData<>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_without_view_model);
		initView();
	}

	private void initView() {
		tvNum = findViewById(R.id.tvNum);
		getValue().observe(this, new Observer<Integer>() {
			@Override
			public void onChanged(@Nullable Integer integer) {
				tvNum.setText(""+integer);
			}
		});

		findViewById(R.id.btnOrientation).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(getResources().getConfiguration().orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

				}else {

					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
			}
		});
	}

	public LiveData<Integer> getValue() {

		callDataSource();

		return dataSource;
	}

	private void callDataSource() {
		//Api calls
		new Thread(new Runnable() {
			@Override
			public void run() {

				for(int i = 1; i< 500; i++) {
					try {

						dataSource.postValue(i);
						Thread.sleep(2000);
					}catch (InterruptedException e) {
						e.printStackTrace();
					}

				}

			}
		}).start();

	}
}
