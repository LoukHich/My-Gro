package com.ensah.mygroceryapp.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ensah.mygroceryapp.R;

import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<Article> articleList ;

    public HomeAdapter(Context context , List<Article> articleList){
        this.context = context;
        this.articleList= articleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTextViewName.setText(articleList.get(position).getName());
        holder.mTextViewUnit.setText(articleList.get(position).getUnite());
        holder.itemView.setOnClickListener(view -> {

            System.out.println(articleList.get(position).getName());

        });

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public  class ViewHolder  extends  RecyclerView.ViewHolder{

        TextView mTextViewName,mTextViewUnit,mTextViewInfo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName=itemView.findViewById(R.id.article_itemName);
            mTextViewUnit=itemView.findViewById(R.id.article_itemUnite);
        }
    }
}
