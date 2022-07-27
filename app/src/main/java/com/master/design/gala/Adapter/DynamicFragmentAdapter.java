package com.master.design.gala.Adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.Fragments.DynamicFragment;

import java.util.ArrayList;

public class DynamicFragmentAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public ArrayList<CategoryList> data;
    public String CategoryID,VendorID;

    public DynamicFragmentAdapter(FragmentManager fm, int NumOfTabs,ArrayList<CategoryList> data,String CategoryID,String VendorId) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.data=data;
        this.CategoryID = CategoryID;
        this.VendorID= VendorId;

    }

    // get the current item with position number
    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putInt("position", position);
        b.putString("categoryid",CategoryID);
        b.putString("vendorid",VendorID);


        b.putParcelableArrayList("data", this.data.get(position).getProductList());

        Fragment frag = DynamicFragment.newInstance();
        frag.setArguments(b);
        return frag;
    }

    // get total number of tabs
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}