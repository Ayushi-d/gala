package com.master.design.gala.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.master.design.gala.DataModel.Combinations;
import com.master.design.gala.Helper.User;
import com.master.design.gala.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter_Bottom extends BaseAdapter {
    private Context context;
    private ArrayList<Combinations>arrayList;
    private Combinations selected;
    private int position;
    User user;

    public Adapter_Bottom(Context context, ArrayList<Combinations>arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        user=new User(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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
            convertView = inflater.inflate(R.layout.custom_item_for_bottom_sheet_list_with_image, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setDetails(viewHolder, position);
        return convertView;
    }


    private void setDetails(ViewHolder viewHolder, int position) {
        Combinations data = arrayList.get(position);
        viewHolder.size.setText(data.getSize());
        viewHolder.price.setText(data.getUnitPriceKWD());

    }

    public Combinations getSelected() {
        return selected;
    }

    public void setSelected(Combinations selected) {
        this.selected = selected;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private static class ViewHolder {
        private TextView price,size;


        private ViewHolder(View view) {
        size = view.findViewById(R.id.sizeTV);
        price = view.findViewById(R.id.prizeTV);
        }
    }
}
