package com.dckroff.todoapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dckroff.todoapp.model.Todo;
import com.dckroff.todoapp.adapter.TodoAdapter;
import com.dckroff.todoapp.databinding.FragmentHomeBinding;
import com.xw.repo.widget.BounceScrollView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<Todo> todoList = new ArrayList<>();
    private ArrayList<Todo> completedTodoList = new ArrayList<>();
    private RecyclerView rvTodo, rvCompletedTodo;
    private TodoAdapter todoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater);
        View root = binding.getRoot();

        rvTodo = binding.rvToDos;
        rvCompletedTodo = binding.rvCompletedTodos;

        getTodoListFromServer();
        setToDoAdapter();
        setCompletedToDoAdapter();

        return root;
    }

    private void getTodoListFromServer() {
        // TODO
        todoList.add(new Todo(0, 2, "Домашка по математики", "", "", false));
        todoList.add(new Todo(0, 1, "Домашка по физике", "", "", false));
        todoList.add(new Todo(0, 3, "Need to finish ui of own site", "", "", false));
        todoList.add(new Todo(0, 2, "UX", "", "", false));
        todoList.add(new Todo(0, 1, "Learn React NativeLearn React Native", "", "", false));
        todoList.add(new Todo(0, 1, "Домашка по физике", "", "", false));
        todoList.add(new Todo(0, 3, "Домашка по физике", "", "", false));
        todoList.add(new Todo(0, 3, "Домашка по физике", "", "", false));

        completedTodoList.add(new Todo(0, 2, "Домашка по математики", "http://ic.pics.livejournal.com/nata_xo/26601373/17912/17912_original.jpg", "12.10.2023 | 10:16", true));
        completedTodoList.add(new Todo(0, 1, "Домашка по физике", "https://i.pinimg.com/originals/c1/ce/4a/c1ce4a1dfe3a10183a4e9b1e8efe5d57.jpg", "12.10.2023 | 10:16", true));
        completedTodoList.add(new Todo(0, 3, "Need to finish ui of own site", "", "12.10.2023 | 10:16", true));
        completedTodoList.add(new Todo(0, 2, "UX", "https://i.pinimg.com/originals/83/8f/81/838f8169a01d494321bf4a54d5f9985a.jpg", "12.10.2023 | 10:16", true));
        completedTodoList.add(new Todo(0, 1, "Learn React NativeLearn React Native", "", "12.10.2023 | 10:16", true));
        completedTodoList.add(new Todo(0, 1, "Домашка по физике", "", "13.10.2023 | 23:45", true));
        completedTodoList.add(new Todo(0, 3, "Домашка по физике", "", "13.10.2023 | 23:45", true));
        completedTodoList.add(new Todo(0, 3, "Домашка по физике", "", "13.10.2023 | 23:45", true));

    }

    private void setToDoAdapter() {
        todoAdapter = new TodoAdapter(requireContext(), todoList);
        rvTodo.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        rvTodo.setAdapter(todoAdapter);
    }

    private void setCompletedToDoAdapter() {
        todoAdapter = new TodoAdapter(requireContext(), completedTodoList);
        rvCompletedTodo.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        rvCompletedTodo.setAdapter(todoAdapter);
    }
}