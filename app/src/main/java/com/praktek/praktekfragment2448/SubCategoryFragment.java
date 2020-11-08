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
import android.widget.TextView;

public class SubCategoryFragment extends Fragment implements View.OnClickListener{

TextView tvCategoryName;
TextView tvCategoryDescription;

    public static String EXTRA_NAME = "extra_name";
    private  String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void onViewCreate(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
    }

    @Override
    public void onActivityCreated (@Nullable Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
    }

    @Override
    public void onViewCreated (@NonNull View view , @Nullable Bundle saveInstanceState){
        super.onViewCreated(view, saveInstanceState);
        Button btnSubCategory = view.findViewById(R.id.btn_sub_category);
        btnSubCategory.setOnClickListener(this);
    }

    @Override
    public void OnClick(View v){
        if (v.getId()== R.id.btn_sub_category){
            SubCategoryFragment mSubCategoryFragment = new SubCategoryFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(SubCategoryFragment.EXTRA_NAME, "ini dikirim dengan bundle");
            String description = "ini dikirim dengan getter setter";

            mSubCategoryFragment.setArguments(mBundle);
            mSubCategoryFragment.setDescription(description);

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null){
                mFragmentManager.beginTransaction().replace(R.id.frame_container, mSubCategoryFragment,SubCategoryFragment.class.getSimpleName()).addToBackStack(null).commit();
            }
        }
    }
}