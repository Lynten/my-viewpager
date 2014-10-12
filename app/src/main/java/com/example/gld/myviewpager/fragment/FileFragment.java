package com.example.gld.myviewpager.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gld.myviewpager.MyActivity;
import com.example.gld.myviewpager.R;
import com.example.gld.myviewpager.adapter.FileFragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class FileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Activity mActivity;

    private ViewPager mViewPager;
    private FileFragmentStatePagerAdapter mFileAdapter;

    public FileFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FileFragment newInstance(String param1, String param2) {
        FileFragment fragment = new FileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("LifeCycle onCreate");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new FragmentApp());
        fragments.add(new FragmentMedia());
        mFileAdapter = new FileFragmentStatePagerAdapter(((MyActivity) mActivity).getSupportFragmentManager
                (), fragments);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("LifeCycle onCreateView");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_file, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mViewPager.setAdapter(mFileAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        System.out.println("LifeCycle onDestroyView");
        super.onDestroyView();
        if (mViewPager != null) {
            mViewPager = null;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        System.out.println("LifeCycle onAttach");
        mActivity = activity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("LifeCycle onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("LifeCycle onDetach");
    }
}
