package com.yenvth.mystore.main;

import android.app.ActivityManager;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.yenvth.mystore.R;
import com.yenvth.mystore.bag.BagFragment;
import com.yenvth.mystore.favorites.FavoriteFragment;
import com.yenvth.mystore.home.HomeFragment;
import com.yenvth.mystore.profile.ProfileFragment;
import com.yenvth.mystore.shop.ShopFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NavigationBarView navigationBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAction();

//        navigationBarView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){
//
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                }
//                return false;
//            }
//
//        });
    }
    private void initView(){
        navigationBarView = findViewById(R.id.bottom_navi);
        navigationBarView.setItemIconTintList(null);

    }
    private void initAction(){

        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment  = null;
                switch (item.getItemId()){
                    case R.id.action_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.action_shop:
                        selectedFragment = new ShopFragment();
                        break;
                    case R.id.action_bag:
                        selectedFragment = new BagFragment();
                        break;
                    case R.id.action_favorite:
                        selectedFragment = new FavoriteFragment();
                        break;
                    case R.id.action_profile:
                        selectedFragment = new ProfileFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentManege, selectedFragment).commit();
                return true;
            }
        });

    }

}