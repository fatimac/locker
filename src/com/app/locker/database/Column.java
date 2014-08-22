package com.app.locker.database;

public class Column {

	private String columnName;
	private String columnIdentifier;

	public Column(String columnName, String columnIdentifier) {
		super();
		this.columnName = columnName;
		this.columnIdentifier = columnIdentifier;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnIdentifier() {
		return columnIdentifier;
	}

	public void setColumnIdentifier(String columnIdentifier) {
		this.columnIdentifier = columnIdentifier;
	}

}
