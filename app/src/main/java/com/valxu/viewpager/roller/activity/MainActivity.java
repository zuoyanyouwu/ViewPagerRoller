package com.valxu.viewpager.roller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.valxu.viewpager.roller.Data;
import com.valxu.viewpager.roller.R;
import com.valxu.viewpager.roller.fragment.ImageFragment;

/**
 * Author: zuoyanyouwu
 * Date: 2015-11-17
 */
public class MainActivity extends AppCompatActivity implements ViewPager.PageTransformer{

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager pager = (ViewPager) findViewById(R.id.main_content_pager);
        pager.setAdapter(new ImagePagerAdapter(getSupportFragmentManager()));
        pager.setPageTransformer(true, this);

    }

    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        float x = position * pageWidth;

        ImageView imageView = (ImageView) page.findViewById(R.id.fragment_image);

        if (imageView == null) {
            return;
        }
        imageView.setTranslationX(0.75f * -x);

    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public ImagePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public ImageFragment getItem(int position) {
            return ImageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return Data.URLS.length;
        }

    }

}
