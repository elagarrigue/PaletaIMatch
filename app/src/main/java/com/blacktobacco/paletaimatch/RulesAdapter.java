package com.blacktobacco.paletaimatch;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Emmanuel on 8/8/2015.
 */
public final class RulesAdapter extends PagerAdapter {
        private final LayoutInflater inflater;
        private final int[] rulesIds = {
                R.drawable.faltas_01,
                R.drawable.faltas_02,
                R.drawable.faltas_03,
                R.drawable.faltas_04,
                R.drawable.faltas_05,
                R.drawable.faltas_06,
                R.drawable.faltas_07,
                R.drawable.faltas_08,
                R.drawable.faltas_09,
                R.drawable.faltas_10,
                R.drawable.faltas_11,
                R.drawable.faltas_12,
                R.drawable.faltas_13,
        };

        private RulesAdapter(@NonNull LayoutInflater inflater) {
            this.inflater = inflater;
        }

        @NonNull
        public static RulesAdapter create(@NonNull LayoutInflater inflater) {
            return new RulesAdapter(inflater);
        }

        @Override
        public int getCount() {
            return rulesIds.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = inflater.inflate(R.layout.rule_layout, container, false);

            ImageView rule = (ImageView)v.findViewById(R.id.imageV);
            rule.setImageResource(rulesIds[position]);

            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }




}