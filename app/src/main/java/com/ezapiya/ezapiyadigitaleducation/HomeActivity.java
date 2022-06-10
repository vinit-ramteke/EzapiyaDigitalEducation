package com.ezapiya.ezapiyadigitaleducation;

import com.ezapiya.ezapiyadigitaleducation.Model.createUser;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.ezapiya.ezapiyadigitaleducation.Model.loginPojo;
import com.ezapiya.ezapiyadigitaleducation.apiInterface.loginInterface;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    loginInterface LoginInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setNavigationViewListener();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);




        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadFragment(new homefregment());
        //loadFragment(new adduser());
    }
    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {


            case R.id.manageUser: {
                 loadFragment(new manageuser());
                break;
            }
            case R.id.class_: {
                 loadFragment(new class_());
                break;
            }
            case R.id.subject: {
                  loadFragment(new subject());
                break;
            }
            case R.id.chapter: {
                 loadFragment(new chapter());
                break;
            }
            case R.id.notes: {
                 loadFragment(new notes());
                break;
            }
            case R.id.question: {
                  loadFragment(new question());
                break;
            }
            case R.id.ChangePassword: {
                    loadFragment(new changepassword());
                    break;
            }
            case R.id.Logout: {
                logoutFunction();

                break;
            }

        }
        //close navigation drawer
        // mDrawerLayout.closeDrawer(GravityCompat.START);
        actionBarDrawerToggle.syncState();
        return true;
    }

    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void logoutFunction()
    {
        LoginInterface=RetrofitInstance.getRetrofit().create(loginInterface.class);
        Call<createUser> call = LoginInterface.logout("logout",Globle_data.loginData.getLoginkey());
        call.enqueue(new Callback<createUser>() {
            @Override
            public void onResponse(Call<createUser> call, Response<createUser> response) {
                createUser cu = new createUser();
                cu= response.body();
                Intent mainactivity = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(mainactivity);
                finish();
            }

            @Override
            public void onFailure(Call<createUser> call, Throwable t) {
                String xx = t.getMessage();
                Toast.makeText(HomeActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}