package com.app.locker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class LockerMainActivity extends FragmentActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.locker_main);

		((ImageButton) findViewById(R.id.btn_main_add))
				.setOnClickListener(this);
		((ImageButton) findViewById(R.id.btn_main_list))
				.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {

		case R.id.btn_main_add:
			setFragment(new LockerNewFragment());
			break;
		case R.id.btn_main_list:
			setFragment(new LockerListFragment());
			break;

		}
	}

	private void setFragment(Fragment fragment) {
		(getSupportFragmentManager().beginTransaction())
				.replace(android.R.id.content, fragment, "")
				.addToBackStack(null).commit();
	}

}
