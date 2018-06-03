package com.quizapp.jitcodez.quizapp.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.quizapp.jitcodez.quizapp.Adapters.PagerAdapter;
import com.quizapp.jitcodez.quizapp.R;

public class TabActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    TabLayout tabLayout ;
     ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.theory));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.quiz));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.program));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.interview));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

         viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener()
        { @Override public boolean onNavigationItemSelected(MenuItem menuItem) {
            menuItem.setChecked(true);
            drawer.closeDrawers();
            int val=menuItem.getItemId();
            switch(val)
            {
                case R.id.nav_pgm:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.nav_theory:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.nav_interview:
                    viewPager.setCurrentItem(3);

                    break;
                case R.id.nav_quiz:
                    viewPager.setCurrentItem(1);
                    break;

            }
            return true; } });
    }


}
