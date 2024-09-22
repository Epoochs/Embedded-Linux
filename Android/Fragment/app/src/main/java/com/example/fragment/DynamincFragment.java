package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DynamincFragment extends Fragment {

    private TextView tvCounterDis;
    private int Count = 0;
    private String str = "Count = ";

    public DynamincFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DynamincFragment", "Fragment created");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynaminc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCounterDis = view.findViewById(R.id.tvCountDisplay);
        if(savedInstanceState != null){
            Count = savedInstanceState.getInt("CountDynaminc");
        }
        tvCounterDis.setText(str + Count);
    }

    public void updateCounter(int count){
        Count = count;
        if(tvCounterDis != null) {
          //  tvCounterDis.setText("");
            tvCounterDis.setText(str + count);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CountDynaminc", Count);
    }
}