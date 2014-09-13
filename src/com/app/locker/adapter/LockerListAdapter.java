package com.app.locker.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.app.locker.R;
import com.app.locker.model.Locker;

public class LockerListAdapter extends BaseAdapter {

	private LayoutInflater layoutInflater;
	private List<Locker> lockerList;

	public LockerListAdapter(Context context, List<Locker> _lockerList) {

		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.lockerList = _lockerList;
	}

	@Override
	public int getCount() {
		return lockerList.size();
	}

	@Override
	public Locker getItem(int position) {
		return lockerList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		if (view == null)
			view = layoutInflater.inflate(R.layout.locker_list_adapter, null);

		Log.e("sdfsdfds", lockerList.get(position).getWebsiteName());
		((TextView) view.findViewById(R.id.txtview_list_webname))
				.setText(lockerList.get(position).getWebsiteName());
		((TextView) view.findViewById(R.id.txtview_list_weburl))
				.setText(lockerList.get(position).getWebsiteUrl());

		return view;

	}

}
