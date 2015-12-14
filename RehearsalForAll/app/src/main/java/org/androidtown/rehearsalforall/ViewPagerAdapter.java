package org.androidtown.rehearsalforall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by shj-1 on 2015-12-12.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment homeTab = new HomeTab();
                return homeTab;
            case 1:
                Fragment whatshotTab = new WhatsHotTab();
                return whatshotTab;
            case 2:
                Fragment subscriptionTab = new SubscriptionTab();
                return subscriptionTab;
            case 3:
                Fragment personTab = new PersonTab();
                return personTab;
            default:
                return null;
        }
    }

}