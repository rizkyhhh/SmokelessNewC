package com.smokeless.smokelessnewc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InfoKesehatan extends AppCompatActivity {
    Button moneyprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kesehatan);

        moneyprogress = (Button) findViewById(R.id.submit_health_progress);
        moneyprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent z = new Intent (InfoKesehatan.this, InfoKeuangan.class );
                startActivity(z);
            }
        });
    }
}
