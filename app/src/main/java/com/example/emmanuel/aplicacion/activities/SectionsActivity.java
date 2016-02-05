package com.example.emmanuel.aplicacion.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.emmanuel.aplicacion.R;
import com.example.emmanuel.aplicacion.activities.adapters.ViewPagerAdapter;
import com.example.emmanuel.aplicacion.activities.utils.SlidingTabLayout;


public class SectionsActivity extends AppCompatActivity {

    private ViewPagerAdapter adapter;
    private ViewPager pager;
    private SlidingTabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sections);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        tabs=(SlidingTabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.Pager);
        pager.setAdapter(adapter);
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.custom);
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });
    }

}
