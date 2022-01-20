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

public class RoomFragment extends Fragment {

    String[] name={"Boss Room(보스 방)","Treasure Room(보물 방)","Silver Treasure Room(은색 보물 방)","Red Treasure Room(빨간 보물 방)"," Planetarium(천체관)","Shop(상점)","Arcade(오락실)","Challenge Room(도전 방)","Boss Challenge Room(보스 도전 방)","Curse Room(저주 방)"};
    int [] image={R.drawable.room_bossroom,R.drawable.room_treasure_rooms,R.drawable.room_silver_treasure_room_opened,R.drawable.room_red_treasure_room,R.drawable.room_planetarium,R.drawable.room_shop,R.drawable.room_arcade,R.drawable.room_challenge_room,R.drawable.room_boss_challenge_room,R.drawable.room_curse_room};
    static final Class<?>[] ACTIVITIES = {Room_Intent_Bossroom.class,Room_Intent_Treasure_Room.class,Room_Intent_Silver_Treasure_Room.class,Room_Intent_Red_Treasure_Room.class,Room_Intent_Planetarium.class,Room_Intent_Shop.class,Room_Intent_Arcade.class,Room_Intent_Challenge_Room.class,Room_Intent_Boss_Challenge_Room.class,Room_Intent_Curse_Room.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_room, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_room);
        li.setAdapter(new RoomFragment.RoomAdapter(getActivity(),R.layout.listview_room,name));

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
    class RoomAdapter extends ArrayAdapter {

        public RoomAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_room, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_room);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_room);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}
