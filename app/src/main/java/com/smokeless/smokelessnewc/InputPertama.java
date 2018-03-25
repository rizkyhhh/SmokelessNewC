package com.smokeless.smokelessnewc;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import com.smokeless.smokelessnewc.MethodPenting.InputContract.inputEntry;
import com.smokeless.smokelessnewc.MethodPenting.DatabaseHelper;

public class InputPertama extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_pertama);
    }


}
