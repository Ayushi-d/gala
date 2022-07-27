package com.master.design.gala.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.master.design.gala.Adapter.Adapter_Add_To_Cart;
import com.master.design.gala.Adapter.Adapter_My_Order;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyOrderActivity extends AppCompatActivity {
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        ButterKnife.bind(this);
        Binding();
    }

    public void Binding()
    {
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyOrderActivity.this,RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(new Adapter_My_Order(MyOrderActivity.this, DummyData.getParking()));
    }
}
