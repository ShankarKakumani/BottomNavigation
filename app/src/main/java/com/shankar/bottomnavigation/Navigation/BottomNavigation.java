package com.shankar.bottomnavigation.Navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shankar.bottomnavigation.Fragments.GamesFragment;
import com.shankar.bottomnavigation.Fragments.HomeFragment;
import com.shankar.bottomnavigation.Fragments.ProfileFragment;
import com.shankar.bottomnavigation.R;

public class BottomNavigation extends AppCompatActivity {


    final Fragment firstFragment = new HomeFragment();
    final Fragment secondFragment = new GamesFragment();
    final Fragment thirdFragment = new ProfileFragment();

    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = firstFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation();

    }


    @SuppressLint("NonConstantResourceId")
    private void bottomNavigation(){
        BottomNavigationView navigation = findViewById(R.id.navigation);
        fm.beginTransaction().add(R.id.frameLayout, thirdFragment, "3").hide(thirdFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, secondFragment, "2").hide(secondFragment).commit();
        fm.beginTransaction().add(R.id.frameLayout, firstFragment, "1").commit();

        navigation.setSelectedItemId(R.id.home);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    fm.beginTransaction().hide(active).show(firstFragment).commit();
                    active = firstFragment;

                    return true;

                case R.id.games:
                    fm.beginTransaction().hide(active).show(secondFragment).commit();
                    active = secondFragment;
                    return true;

                case R.id.profile:
                    fm.beginTransaction().hide(active).show(thirdFragment).commit();
                    active = thirdFragment;
                    return true;
            }
            return false;
        });
    }

}