package com.master.design.gala.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.master.design.gala.Activity.SubListingActivity;

import com.master.design.gala.DataModel.OccasionSlides;
import com.master.design.gala.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImagePagerAdapter extends PagerAdapter {

    private Context mContext;


    private ArrayList<OccasionSlides> sub;
    public ImagePagerAdapter(Context context, ArrayList<OccasionSlides> OccasionSlidess) {
        mContext = context;
        sub = OccasionSlidess;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_image, collection, false);
        ImageView img = (ImageView) layout.findViewById(R.id.img);
        Picasso.with(mContext).load(sub.get(position).getImage()).into(img);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return sub.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

}

