package com.menanga.ezparking.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.menanga.ezparking.R;

import java.util.ArrayList;

/**
 * Created by sai on 15/11/2016.
 */
public class ParkAdapter extends ArrayAdapter<Contain> {
    public ParkAdapter(Context context, int resource, ArrayList<String> listKontak) {
        super(context, resource);
    }
    public View getView(int pos, View convertView, ViewGroup parent){
        final Contain ge = getItem(pos);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_peritem,parent,false);
        }
        TextView no = (TextView)convertView.findViewById(R.id.tv_i_no);
        TextView id = (TextView)convertView.findViewById(R.id.tv_i_id);

        id.setText(ge.getId());
        no.setText(ge.getNo());
        return convertView;
    }
}
