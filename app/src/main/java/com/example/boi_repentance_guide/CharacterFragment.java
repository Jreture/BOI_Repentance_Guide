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

public class CharacterFragment extends Fragment {

    String[] name={"ISAAC(아이작)","MAGDALENE(막달레나)","CAIN(카인)","JUDAS(유다)","BLACK JUDAS(검은 유다)","???","EVE(이브)","SAMSON(삼손)","AZAZEL(아자젤)","LAZARUS(나사로)","REVIVED LAZARUS(부활 나사로)","EDEN(에덴)","THE LOST(더 로스트)","LILITH(릴리스)","KEEPER(키퍼)","APOLLYON(아폴리온)","THE FORGOTTEN(더 포가튼)","THE SOUL(더 소울)","BETHANY(베다니)","JACOB(야곱)","ESAU(에사우)"};
    int [] image={R.drawable.character_isaac,R.drawable.character_magdalene,R.drawable.character_cain,R.drawable.character_judas,R.drawable.character_black_judas,R.drawable.character_mongmongi,R.drawable.character_eve,R.drawable.character_samson,R.drawable.character_azazel,R.drawable.character_lazarus,R.drawable.character_revived_razarus,R.drawable.character_eden,R.drawable.character_the_lost,R.drawable.character_lilith,R.drawable.character_keeper,R.drawable.character_apollyon,R.drawable.character_the_forgatten,R.drawable.character_the_soul,R.drawable.character_bethany,R.drawable.character_jacob,R.drawable.character_esau};
    static final Class<?>[] ACTIVITIES = {Character_Intent_isaac.class,Character_Intent_magdalene.class,Character_Intent_cain.class,Character_Intent_judas.class,Character_Intent_black_judas.class,Character_Intent_threequestion.class,Character_Intent_eve.class,Character_Intent_samson.class,Character_Intent_azazel.class,Character_Intent_lazarus.class,Character_Intent_revived_razarus.class,Character_Intent_eden.class,Character_Intent_the_lost.class,Character_Intent_lilith.class,Character_Intent_keeper.class,Character_Intent_apollyon.class,Character_Intent_the_forgatten.class,Character_Intent_the_soul.class,Character_Intent_bethany.class,Character_Intent_jacob.class,Character_Intent_esau.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_character, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_character);
        li.setAdapter(new CharacterFragment.CharacterAdapter(getActivity(),R.layout.listview_character,name));

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
    class CharacterAdapter extends ArrayAdapter {

        public CharacterAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_character, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_character);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_character);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }
}