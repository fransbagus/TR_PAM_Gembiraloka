package com.example.tugas_rancang_pam;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class AttractionActivity extends AppCompatActivity {
    ViewPager viewPager;
    AdapterRecreation adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.gallery4, getResources().getString(R.string.title_BS), getResources().getString(R.string.desc_BS)));
        models.add(new Model(R.drawable.interaksi_reptile, getResources().getString(R.string.title_IR), getResources().getString(R.string.desc_IR)));
        models.add(new Model(R.drawable.presentasi_dan_edukasi_satwa, getResources().getString(R.string.title_PES), getResources().getString(R.string.desc_PES)));
        models.add(new Model(R.drawable.atraksi4, getResources().getString(R.string.title_FTA), getResources().getString(R.string.desc_FTA)));


        adapter = new AdapterRecreation(models, AttractionActivity.this);

        viewPager = findViewById(R.id.viewPager2);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
