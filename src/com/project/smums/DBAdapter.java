package com.project.smums;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter extends SQLiteOpenHelper {

	public DBAdapter(Context context) {
		super(context, "schedule", null, 1);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE schedule" + "(_id text primary key,"
		+ "date TEXT, game TEXT, stadium TEXT);");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140724', 'soccer', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140724', 'handball', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
				+"VALUES('20140724', 'golf', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
				+"VALUES('20140724', 'rhythm', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
				+"VALUES('20140724', 'judo', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
				+"VALUES('20140724', 'handball', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140725', 'baseball', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140725', 'waterpolo', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140726', 'basketball', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140726', 'golf', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
			+"VALUES('20140727', 'fencing', 'gwangju');");
		db.execSQL("INSERT INTO schedule"+"(date, game, stadium)"
				+"VALUES('20140729', 'soccer', 'gwangju');");
	}

	public void onUpgrade(SQLiteDatabase db,int oldVersion, int newViersion) {
		db.execSQL("DROP TABLE IF EXISTS schedule");
		onCreate(db);
	}
}