package com.ensah.mygroceryapp.ui.Course;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ensah.mygroceryapp.R;
import com.ensah.mygroceryapp.adapters.CourseAdapter;
import com.ensah.mygroceryapp.databinding.FragmentSlideshowBinding;
import com.ensah.mygroceryapp.db.DatabaseHelper;
import com.ensah.mygroceryapp.models.Article;
import com.ensah.mygroceryapp.models.Course;
import com.ensah.mygroceryapp.models.CoursesAdapter;
import com.ensah.mygroceryapp.models.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class CourseFragment extends Fragment {
    RecyclerView courseRec;
    List<Course> coursesList;
    CoursesAdapter courseAdapter;
//    ProgressBar mProgressBar;
 //   ScrollView mScrollView ;
    DatabaseHelper databaseHelper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        ListsViewModel listsViewModel = new ListsViewModel();
//
//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        listsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View view = inflater.inflate(R.layout.fragment_course, container, false);
//        mScrollView=  view.findViewById(R.id.scrole_cors);
//        mProgressBar = view.findViewById(R.id.progress_cors);
//        mProgressBar.setVisibility(View.VISIBLE);
//        mScrollView.setVisibility(View.GONE);
        courseRec = view.findViewById(R.id.recycle_view_course);
        courseRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        coursesList = new ArrayList<>();
        courseAdapter = new CoursesAdapter(getContext(),coursesList);
        courseRec.setAdapter(courseAdapter);
        databaseHelper= DatabaseHelper.instanceOfDatabase(getContext());
        List<Course> courses = databaseHelper.getAllCourses();
        courses.stream().forEach(c-> System.out.println(c));
        for(Course course : courses){
            coursesList.add(course);
            courseAdapter.notifyDataSetChanged();
        }
//        mProgressBar.setVisibility(View.GONE);
//        mScrollView.setVisibility(View.VISIBLE);

        return view;

    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}