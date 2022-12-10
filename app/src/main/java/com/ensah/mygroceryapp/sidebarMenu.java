package com.ensah.mygroceryapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;

import com.ensah.mygroceryapp.adapters.CourseAdapter;
import com.ensah.mygroceryapp.db.DatabaseHelper;
import com.ensah.mygroceryapp.models.ArticleWithInfo;
import com.ensah.mygroceryapp.models.Course;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.ensah.mygroceryapp.databinding.ActivitySidebarMenuBinding;

import java.util.List;

public class sidebarMenu extends AppCompatActivity {
    private ListView courseListView;
    List<Course> courseList;
    CourseAdapter courseAdapter;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivitySidebarMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySidebarMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarSidebarMenu.toolbar);
        binding.appBarSidebarMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_courses, R.id.nav_profil, R.id.nav_categories, R.id.nav_cust_categories, R.id.nav_cust_Products,
                R.id.nav_Group, R.id.nav_home, R.id.nav_Products)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




        DatabaseHelper databaseHelper = DatabaseHelper.instanceOfDatabase(this);
//        List<ArticleWithInfo> articleWithInfos = databaseHelper.getAllArtclewithInfo();
//        articleWithInfos.stream().forEach(a -> {
//            System.out.println(a.getArticle().getId() + " " + a.getArticle().getName() + " " + a.getInfo() + " ");
////        });
//        courseListView = findViewById();
//        System.out.println(courseListView);
//        courseList = databaseHelper.getAllCourses();
//        courseList.stream().forEach(c-> System.out.println(c.getName()));
//        courseAdapter = new CourseAdapter(getApplicationContext(), courseList);
//        courseListView.setAdapter(courseAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidebar_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sidebar_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//    private void initWidget() {
//        courseListView = findViewById(R.id.list_view_product);
//        Log.e("MAINACTIVITY: ", "CourseListView initialise");
//    }
}