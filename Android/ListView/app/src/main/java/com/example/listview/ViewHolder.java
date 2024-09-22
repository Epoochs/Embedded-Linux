package com.example.listview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    TextView text;
    ImageView img;
    View convertView;

    public ViewHolder(View view) {
        convertView = view;
    }

    public TextView getText() {
        if(text == null){
            text = convertView.findViewById(R.id.tvIconName);
        }
        return text;
    }

    public ImageView getImg() {
        if(img == null){
            img = convertView.findViewById(R.id.imageView);
        }
        return img;
    }
}
