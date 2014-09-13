package com.app.locker;

import com.app.locker.database.LockerDatabase;
import com.app.locker.model.Locker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LockerNewFragment extends Fragment {

	private LockerDatabase lockerDb;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lockerDb = new LockerDatabase(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.locker_new, container, false);

		final EditText etUsername = (EditText) view
				.findViewById(R.id.et_locker_username);
		final EditText etEmailAdd = (EditText) view
				.findViewById(R.id.et_locker_email);
		final EditText etPassword = (EditText) view
				.findViewById(R.id.et_locker_password);
		final EditText etWebName = (EditText) view
				.findViewById(R.id.et_locker_webName);
		final EditText etWebUrl = (EditText) view
				.findViewById(R.id.et_locker_weburl);

		((Button) view.findViewById(R.id.btn_add_locker))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Locker locker = new Locker();
						locker.setUsername(etUsername.getText().toString());
						locker.setEmailAddress(etEmailAdd.getText().toString());
						locker.setPassword(etPassword.getText().toString());
						locker.setWebsiteName(etWebName.getText().toString());
						locker.setWebsiteUrl(etWebUrl.getText().toString());

						lockerDb.addLocker(locker);
					}
				});

		return view;
	}
}
