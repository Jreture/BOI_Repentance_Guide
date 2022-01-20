package com.example.boi_repentance_guide;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


public class HomeFragment extends DialogFragment {


    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState){

        FrameLayout layout = (FrameLayout)  inflater.inflate(R.layout.fragment_home, container, false);
        return layout;
    }


        @Nullable
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savdInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("종료 확인");
        builder.setMessage("종료하시겠습니까?");
        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton("취소",null);

        return builder.create();
    }

}

