package com.app.locker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.locker.database.LockerDatabase;
import com.app.locker.model.Locker;

public class LockerListViewFragment extends Fragment implements
		OnLongClickListener, OnClickListener {

	private Locker locker;

	private TextView tvUsername;
	private TextView tvEmail;
	private TextView tvPassword;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LockerDatabase lockerDb = new LockerDatabase(getActivity());

		if (getArguments() != null) {
			int lockerId = getArguments().getInt(Locker.LOCKER_ID);
			if (lockerId >= 0) {
				locker = lockerDb.getLocker(lockerId);
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.locker_list_view, container,
				false);

		((TextView) view.findViewById(R.id.tv_lview_webname)).setText(locker
				.getWebsiteName());
		((TextView) view.findViewById(R.id.tv_lview_weburl)).setText(locker
				.getWebsiteUrl());

		tvUsername = (TextView) view.findViewById(R.id.tv_lview_username);
		tvEmail = (TextView) view.findViewById(R.id.tv_lview_email);
		tvPassword = (TextView) view.findViewById(R.id.tv_lview_password);

		tvUsername.setOnLongClickListener(this);
		tvEmail.setOnLongClickListener(this);
		tvPassword.setOnLongClickListener(this);

		tvUsername.setOnClickListener(this);
		tvEmail.setOnClickListener(this);
		tvPassword.setOnClickListener(this);

		return view;
	}

	@Override
	public boolean onLongClick(View view) {
		switch (view.getId()) {

		case R.id.tv_lview_username:
			tvUsername.setText(locker.getUsername());
			break;
		case R.id.tv_lview_email:
			tvEmail.setText(locker.getEmailAddress());
			break;
		case R.id.tv_lview_password:
			tvPassword.setText(locker.getPassword());
			break;

		}

		return true;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {

		case R.id.tv_lview_username:
			tvUsername.setText("Username");
			break;
		case R.id.tv_lview_email:
			tvEmail.setText("Email Address");
			break;
		case R.id.tv_lview_password:
			tvPassword.setText("Password");
			break;

		}

	}
}
