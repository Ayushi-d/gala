package com.master.design.gala.Fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Html;
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
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import com.master.design.gala.Activity.AddToCart;
import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Activity.MainListingActivity;
import com.master.design.gala.Activity.TermsAndCondition;
import com.master.design.gala.Adapter.ImagePagerAdapter;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.DataPrivacyPolicyDM;
import com.master.design.gala.DataModel.OccasionSlidesDM;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.Helper;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import org.jsoup.select.Evaluator;

import java.nio.charset.StandardCharsets;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.widget.HListView;
import me.crosswall.lib.coverflow.CoverFlow;
import me.crosswall.lib.coverflow.core.PagerContainer;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class HomeFragment extends Fragment {
    ViewPager pager;
    private View rootView;
    private Context context;
    AppController appController;
    ConnectionDetector connectionDetector;
    User user;

    @BindView(R.id.pager_container)
    PagerContainer pagerContainer;

    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;
    @BindView(R.id.txt_error)
    TextView txt_error;

    @BindView(R.id.layout_parent)
    LinearLayout layout_parent;
    private HListView lst_latest_profiles, lst_latest_news, lst_featured_video;


    ProgressDialog progressDialog;

    @BindView(R.id.viewPager) ViewPager viewPager;

    @OnClick(R.id.addToBag)
    public void AddToBag()
    {
        startActivity(new Intent(getActivity(), AddToCart.class));
    }

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

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this,rootView);
            pager = (ViewPager) rootView.findViewById(R.id.view_pager);
            TabLayout layout= (TabLayout) rootView.findViewById(R.id.tablayout);
            layout.addTab(layout.newTab().setText("OCCASIONS"));
            layout.addTab(layout.newTab().setText("PACKAGE"));

            pager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    Occasion_Fragment occasion_fragment=new Occasion_Fragment();
                    Bundle bd=new Bundle();
                    bd.putInt("position",position);
                    occasion_fragment.setArguments(bd);
                    return occasion_fragment;
                }


                @Override
                public int getCount() {
                    return layout.getTabCount();
                }
            });
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));
            layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    pager.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {
                }
            });







                if (connectionDetector.isConnectingToInternet()) {
 //                   String refreshedToken = FirebaseInstanceId.getInstance().getToken();
                    appController.paServices.OccasionSlides(new Callback<OccasionSlidesDM>() {
                        @Override

                        public void success(OccasionSlidesDM occSlides, Response response) {
                            if (occSlides.getStatus().equalsIgnoreCase("1"))
                            {
                            viewPager.setAdapter(new ImagePagerAdapter(getActivity(), occSlides.getList()));
                            viewPager.setClipToPadding(false);
                            viewPager.setPadding(28, 0, 28, 0);
                            viewPager.setPageMargin(5);
                            viewPager.setCurrentItem((occSlides.getList().size()/2));


                                new CoverFlow.Builder().with(viewPager)
                                        .scale(0.3f)
                                        .pagerMargin(getResources().getDimensionPixelSize(R.dimen.overlap_pager_margin))
                                        .spaceSize(0f)
                                        .build();

                                pagerContainer.setOverlapEnabled(true);
                            } else
                                Helper.showToast(getActivity(),occSlides.getMessage());
                        }

                        @Override
                        public void failure(RetrofitError retrofitError) {
                            Log.e("error", retrofitError.toString());

                        }
                    });
                }

                else
                    Helper.showToast(getActivity(), getString(R.string.no_internet_connection));



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

    private void setDetails() {




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
