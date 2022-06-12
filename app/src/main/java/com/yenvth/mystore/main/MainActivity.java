package com.yenvth.mystore.main;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationBarView;
import com.yenvth.mystore.R;
import com.yenvth.mystore.bag.BagFragment;
import com.yenvth.mystore.favorites.FavoriteFragment;
import com.yenvth.mystore.home.HomeFragment;
import com.yenvth.mystore.profile.ProfileFragment;
import com.yenvth.mystore.shop.ShopFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private NavigationBarView navigationBarView;
    private Fragment homeFragment = new HomeFragment();
    private Fragment shopFragment = new ShopFragment();
    private Fragment bagFragment = new BagFragment();
    private Fragment favoriteFragment = new FavoriteFragment();
    private Fragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        loadFragment(homeFragment);
        initView();
        initAction();

    }

    private void initView(){
        navigationBarView = findViewById(R.id.bottom_navi);
        navigationBarView.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentManager, new HomeFragment()).commit();


    }
    private void initAction(){
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment  = null;
                switch (item.getItemId()){
                    case R.id.action_home:
                        selectedFragment = homeFragment;
                        break;
                    case R.id.action_shop:
                        selectedFragment = shopFragment;
                        break;
                    case R.id.action_bag:
                        selectedFragment = bagFragment;
                        break;
                    case R.id.action_favorite:
                        selectedFragment = favoriteFragment;
                        break;
                    case R.id.action_profile:
                        selectedFragment = profileFragment;
                        break;
                    default:
                        selectedFragment =homeFragment;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentManager, selectedFragment).commit();
                return true;
            }
        });

    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.bottom_navi, fragment);
        transaction.commit();

    }

}