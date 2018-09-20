package livedata.sample.com.livedata.view;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import livedata.sample.com.livedata.R;
import livedata.sample.com.livedata.viewmodel.MyActivityViewModel;

public class TimerActivity extends AppCompatActivity {

	private MyActivityViewModel mViewModel;
	private TextView textView;
	MediatorLiveData


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer);
		initViewModel();
	}

	private void initView() {
		textView = findViewById(R.id.tvNumber);
		mViewModel.getValue().observeForever( new Observer<Integer>() {
			@Override
			public void onChanged(@Nullable Integer integer) {
				textView.setText(""+integer);
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

	private void initViewModel() {
		mViewModel = ViewModelProviders.of(this).get(MyActivityViewModel.class);
		initView();

	}

	@Override
	protected void onDestroy() {
		Log.d("LiveData--->", "onDestroy()");
		super.onDestroy();
	}
}
