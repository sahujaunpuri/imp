package com.gnnsnowszerro.psngiftcardsgenerator.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.custom.CustomToolbar;
import com.gnnsnowszerro.psngiftcardsgenerator.helpers.PrefenceHelper;


public class MainFragment extends Fragment {

    public static final String ACTION_UPDATE = "action_update";

    public static final String TAG = "MainFragment";

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private CustomToolbar toolbar;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            toolbar.setCoinsText(String.valueOf(PrefenceHelper.getInstance(getContext()).loadCoins()));
        }
    };


    private IntentFilter filter = new IntentFilter(ACTION_UPDATE);

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        getContext().registerReceiver(receiver, filter);
        toolbar.setCoinsText(String.valueOf(PrefenceHelper.getInstance(getContext()).loadCoins()));
        Log.d(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        getContext().unregisterReceiver(receiver);
        Log.d(TAG,"onPause");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        toolbar = (CustomToolbar) view.findViewById(R.id.toolbar);

        toolbar.setLogo(R.mipmap.ic_launcher);

        toolbar.setCoinsText(String.valueOf(PrefenceHelper.getInstance(getContext()).loadCoins()));

        ((AppCompatActivity) getContext()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getContext()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        mSectionsPagerAdapter = new SectionsPagerAdapter(((AppCompatActivity) getContext()).getSupportFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        return view;
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
                    return getString(R.string.choose_coupon);
                case 1:
                    return getString(R.string.earn_coins);
                case 2:
                    return getString(R.string.instructions);
            }
            return null;
        }
    }
}
