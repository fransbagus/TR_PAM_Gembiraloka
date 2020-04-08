package com.example.tugas_rancang_pam;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter adapter;
    List<GalleryModel> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        models = new ArrayList<>();
        models.add(new GalleryModel(R.drawable.gallery1));
        models.add(new GalleryModel(R.drawable.gallery2));
        models.add(new GalleryModel(R.drawable.gallery3));
        models.add(new GalleryModel(R.drawable.gallery4));
        models.add(new GalleryModel(R.drawable.gallery5));
        models.add(new GalleryModel(R.drawable.gallery6));
        models.add(new GalleryModel(R.drawable.gallery7));
        models.add(new GalleryModel(R.drawable.slide1));
        models.add(new GalleryModel(R.drawable.slide2));
        models.add(new GalleryModel(R.drawable.slide3));


        adapter = new Adapter(models, GalleryActivity.this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color5),
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
