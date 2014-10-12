package com.example.gld.myviewpager.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gld.myviewpager.R;

import java.util.List;

/**
 * Created by gld on 2014/10/12.
 */
public class AppAdapter extends BaseAdapter {

    private static final int KEY_HOLDER = AppAdapter.class.hashCode();
    private Context mContext;
    private LayoutInflater mInflater;
    private List<PackageInfo> mPackageInfos;

    public AppAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mPackageInfos = context.getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
        for (int i = 0; i < mPackageInfos.size(); i++) {
            if ((mPackageInfos.get(i).applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0) {
                mPackageInfos.remove(i);
            }
        }
    }

    @Override
    public int getCount() {
        return mPackageInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mPackageInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.app_item, null);
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(KEY_HOLDER, viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(KEY_HOLDER);
        }

        PackageInfo packageInfo = mPackageInfos.get(position);
        viewHolder.ivIcon.setImageDrawable(packageInfo.applicationInfo.loadIcon(mContext.getPackageManager()));
        viewHolder.tvName.setText(packageInfo.applicationInfo.loadLabel(mContext.getPackageManager()));


        return convertView;
    }

    static class ViewHolder {
        ImageView ivIcon;
        TextView tvName;
    }
}
