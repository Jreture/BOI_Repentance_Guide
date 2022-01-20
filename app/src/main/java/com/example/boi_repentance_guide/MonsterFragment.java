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

public class MonsterFragment extends Fragment {

    String[] name={"Fly(파리)","Attack Fly(전투형 파리)","Moter(모터 파리)","Pooter(푸터)","Boom Fly(봄파리)","Red Boom Fly(레드 봄 파리)","Sucker(따라오는 파리)","Boil(붉은 거미집)","Mulligan(멀리건)","Mulligoon(멀리군)","Hive(하이브)","Hopper(호퍼)","Flaming Hopper(불타는 호퍼)","Leaper(곡예사)","Pacer(페이서)"};
    int [] image={R.drawable.monster_fly,R.drawable.monster_attack_fly,R.drawable.monster_moter,R.drawable.monster_pooter,R.drawable.monster_boom_fly,R.drawable.monster_red_boom_fly,R.drawable.monster_sucker,R.drawable.monster_boil,R.drawable.monster_mulligan,R.drawable.monster_mulligoon,R.drawable.monster_hive,R.drawable.monster_hopper,R.drawable.monster_flaming_hopper,R.drawable.monster_leaper,R.drawable.monster_pacer};
    static final Class<?>[] ACTIVITIES = {Monster_Intent_Fly.class,Monster_Intent_Attack_Fly.class,Monster_Intent_Moter.class,Monster_Intent_Pooter.class,Monster_Intent_Boom_Fly.class,Monster_Intent_Red_Boom_Fly.class,Monster_Intent_Sucker.class,Monster_Intent_Boil.class,Monster_Intent_Mulligan.class,Monster_Intent_Mulligoon.class,Monster_Intent_Hive.class,Monster_Intent_Hopper.class,Monster_Intent_Flaming_Hopper.class,Monster_Intent_Leaper.class,Monster_Intent_Pacer.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_monster, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_monster);
        li.setAdapter(new MonsterFragment.MonsterAdapter(getActivity(),R.layout.listview_monster,name));

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
    class MonsterAdapter extends ArrayAdapter {

        public MonsterAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_monster, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_monster);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_monster);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}
