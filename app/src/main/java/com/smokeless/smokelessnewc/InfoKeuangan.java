package com.smokeless.smokelessnewc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper;
import com.smokeless.smokelessnewc.MethodPenting.InputContract;

public class InfoKeuangan extends AppCompatActivity {

    private DatabaseHelper mDbHelper;
    final int harga = 1500;
    String currentJumlah;
    Button info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_keuangan);
        mDbHelper = new DatabaseHelper(this);
        displayDatabaseInfo();
        info = (Button) findViewById(R.id.submit_money_progress);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent (InfoKeuangan.this, MainActivity.class );
                startActivity(z);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }
    private void displayDatabaseInfo() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                "SUM("+ InputContract.inputEntry.COLUMN_JUMLAH_ROKOK+")"
        };

        Cursor cursor = db.query(
                InputContract.inputEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        TextView textJumlah = findViewById(R.id.biaya_rokok);
        try{
            while (cursor.moveToNext()){
                int tempJumlah = cursor.getInt(0);
                int biaya = tempJumlah * harga;
                currentJumlah = Integer.toString(biaya);
                textJumlah.setText(("Rp. "+currentJumlah));
            }
        }finally{
            cursor.close();
        }
    }
}
