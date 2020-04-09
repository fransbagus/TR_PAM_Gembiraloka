package com.example.tugas_rancang_pam;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ContactusActivity extends AppCompatActivity {
    Button mDialbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDialbtn=findViewById(R.id.dialbtn);
        String number = "6281231925666";
        mDialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "6281231925666";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+Uri.encode(number)));
                startActivity(intent);
            }
        });

    }

}
