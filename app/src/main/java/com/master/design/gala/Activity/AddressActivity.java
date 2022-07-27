package com.master.design.gala.Activity;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Adapter.Adapter_Address;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.AddressDM;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressActivity extends AppCompatActivity {
    AppController appController;

    Dialog progress;
    ConnectionDetector connectionDetector;
    User user;
    DialogUtil dialogUtil;


    @BindView(R.id.recycleViewAddress)
    RecyclerView recycleViewAddress;

/*   @OnClick(R.id.frontSizeTV)
    public void frontSize() {

        Intent intent=new Intent(AddImageAndTextActivity.this,AddToCartWithImageActivity.class);
        startActivity(intent);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        dialogUtil = new DialogUtil();
        appController = (AppController) getApplicationContext();
        connectionDetector = new ConnectionDetector(getApplicationContext());

        adapterCode();

    }


    ArrayList<AddressDM> list  =  new ArrayList();
    private void adapterCode() {
        AddressDM d1 = new AddressDM("HOME","Hawally,Salmiya Blocks,Street 10,Avenue 10,Floor 10,Flat 10","Direction-","Phone -");
        AddressDM d2 = new AddressDM("HOME","Hawally,Salmiya Blocks,Street 10,Avenue 10,Floor 10,Flat 10","Direction-","Phone -");
        AddressDM d3 = new AddressDM("HOME","Hawally,Salmiya Blocks,Street 10,Avenue 10,Floor 10,Flat 10","Direction-","Phone -");


        list.add(d1);
        list.add(d2);
        list.add(d3);



        Adapter_Address ma =new Adapter_Address(AddressActivity.this,list);
        LinearLayoutManager lm = new LinearLayoutManager(AddressActivity.this,LinearLayoutManager.VERTICAL,false);
        recycleViewAddress.setHasFixedSize(true);
        recycleViewAddress.setLayoutManager(lm);
        recycleViewAddress.setAdapter(ma);



    }



}
