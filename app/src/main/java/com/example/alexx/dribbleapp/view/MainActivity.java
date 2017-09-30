package com.example.alexx.dribbleapp.view;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.alexx.dribbleapp.R;
import com.example.alexx.dribbleapp.view.shot_list.ShotListFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.drawer) NavigationView navigationView;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setUpDrawer();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, ShotListFragment.newInstance())
                .commit();

        List<Fragment> frag = getSupportFragmentManager().getFragments();

        Log.d("xgan68", frag.size() + "");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.open_drawer,         /* "open drawer" description */
                R.string.close_drawer
        );

        drawerLayout.setDrawerListener(mDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) {
                    drawerLayout.closeDrawers();

                    return true;
                }

                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.drawer_menu_home:
                        fragment = new ShotListFragment().newInstance();
                        Toast.makeText(MainActivity.this, "home clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.drawer_menu_likes:
                        Toast.makeText(MainActivity.this, "likes clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.drawer_menu_buckets:
                        Toast.makeText(MainActivity.this, "buckets clicked", Toast.LENGTH_LONG).show();
                        break;
                }

                if (fragment != null) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                    return true;
                }

                return true;
            }
        });
    }

}
