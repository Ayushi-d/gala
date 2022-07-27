package com.master.design.gala.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Adapter.Adapter_SubListing;
import com.master.design.gala.Adapter.Adapter_SubSubListing_Fragment;
import com.master.design.gala.DataModel.ECommerceList;
import com.master.design.gala.DataModel.ProductList;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DynamicFragment extends Fragment {

    public static DynamicFragment newInstance() {
        return new DynamicFragment();
    }
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    ArrayList<ProductList> data1;
    String CategoryID,VendorID;

    // adding the layout with inflater
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, container, false);
        ButterKnife.bind(this,view);
        data1 = getArguments().getParcelableArrayList("data");
        CategoryID = getArguments().getString("categoryid");
        VendorID = getArguments().getString("vendorid");
        initViews(view);
        return view;
    }
ArrayList<SubListingModel> data;
    // initialise the categories
    private void initViews(View view) {
        data=new ArrayList<>();

        if(data1!=null)
        for (ProductList v : data1) {
            SubListingModel s = new SubListingModel();
            s.setHeading(v.getProductName());
            s.setHeadingAr(v.getProductNameAr());
//            s.setDescription(v.ge());
//            s.setDescriptionAr(v.get);
            s.setImgUrl(v.getThumbImage());
            s.setId(v.getProductID());
            s.setPrice(v.getUnitPrice());
            s.setCategoryID(CategoryID);
            s.setVendorID(VendorID);
            data.add(s);
        }

        Adapter_SubSubListing_Fragment occasionAdapter=new Adapter_SubSubListing_Fragment(getActivity(),data );
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(occasionAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    // pause function call
    @Override
    public void onPause() {
        super.onPause();
    }

    // resume function call
    @Override
    public void onResume() {
        super.onResume();
    }

    // stop when we close
    @Override
    public void onStop() {
        super.onStop();
    }

    // destroy the view
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}