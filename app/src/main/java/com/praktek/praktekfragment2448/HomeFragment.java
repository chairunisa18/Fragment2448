package com.praktek.praktekfragment2448;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment implements View.OnClickListener {


    @Override
    public void onViewCreate(@NonNull View view , @Nullable Bundle
        savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button btnCategory = view.findViewById(R.id.btn_category);
        btnCategory.setOnClickListener(this);

        }
    }

    @Override
    public void onClick(View v) {
    if (v.getId()==R.id.btn_category){
        FragmentCategory mFragmentCategory = new FragmentCategory();
        FragmentManager mFragmentMananger = getFragmentManager();
        if (mFragmentMananger != null){
            mFragmentMananger.beginTransaction().replace(R.id.frame_container, mFragmentCategory,
                    FragmentCategory.class.getSimpleName()).addToBackStack(null).commit();

        }
    }
}