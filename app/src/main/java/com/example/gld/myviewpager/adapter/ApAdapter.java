package com.example.gld.myviewpager.adapter;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gld.myviewpager.R;

import java.util.List;

/**
 * Created by gld on 2014/10/12.
 */
public class ApAdapter extends BaseAdapter {
    private static final int KEY_HOLDER = AppAdapter.class.hashCode();
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ScanResult> mScanResults;

    public ApAdapter(Context context, List<ScanResult> scanResults) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mScanResults = scanResults;
    }

    @Override
    public int getCount() {
        return mScanResults.size();
    }

    @Override
    public Object getItem(int position) {
        return mScanResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.ap_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvSsid = (TextView) convertView.findViewById(R.id.tvSsid);
            convertView.setTag(KEY_HOLDER);
        } else {
            viewHolder = (ViewHolder) convertView.getTag(KEY_HOLDER);
        }
        ScanResult scanResult = mScanResults.get(position);
        viewHolder.tvSsid.setText(scanResult.SSID);
        return convertView;
    }

    static class ViewHolder {
        TextView tvSsid;
    }
}
