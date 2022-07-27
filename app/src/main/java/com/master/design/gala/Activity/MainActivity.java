
package com.master.design.gala.Activity;

import static com.facebook.FacebookSdk.getApplicationContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.master.design.gala.Controller.AppController;
import com.master.design.gala.DataModel.CustomerRegisterDM;
import com.master.design.gala.Fragments.Fragment_Default;
import com.master.design.gala.Fragments.HomeFragment;
import com.master.design.gala.Fragments.LikesFragment;
import com.master.design.gala.Fragments.ProfileFragment;
import com.master.design.gala.Fragments.SearchFragment;
import com.master.design.gala.Helper.DialogUtil;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;
import com.master.design.gala.Utils.ConnectionDetector;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    User user;
    AppController appController;
    ConnectionDetector connectionDetector;
    private SharedPreferences sharedpreferences;



    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;

    // key to store image path in savedInstance state
    public static final String KEY_IMAGE_STORAGE_PATH = "image_path";

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    // Bitmap sampling size
    public static final int BITMAP_SAMPLE_SIZE = 8;

    // Gallery directory name to store the images or videos
    public static final String GALLERY_DIRECTORY_NAME = "Hello Camera";

    // Image and Video file extensions
    public static final String IMAGE_EXTENSION = "jpg";
    public static final String VIDEO_EXTENSION = "mp4";

    @BindView(R.id.homeImage)
    ImageView homeImg;

    @BindView(R.id.searchImage)
    ImageView searchImage;

    @BindView(R.id.likeImage)
    ImageView likeImage;


    @BindView(R.id.profileImage)
    ImageView profileImage;


    HomeFragment homeFragment=null;
    @OnClick(R.id.homeLL)
    public void HomeClicked()
    {

        startActivity(new Intent(this,MainActivity.class));
        finish();
//        homeImg.setImageResource(R.drawable.home_unselected_selected);
//        searchImage.setImageResource(R.drawable.ic_search_new);
//        likeImage.setImageResource(R.drawable.ic_like);
//        profileImage.setImageResource(R.drawable.ic_profile);
    }

    @OnClick(R.id.searchLL)
    public void SearchClicked()
    {
        addFragment(new SearchFragment(),false);

        homeImg.setImageResource(R.drawable.ic_unbold_home);
        searchImage.setImageResource(R.drawable.ic_bold_search);
        likeImage.setImageResource(R.drawable.ic_unbold_star);
        profileImage.setImageResource(R.drawable.ic_unbold_profile);
    }

    @OnClick(R.id.likeLL)
    public void LikeClicked()
    {
        addFragment(new LikesFragment(),false);

        homeImg.setImageResource(R.drawable.ic_unbold_home);
        searchImage.setImageResource(R.drawable.ic_unbold_search);
        likeImage.setImageResource(R.drawable.ic_bold_star);
        profileImage.setImageResource(R.drawable.ic_unbold_profile);
    }


    @OnClick(R.id.profileLL)
    public void ProfileClicked()
    {
        addFragment(new ProfileFragment(),false);

        homeImg.setImageResource(R.drawable.ic_unbold_home);
        searchImage.setImageResource(R.drawable.ic_unbold_search);
        likeImage.setImageResource(R.drawable.ic_unbold_star);
        profileImage.setImageResource(R.drawable.ic_bold_profile);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setDetails();
        user = new User(MainActivity.this);
        appController = (AppController)  getApplicationContext();
        connectionDetector = new ConnectionDetector(MainActivity.this);
    }

    public void setDetails()
    {
        addFragment(new HomeFragment(),true);

        homeImg.setImageResource(R.drawable.ic_bold_home);
        searchImage.setImageResource(R.drawable.ic_unbold_search);
        likeImage.setImageResource(R.drawable.ic_unbold_star);
        profileImage.setImageResource(R.drawable.ic_unbold_profile);

    }

    private void exitDialog() {
        DialogUtil.showDialogTwoButton(this, R.drawable.app_icon, getString(R.string.app_name), getString(R.string.are_you_sure_you_want_to_exit_the_app), getString(R.string.ok), getString(R.string.cancel), new DialogUtil.CallBack() {
            @Override
            public void onDismiss(boolean isPressedOK) {
                if (isPressedOK) {
                    MainActivity.this.finish();

                }
            }
        });
    }

    public void setDrawer()
    {}
    public void setToolBar()
    {}
    public void setOnClickListeners()
    {}

    @Override
    public void onClick(View view) {
    }

    public void setElevation(boolean isElevate) {


    }
    public void addFragment(Fragment fragment, boolean addToStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment, fragment.getClass().getName());
        if (addToStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
    @Override
    public void onBackPressed() {

        int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if (backStackEntryCount == 0) {
        } else {
            if (fragment != null && fragment instanceof Fragment_Default) {
                //this.finish();
                exitDialog();


            } else {
                addFragment(new Fragment_Default(), false);
            }
            super.onBackPressed();
        }

    }
}
