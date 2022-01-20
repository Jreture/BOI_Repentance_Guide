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

public class TransformationFragment extends Fragment {

    String[] name={"Guppy(구피)","Beelzebub(벨제부브)","Bob(밥)","Spun(약쟁이)","Yes Mother?(엄마)","Seraphim(세라핌)","Leviathan(레비아탄)","Fun Guy(버섯)","Oh Crap(똥)","Conjoined(샴쌍둥이)","Super Bum(슈퍼 거지)"};
    int [] image={R.drawable.transformation_guppy,R.drawable.transformation_beelzebub,R.drawable.transformation_bob,R.drawable.transformation_spun,R.drawable.transformation_yes_mother,R.drawable.transformation_seraphim,R.drawable.transformation_leviathan,R.drawable.transformation_fun_guy,R.drawable.transformation_oh_crap,R.drawable.transformation_conjoined,R.drawable.transformation_super_bum};
    static final Class<?>[] ACTIVITIES = {Transformation_Intent_Guppy.class,Transformation_Intent_Beelzebub.class,Transformation_Intent_Bob.class,Transformation_Intent_Spun.class,Transformation_Intent_Yes_Mother.class,Transformation_Intent_Seraphim.class,Transformation_Intent_Leviathan.class,Transformation_Intent_Fun_Guy.class,Transformation_Intent_Oh_Crap.class,Transformation_Intent_Conjoined.class,Transformation_Intent_Super_Bum.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_transformation, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_transformation);
        li.setAdapter(new TransformationFragment.TransformationAdapter(getActivity(),R.layout.listview_transformation,name));

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
    class TransformationAdapter extends ArrayAdapter {

        public TransformationAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_transformation, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_transformation);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_transformation);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}