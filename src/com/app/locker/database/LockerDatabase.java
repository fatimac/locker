package com.app.locker.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.locker.model.Locker;

public class LockerDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "lockerdb";
	private static final String LOCKER_ACCOUNTS_TABLE = "LOCKER_TABLE";

	public LockerDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		ArrayList<Column> lockerTableColumns = new ArrayList<Column>();
		lockerTableColumns.add(new Column(Locker.LOCKER_ID,
				"INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL"));
		lockerTableColumns.add(new Column(Locker.USERNAME, "TEXT"));
		lockerTableColumns.add(new Column(Locker.EMAIL_ADDRESS, "TEXT"));
		lockerTableColumns.add(new Column(Locker.PASSWORD, "TEXT"));
		lockerTableColumns.add(new Column(Locker.WEBSITE_NAME, "TEXT"));
		lockerTableColumns.add(new Column(Locker.WEBSITE_URL, "TEXT"));

		db.execSQL(tableCreator(LOCKER_ACCOUNTS_TABLE, lockerTableColumns));

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void addLocker(Locker account) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(Locker.USERNAME, account.getUsername());
		values.put(Locker.EMAIL_ADDRESS, account.getEmailAddress());
		values.put(Locker.PASSWORD, account.getPassword());
		values.put(Locker.WEBSITE_NAME, account.getWebsiteName());
		values.put(Locker.WEBSITE_URL, account.getWebsiteUrl());

		db.insert(LOCKER_ACCOUNTS_TABLE, null, values);
		db.close();
	}

	public List<Locker> getLockerList() {
		SQLiteDatabase db = this.getReadableDatabase();

		List<Locker> lockerList = new ArrayList<Locker>();
		Cursor cursor = db.query(LOCKER_ACCOUNTS_TABLE, new String[] {
				Locker.LOCKER_ID, Locker.WEBSITE_NAME, Locker.WEBSITE_URL },
				null, null, null, null, null);

		if (cursor.moveToFirst()) {
			do {
				Locker locker = new Locker();
				locker.setLockerId(cursor.getInt(0));
				locker.setWebsiteName(cursor.getString(1));
				locker.setWebsiteUrl(cursor.getString(2));
				lockerList.add(locker);
			} while (cursor.moveToNext());
		}
		db.close();

		return lockerList;
	}

	public Locker getLocker(int lockerId) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(LOCKER_ACCOUNTS_TABLE, new String[] {
				Locker.WEBSITE_NAME, Locker.WEBSITE_URL, Locker.USERNAME,
				Locker.EMAIL_ADDRESS, Locker.PASSWORD }, Locker.LOCKER_ID
				+ "=?", new String[] { String.valueOf(lockerId) }, null, null,
				null);
		if (cursor != null)
			cursor.moveToFirst();
		db.close();

		return new Locker(cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(0), cursor.getString(1));
	}

	private String tableCreator(String tableName, ArrayList<Column> columns) {

		String columnText = "";
		for (int count = 0; count < columns.size(); count++) {
			columnText += columns.get(count).getColumnName() + " ";
			columnText += columns.get(count).getColumnIdentifier();

			if (count != columns.size() - 1)
				columnText += ", ";
		}

		return "CREATE TABLE " + tableName + "(" + columnText + ")";

	}
}
