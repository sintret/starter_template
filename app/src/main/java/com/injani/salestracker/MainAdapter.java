package com.injani.salestracker;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by andi on 6/20/2016.
 */
public class MainAdapter extends FragmentPagerAdapter {
    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "Home", "Log View" };


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public MainAdapter(FragmentManager fm) {
        super(fm);

        //this.Titles = mTitles;
        this.NumbOfTabs = PAGE_COUNT;
    }

    //This method return the fragment for the every position in the View Pager

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabHome tab1 = new TabHome();
                return tab1;
            case 1:
                TabList tab2 = new TabList();
                return tab2;

            default:
                return null;
        }
    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}