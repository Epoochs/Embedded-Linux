package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Vector;

public class ItemArrayAdapter extends ArrayAdapter {

    private Vector<MyItems> myItems_ref;
    private Context context;

    public ItemArrayAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List list) {
        super(context, resource, textViewResourceId, list);
        myItems_ref = (Vector<MyItems>) list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row, parent, false);

            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) row.getTag();
        }
        viewHolder.getText().setText(myItems_ref.get(position).getsName());
        viewHolder.getImg().setImageResource(myItems_ref.get(position).getThumnails());

        return row;
    }
}
