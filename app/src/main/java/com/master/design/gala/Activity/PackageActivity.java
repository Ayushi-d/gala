package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.master.design.gala.Adapter.Adapter_Package;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PackageActivity extends AppCompatActivity {
    private View rootView;
    private Context context;

    AppController appController;
    ConnectionDetector connectionDetector;
    ProgressDialog progressDialog;
    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(this,AddToCart.class));
    }
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package);
        ButterKnife.bind(this);


        setDetails();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    ArrayList<OccasionDataModel> occasionDataModels;

    private void setDetails() {
        occasionDataModels=new ArrayList<>();
        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));

        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));

        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));

        Adapter_Package occasionAdapter=new Adapter_Package(PackageActivity.this,occasionDataModels);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(PackageActivity.this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(occasionAdapter);
    }

}
