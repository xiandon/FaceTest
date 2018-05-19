package com.xiandon.facetest.storage;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xiandon.facetest.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StorageActivity extends AppCompatActivity {
    private static String TAG = "StorageActivity";

    @BindView(R.id.et_storage_save_content)
    EditText etStorageSaveContent;
    @BindView(R.id.et_storage_load_content)
    EditText etStorageLoadContent;

    private MyDataBaseHelper helper;

    private String fileSaveName = "FILE_STUDENT_NUM";
    private String sharedPreferencesSaveName = "SHARED_STUDENT_NUM";
    private String sqLiteSaveName = "SQ_LITE_STUDENT_NUM";

    private String saveData;
    private String loadData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_storage_file_save,
            R.id.btn_storage_file_load,
            R.id.btn_storage_shared_preferences_save,
            R.id.btn_storage_shared_preferences_load,
            R.id.btn_storage_sqLite_create_db,
            R.id.btn_storage_sqLite_update_Database,
            R.id.btn_storage_sqLite_save,
            R.id.btn_storage_sqLite_load,
            R.id.btn_storage_sqLite_insert_table,
            R.id.btn_storage_sqLite_update_table,
            R.id.btn_storage_sqLite_delete_table,
            R.id.btn_storage_sqLite_query_table})
    public void onViewClicked(View view) {
        saveData = etStorageSaveContent.getText().toString();
        switch (view.getId()) {
            case R.id.btn_storage_file_save:
                fileSave(saveData, fileSaveName);
                etStorageSaveContent.setText("");
                break;
            case R.id.btn_storage_file_load:
                loadData = fileLoad(fileSaveName);
                etStorageLoadContent.setText(loadData);
                break;
            case R.id.btn_storage_shared_preferences_save:
                sharedPreferencesSave(saveData, sharedPreferencesSaveName);
                etStorageSaveContent.setText("");
                break;
            case R.id.btn_storage_shared_preferences_load:
                loadData = sharedPreferencesLoad(sharedPreferencesSaveName);
                etStorageLoadContent.setText(loadData);
                break;
            case R.id.btn_storage_sqLite_create_db:
                createDb();
                break;
            case R.id.btn_storage_sqLite_update_Database:
                updateDatabase();
                break;
            case R.id.btn_storage_sqLite_save:
                break;
            case R.id.btn_storage_sqLite_load:
                break;
            case R.id.btn_storage_sqLite_insert_table:
                addDataToTable();
                break;
            case R.id.btn_storage_sqLite_update_table:
                break;
            case R.id.btn_storage_sqLite_delete_table:
                break;
            case R.id.btn_storage_sqLite_query_table:
                queryDataFromTable();
                break;
        }
    }

    /**
     * 从数据库查数据
     */
    private void queryDataFromTable() {
        helper = new MyDataBaseHelper(this, "BOOK_STORE.db", null, 3);
        SQLiteDatabase database = helper.getWritableDatabase();

        //查询所有数据
        Cursor cursor = database.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.d(TAG, "书名：" + name + " ，作者：" + author + " 共 " + pages + " 页，一本 " + price + " 元。");
            } while (cursor.moveToNext());
        }
        cursor.close();

    }

    /**
     * 数据库新增数据
     */
    private void addDataToTable() {
        helper = new MyDataBaseHelper(this, "BOOK_STORE.db", null, 3);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", "Android一周提升");
        values.put("author", "东东");
        values.put("price", 29.99);
        values.put("pages", 200);
        database.insert("Book", null, values);
        values.clear();
        values.put("name", "Java编程思想");
        values.put("author", "蓬蓬");
        values.put("price", 99.89);
        values.put("pages", 700);
        database.insert("Book", null, values);
    }

    /**
     * 数据库版本升级，可用于在表过大的时候，新增表，删除表等操作.
     * 只要版本于当前版本，则会先执行MyDataBaseHelper中的onUpgrade方法，执行相关操作，进行升级.
     */
    private void updateDatabase() {
        helper = new MyDataBaseHelper(this, "BOOK_STORE.db", null, 3);
        helper.getWritableDatabase();
    }

    /**
     * 创建SQLite数据库，会生成2个文件，一个是数据库文件，一个是临时日志文件
     */
    private void createDb() {
        helper = new MyDataBaseHelper(this, "BOOK_STORE.db", null, 1);
        helper.getWritableDatabase();
    }

    /**
     * SQLite读取数据
     *
     * @param sqLiteSaveName 数据库名称
     */
    private String sqLiteLoad(String sqLiteSaveName) {
        return sqLiteSaveName;
    }

    /**
     * SQLite 数据库保存，文件格式使用XML表示的
     *
     * @param saveData       内容
     * @param sqLiteSaveName 数据库名称
     */
    private void sqLiteSave(String saveData, String sqLiteSaveName) {
    }

    /**
     * sharedPreferences 读取
     *
     * @param sharedPreferencesSaveName 名称
     * @return 读取的值
     */
    private String sharedPreferencesLoad(String sharedPreferencesSaveName) {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferencesSaveName, MODE_PRIVATE);
        String saveData = sharedPreferences.getString("存了啥？", "没啥");
        return saveData;
    }


    /**
     * sharedPreferences 保存
     *
     * @param saveData                  保存的值
     * @param sharedPreferencesSaveName 名称
     */
    private void sharedPreferencesSave(String saveData, String sharedPreferencesSaveName) {
        SharedPreferences.Editor editor = getSharedPreferences(sharedPreferencesSaveName, MODE_PRIVATE).edit();
        editor.putString("存了啥？", saveData);// 这里editor可以存多个键值对
        editor.apply();
    }

    /**
     * 文件读取
     *
     * @param fileSaveName 文件名称
     * @return 读取的内容
     */
    private String fileLoad(String fileSaveName) {
        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;
        StringBuffer content = new StringBuffer();
        try {
            Toast.makeText(this, fileSaveName, Toast.LENGTH_SHORT).show();
            fileInputStream = openFileInput(fileSaveName);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            Toast.makeText(this, "读取完成" + content.toString(), Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

    /**
     * 文件保存
     *
     * @param saveData     文件内容
     * @param fileSaveName 文件名称
     */
    private void fileSave(String saveData, String fileSaveName) {
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        Toast.makeText(this, fileSaveName, Toast.LENGTH_SHORT).show();
        try {
            // fileOutputStream = openFileOutput(fileSaveName, Context.MODE_PRIVATE);// 覆盖原数据
            fileOutputStream = openFileOutput(fileSaveName, Context.MODE_APPEND); // 在原数据之后追加值
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(saveData);
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
