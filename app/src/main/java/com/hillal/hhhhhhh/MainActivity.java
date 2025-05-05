package com.hillal.hhhhhhh;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hillal.hhhhhhh.databinding.ActivityMainBinding;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate started");
        try {
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            Log.d(TAG, "Layout inflated successfully");

            // إعداد NavController
            NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.nav_host_fragment_content_main);
            if (navHostFragment != null) {
                navController = navHostFragment.getNavController();
                Log.d(TAG, "NavController initialized");
                
                appBarConfiguration = new AppBarConfiguration.Builder(
                        R.id.homeFragment,
                        R.id.reportsFragment
                ).build();
                NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
                Log.d(TAG, "ActionBar setup completed");
            } else {
                Log.e(TAG, "NavHostFragment is null - This is a critical error");
                return;
            }

            // ربط BottomNavigationView مع NavController
            BottomNavigationView bottomNav = binding.bottomNavView;
            if (bottomNav != null) {
                NavigationUI.setupWithNavController(bottomNav, navController);
                Log.d(TAG, "BottomNavigationView setup completed");
            } else {
                Log.e(TAG, "BottomNavigationView is null");
            }

            Log.d(TAG, "onCreate completed successfully");
        } catch (Exception e) {
            Log.e(TAG, "Critical error in onCreate", e);
            throw e;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        try {
            return navController.navigateUp() || super.onSupportNavigateUp();
        } catch (Exception e) {
            Log.e(TAG, "Error in onSupportNavigateUp", e);
            return super.onSupportNavigateUp();
        }
    }
}