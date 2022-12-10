package com.ensah.mygroceryapp.ui.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.ensah.mygroceryapp.R;
import com.ensah.mygroceryapp.databinding.FragmentSlideshowBinding;

public class CategoriesFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_categories, container,  false);
        return root;
//        CategoriesViewModel categoriesViewModel = new CategoriesViewModel();
//
//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        categoriesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}