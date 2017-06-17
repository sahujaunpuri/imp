package com.gnnsnowszerro.psngiftcardsgenerator.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.gnnsnowszerro.psngiftcardsgenerator.fragments.CouponsListFragment;
import com.gnnsnowszerro.psngiftcardsgenerator.custom.CustomToolbar;
import com.gnnsnowszerro.psngiftcardsgenerator.fragments.EarnListFragment;
import com.gnnsnowszerro.psngiftcardsgenerator.fragments.InstructionsListFragment;
import com.gnnsnowszerro.psngiftcardsgenerator.R;

public class MainActivity extends AppCompatActivity{


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private CustomToolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (CustomToolbar) findViewById(R.id.toolbar);

        toolbar.setLogo(R.drawable.icon);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        toolbar.setCoinsText("12");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("sadnjkdsa");

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return CouponsListFragment.newInstance();
                case 1:
                    return EarnListFragment.newInstance();
                case 2:
                    return InstructionsListFragment.newInstance();
                default:
                    return CouponsListFragment.newInstance();

            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
