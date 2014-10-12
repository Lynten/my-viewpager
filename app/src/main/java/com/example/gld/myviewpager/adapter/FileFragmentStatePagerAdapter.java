package com.example.gld.myviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by gld on 2014/10/12.
 */
public class FileFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;

    public FileFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public FileFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
