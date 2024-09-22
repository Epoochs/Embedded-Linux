package com.example.fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements MyStaticFragment.Counting {

    DynamincFragment dynamincFragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        /* Creating the Dynamic Fragment */
        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            System.out.println("savedInstanceState");
            dynamincFragment = new DynamincFragment();
            fragmentTransaction.add(R.id.fragmentContainerView3, dynamincFragment, "dynamic_fragment");
            fragmentTransaction.commit();
        }else{
            dynamincFragment = (DynamincFragment) fragmentManager.findFragmentByTag("dynamic_fragment");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void count(int counter) {
        System.out.println(counter);
        if(dynamincFragment != null) {
            dynamincFragment.updateCounter(counter);
        }
    }
}