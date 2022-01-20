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

public class ChapterFragment extends Fragment {

    String[] name={"Basement","Cellar","Burning Basement","Downpour","Dross","Caves","Catacombs","Flooded Caves","Mines","Ashpit","Depths","Necropolis","Dank Depths","Mausoleum","Gehenna"};
    int [] image={R.drawable.chapter_basement,R.drawable.chapter_celler,R.drawable.chapter_burning_basement,R.drawable.chapter_downpour,R.drawable.chapter_dross,R.drawable.chapter_caves,R.drawable.chapter_catacombs,R.drawable.chapter_flooded_caves,R.drawable.chapter_mines,R.drawable.chapter_ashpit,R.drawable.chapter_depths,R.drawable.chapter_necropolis,R.drawable.chapter_dank_depths,R.drawable.chapter_mausoleum,R.drawable.chapter_gehenna};
    static final Class<?>[] ACTIVITIES = {Chapter_Intent_Basement.class,Chapter_Intent_Celler.class,Chapter_Intent_Burning_Basement.class,Chapter_Intent_Downpour.class,Chapter_Intent_Dross.class,Chapter_Intent_Caves.class,Chapter_Intent_Catacombs.class,Chapter_Intent_Flooded_Caves.class,Chapter_Intent_Mines.class,Chapter_Intent_ashpit.class,Chapter_Intent_Depths.class,Chapter_Intent_Necropolis.class,Chapter_Intent_Dank_Depths.class,Chapter_Intent_Mausoleum.class,Chapter_Intent_Gehenna.class };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chapter, container, false);

        ListView li=(ListView)v.findViewById(R.id.listView_chapter);
        li.setAdapter(new ChapterFragment.ChapterAdapter(getActivity(),R.layout.listview_chapter,name));

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
    class ChapterAdapter extends ArrayAdapter {

        public ChapterAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_chapter, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_chapter);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_chapter);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}