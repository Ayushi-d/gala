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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Adapter.ImagePagerAdapter;
import com.master.design.gala.Adapter.OccasionAdapter;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.OccasionList;
import com.master.design.gala.DataModel.OccasionListDM;
import com.master.design.gala.DataModel.OccasionSlidesDM;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.User;
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

public class Occasion_Fragment extends Fragment {

    private View rootView;
    private Context context;

    AppController appController;
    ConnectionDetector connectionDetector;
    User user;

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    @BindView(R.id.txt_error)
    TextView txt_error;

    @BindView(R.id.layout_parent)
    LinearLayout layout_parent;
    private HListView lst_latest_profiles, lst_latest_news, lst_featured_video;

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

    private void setDetails()
    {
//        occasionDataModels=new ArrayList<>();
//        occasionDataModels.add(new OccasionDataModel(R.drawable.wedding,"Wedding","Take inspirations and book the best of services perfect for Wedding"));
//        occasionDataModels.add(new OccasionDataModel(R.drawable.event,"Event","Take inspirations and book the best of services perfect for Wedding"));


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
