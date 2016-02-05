package com.example.emmanuel.aplicacion.activities.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.emmanuel.aplicacion.activities.fragments.CameraFragment;
import com.example.emmanuel.aplicacion.activities.fragments.ThreadFragment;

/**
 * Created by Emmanuel on 03/02/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private CharSequence mTiles[] = {"Camara", "hilos"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return CameraFragment.newInstance();
        }
        if (position==1){
            return ThreadFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTiles[position];
    }
}
