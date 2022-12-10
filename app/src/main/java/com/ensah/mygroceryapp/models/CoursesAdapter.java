package com.ensah.mygroceryapp.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ensah.mygroceryapp.R;
import com.ensah.mygroceryapp.activities.CourseArticleActivity;
import com.ensah.mygroceryapp.activities.MainActivity;

import java.util.List;

public class CoursesAdapter   extends RecyclerView.Adapter<CoursesAdapter.ViewHolder>{

    Context context;
    List<Course> courseList ;

    public CoursesAdapter(Context context , List<Course> courseList){
        this.context = context;
        this.courseList= courseList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nav_course_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Glide.with(context).load(courseList.get(position).get)
        holder.mTextViewName.setText(courseList.get(position).getName());
        holder.mTextViewDesc.setText(courseList.get(position).getDescription());
        holder.itemView.setOnClickListener(view -> {

            System.out.println(courseList.get(position).getName());
            Intent articleIntent = new Intent(context, CourseArticleActivity.class);
            articleIntent.putExtra(Article.COURSE_NAME, courseList.get(position).getName());
            context.startActivity(articleIntent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public  class ViewHolder  extends  RecyclerView.ViewHolder{

        TextView mTextViewName,mTextViewDesc,mTextViewCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewName=itemView.findViewById(R.id.course_name);
            mTextViewDesc=itemView.findViewById(R.id.course_description);
            //mTextViewCount=itemView.findViewById(R.id.course_count);
        }
    }
}
