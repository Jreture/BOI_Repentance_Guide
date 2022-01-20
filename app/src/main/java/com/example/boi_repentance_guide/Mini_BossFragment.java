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

public class Mini_BossFragment extends Fragment {

    String[] name={"Envy(시기)","Super Envy(강력한 시기)","Gluttony(식탐)","Super Gluttony(강력한 식탐)","Greed(탐욕)","Super Greed(강력한 탐욕)","Lust(색욕)","Super Lust(강력한 색욕)","Sloth(나태)","Super Sloth(강력한 나태)","Wrath(분노)","Super Wrath(강력한 분노)","Pride(교만)","Super Pride(강력한 교만)","Ultra Pride(극심한 교만)"};
    int [] image={R.drawable.mini_boss_envy,R.drawable.mini_boss_super_envy,R.drawable.mini_boss_gluttony,R.drawable.mini_boss_super_gluttony,R.drawable.mini_boss_greed,R.drawable.mini_boss_super_greed,R.drawable.mini_boss_lust,R.drawable.mini_boss_super_lust,R.drawable.mini_boss_sloth,R.drawable.mini_boss_super_sloth,R.drawable.mini_boss_wrath,R.drawable.mini_boss_super_wrath,R.drawable.mini_boss_pride,R.drawable.mini_boss_super_pride,R.drawable.mini_boss_ultra_pride};
    static final Class<?>[] ACTIVITIES = {Mini_Boss_Intent_Envy.class,Mini_Boss_Intent_Super_Envy.class,Mini_Boss_Intent_Gluttony.class,Mini_Boss_Intent_Super_Gluttony.class,Mini_Boss_Intent_Greed.class,Mini_Boss_Intent_Super_Greed.class,Mini_Boss_Intent_Lust.class,Mini_Boss_Intent_Super_Lust.class,Mini_Boss_Intent_Sloth.class,Mini_Boss_Intent_Super_Sloth.class,Mini_Boss_Intent_Wrath.class,Mini_Boss_Intent_Super_Wrath.class,Mini_Boss_Intent_Pride.class,Mini_Boss_Intent_Super_Pride.class,Mini_Boss_Intent_Ultra_Pride.class };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_mini_boss, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_mini_boss);
        li.setAdapter(new Mini_BossFragment.Mini_BossAdapter(getActivity(),R.layout.listview_mini_boss,name));

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
    class Mini_BossAdapter extends ArrayAdapter {

        public Mini_BossAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_mini_boss, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_mini_boss);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_mini_boss);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}