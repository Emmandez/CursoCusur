package com.example.emmanuel.aplicacion.activities.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.emmanuel.aplicacion.R;

/**
 * Created by Emmanuel on 03/02/2016.
 */
public class ThreadFragment extends Fragment {

    public static ThreadFragment newInstance(){
        ThreadFragment threadFragment = new ThreadFragment();
        return threadFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.thread_fragment_layout, container, false);
        return view;
    }
}
