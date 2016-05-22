package com.atomath.finalmedie;

/**
 * Created by atomath on 12/4/59.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by atomath on 25/2/59.
 */
public class ListViewAdapter extends BaseAdapter {

    private static final String IMG_LINK = "image_link";
    private static final String TITLE = "title";
    private static final String DESC = "description";
    private static final String IMG_YOUTUBE = "youtube_image";
    private static final String YOUTUBE_ID = "youtubeID";

    public Context mContext;
    public LayoutInflater mInflater;
    public ArrayList<HashMap<String, String>> mData;

    public ListViewAdapter(Context context, ArrayList<HashMap<String, String>> arrayList){
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mData = arrayList;

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder holder = null;
        HashMap<String, String> item = mData.get(position);
        if(convertView == null){
            // load layout
            convertView = mInflater.inflate(R.layout.item_listview,null);

            holder = new viewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.item_listview_title);
            holder.description = (TextView) convertView.findViewById(R.id.item_listview_desc);
            holder.image_link = (ImageView) convertView.findViewById(R.id.item_listview_authorIcon);
            holder.youtube_image = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);




        }else{
            //restoration

            holder = (viewHolder) convertView.getTag();

        }
        holder.title.setText(item.get(TITLE));
        holder.description.setText(item.get(DESC));
        Glide.with(mContext).load(item.get(IMG_LINK)).placeholder(R.drawable.loading).into(holder.image_link);
        Glide.with(mContext).load(item.get(IMG_YOUTUBE)).placeholder(R.drawable.loading).into(holder.youtube_image);

        holder.youtubeID = item.get(YOUTUBE_ID);
        holder.image_link_url = item.get(IMG_LINK);
        holder.youtube_image_url = item.get(IMG_YOUTUBE);
        convertView.setTag(holder);

        return convertView;
    }

    public class viewHolder{
        TextView title;
        TextView description;
        ImageView image_link;
        ImageView youtube_image;
        String youtubeID;
        String image_link_url;
        String youtube_image_url;
    }
}

