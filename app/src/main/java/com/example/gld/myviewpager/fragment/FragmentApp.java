package com.example.gld.myviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.gld.myviewpager.R;
import com.example.gld.myviewpager.adapter.AppAdapter;

/**
 * Created by gld on 2014/10/12.
 */
public class FragmentApp extends Fragment {
    private ListView mLvApps;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        System.out.println("LifeCycle FragmentApp onCreateView");
        View view = inflater.inflate(R.layout.fragment_app, null);
        mLvApps = (ListView) view.findViewById(R.id.listView);
        mLvApps.setAdapter(new AppAdapter(getActivity()));
        return view;

    }

    @Override
    public void onDestroyView() {
        System.out.println("LifeCycle FragmentApp onDestroyView");
        super.onDestroyView();
    }
}
