package com.example.a4_6_app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReadDBActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_db);

        TextView titleView = findViewById(R.id.read_title);
        TextView contentView =findViewById(R.id.read_content);

        DBHELPER dbhelper = new DBHELPER(this);
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select title, content from tb_memo order by _id desc limit 1", null);
        while (cursor . moveToNext()){
            titleView.setText(cursor.getString (0));
            contentView.setText(cursor.getString(1));

            // setText 의 의미는 ?
        }
        db.close();

    }
}
