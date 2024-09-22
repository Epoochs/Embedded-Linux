package com.example.room.AllProducts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.room.Model.Products;
import com.example.room.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.ViewHolder> {

    ArrayList<Products> pro;
    Context context;
    OnProductClickListener listener;

    public AllProductAdapter(Context context, List list, OnProductClickListener listener){
        if(list != null) {
            pro = (ArrayList<Products>) list;
        }else{
            pro = new ArrayList<>();
        }
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AllProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.product_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull AllProductAdapter.ViewHolder holder, int position) {
        Products products = pro.get(position);
        holder.tvTitle.setText(pro.get(position).getTitle());
        holder.tvBrand.setText(pro.get(position).getBrand());
        holder.tvPrice.setText(""+pro.get(position).getPrice());
        holder.tvDes.setText(pro.get(position).getDescription());
        holder.ratingBar.setRating((float) pro.get(position).getRating());
        Glide.with(this.context).load(pro.get(position).getThumbnail()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(holder.imageView);

        holder.btnAddFav.setOnClickListener(v -> {
            listener.onFavClick(products);
        });
    }

    @Override
    public int getItemCount() {
        return pro.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvDes, tvBrand, tvPrice;
        RatingBar ratingBar;
        ImageView imageView;
        View convertView;
        Button btnAddFav;

        public ViewHolder(View convertView) {
            super(convertView);
            this.convertView = convertView;

            tvTitle = convertView.findViewById(R.id.tvTitleVal);
            tvBrand = convertView.findViewById(R.id.tvBrandVal);
            tvPrice = convertView.findViewById(R.id.tvPriceVal);
            tvDes = convertView.findViewById(R.id.tvDescriptionVal);
            imageView = convertView.findViewById(R.id.imProduct);
            ratingBar = convertView.findViewById(R.id.ratingBar);
            btnAddFav = convertView.findViewById(R.id.btnAddFav);
        }
    }

    public void setList(List<Products> products){
        pro = (ArrayList<Products>) products;
    }
}
