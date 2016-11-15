package com.menanga.ezparking.server;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.menanga.ezparking.R;

/**
 * Created by haqiqi on 14-Nov-16.
 */

public class SliderAdapter extends PagerAdapter {
    private Context ctx;

    public SliderAdapter(Context ctx){
        this.ctx = ctx;
    }

    private int[] sliderImagesId = new int[]{
            //R.event.img_acara_1, R.drawable.img_acara_2, R.drawable.img_acara_3,
            //R.drawable.img_acara_4, R.drawable.img_acara_5,
    };

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView img = new ImageView(this.ctx);
        img.setScaleType(ImageView.ScaleType.FIT_START);
        img.setImageResource(sliderImagesId[position]);
        img.requestLayout();


        //ViewPager.LayoutParams para = (ViewPager.LayoutParams) img.getLayoutParams();
        //para.height = ViewPager.LayoutParams.MATCH_PARENT;
        //para.width = ViewPager.LayoutParams.WRAP_CONTENT;

        ///img.setLayoutParams(para);

        ((ViewPager) container).addView(img, 0);


        return img;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((ImageView) object);
    }
}
