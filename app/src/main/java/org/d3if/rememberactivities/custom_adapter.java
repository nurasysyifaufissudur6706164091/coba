package org.d3if.rememberactivities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yoga Wahyu Yuwono on 11/03/2018.
 */

public class custom_adapter extends ArrayAdapter<simpankegiatan> {
    int resource;
    public custom_adapter (Context context, int resource, List<simpankegiatan> object){
        super(context ,resource,object);
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout customview;
        simpankegiatan currentKegiatan=getItem(position);
        if (convertView==null){
            customview=new LinearLayout(getContext());
            String inflater=Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi=(LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource,customview,true);
        }else {
            customview=(LinearLayout)convertView;
        }
        TextView namakegiatan=(TextView)customview.findViewById(R.id.custom_namaKegiatan);
        TextView tanggal=(TextView)customview.findViewById(R.id.custom_tanggalKegiatan);
        namakegiatan.setText(currentKegiatan.getNamakegiatan());
        tanggal.setText(currentKegiatan.getTgl_mulai());
        return customview;
    }
}
