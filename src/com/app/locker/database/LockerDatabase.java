package com.app.locker.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LockerDatabase extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "drumbilivedb";
	private static final String DRUMBI_ACCOUNT_TABLE = "ACCOUNT_TABLE";
	private static final String DRUMBI_STATUSES_TABLE = "STATUSES_TABLE";

	public LockerDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		// DRUMBI ACCOUNT TABLE Creation
		ArrayList<Column> accountTableColumns = new ArrayList<Column>();
		accountTableColumns.add(new Column(Account.ID_KEY, "INTEGER"));
		accountTableColumns.add(new Column(Account.USERNAME_KEY, "TEXT"));
		accountTableColumns.add(new Column(Account.FIRSTNAME_KEY, "TEXT"));
		accountTableColumns.add(new Column(Account.COMPANY_NAME_KEY, "TEXT"));
		accountTableColumns.add(new Column(Account.PHONENUMBER_KEY, "TEXT"));
		db.execSQL(tableCreator(DRUMBI_ACCOUNT_TABLE, accountTableColumns));

		// DRUMBI STATUSES TABLE Creation
		ArrayList<Column> statusTableColumns = new ArrayList<Column>();
		statusTableColumns.add(new Column(DrumbiStatus.STATUS_KEY, "TEXT"));
		statusTableColumns
				.add(new Column(DrumbiStatus.DISPLAY_NAME_KEY, "TEXT"));
		statusTableColumns.add(new Column(DrumbiStatus.ICON_KEY, "INTEGER"));
		db.execSQL(tableCreator(DRUMBI_STATUSES_TABLE, statusTableColumns));
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

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
