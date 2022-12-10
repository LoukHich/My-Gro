package com.ensah.mygroceryapp.ui.products;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ensah.mygroceryapp.R;
import com.ensah.mygroceryapp.adapters.CourseAdapter;
import com.ensah.mygroceryapp.databinding.FragmentSlideshowBinding;
import com.ensah.mygroceryapp.db.DatabaseHelper;
import com.ensah.mygroceryapp.models.Article;
import com.ensah.mygroceryapp.models.ArticleWithInfo;
import com.ensah.mygroceryapp.models.Course;
import com.ensah.mygroceryapp.models.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {

    RecyclerView  articleRec;
    List<Article> aticleList;
    HomeAdapter homeAdapter;
    ProgressBar mProgressBar;
    ScrollView mScrollView ;
    DatabaseHelper databaseHelper;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        ProductsViewModel productsViewModell = new ProductsViewModel();

//        List<ArticleWithInfo> articleWithInfos = databaseHelper.getAllArtclewithInfo();
//        articleWithInfos.stream().forEach(a -> {
//            System.out.println(a.getArticle().getId() + " " + a.getArticle().getName() + " " + a.getInfo() + " ");
//        });

//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        productsViewModell.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;


        View view = inflater.inflate(R.layout.fragment_products, container,  false);
        mScrollView=  view.findViewById(R.id.scrole_prod);
        mProgressBar = view.findViewById(R.id.progress_prod);
        mProgressBar.setVisibility(View.VISIBLE);
        mScrollView.setVisibility(View.GONE);

//        databaseHelper= DatabaseHelper.instanceOfDatabase(getContext());
//        courseListView = root.findViewById(R.id.list_view_product);
//        courseList = databaseHelper.getAllCourses();
//        courseList.stream().forEach(c-> System.out.println(c.getName()));
//        courseAdapter = new CourseAdapter(getContext(), courseList);
//        courseListView.setAdapter(courseAdapter);
        //------------------------------------------------------------------------
           articleRec = view.findViewById(R.id.recycle_view_prod);
           articleRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
           aticleList = new ArrayList<>();
           homeAdapter = new HomeAdapter(getContext(),aticleList);
           articleRec.setAdapter(homeAdapter);
           databaseHelper= DatabaseHelper.instanceOfDatabase(getContext());
           List<Article> articles = databaseHelper.getAllArticles();
           for(Article article : articles){
               aticleList.add(article);
               homeAdapter.notifyDataSetChanged();
           }
        mProgressBar.setVisibility(View.GONE);
        mScrollView.setVisibility(View.VISIBLE);
        return view;

    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}