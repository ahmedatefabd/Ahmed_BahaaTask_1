package com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite;

import android.content.Context;

public class Database_Helper {

    private static Database_Connection databaseConnection;

    public static Database_Connection getInstance(Context mContext){

        if (databaseConnection == null){
            databaseConnection = new Database_Connection(mContext);
        }
        return databaseConnection;
    }
}
