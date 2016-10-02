package com.example.ckh.cstview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ckh.foodtruck.R;

import java.util.ArrayList;

/**
 * Created by Ckh on 2016-10-02.
 */
public class UserTruckListviewAdapter extends BaseAdapter {
    private Context allMenuContext = null;
    private ArrayList<User_TruckItem> allMenuListData = new ArrayList<User_TruckItem>();

    public UserTruckListviewAdapter(Context allMenuContext){
        super();
        this.allMenuContext = allMenuContext;
    }

    @Override
    public int getCount() {
        return allMenuListData.size();
    }

    @Override
    public Object getItem(int position) {
        return allMenuListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(Drawable truckimg, String trucktitle, String truckPrice, String truckInfo){
        User_TruckItem addInfo = new User_TruckItem();
        addInfo.TruckImg = truckimg;
        addInfo.TruckTitle = trucktitle;
        addInfo.TruckInfo = truckInfo;

        allMenuListData.add(addInfo);
    }

    public void remove(int position){
        allMenuListData.remove(position);
    }

    /*public void dataChange() {
        allMenuAdapter.notifyDataSetChanged();
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder allMenuHolder;
        if(convertView == null){
            allMenuHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)allMenuContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.seller_menu_added_layout,null);

            allMenuHolder.Truckimg = (ImageView)convertView.findViewById(R.id.all_menu_image);
            allMenuHolder.TruckTitle = (TextView)convertView.findViewById(R.id.all_menu_foodname);
            allMenuHolder.TruckInfo = (TextView)convertView.findViewById(R.id.all_menu_price);
            allMenuHolder.TruckInfo = (TextView)convertView.findViewById(R.id.all_menu_origin);


            convertView.setTag(allMenuHolder);
        }
        else{
            allMenuHolder = (ViewHolder)convertView.getTag();
        }

        User_TruckItem allMenuData = allMenuListData.get(position);

        if(allMenuData.TruckImg != null){
            allMenuHolder.Truckimg.setVisibility(View.VISIBLE);
            allMenuHolder.Truckimg.setImageDrawable(allMenuData.TruckImg);
        }
        else{
            allMenuHolder.Truckimg.setVisibility(View.GONE);
        }

        allMenuHolder.TruckTitle.setText(allMenuData.TruckTitle);
        allMenuHolder.TruckInfo.setText(allMenuData.TruckInfo);
        allMenuHolder.TruckLoc.setText(allMenuData.TruckLoc);

        return convertView;
    }
    private class ViewHolder{
        public ImageView Truckimg;
        public TextView TruckTitle;
        public TextView TruckInfo;
        public TextView TruckLoc;
    }
}
