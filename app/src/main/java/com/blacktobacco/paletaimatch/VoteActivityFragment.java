package com.blacktobacco.paletaimatch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class VoteActivityFragment extends Fragment {

    public static final int ORANGE = R.color.orange_team;
    public static final int GREEN = R.color.green_team;

    private View colorV;
    private View muteV;
    private  AudioManager mAudioManager;

    public VoteActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_vote, container, false);

        mAudioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);

        View voteOrange = v.findViewById(R.id.orange_vote);
        View voteGreen = v.findViewById(R.id.green_vote);
        View viewRules = v.findViewById(R.id.view_rules);
        View viewLinks = v.findViewById(R.id.view_links);
        muteV = v.findViewById(R.id.view_mute);

        colorV = v.findViewById(R.id.color_layout);

        voteOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote(ORANGE);
            }
        });

        voteGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote(GREEN);
            }
        });

        colorV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //colorV.setVisibility(View.GONE);
            }
        });

        viewRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vote = new Intent(getActivity(),RulesActivity.class);
                startActivity(vote);
            }
        });

        viewLinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent links = new Intent(getActivity(),LinksActivity.class);
                startActivity(links);
            }
        });

        BroadcastReceiver receiver=new BroadcastReceiver(){
            @Override
            public void onReceive(Context context, Intent intent) {
                checkAudio();
            }
        };
        IntentFilter filter=new IntentFilter(
                AudioManager.RINGER_MODE_CHANGED_ACTION);
       getActivity().registerReceiver(receiver, filter);


        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        checkAudio();
    }

    private void checkAudio() {
        AudioManager audio = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        switch( audio.getRingerMode() ){
            case AudioManager.RINGER_MODE_SILENT:
                muteV.setVisibility(View.INVISIBLE);
                break;
            default:
                muteV.setVisibility(View.VISIBLE);
                break;

        }
    }

    private void vote(int teamColor){

        colorV.setVisibility(View.VISIBLE);
        colorV.setBackgroundResource(teamColor);
    }


    public boolean backPressed() {

        if (colorV.getVisibility() == View.VISIBLE){
            colorV.setVisibility(View.GONE);
            return true;
        }else{
            return false;
        }

    }
}
