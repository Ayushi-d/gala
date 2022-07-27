package com.master.design.gala.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.AddToCart;
import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Adapter.Adapter_SubListing;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.Helper.BottomDateTimeSelector;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.Models.SubListingModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.widget.HListView;

public class LikesFragment extends Fragment implements ResponseListener {
    private View rootView;
    private Context context;

    @BindView(R.id.progress_bar) ProgressBar progress_bar;
    @BindView(R.id.txt_error) TextView txt_error;

    @BindView(R.id.layout_parent) LinearLayout layout_parent;
    private HListView lst_latest_profiles, lst_latest_news, lst_featured_video;
    AppController appController;
    ConnectionDetector connectionDetector;
    ProgressDialog progressDialog;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;

    @BindView(R.id.viewTxt)
    TextView viewTxt;

    @BindView(R.id.title)
    TextView title;

    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(getActivity(), AddToCart.class));
    }

    @OnClick(R.id.viewTxt)
    public void View()
    {
        isVertical=!isVertical;
        if(isVertical)
        {
            VerticalView();
        }else
        {
            HorizontalView();
        }
    }
    BottomDateTimeSelector bottomDateTimeSelector;

    public void OpenBottomSheet()
    {
        bottomDateTimeSelector= new BottomDateTimeSelector();
        bottomDateTimeSelector.setResponseListener(this);

        bottomDateTimeSelector.show(getActivity().getSupportFragmentManager(), "bottomSheetCountry");
    }
    boolean isVertical=true;

    boolean isDetail=false;

    public void VerticalView()
    {
        viewTxt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_two_icon, 0, 0, 0);

        if(position==99)
            isDetail=true;

        Adapter_SubListing occasionAdapter=new Adapter_SubListing(getActivity(), data,true,position,isDetail,title.getText().toString());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(occasionAdapter);
    }

    public void HorizontalView()
    {

        if(position==99)
            isDetail=true;

        viewTxt.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_list_icon, 0, 0, 0);
        Adapter_SubListing occasionAdapter=new Adapter_SubListing(getActivity(), data,false,position,isDetail,title.getText().toString());
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(occasionAdapter);
    }

    @OnClick(R.id.date)
    public void chooseDate()
    {
        OpenBottomSheet();
    }

    int position;
    ArrayList<SubListingModel> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        context = getActivity();
        appController = (AppController) getActivity().getApplicationContext();

        connectionDetector = new ConnectionDetector(getActivity());
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        ((MainActivity) context).setTitle(getString(R.string.home));
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.activity_sub_listing, container, false);
            ButterKnife.bind(this,rootView);
            setDetails();
            data= DummyData.getClothing();
            Binding();
        }
        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    private void setDetails() {
        ShowProgress();
        rootView.postDelayed(new Runnable() {
            @Override
            public void run() {
                DismissProgress();
            }
        }, 1500);




    }

    public void ShowProgress()
    {
        progress_bar.setVisibility(View.VISIBLE);
        txt_error.setVisibility(View.GONE);
        layout_parent.setVisibility(View.GONE);
    }

    public void DismissProgress()
    {
        progress_bar.setVisibility(View.GONE);
        txt_error.setVisibility(View.GONE);
        layout_parent.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_back).setVisible(false);
    }

    @Override
    public void response(Object object) {
        if(object instanceof OccasionDataModel) {
            if(((OccasionDataModel) object).getHeading().equalsIgnoreCase("wedding"))
            {

            }else
            {

            }
        }


    }
    public void Binding()
    {
        VerticalView();
    }
}