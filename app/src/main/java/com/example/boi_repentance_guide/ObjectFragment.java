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

public class ObjectFragment extends Fragment {

    String[] name={"Beggar(일반 거지)","Devil Beggar(악마 거지)","Key Master(열쇠 거지)","Bomb Beggar(폭탄 거지)","Battery Beggar(전지 거지)","Rotten Beggar(썩은 거지)","Shell Game(야바위꾼 거지)","Hell Game(악마 야바위꾼)","Slot Machine(슬롯머신)","Fortune Telling Machine(점술기계)","Blood Donation Machine(헌혈기계)","Restock Machine(리스톡기계)","Mom's Dressing Table(엄마의 화장대)","Crane Game(크레인 게임)","Confessional(고해실)","Donation Machine(기부 머신)","Greed Donation Machine(그리드 기부 머신)"};
    int [] image={R.drawable.object_beggar,R.drawable.object_devil_beggar,R.drawable.object_key_master,R.drawable.object_bomb_bum,R.drawable.object_battery_bum,R.drawable.object_rotten_beggar,R.drawable.object_shell_game,R.drawable.object_hell_game,R.drawable.object_slot_machine,R.drawable.object_fortune_telling_machine,R.drawable.object_blood_donation_machine,R.drawable.object_shop_restock_machine,R.drawable.object_moms_dressing_table,R.drawable.object_crane_game,R.drawable.object_confessional,R.drawable.object_donation_machine,R.drawable.object_greed_donation_machine};
    static final Class<?>[] ACTIVITIES = {Object_Intent_Beggar.class,Object_Intent_Devil_Beggar.class,Object_Intent_Key_Master.class,Object_Intent_Bomb_Bum.class,Object_Intent_Battery_Bum.class,Object_Intent_Rotten_Beggar.class,Object_Intent_Shell_Game.class,Object_Intent_Hell_Game.class,Object_Intent_Slot_Machine.class,Object_Intent_Fortune_Telling_Machine.class,Object_Intent_Blood_Donation_Machine.class,Object_Intent_Restock_Machine.class,Object_Intent_Moms_Dressing_Table.class,Object_Intent_Crane_Game.class,Object_Intent_Confessional.class,Object_Intent_Donation_Machine.class,Object_Intent_Greed_Donation_Machine.class};
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 프래그먼트의 레이아웃을 확장
        //레이아웃에 리스트뷰를 포함
        View v = inflater.inflate(R.layout.fragment_object, container, false);
        //리스트뷰 목록 초기화
        ListView li=(ListView)v.findViewById(R.id.listView_object);
        //리스트뷰에 adapter연결
        li.setAdapter(new ObjectFragment.ObjectAdapter(getActivity(),R.layout.listview_object,name));

        //리스트 뷰의 아이템을 클릭하면 설명 화면으로 넘어가게 만듬
        //parent : 클릭이 된 항목을 포함하는 ListView
        //view : 클릭된 항목의 View
        //position : 클릭이 된 항목의 Adapter에서의 위치값. 첫번째 항목은 0, 두번째 항목은 1 같이
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
    //adapter를 이용하여 listview가 데이터를 가져온다.
    class ObjectAdapter extends ArrayAdapter {
        //context : 현재의 Context. 일반적으로 Adapter를 포함하는 Activity의 instance가 들어감
        //resourse : TextView를 포함하는 layout 파일의 resource ID. 각 항목들을 어떤 형식으로 나타낼 것인지 결정.
        //objects : ListView에 나타낼 리스트 객체. Strig[], ArrayList<String>의 객체 등이 들어감
        public ObjectAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }
//getView() : 리스트뷰 안에 들어가는 하나의 항목을 구성(10개를 넘기면 10번 호출)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.listview_object, null);
            TextView txt1 = (TextView) v.findViewById(R.id.text_listview_object);
            txt1.setText(name[position]);
            ImageView img = (ImageView) v.findViewById(R.id.img_listview_object);
            img.setBackgroundResource(image[position]);

            return v;
        }
    }

}