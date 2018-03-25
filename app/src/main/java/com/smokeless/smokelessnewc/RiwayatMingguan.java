package com.smokeless.smokelessnewc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper;
import com.smokeless.smokelessnewc.MethodPenting.InputContract.inputEntry;

public class RiwayatMingguan extends AppCompatActivity {


    private DatabaseHelper mDbHelper;
    String currentJumlah;
    Button riwayat_mingguan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_mingguan);

        riwayat_mingguan = (Button) findViewById(R.id.button_riwayat_mingguan);
        riwayat_mingguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent (RiwayatMingguan.this, InfoKesehatan.class );
                startActivity(z);
            }
        });
        mDbHelper = new DatabaseHelper(this);
        displayDatabaseInfo();


    }
    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }
    private void displayDatabaseInfo() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                "SUM("+inputEntry.COLUMN_JUMLAH_ROKOK+")"
        };

        Cursor cursor = db.query(
                inputEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        TextView textJumlah = findViewById(R.id.jumlah_batang);
        try{
            while (cursor.moveToNext()){
                int tempJumlah = cursor.getInt(0);
                currentJumlah = Integer.toString(tempJumlah);
                textJumlah.setText((currentJumlah +" Batang"));
            }
        }finally{
            cursor.close();
        }
    }
}
