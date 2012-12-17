package com.orm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class Database {
    private SugarDb sugarDb;
    private SQLiteDatabase sqLiteDatabase;
    private int activeDatabaseCount = 0;
    
    public Database(Context context){
        this.sugarDb  = new SugarDb(context);
    }


  public SQLiteDatabase openDB() {
    this.sqLiteDatabase = this.sugarDb.getWritableDatabase();
    activeDatabaseCount++;

    return this.sqLiteDatabase;
  }

  public void closeDB() {
    
    activeDatabaseCount--;
    if (activeDatabaseCount == 0) {
    	if (this.sqLiteDatabase != null) {
    		if (sqLiteDatabase.isOpen()) {
    			sqLiteDatabase.close();
            }
    	}
    }
  }
}
