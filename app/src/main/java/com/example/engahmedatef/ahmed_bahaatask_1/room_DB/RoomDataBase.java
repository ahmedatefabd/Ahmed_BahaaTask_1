package com.example.engahmedatef.ahmed_bahaatask_1.room_DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.PostModel_Room;


@Database(entities = {PostModel_Room.class}, version = 1, exportSchema = false)
public abstract class RoomDataBase extends RoomDatabase {

    private static RoomDatabase instance;

    public abstract PostDAO oper();


    public RoomDataBase() {
    }


    //Single ton
    public static RoomDatabase getInstance(Context context) {

        if (instance == null) {
            synchronized (RoomDataBase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDataBase.class,
                            "product_database")
                            .build();

                }
            }
        }
        return instance;
    }

}
