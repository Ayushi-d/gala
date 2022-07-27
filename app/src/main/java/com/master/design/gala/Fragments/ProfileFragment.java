package com.master.design.gala.Fragments;

import static com.facebook.FacebookSdk.getApplicationContext;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import com.master.design.gala.Activity.AddressActivity;
import com.master.design.gala.Activity.ContactUsActivity;
import com.master.design.gala.Activity.LoginActivity;
import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Activity.MyOrderActivity;
import com.master.design.gala.Activity.MyPrivacyPolicy;
import com.master.design.gala.Activity.SignUpActivity;
import com.master.design.gala.Activity.TermsAndCondition;
import com.master.design.gala.Adapter.Adapter_Menu;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CustomerDetailsDM;
import com.master.design.gala.DataModel.CustomerRegisterDM;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.User;
import com.master.design.gala.Models.DrawerMenu;

import com.master.design.gala.Utils.ConnectionDetector;
import com.master.design.gala.Utils.Helper;
import com.suke.widget.SwitchButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import it.sephiroth.android.library.widget.HListView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.master.design.gala.R;
public class ProfileFragment extends Fragment {

    private View rootView;
    private Context context;
    AppController appController;


    private HListView lst_latest_profiles, lst_latest_news, lst_featured_video;
    ConnectionDetector connectionDetector;
    ProgressDialog progressDialog;

    @BindView(R.id.listView)
    ListView listView;



    User user;


    @BindView(R.id.logoutTxt) TextView logoutTxt;
    @BindView(R.id.nameTxt) TextView nameTxt;
    private ActionBar.Tab fullNameET;


    @OnClick(R.id.logoutTxt)
    public void loginLogoutClicked()
    {
//        if(user.getId()==0)
//        {
//
//          user.setId(1);
//         logoutTxt.setText(getActivity().getString(R.string.logout));
//         nameTxt.setVisibility(View.VISIBLE);

//
//            String nameTxt1 = fullNameET.getText().toString();
//            nameTxt.setText("Welcome:\t" + nameTxt1);



            logoutTxt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick ( View v ) {

                 startActivity(new Intent(getActivity(), LoginActivity.class));
                 getActivity().finish();
             }
         });



            Adapter_Menu adapter_menu=new Adapter_Menu(getActivity(), DummyData.getWithUserMenu(getActivity()));
            listView.setAdapter(adapter_menu);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(DummyData.getWithUserMenu(getActivity()).get(i).getId()== DrawerMenu.Contact_us)
                    {
                        startActivity(new Intent(getActivity(), ContactUsActivity.class));
                    }
                    else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Address) {
                        startActivity(new Intent(getActivity(), AddressActivity.class));
                    } else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.Terms)
                    {
                        startActivity(new Intent(getActivity(), TermsAndCondition.class));

                    }else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Order)
                    {
                        startActivity(new Intent(getActivity(), MyOrderActivity.class));

                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId()==DrawerMenu.Privacy_Policy)
                    {
                        startActivity(new Intent(getActivity(),MyPrivacyPolicy.class));
                    }
                }
            });
//        }else
//        {
//            user.setId(0);
//
//            logoutTxt.setText(getActivity().getString(R.string.logout));
//            nameTxt.setVisibility(View.GONE);
//
//
//        }

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
        ((MainActivity) context).setTitle(getString(R.string.home));
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.profile_fragment, container, false);
            ButterKnife.bind(this,rootView);
            user=new User(getActivity());
            idMapping();

            setClickListeners();
            setDetails();
        }
        return rootView;
    }

    private void idMapping() {
        Adapter_Menu adapter_menu;
        if(user.getId()!=0)
        {
             adapter_menu=new Adapter_Menu(getActivity(), DummyData.getWithUserMenu(getActivity()));

        }else
         adapter_menu=new Adapter_Menu(getActivity(), DummyData.getWithoutUserMenu(getActivity()));

        listView.setAdapter(adapter_menu);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(user.getId()!=0) {
                    if (DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.Contact_us) {
                        startActivity(new Intent(getActivity(), ContactUsActivity.class));
                    }else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Address) {
                        startActivity(new Intent(getActivity(), AddressActivity.class));
                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.Terms) {
                        startActivity(new Intent(getActivity(), TermsAndCondition.class));

                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Order) {
                        startActivity(new Intent(getActivity(), MyOrderActivity.class));
                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.Privacy_Policy) {
                        startActivity(new Intent(getActivity(), MyPrivacyPolicy.class));
                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Wishlist) {
                        ((MainActivity) getActivity()).addFragment(new LikesFragment(),false);
                    }
                }else
                {
                    if(DummyData.getWithUserMenu(getActivity()).get(i).getId()== DrawerMenu.Contact_us)
                    {
                        startActivity(new Intent(getActivity(), ContactUsActivity.class));
                    }else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.Terms)
                    {
                        startActivity(new Intent(getActivity(), TermsAndCondition.class));

                    }else if(DummyData.getWithUserMenu(getActivity()).get(i).getId() == DrawerMenu.My_Order)
                    {
                        startActivity(new Intent(getActivity(), MyOrderActivity.class));

                    } else if (DummyData.getWithUserMenu(getActivity()).get(i).getId()==DrawerMenu.Privacy_Policy)
                    {
                        startActivity(new Intent(getActivity(),MyPrivacyPolicy.class));
                    }
                }
            }
        });
    }

    private void setClickListeners() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setDetails() {


    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        user = new User(getActivity());
        appController = (AppController)  getApplicationContext();

        String customerId =String.valueOf(user.getId()) ;

        appController.paServices.CustomerDetails(customerId, new Callback<CustomerDetailsDM>() {
            @Override
            public void success ( CustomerDetailsDM customerDetailsDM, Response response ) {
                if (customerDetailsDM.getStatus().equalsIgnoreCase("1")) {

                    nameTxt.setText("Welcome\t"+ customerDetailsDM.getCustomer().getCustomerName());
                } else
                    Helper.showToast( getActivity(), customerDetailsDM.getMessage());
            }

            @Override
            public void failure ( RetrofitError retrofitError ) {
                Log.e("error", retrofitError.toString());
            }
        });

    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.action_back).setVisible(false);
    }
}