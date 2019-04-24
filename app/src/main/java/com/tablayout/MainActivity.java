package com.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] channels = new String[]{"GINGERBREAD", "HONEYCOMB", "ICE_CREAM_SANDWICH", "JELLY_BEAN", "KITKAT", "LOLLIPOP", "M", "NOUGAT"};


    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return channels.length;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                final TextView textView = new TextView(container.getContext());
                textView.setText(channels[position]);
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(24);
                container.addView(textView);
                return textView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return channels[position];
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }
        });

//        tabLayout.setOnCreateTabCustomViewListener(new TabLayout.OnCreateTabCustomViewListener() {
//            @Override
//            public View OnCreateTabView(TabLayout.TabView view, int position) {
//                View view1 = LayoutInflater.from(view.getContext()).inflate(R.layout.tab_item_icon_layout, view, false);
//                TextView textView = view1.findViewById(R.id.tab_txt);
//                textView.setText(channels[position]);
//                textView.setTextColor(Color.BLACK);
//                ImageView imageView = view1.findViewById(R.id.tab_icon);
//                if (position % 4 == 0)
//                    imageView.setVisibility(View.VISIBLE);
//                imageView.setImageResource(R.mipmap.ic_tab_selected);
//
//                return view1;
//            }
//        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                TextView textView = tab.view.findViewById(R.id.tab_txt);
//                textView.setText(channels[tab.getPosition()]);
//                textView.setTextColor(Color.WHITE);
//                ImageView imageView = tab.view.findViewById(R.id.tab_icon);
//                imageView.setImageResource(R.mipmap.ic_tab_selected);
                tab.setIcon(R.mipmap.ic_tab_selected);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                TextView textView = tab.view.findViewById(R.id.tab_txt);
//                textView.setText(channels[tab.getPosition()]);
//                textView.setTextColor(Color.BLACK);
//                ImageView imageView = tab.view.findViewById(R.id.tab_icon);
//                imageView.setImageResource(R.mipmap.ic_tab_unselected);
                tab.setIcon(R.mipmap.ic_tab_unselected);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        RoundShadowIndicator roundIndicator = new RoundShadowIndicator();
        roundIndicator.setRoundRadius(200);
        roundIndicator.setUseGradient(true);
        roundIndicator.setUseShadow(true);

//        tabLayout.setSelectedTabIndicator(roundIndicator);

        tabLayout.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        tabLayout.setTabTextColors(Color.BLACK,Color.WHITE);
        tabLayout.setupWithViewPager(viewPager);

    }
}
