package com.example.tugas_rancang_pam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class ContactusActivity extends AppCompatActivity {
    Button mDialbtn;
    private final int SHOW_CALL_PHONE = 1;
    private final int CALL_PHONE_PERMISSION = 2;
    private String[] PERMISSIONS = {Manifest.permission.CALL_PHONE};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
            for (String permission : PERMISSIONS) {
                if (ActivityCompat.checkSelfPermission(ContactusActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(ContactusActivity.this, PERMISSIONS, CALL_PHONE_PERMISSION);
                }
            }
        }


        mDialbtn=findViewById(R.id.dialbtn);
        mDialbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkPermission()){
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:085720037803"));
                    startActivity(callIntent);
                }else{
                    if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
                        for (String permission : PERMISSIONS) {
                            if (ActivityCompat.checkSelfPermission(ContactusActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(ContactusActivity.this, PERMISSIONS, CALL_PHONE_PERMISSION);
                            }
                        }
                    }
                }
            }
        });

    }

    public boolean checkPermission(){
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)) {
            for (String permission : PERMISSIONS) {
                if (ActivityCompat.checkSelfPermission(ContactusActivity.this, permission) == PackageManager.PERMISSION_GRANTED) {
                    return true ;
                }
                else{
                    return false ;
                }
            }
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

}
