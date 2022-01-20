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

public class TrinketFragment extends Fragment {

    String[] name={"Swallowed Penny(삼킨 동전)","Petrified Poop(굳은 똥)","AAA Battery(AAA 건전지)","Broken Remote(고장난 리모컨)","Purple Heart(퍼플 하트 훈장)","Broken Magnet(깨진 자석)","Rosary Bead(묵주 구슬)","Cartridge(카트리지)","Pulse Worm(파동 벌레)","Wiggle Worm(씰룩 벌레)"};
    int [] image={R.drawable.trinket_swallowed_penny,R.drawable.trinket_petrified_poop,R.drawable.trinket_aaa_battery,R.drawable.trinket_broken_remote,R.drawable.trinket_purple_heart,R.drawable.trinket_broken_magnet,R.drawable.trinket_rosary_bead,R.drawable.trinket_cartridge,R.drawable.trinket_pulse_worm,R.drawable.trinket_wiggle_worm};
    static final Class<?>[] ACTIVITIES = {Trinket_Intent_Swallowed_Penny.class,Trinket_Intent_Petrified_Poop.class,Trinket_Intent_AAA_Battery.class,Trinket_Intent_Broken_Remote.class,Trinket_Intent_Purple_Heart.class,Trinket_Intent_Broken_Magnet.class,Trinket_Intent_Rosary_Bead.class,Trinket_Intent_Cartridge.class,Trinket_Intent_Pulse_Worm.class,Trinket_Intent_Wiggle_Worm.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_trinket, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_trinket);
        li.setAdapter(new TrinketFragment.TrinketAdapter(getActivity(),R.layout.listview_trinket,name));

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
    class TrinketAdapter extends ArrayAdapter {

        public TrinketAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_trinket, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_trinket);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_trinket);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}
