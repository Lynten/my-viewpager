package com.example.gld.myviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gld.myviewpager.R;

/**
 * Created by gld on 2014/10/12.
 */
public class FragmentMedia extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        System.out.println("LifeCycle FragmentMedia onCreateView");
        View view = inflater.inflate(R.layout.fragment_media, null);
        return view;
    }

    @Override
    public void onDestroyView() {
        System.out.println("LifeCycle FragmentMedia onDestroyView");
        super.onDestroyView();
    }
}
