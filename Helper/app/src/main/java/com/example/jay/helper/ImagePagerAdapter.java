package com.example.jay.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by jay on 29/01/2016.
 */
public class ImagePagerAdapter extends FragmentStatePagerAdapter {

    private final int mSize;
    Context ctx;

    public ImagePagerAdapter(FragmentManager fm, int size, Context ctx) {
        super(fm);
        mSize = size;
        this.ctx = ctx;
    }

    @Override
    public Fragment getItem(int position) {
        //Toast.makeText(ctx, "Current Item : " + ImageDetailActivity.viewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();

        //int current_item = ImageDetailActivity.viewPager.getCurrentItem();


//        if(current_item < 1){
//            ImageDetailActivity.rb1.setChecked(true);
//        }
//        if(current_item > 4){
//            ImageDetailActivity.rb6.setChecked(true);
//        }
//
//        switch (current_item){
//            case 0: ImageDetailActivity.rb1.setChecked(true);
//                break;
//            case 1: ImageDetailActivity.rb2.setChecked(true);
//                break;
//            case 2: ImageDetailActivity.rb3.setChecked(true);
//                break;
//            case 3: ImageDetailActivity.rb4.setChecked(true);
//                break;
//            case 4: ImageDetailActivity.rb5.setChecked(true);
//                break;
//            case 5: ImageDetailActivity.rb6.setChecked(true);
//                break;
//            default: ImageDetailActivity.rb1.setChecked(true);
//                break;
//        }

        return ImageDetailFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mSize;
    }
}
