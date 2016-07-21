package com.blacktobacco.paletaimatch;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.viewpagerindicator.CirclePageIndicator;

/**
 * A placeholder fragment containing a simple view.
 */
public class RulesActivityFragment extends Fragment {

    public RulesActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_rules, container, false);

        final RulesAdapter rulesAdapter = RulesAdapter.create(inflater);
        final ViewPager rulesView = (ViewPager) view.findViewById(R.id.rulesPager);
        rulesView.setAdapter(rulesAdapter);

        final CirclePageIndicator pageIndicator = (CirclePageIndicator) view.findViewById(R.id.pageIndicator);
        pageIndicator.setViewPager(rulesView);


        final View goLeft = view.findViewById(R.id.leftBtn);
        goLeft.setVisibility(View.INVISIBLE);
        final View gRight = view.findViewById(R.id.rightBtn);
        gRight.setVisibility(View.VISIBLE);

        final View actionLeft = view.findViewById(R.id.leftAction);
        final View actionRight = view.findViewById(R.id.rightAction);


        rulesView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                goLeft.setVisibility(View.VISIBLE);
                gRight.setVisibility(View.VISIBLE);

                if (position == 0) goLeft.setVisibility(View.INVISIBLE);
                if (position == rulesAdapter.getCount() - 1) gRight.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        actionLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rulesView.setCurrentItem(rulesView.getCurrentItem() - 1, true);
            }
        });

        actionRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rulesView.setCurrentItem(rulesView.getCurrentItem() + 1, true);
            }
        });

        return view;
    }


}
