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

public class Card_Rune_PillsFragment extends Fragment {

    String[] name={"0 - The Fool(바보)","I - The Magician(마술사)","II - The High Priestess(여교황)","III - The Empress(여제)","IV - The Emperor(황제)","V - The Hierophant(교황)","VI - The Lovers(연인)","VII - The Chariot(전차)","VIII - Justice(정의)","IX - The Hermit(은둔자)","X - Wheel of Fortune(운명의 수레바퀴)","XI - Strength(힘)","XII - The Hanged Man(매달린 남자)","XIII - Death(죽음)","XIV - Temperance(절제)","XV - The Devil(악마)","XVI - The Tower(탑)","XVII - The Stars(별)","XVIII - The Moon(달)","XIX - The Sun(태양)","XX - Judgement(심판)","XXI - The World(세계)"};
    int [] image={R.drawable.card_the_fool,R.drawable.card_the_magicion,R.drawable.card_the_high_priestess,R.drawable.card_the_empress,R.drawable.card_the_emperor,R.drawable.card_the_hierophant,R.drawable.card_the_lovers,R.drawable.card_the_chariot,R.drawable.card_justice,R.drawable.card_the_hermit,R.drawable.card_wheel_of_fortune,R.drawable.card_strength,R.drawable.card_the_hanged_man,R.drawable.card_death,R.drawable.card_temperance,R.drawable.card_the_devil,R.drawable.card_the_tower,R.drawable.card_the_stars,R.drawable.card_the_moon,R.drawable.card_the_sun,R.drawable.card_judgement,R.drawable.card_the_world};
    static final Class<?>[] ACTIVITIES = { Card_Rune_PillsIntent_The_Fool.class,Card_Rune_PillsIntent_The_Magician.class,Card_Rune_PillsIntent_The_High_Priestess.class,Card_Rune_PillsIntent_The_Empress.class,Card_Rune_PillsIntent_The_Emperor.class,Card_Rune_PillsIntent_The_Hierophant.class,Card_Rune_PillsIntent_The_Lovers.class,Card_Rune_PillsIntent_The_Chariot.class,Card_Rune_PillsIntent_Justice.class,Card_Rune_PillsIntent_The_Hermit.class,Card_Rune_PillsIntent_Wheel_of_Fortune.class,Card_Rune_PillsIntent_Strength.class,Card_Rune_PillsIntent_The_Hanged_Man.class,Card_Rune_PillsIntent_The_Death.class,Card_Rune_PillsIntent_The_Temperance.class,Card_Rune_PillsIntent_The_Devil.class,Card_Rune_PillsIntent_The_Tower.class,Card_Rune_PillsIntent_The_Stars.class,Card_Rune_PillsIntent_The_Moon.class,Card_Rune_PillsIntent_The_Sun.class,Card_Rune_PillsIntent_Judgement.class,Card_Rune_PillsIntent_The_World.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_card_rune_pills, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_card_view_pills);
        li.setAdapter(new Card_Rune_PillsAdapter(getActivity(),R.layout.listview_card_run_pills,name));

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
    class Card_Rune_PillsAdapter extends ArrayAdapter {

        public Card_Rune_PillsAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_card_run_pills, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_card_run_pill);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_card_run_pills);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }
}
