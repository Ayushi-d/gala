package com.master.design.gala.Helper;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.master.design.gala.Activity.MainListingActivity;
import com.master.design.gala.Activity.PackageActivity;

import com.master.design.gala.DataModel.CategoryList;
import com.master.design.gala.R;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BottomDateTimeSelector extends BottomSheetDialogFragment implements View.OnClickListener, View.OnTouchListener {

    private Context context;
//    private ListView listview;
    private TextView btn_cancel, btn_done, txt_error_message;
    private ResponseListener responseListener;
    private BottomSheetBehavior bottomSheetBehavior;
    private ProgressBar progressBar;
    private RelativeLayout layout_top;
   public ArrayList<CategoryList> categoryLists111;

    private boolean isTopScroll = false;
    private String selected;

    public int selectedPosition;

    public Intent intent;
    User user;

    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismiss();
            }

        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
        }
    };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        this.context = getContext();

        View contentView = View.inflate(context, R.layout.custom_item_date_picker, null);
        user=new User(context);
        // assert dialog.getWindow() != null;
        //dialog.getWindow().setDimAmount(0f);
        //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(contentView);

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) contentView.getParent()).getLayoutParams();
        CoordinatorLayout.Behavior behavior = params.getBehavior();
        ((View) contentView.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));

        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            bottomSheetBehavior = (BottomSheetBehavior) behavior;
            bottomSheetBehavior.setBottomSheetCallback(mBottomSheetBehaviorCallback);
        }
        mapping(contentView);

    }

    private void getList() {
//        arrayList = new ArrayList<>();
//        arrayList = new DummyData(context).getStringList();
//        setData(arrayList);
    }


    public void setData(ArrayList<String> arrayList) {
//        if (arrayList != null && arrayList.size() > 0) {
//            if (adapter == null) {
//                adapter = new Adapter_Bottom(context, arrayList);
//                selected = arrayList.get(0);
//            }
//        }
//        this.arrayList=arrayList;
    }


    com.github.florent37.singledateandtimepicker.SingleDateAndTimePicker dateAndTimePicker;
TextView submit;
    private void mapping(View view) {

//        btn_done = view.findViewById(R.id.btn_done);
//        btn_cancel = view.findViewById(R.id.btn_cancel);

//        listview = view.findViewById(R.id.list_view);
//        listview.setVisibility(View.VISIBLE);
        progressBar = view.findViewById(R.id.progressBar);
        layout_top = view.findViewById(R.id.layout_top);
        dateAndTimePicker = view.findViewById(R.id.single_day_picker);
        txt_error_message = view.findViewById(R.id.txt_error_message);

        submit = view.findViewById(R.id.submitTxt);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedPosition==0) {
                   Date date1= dateAndTimePicker.getDate();
                    SimpleDateFormat formatNowDay = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat formatNowDayNew = new SimpleDateFormat("dd - MMM - yyyy");

                   String newDate= formatNowDayNew.format(date1);
                    String newDateNew= formatNowDay.format(date1);

                   //                   String dateString=date1.getDate()+"/"+date1.getMonth()+"/"+date1.getYear();
                   user.setSelectedDate(newDate);
                   user.setSelectedDateNew(newDateNew);
                   Intent intent = new Intent(context, MainListingActivity.class);
                    intent.putExtra("data", categoryLists111);
                    context.startActivity(intent);
                }
                else {
                    context.startActivity(new Intent(getActivity(), PackageActivity.class));
                }

            }
        });


//        btn_done.setOnClickListener(this);
//        btn_cancel.setOnClickListener(this);
//        layout_top.setOnTouchListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.btn_done:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
//                if (responseListener != null && adapter != null) {
//                    responseListener.response(adapter.getSelected(),adapter.getPosition());
//                }
                break;
        }
    }


    public void setResponseListener(ResponseListener responseListener) {
        this.responseListener = responseListener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            isTopScroll = true;
        } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
            isTopScroll = false;
        }
        return true;
    }
}