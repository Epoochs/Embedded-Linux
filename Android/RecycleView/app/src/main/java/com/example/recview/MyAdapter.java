package com.example.recview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Vector;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    Vector<Products> pro;
    Context context;

    public MyAdapter(Context context, List list){
        pro = (Vector<Products>) list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.resycl,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(pro.get(position).getTitle());
        holder.tvBrand.setText(pro.get(position).getBrand());
        holder.tvPrice.setText(""+pro.get(position).getPrice());
        holder.tvDescription.setText(pro.get(position).getDescription());
        holder.ratingBar.setRating((float) pro.get(position).getRatings());
        holder.DownloadImages(position);

    }

    @Override
    public int getItemCount() {
        return pro.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTitle, tvBrand, tvPrice, tvDescription;
        RatingBar ratingBar;
        View convertView;

        public ViewHolder(View convertView) {
            super(convertView);
            this.convertView = convertView;

            tvTitle = convertView.findViewById(R.id.tvTitle);
            tvBrand = convertView.findViewById(R.id.tvBrand);
            tvPrice = convertView.findViewById(R.id.tvPrice);
            tvDescription = convertView.findViewById(R.id.tvDescription);
            img = convertView.findViewById(R.id.imageView);
            ratingBar = convertView.findViewById(R.id.ratingBar);
        }
        public void DownloadImages(int pos){
            new DownloadImage(img).execute(pro.get(pos).getImgURL());
        }
    }
}
