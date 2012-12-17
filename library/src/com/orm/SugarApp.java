package com.orm;

import android.content.Context;
import android.util.Log;

import java.util.*;

import static com.orm.dsl.Collection.set;

public class SugarApp extends android.app.Application{

    Database database;
    private static SugarApp sugarContext;

    public void onCreate(){
        super.onCreate();
        SugarApp.sugarContext = this;
        this.database = new Database(this);
    }

    public void onTerminate(){

    if (this.database != null) {
      this.database.closeDB();
    }
        super.onTerminate();
    }

    public static SugarApp getSugarContext(){
        return sugarContext;
    }
    public Database getDatabase() {
    	return database;
    }


}
