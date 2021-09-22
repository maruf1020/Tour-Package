package com.example.tourpackage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends  RecyclerView.Adapter<TourViewHolder>{


    private Context mContext;
    private List<TourData> myTourList;

    public MyAdapter(Context mContext, List<TourData> myTourList) {
        this.mContext = mContext;
        this.myTourList = myTourList;
    }

    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_rowitem,parent,false);

        return new TourViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TourViewHolder holder, int position) {

        holder.imageView.setImageResource(myTourList.get(position).getItemImage());
        holder.mTitle.setText(myTourList.get(position).getItemName());
        holder.mDescription.setText(myTourList.get(position).getItemDescription());
        holder.mPrice.setText(myTourList.get(position).getItemPrice());

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(mContext,DetailActivity.class);
                intent.putExtra("Title",myTourList.get(holder.getAdapterPosition()).getItemName());
                intent.putExtra("Image",myTourList.get(holder.getAdapterPosition()).getItemImage());
                intent.putExtra("Description",myTourList.get(holder.getAdapterPosition()).getItemDescription());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return myTourList.size();
    }
}




    class TourViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView mTitle, mDescription,mPrice;
        CardView mCardView;


        public TourViewHolder( View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivImage);
            mTitle = itemView.findViewById(R.id.tvTitle);
            mDescription =itemView.findViewById(R.id.tvDescription);
            mPrice = itemView.findViewById(R.id.tvPrice);

            mCardView = itemView.findViewById(R.id.myCardView);
        }
    }

