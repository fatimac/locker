package com.app.locker.model;

import android.support.v4.app.Fragment;

public class LockerTab {

	private Fragment fragment;
	private String fragmentName;

	public LockerTab() {
		// TODO Auto-generated constructor stub
	}

	public LockerTab(Fragment fragment, String fragmentName) {
		super();
		this.fragment = fragment;
		this.fragmentName = fragmentName;
	}

	public Fragment getFragment() {
		return fragment;
	}

	public void setFragment(Fragment fragment) {
		this.fragment = fragment;
	}

	public String getFragmentName() {
		return fragmentName;
	}

	public void setFragmentName(String fragmentName) {
		this.fragmentName = fragmentName;
	}

}
