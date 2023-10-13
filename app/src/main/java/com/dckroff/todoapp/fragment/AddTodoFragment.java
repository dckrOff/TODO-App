package com.dckroff.todoapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.dckroff.todoapp.R;
import com.dckroff.todoapp.databinding.FragmentAddTodoBinding;

public class AddTodoFragment extends Fragment {

    private FragmentAddTodoBinding binding;
    private String[] priorityList = {"High", "Medium", "Low"};
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> adapterPriority;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAddTodoBinding.inflate(inflater);
        View root = binding.getRoot();

        autoCompleteTextView = binding.actvPriority;
        adapterPriority = new ArrayAdapter<>(requireContext(), R.layout.list_item, priorityList);
        autoCompleteTextView.setAdapter(adapterPriority);

        autoCompleteTextView.setOnItemClickListener((adapterView, view, i, l) -> {
            String selectedPriority = adapterView.getItemAtPosition(i).toString();
//            autoCompleteTextView.setText(selectedPriority);
        });

        return root;
    }
}