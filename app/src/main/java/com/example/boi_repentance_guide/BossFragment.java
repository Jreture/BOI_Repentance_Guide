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


public class BossFragment extends Fragment {

    String[] name={"The Fallen(타락한 자)","Headless Horseman(머리 없는 기마병)","Monstro(몬스트로)","The Duke of Flies(파리 공작)","Gemini(쌍둥이)","Steven(스티븐)","Larry Jr(래리 주니어)","Widow(과부)","Pin(핀)","Blighted Ovum(계류유산)","Dingle(딩글)","Gurglings(거글링)","The Haunt(유령)","Rag Man(넝마주이)","Dangle(댕글)","Turdlings(응가링)","Little Horn(작은 뿔)","Baby Plum (아기 플럼)","Famine(기근)"};
    int [] image={R.drawable.boss_the_fallen,R.drawable.boss_headless_horseman,R.drawable.boss_monstro,R.drawable.boss_the_duke_of_flies,R.drawable.boss_gemini,R.drawable.boss_steven,R.drawable.boss_larry_jr,R.drawable.boss_widow,R.drawable.boss_pin,R.drawable.boss_blighted_ovum,R.drawable.boss_dingle,R.drawable.boss_gurglings,R.drawable.boss_the_haunt,R.drawable.boss_rag_man,R.drawable.boss_dangle,R.drawable.boss_turdlings,R.drawable.boss_little_horn,R.drawable.boss_baby_plum,R.drawable.boss_famine};
    static final Class<?>[] ACTIVITIES = {Boss_Intent_the_fallen.class,Boss_Intent_headless_horseman.class,Boss_Intent_monstro.class,Boss_Intent_the_duke_of_flies.class,Boss_Intent_gemini.class,Boss_Intent_steven.class,Boss_Intent_larry_jr.class,Boss_Intent_widow.class,Boss_Intent_pin.class,Boss_Intent_blighted_ovum.class,Boss_Intent_dingle.class,Boss_Intent_gurglings.class,Boss_Intent_the_haunt.class,Boss_Intent_rag_man.class,Boss_Intent_dangle.class,Boss_Intent_turdlings.class,Boss_Intent_little_horn.class,Boss_Intent_baby_plum.class,Boss_Intent_famine.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_boss, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_boss);
        li.setAdapter(new BossAdapter(getActivity(),R.layout.listview_boss,name));

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
    class BossAdapter extends ArrayAdapter {

        public BossAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_boss, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_boss);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_boss);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }
}
