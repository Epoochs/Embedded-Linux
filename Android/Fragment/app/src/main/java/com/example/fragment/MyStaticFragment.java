package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyStaticFragment extends Fragment {

    private Button btnCount;
    private Counting counterInterface;
    private int counterVal = 0;

    public interface Counting{
        void count(int counter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            counterVal = savedInstanceState.getInt("counter");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_static, container, false);
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // Ensure the activity implements the Counting interface
        try {
            counterInterface = (Counting) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement Counting");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCount = view.findViewById(R.id.btnCount);

        btnCount.setOnClickListener(v -> {
            counterVal++;
            updateCounter(counterVal);
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counterVal);
    }

    public void updateCounter(int counter){
        if(counterInterface != null) {
            counterInterface.count(counter);
        }
    }
}