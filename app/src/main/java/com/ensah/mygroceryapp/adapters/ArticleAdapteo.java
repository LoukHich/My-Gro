package com.ensah.mygroceryapp.adapters;

import static com.ensah.mygroceryapp.activities.ArticleActivity.courseNameSelected;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.ensah.mygroceryapp.R;
import com.ensah.mygroceryapp.activities.ArticleActivity;
import com.ensah.mygroceryapp.activities.CourseArticleActivity;
import com.ensah.mygroceryapp.db.DatabaseHelper;
import com.ensah.mygroceryapp.models.Article;
import com.ensah.mygroceryapp.models.ArticleWithCount;
import com.ensah.mygroceryapp.models.ArticleWithInfo;

import java.util.List;
import java.util.ListIterator;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    Context context;
    List<ArticleWithInfo> articleList ;
    DatabaseHelper databaseHelper;
    public ArticleAdapter(Context context , List<ArticleWithInfo> articleList){
        this.context = context;
        this.articleList= articleList;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {
        holder.mTextViewName.setText(articleList.get(position).getArticle().getName());
        holder.mTextViewUnit.setText(articleList.get(position).getArticle().getUnite());
        holder.itemView.setOnClickListener(view -> {

            System.out.println(articleList.get(position).getArticle().getName());

        });

        holder.itemView.setOnClickListener(view -> {
            ArticleWithInfo articleClicked = articleList.get(position);

            databaseHelper  = DatabaseHelper.instanceOfDatabase(context);
            String str = String.format("ID: %d | Name: %s  | Desc: %s", articleClicked.getArticle().getId(), articleClicked.getArticle().getName(), articleClicked.getArticle().getUnite());
            System.out.println(str);
            if(  databaseHelper.CheckIsAlreadyInDB(courseNameSelected,articleClicked.getArticle().getName()) == false){
                databaseHelper.addArticleToCourse(courseNameSelected, articleClicked.getArticle().getName(), 1);
                CourseArticleActivity.articleList.add(new ArticleWithCount(articleClicked.getArticle().getId(),articleClicked.getArticle().getName(),articleClicked.getArticle().getUnite(),1));
                Toast.makeText(context, articleClicked.getArticle().getName()+" added successfully in "+courseNameSelected, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context,CourseArticleActivity.class));

            }else{
                databaseHelper.incrementCountInCourse(courseNameSelected,articleClicked.getArticle().getId());
                ListIterator<ArticleWithCount> iterator = CourseArticleActivity.articleList.listIterator();
                while (iterator.hasNext()){
                    ArticleWithCount arIn = iterator.next();
                    if(arIn.getId()==articleClicked.getArticle().getId()){

                        iterator.set(new ArticleWithCount(articleClicked.getArticle().getId(), articleClicked.getArticle().getName(), articleClicked.getArticle().getUnite(),arIn.getCount()+1));
                    }
                }
                context.startActivity(new Intent(context,CourseArticleActivity.class));
                Toast.makeText(context, articleClicked.getArticle().getName()+" increment successfully in "+courseNameSelected, Toast.LENGTH_SHORT).show();

                Log.e("ArticleActivity ","count incrimented");
            }
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
            mTextViewInfo=itemView.findViewById(R.id.article_txt_info);
        }
    }
}
