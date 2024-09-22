package com.example.room.FavProducts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.room.AllProducts.OnProductClickListener;
import com.example.room.Model.Products;
import com.example.room.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    ArrayList<Products> pro;
    Context context;
    OnFavClickListener listener;

    public FavAdapter(Context context, List list, OnFavClickListener listener){
        this.context = context;
        if(list != null) {
            pro = (ArrayList<Products>) list;
        }else{
            pro = new ArrayList<>();
            Toast.makeText(this.context,"No Products added",Toast.LENGTH_SHORT).show();
        }
        this.listener = listener;
    }

    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {
        Products products = pro.get(position);
        holder.tvTitle.setText(pro.get(position).getTitle());
        holder.tvBrand.setText(pro.get(position).getBrand());
        holder.tvPrice.setText(""+pro.get(position).getPrice());
        holder.tvDes.setText(pro.get(position).getDescription());
        holder.ratingBar.setRating((float) pro.get(position).getRating());
        Glide.with(this.context).load(pro.get(position).getThumbnail()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground).into(holder.imageView);

        holder.btnDel.setOnClickListener(v -> {
            listener.onDeleteClick(products);
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
        Button btnDel;

        public ViewHolder(View convertView) {
            super(convertView);
            this.convertView = convertView;

            tvTitle = convertView.findViewById(R.id.tvTitleVal2);
            tvBrand = convertView.findViewById(R.id.tvBrandVal2);
            tvPrice = convertView.findViewById(R.id.tvPriceVal2);
            tvDes = convertView.findViewById(R.id.tvDescriptionVal2);
            imageView = convertView.findViewById(R.id.imFav);
            ratingBar = convertView.findViewById(R.id.ratingBar2);
            btnDel = convertView.findViewById(R.id.btnDelete);
        }
    }

    public void setList(List<Products> products){
        pro = (ArrayList<Products>) products;
    }
}
