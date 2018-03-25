package com.smokeless.smokelessnewc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper;
import com.smokeless.smokelessnewc.MethodPenting.InputContract;

import static com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper.DATABASE;
import static com.smokeless.smokelessnewc.MethodPenting.InputContract.inputEntry.TABLE_NAME;

public class InputHarian extends AppCompatActivity {

    EditText mJumlahEditText;
    Button dailyinput;
    String jumlahString;
    int jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_harian);

        mJumlahEditText = (EditText)findViewById(R.id.edit_input_daily);
        dailyinput = (Button) findViewById(R.id.submit_daily_input);

        addData();

    }


    private void insertData(){
        jumlahString = mJumlahEditText.getText().toString().trim();

        if (!jumlahString.equals("")){
            jumlah = Integer.parseInt(jumlahString);
            DatabaseHelper myDb = new DatabaseHelper(this);
            SQLiteDatabase db = myDb.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(InputContract.inputEntry.COLUMN_JUMLAH_ROKOK, jumlah);
            long newRowId = db.insert(InputContract.inputEntry.TABLE_NAME,null, values);
            if(newRowId == -1){
                Toast.makeText(this, "Data yang anda masukkan tidak valid", Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent(InputHarian.this, RiwayatMingguan.class);
                startActivity(i);
                Toast.makeText(this,"Data harian anda sudah berhasil di masukkan ",Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }



    }

    public void addData() {
        dailyinput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();

            }
        });
}
}

