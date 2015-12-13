package org.androidtown.ui_design;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.home_tab_name);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_white_18dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_whatshot_black_18dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_subscriptions_black_18dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_person_black_18dp));

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch(tab.getPosition()) {
                    case 0:
                        toolbar.setTitle(R.string.home_tab_name);
                        tab.setIcon(R.drawable.ic_home_white_18dp);
                        break;
                    case 1:
                        toolbar.setTitle(R.string.whatshot_tab_name);
                        tab.setIcon(R.drawable.ic_whatshot_white_18dp);
                        break;
                    case 2:
                        toolbar.setTitle(R.string.subscription_tab_name);
                        tab.setIcon(R.drawable.ic_subscriptions_white_18dp);
                        break;
                    case 3:
                        toolbar.setTitle(R.string.person_tab_name);
                        tab.setIcon(R.drawable.ic_person_white_18dp);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 0:
                        tab.setIcon(R.drawable.ic_home_black_18dp);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_whatshot_black_18dp);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_subscriptions_black_18dp);
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_person_black_18dp);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
}
