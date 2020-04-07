package com.example.tugas_rancang_pam;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class RecreationActivity extends AppCompatActivity {

    ViewPager viewPager;
    AdapterRecreation adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recreation);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        models = new ArrayList<>();
        models.add(new Model(R.drawable.onta_tunggang, getResources().getString(R.string.title_OT), getResources().getString(R.string.desc_OT)));
        models.add(new Model(R.drawable.petting_zoo, getResources().getString(R.string.title_PZ), getResources().getString(R.string.desc_PZ)));
        models.add(new Model(R.drawable.zoo_express, getResources().getString(R.string.title_ZE), getResources().getString(R.string.desc_ZE)));
        models.add(new Model(R.drawable.ninebot, getResources().getString(R.string.title_NB), getResources().getString(R.string.desc_NB)));
        models.add(new Model(R.drawable.kolam_sentuh, getResources().getString(R.string.title_KS), getResources().getString(R.string.desc_KS)));
        models.add(new Model(R.drawable.gajah_tunggang, getResources().getString(R.string.title_GT), getResources().getString(R.string.desc_GT)));
        models.add(new Model(R.drawable.kolam_tangkap, getResources().getString(R.string.title_KT), getResources().getString(R.string.desc_KT)));
        models.add(new Model(R.drawable.terapi_ikan, getResources().getString(R.string.title_TI), getResources().getString(R.string.desc_TI)));
        models.add(new Model(R.drawable.perahu_kayuh, getResources().getString(R.string.title_PK), getResources().getString(R.string.desc_PK)));
        models.add(new Model(R.drawable.skuter_air, getResources().getString(R.string.title_SA), getResources().getString(R.string.desc_SA)));
        models.add(new Model(R.drawable.taring_transportasi_keliling, getResources().getString(R.string.title_TK), getResources().getString(R.string.desc_TK)));
        models.add(new Model(R.drawable.atv, getResources().getString(R.string.title_ATV), getResources().getString(R.string.desc_ATV)));
        models.add(new Model(R.drawable.bumper_boat, getResources().getString(R.string.title_BB), getResources().getString(R.string.desc_BB)));
        models.add(new Model(R.drawable.speed_boat, getResources().getString(R.string.title_SB), getResources().getString(R.string.desc_SB)));
        models.add(new Model(R.drawable.perahu_katamaran, getResources().getString(R.string.title_PKA), getResources().getString(R.string.desc_PKA)));


        adapter = new AdapterRecreation(models, RecreationActivity.this);

        viewPager = findViewById(R.id.viewPager1);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
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
