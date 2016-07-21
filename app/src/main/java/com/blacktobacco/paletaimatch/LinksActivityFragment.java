package com.blacktobacco.paletaimatch;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class LinksActivityFragment extends Fragment {

    public LinksActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_links, container, false);

        View fbView = v.findViewById(R.id.fbImg);
        View youtubeView = v.findViewById(R.id.youtubeImg);
        View btView = v.findViewById(R.id.btImg);

        fbView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.facebook.com/MatchDeImprovisacionBahia?fref=ts");
            }
        });

        youtubeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.youtube.com/channel/UCfz0x5lmXfzGtUs-AuUrhWQ");
            }
        });

        btView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("http://www.black-tobacco.com");
            }
        });

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Archer-Medium-Pro.otf");

        TextView textFB = (TextView)v.findViewById(R.id.fbTxt);
        TextView textYT = (TextView)v.findViewById(R.id.youtubeTxt);
        TextView textBT = (TextView)v.findViewById(R.id.btTxt);

        textFB.setTypeface(tf);
        textFB.setTextColor(getResources().getColor(R.color.link_text));
        textYT.setTypeface(tf);
        textYT.setTextColor(getResources().getColor(R.color.link_text));
        textBT.setTypeface(tf);
        textBT.setTextColor(getResources().getColor(R.color.link_text));

        return v;
    }

    private void openLink(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
