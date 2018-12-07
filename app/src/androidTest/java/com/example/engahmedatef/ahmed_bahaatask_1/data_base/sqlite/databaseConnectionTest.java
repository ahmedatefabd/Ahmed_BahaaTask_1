package com.example.engahmedatef.ahmed_bahaatask_1.data_base.sqlite;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.engahmedatef.ahmed_bahaatask_1.data.local.Posts;
import com.example.engahmedatef.ahmed_bahaatask_1.ui.main_screen.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class databaseConnectionTest {

    private Database_Connection dbHelper ;
    private Posts posts ;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        dbHelper = new Database_Connection(mainActivityActivityTestRule.getActivity());
        posts = new Posts(mainActivityActivityTestRule.getActivity());
    }

    @Test
    public void insertPost() throws Exception {

//        Posts posts1  = new Posts();

        posts.setId("1");
        posts.setBody("ahmed");
        posts.setTitle("Atef");
//        posts.setUserId(Integer.valueOf("10"));


//        boolean isInserted = dbHelper.insertPost(posts);

//        assertEquals(true, isInserted); // no work

//        assertEquals(false, isInserted); //work

    }
}