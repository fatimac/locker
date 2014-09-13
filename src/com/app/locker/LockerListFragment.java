package com.app.locker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.app.locker.adapter.LockerListAdapter;
import com.app.locker.database.LockerDatabase;
import com.app.locker.model.Locker;

public class LockerListFragment extends Fragment implements OnItemClickListener {

	private LockerDatabase lockerDb;
	private ListView listViewLocker;
	private LockerListAdapter listAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lockerDb = new LockerDatabase(getActivity());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.locker_list, container, false);

		listViewLocker = (ListView) view.findViewById(R.id.listview_locker);
		listAdapter = new LockerListAdapter(getActivity(),
				lockerDb.getLockerList());
		listViewLocker.setOnItemClickListener(this);
		listViewLocker.setAdapter(listAdapter);

		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.e("list clicked", listAdapter.getItem(position).getWebsiteName());

		Locker selectedLocker = listAdapter.getItem(position);
		LockerListViewFragment fragmentView = new LockerListViewFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(Locker.LOCKER_ID, selectedLocker.getLockerId());
		fragmentView.setArguments(bundle);

		(getActivity().getSupportFragmentManager().beginTransaction())
				.replace(android.R.id.content, fragmentView, "")
				.addToBackStack(null).commit();
	}

}
