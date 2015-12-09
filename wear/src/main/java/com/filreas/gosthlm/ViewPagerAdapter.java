package com.filreas.gosthlm;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] stationName;

    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] stationName) {
        this.context = context;
        this.stationName = stationName;
    }

    @Override
    public int getCount() {
        return stationName.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // Declare Variables
        TextView txtrank;

        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        // Locate the TextViews in viewpager_item.xml
        txtrank = (TextView) itemView.findViewById(R.id.fromText);

        // Capture position and set to the TextViews
        txtrank.setText(stationName[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}