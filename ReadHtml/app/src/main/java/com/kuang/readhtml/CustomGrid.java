package com.kuang.readhtml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by SONY on 2016/11/5.
 */

public class CustomGrid extends BaseAdapter{
    Context mContext;
    List<String> imgText;
    List<Integer> imgId;

    public CustomGrid(Context context, List<String> imgText, List<Integer> imgId){
        this.mContext=context;
        this.imgText=imgText;
        this. imgId=imgId;
    }

    @Override
    public int getCount() {
        return imgText.size();
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
        View grid;
        LayoutInflater inflater =  (LayoutInflater)mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null) {
            grid = inflater.inflate(R.layout.gridview_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView) grid.findViewById(R.id.grid_image);
            textView.setText(imgText.get(position));
            imageView.setImageResource(imgId.get(position));
        }
        else{
            grid=convertView;
        }
        return grid;
    }
}
