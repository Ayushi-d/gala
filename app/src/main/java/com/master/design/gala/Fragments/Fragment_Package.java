package com.master.design.gala.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Adapter.Adapter_Package;
import com.master.design.gala.Adapter.OccasionAdapter;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.OccasionListDM;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Models.OccasionDataModel;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.widget.HListView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Fragment_Package extends Fragment {

    private View rootView;
    private Context context;

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    @BindView(R.id.txt_error)
    TextView txt_error;

    @BindView(R.id.layout_parent)
    LinearLayout layout_parent;
    private HListView lst_latest_profiles, lst_latest_news, lst_featured_video;
    AppController appController;
    ConnectionDetector connectionDetector;
    ProgressDialog progressDialog;

    @BindView(R.id.recycleView)
    RecyclerView recyclerView;


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
            rootView = inflater.inflate(R.layout.fragment_occassion, container, false);
            ButterKnife.bind(this,rootView);
            idMapping();

            setClickListeners();
            setDetails();
        }
        return rootView;
    }

    private void idMapping() {


    }

    private void setClickListeners() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    ArrayList<OccasionDataModel> occasionDataModels;

    private void setDetails() {
//        occasionDataModels=new ArrayList<>();
//        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
//        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
//
//        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
//        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
//
//        occasionDataModels.add(new OccasionDataModel(R.drawable.packages_1,"Classic Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));
//        occasionDataModels.add(new OccasionDataModel(R.drawable.package_2,"Premier Wedding Package","Easy & romantic wedding options! Our all-inclusive wedding packages mean you can shortcut all your wedding prep, get introductions to vendors we know and trust, and hear expert advice from people with your best interests at heart. This is a revolutionary way to plan your wedding: enjoy an easy, stress-free, and pleasant process that gives you time, space, and energy to enjoy every day of your engagement! "));

        if (connectionDetector.isConnectingToInternet()) {
            //                   String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            appController.paServices.OccasionList(new Callback<OccasionListDM>() {
                @Override

                public void success(OccasionListDM occList, Response response) {
                    if (occList.getStatus().equalsIgnoreCase("1"))
                    {
                        OccasionAdapter occasionAdapter=new OccasionAdapter(getActivity(),occList.getOccasionList(),getArguments().getInt("position"));
                        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(occasionAdapter);


                    } else
                        Helper.showToast(getActivity(),occList.getMessage());
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Log.e("error", retrofitError.toString());

                }
            });
        }

        else
            Helper.showToast(getActivity(), getString(R.string.no_internet_connection));

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
}
