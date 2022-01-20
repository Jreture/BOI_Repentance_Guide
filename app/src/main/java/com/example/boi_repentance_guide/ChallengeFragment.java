package com.example.boi_repentance_guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChallengeFragment extends Fragment {

    String[] name={"Pitch Black(칠흑)","High Brow(먹물)","Head Trauma(뇌진탕)","Darkness Falls(암흑이 내리면)","The Tank(탱크)","Solar System(태양계)","Suicide King(자살 왕)","Cat Got Your Tongue(고양이에게 잘린 혀)","Demo Man(폭탄마)","Cursed!(저주!)","Glass Cannon(유리 대포)","When Life Gives You Lemons(인생이 네게 엿을 먹이면)","Beans!(콩이다!)","It's in the Cards(다 카드에 써져 있어)","Slow Roll(굼벵이)","Computer Savvy(컴잘알)","Waka Waka(뻐끔 뻐끔)","The Host(숙주)","The Family Man(가족적인 남자)","Purist(순수주의자)"};
    int [] image={R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,R.drawable.menu_challenges,};
    static final Class<?>[] ACTIVITIES = {Challenge_Intent_pitch_black.class,Challenge_Intent_high_brow.class,Challenge_Intent_head_trauma.class,Challenge_Intent_darkness_falls.class,Challenge_Intent_the_tank.class,Challenge_Intent_solar_system.class,Challenge_Intent_suicide_king.class,Challenge_Intent_cat_got_out_tongue.class,Challenge_Intent_demo_man.class,Challenge_Intent_cursed.class,Challenge_Intent_glass_cannon.class,Challenge_Intent_when_life_gives_you_lemons.class,Challenge_Intent_beans.class,Challenge_Intent_it_is_in_the_cards.class,Challenge_Intent_slow_roll.class,Challenge_Intent_computer_savvy.class,Challenge_Intent_waka_waka.class,Challenge_Intent_the_host.class,Challenge_Intent_the_family_man.class,Challenge_Intent_purist.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_challenge, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_challenge);
        li.setAdapter(new ChallengeFragment.ChallengeAdapter(getActivity(),R.layout.listview_challenge,name));

        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                Intent intent = new Intent(getActivity(),ACTIVITIES[position]);
                startActivity(intent);
            }

        });
        return v;
    }
    class ChallengeAdapter extends ArrayAdapter {

        public ChallengeAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_challenge, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_challenge);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_challenge);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}