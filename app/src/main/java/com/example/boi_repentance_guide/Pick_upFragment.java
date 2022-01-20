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

public class Pick_upFragment extends Fragment {

    String[] name={"Penny(동전)","Double Penny(1+1 동전)","Nickel(백동화)","Dime(10센트 은화)","Lucky Penny(행운의 동전)","Sticky Nickel(움직이지 않는 백동화)","Golden Penny(황금 동전)","Bomb(폭탄)","Double Bomb(1+1 폭탄)","Golden Bomb(황금 폭탄)","Troll Bomb(트롤 폭탄)","Golden Troll Bomb(황금 트롤 폭탄)","Mega Troll Bomb(메가 트롤 폭탄)","Giga Bomb(기가 폭탄)","Throwable Bomb(투척용 폭탄)"};
    int [] image={R.drawable.pick_up_penny,R.drawable.pick_up_double_penny,R.drawable.pick_up_nickel,R.drawable.pick_up_dime,R.drawable.pick_up_lucky_penny,R.drawable.pick_up_sticky_nickel,R.drawable.pick_up_golden_penny,R.drawable.pick_up_bomb,R.drawable.pick_up_double_bomb,R.drawable.pick_up_golden_bomb,R.drawable.pick_up_troll_bomb,R.drawable.pick_up_golden_troll_bomb,R.drawable.pick_up_mega_troll_bomb,R.drawable.pick_up_giga_bomb,R.drawable.pick_up_throwable_bomb};
    static final Class<?>[] ACTIVITIES = {Pick_Up_Intent_Penny.class,Pick_Up_Intent_Double_Penny.class,Pick_Up_Intent_Nickel.class,Pick_Up_Intent_Dime.class,Pick_Up_Intent_Lucky_Penny.class,Pick_Up_Intent_Sticky_Nickel.class,Pick_Up_Intent_Golden_Penny.class,Pick_Up_Intent_Bomb.class,Pick_Up_Intent_Double_Bomb.class,Pick_Up_Intent_Golden_Bomb.class,Pick_Up_Intent_Troll_Bomb.class,Pick_Up_Intent_Golden_Troll_Bomb.class,Pick_Up_Intent_Mega_Troll_Bomb.class,Pick_Up_Intent_Giga_Bomb.class,Pick_Up_Intent_Throwable_Bomb.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pick_up, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_pick_up);
        li.setAdapter(new Pick_upFragment.Pick_upAdapter(getActivity(),R.layout.listview_pick_up,name));

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
    class Pick_upAdapter extends ArrayAdapter {

        public Pick_upAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_pick_up, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_pick_up);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_pick_up);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}