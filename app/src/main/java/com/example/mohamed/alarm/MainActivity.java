package com.example.mohamed.alarm;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.mohamed.alarm.AlarmDirectory.AlarmFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AlarmFragment.OnFragmentInteractionListener
        ,TimerFragment.OnFragmentInteractionListener
        ,StopWatchFragment.OnFragmentInteractionListener{
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        tabLayout.getTabAt(0).setIcon(R.drawable.alarm);
        tabLayout.getTabAt(1).setIcon(R.drawable.timer);
        tabLayout.getTabAt(2).setIcon(R.drawable.stopwatch);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more_tab_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class MyPageAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();
        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
        @Override
        public int getCount() {
            return mFragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
            addFragment(AlarmFragment.newInstance("alarm","fragment"),"Alarm");
            addFragment(TimerFragment.newInstance("stopwatch","fragment"),"Timer");
            addFragment(StopWatchFragment.newInstance("stopwatch","fragment"),"StopWatch");
        }

    }
}
