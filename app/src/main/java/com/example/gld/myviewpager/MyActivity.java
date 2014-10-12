package com.example.gld.myviewpager;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.example.gld.myviewpager.fragment.SearchFragment;


public class MyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        getSupportFragmentManager().beginTransaction().add(R.id.container, SearchFragment.newInstance("arg", "arg")).commitAllowingStateLoss();

    }
}
