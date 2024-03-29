package com.example.emflashcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "Flashcard";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "Question";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our question column
    private static final String QUEST_COL = "question";

    // below variable id for our True respons column.
    private static final String REPONST_COL = "reponsT";

    // below variable for our false responce column.
    private static final String REPONSF1_COL = "reponsf1";

    // below variable is for our false responce column.
    private static final String REPONSF2_COL = "reponsf2";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUEST_COL + " TEXT,"
                + REPONST_COL + " TEXT,"
                + REPONSF1_COL + " TEXT,"
                + REPONSF2_COL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new question to our sqlite database.
    public void addNewQuestion(String question, String reponsv, String reponsf1, String reponsf2) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(QUEST_COL, question);
        values.put(REPONST_COL, reponsv);
        values.put(REPONSF1_COL, reponsf1);
        values.put(REPONSF2_COL, reponsf2);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<QuestionModal> readQuestion(){

        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to
        // read data from database
        Cursor cursorQuestion
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // on below line we are creating a new array list.
        ArrayList<QuestionModal> questionModalArrayList
                = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorQuestion.moveToFirst()) {
            do {
                // on below line we are adding the data from
                // cursor to our array list.
                questionModalArrayList.add(new QuestionModal(
                        cursorQuestion.getString(1),
                        cursorQuestion.getString(4),
                        cursorQuestion.getString(2),
                        cursorQuestion.getString(3)));
            } while (cursorQuestion.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorQuestion.close();
        return questionModalArrayList;
    }

    // below is the method for updating our Qustion
    public void updateQuestion(String originalQuestion, String question, String reponsv, String reponsf1, String reponsf2) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(QUEST_COL, question);
        values.put(REPONST_COL, reponsv);
        values.put(REPONSF1_COL, reponsf1);
        values.put(REPONSF2_COL, reponsf2);

        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update(TABLE_NAME, values, "question=?", new String[]{originalQuestion});
        db.close();
    }
    // below is the method for deleting our course.
    public void deleteQuestion(String question) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete(TABLE_NAME, "question=?", new String[]{question});
        db.close();
    }



}
