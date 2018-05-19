package com.xiandon.facetest.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private Context mContext;
    private static String TAG = "MyDataBaseHelper";

    public static String CREATE_BOOK = "create table Book(id integer primary key autoincrement,author text,price real,pages integer,name text)";
    public static String CREATE_CATEGORY = "create table Category(id integer primary key autoincrement,category_name text,category_code integer)";

    public MyDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        Log.d(TAG, "数据表CREATE_BOOK创建成功");
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Log.d(TAG, "数据表CREATE_CATEGORY创建成功");
    }

    /**
     * 升级数据库
     *
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Book");
        sqLiteDatabase.execSQL("drop table if exists Category");
        onCreate(sqLiteDatabase);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        Toast.makeText(mContext, "创建数据库成功" + getDatabaseName(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "数据库Book.db创建成功" + getDatabaseName());
        return super.getWritableDatabase();
    }
}
