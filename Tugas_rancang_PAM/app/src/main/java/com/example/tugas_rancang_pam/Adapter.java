package com.example.tugas_rancang_pam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends PagerAdapter {

    private List<GalleryModel> models;
    private LayoutInflater layoutInflater;
    private Context context;
    private View view ;
    int pos ;

    public Adapter(List<GalleryModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.item, container, false);
        ImageView imageView;
        imageView = view.findViewById(R.id.image);
        imageView.setImageResource(models.get(position).getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView1 = ((GalleryActivity) context).findViewById(R.id.viewImage);
                imageView1.setImageResource(models.get(position).getImage());
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
