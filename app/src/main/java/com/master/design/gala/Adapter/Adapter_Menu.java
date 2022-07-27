package com.master.design.gala.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.master.design.gala.Activity.AddressActivity;
import com.master.design.gala.Activity.BottomForAll;
import com.master.design.gala.Activity.ContactUsActivity;
import com.master.design.gala.Activity.MainActivity;
import com.master.design.gala.Activity.MyOrderActivity;
import com.master.design.gala.Activity.MyPrivacyPolicy;
import com.master.design.gala.Activity.TermsAndCondition;
import com.master.design.gala.DataModel.Combinations;
import com.master.design.gala.Fragments.LikesFragment;
import com.master.design.gala.Helper.DummyData;
import com.master.design.gala.Helper.ResponseListener;
import com.master.design.gala.Models.DrawerMenu;
import com.master.design.gala.R;
import com.suke.widget.SwitchButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Adapter_Menu extends BaseAdapter {

    private Context context;
    private ArrayList<DrawerMenu> menus;




    public Adapter_Menu(Context context, ArrayList<DrawerMenu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    int i;
    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_item_for_menu, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setDetails(viewHolder, position);
        return convertView;
    }

    private void setDetails(ViewHolder viewHolder, int position) {
        DrawerMenu drawerMenu = menus.get(position);
        viewHolder.img.setImageResource(drawerMenu.getIcon());
        viewHolder.txt_title.setText(drawerMenu.getName());
        if(DrawerMenu.Langauge == drawerMenu.getId())
        {
            viewHolder.languageTV.setVisibility(View.VISIBLE);
        }else
        {
            viewHolder.languageTV.setVisibility(View.GONE);
        }

//        if(DrawerMenu.Notification == drawerMenu.getId())
//        {
//            viewHolder.switchB.setVisibility(View.VISIBLE);
//        }else
//        {
//            viewHolder.switchB.setVisibility(View.GONE);
//        }
       viewHolder.ll.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (DrawerMenu.Langauge == drawerMenu.getId()) {
//                  BottomForAll bottomForAll=new BottomForAll();
//                  ArrayList<Combinations> combinations=new ArrayList<>();
//                  Combinations combination1=new Combinations();
//                  combination1.setSize("English");
//                  combinations.add(combination1);
//
//                  Combinations combination2=new Combinations();
//                  combination2.setSize("Arabic");
//                  combinations.add(combination2);
//
////                  bottomForAll.arrayList = combinations;
//
//                  bottomForAll.setResponseListener(new ResponseListener() {
//                      @Override
//                      public void response(Object object) {
//                          response(object);
//
//                      }
//                  });
//                  bottomForAll.show(((MainActivity)context).getSupportFragmentManager(), "bottomSheetCountry");



                       final Dialog dialog = new Dialog(context);

                       dialog.setTitle("CHANGE LANGUAGE");
                       dialog.setContentView(R.layout.dialog_layout);
                       List<String> stringList = new ArrayList<>();  // here is list
                       for (int i = 0; i < 2; i++) {
                           if (i == 0) {
                               stringList.add("English");
                           } else {
                               stringList.add("العربي");
                           }

                       }

                       RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

                       for ( i = 0; i < stringList.size(); i++) {
                           RadioButton rb = new RadioButton(context); // dynamically creating RadioButton and adding to RadioGroup.
                           rb.setText(stringList.get(i));
                           rg.addView(rb);
                           dialog.show();


                           rb.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View v) {
                                   StringBuffer responseText = new StringBuffer();

                                   responseText.append(rb.getText());
                                   viewHolder.languageTV.setText(responseText);
                                   dialog.dismiss();

                               }
                           });
//                           rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//                           {
//                               @Override
//                               public void onCheckedChanged(RadioGroup group, int stringList) {
//                                   switch (stringList) {
//                                       case 1:
//                                           viewHolder.languageTV.setText("sddjvhjf");
//                                           dialog.dismiss();
//                                           break;
//
//                                       case 2:
//                                           viewHolder.languageTV.setText("eng");
//                                           dialog.dismiss();
//                                           break;
//
//                                   }
//
//                               }
//
//                           });
//
//                       if(stringList== true) {
//
//                       viewHolder.languageTV.setText("sddjvhjf");
//
//                      }

                         }


               }else if(DrawerMenu.My_Address==drawerMenu.getId())
              {
                  context.startActivity(new Intent(context, AddressActivity.class));
              }else if(DrawerMenu.My_Wishlist==drawerMenu.getId())
              {
                  ((MainActivity) context).addFragment(new LikesFragment(),false);
              }else if(DrawerMenu.My_Order==drawerMenu.getId())
              {
                  context.startActivity(new Intent(context, MyOrderActivity.class));
              }else if(DrawerMenu.Terms==drawerMenu.getId())
              {
                  context.startActivity(new Intent(context, TermsAndCondition.class));
              }else if(DrawerMenu.Privacy_Policy==drawerMenu.getId())
              {
                  context.startActivity(new Intent(context, MyPrivacyPolicy.class));
              }else if(DrawerMenu.Contact_us==drawerMenu.getId())
              {
                  context.startActivity(new Intent(context, ContactUsActivity.class));
              }

           }
       });

    }

    private static class ViewHolder {
        private TextView txt_title,languageTV;
        ImageView img;
        LinearLayout ll;
        SwitchButton switchB;

        private ViewHolder(View view) {
            txt_title = (TextView) view.findViewById(R.id.txt);
            img=(ImageView) view.findViewById(R.id.img);
            switchB=(SwitchButton)view.findViewById(R.id.switch_button);
            ll=(LinearLayout)view.findViewById(R.id.linearLayout1);
            languageTV= (TextView) view.findViewById(R.id.language);
        }
    }
}
