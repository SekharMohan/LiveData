package livedata.sample.com.livedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import livedata.sample.com.livedata.view.ActivityWithoutViewModel;
import livedata.sample.com.livedata.view.ThreadActivity;
import livedata.sample.com.livedata.view.TimerActivity;

public class MainActivity extends AppCompatActivity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	private void initView() {
		findViewById(R.id.btnThread).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startThreadActivity();

			}
		});

		findViewById(R.id.btnTimer).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startTimerActivity();

			}
		});

		findViewById(R.id.btnWoutVM).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivityWithoutVM();
			}
		});
	}

	private void startThreadActivity() {
		Intent intent = new Intent(this, ThreadActivity.class);
		startActivity(intent);
	}

	private void startTimerActivity() {
		Intent intent = new Intent(this, TimerActivity.class);
		startActivity(intent);
	}

	private void startActivityWithoutVM() {
		Intent intent = new Intent(this, ActivityWithoutViewModel.class);
		startActivity(intent);
	}
}
