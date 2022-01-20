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

public class ItemFragment extends Fragment {

    String[] name={"The Sad Onion(눈물나는 양파)","The Inner Eye(내면의 눈)","Spoon Bender(초능력자)","Cricket's Head(크리켓의 머리)","My Reflection(거울상)","Number One(오줌싸개)","Blood of the Martyr(순교자의 피)","Brother Bobby(보비 형)","Skatole(스카톨)","Halo of Flies(파리 떼)","1UP!","Magic Mushroom(요술 버섯)"};
    int [] image={R.drawable.item_the_sad_onion,R.drawable.item_the_inner_eye,R.drawable.item_spoon_bender,R.drawable.item_crickets_head,R.drawable.item_my_reflection,R.drawable.item_number_one,R.drawable.item_blood_of_the_martyr,R.drawable.item_brother_bobby,R.drawable.item_skatole,R.drawable.item_halo_of_flies,R.drawable.item_1up,R.drawable.item_magic_mushroom};
    static final Class<?>[] ACTIVITIES = {Item_Intent_The_Sad_Onion.class,Item_Intent_The_Inner_Eye.class,Item_Intent_Spoon_Bender.class,Item_Intent_Crikets_Head.class,Item_Intent_My_Reflection.class,Item_Intent_Number_One.class,Item_Intent_Blood_of_the_Martyr.class,Item_Intent_Brother_Bobby.class,Item_Intent_Skatole.class,Item_Intent_Halo_of_Flies.class,Item_Intent_1UP.class,Item_Intent_Magic_Mushroom.class };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_item, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_item);
        li.setAdapter(new ItemFragment.ItemAdapter(getActivity(),R.layout.listview_item,name));

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
    class ItemAdapter extends ArrayAdapter {

        public ItemAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_item, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_item);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_item);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }
}
