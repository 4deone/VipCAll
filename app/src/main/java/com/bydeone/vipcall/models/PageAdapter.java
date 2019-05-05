package com.bydeone.vipcall.models;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bydeone.vipcall.controllers.fragments.CampagneFragment;
import com.bydeone.vipcall.controllers.fragments.NewsFragment;
import com.bydeone.vipcall.controllers.fragments.UsersFragment;


public class PageAdapter extends FragmentPagerAdapter {

    //Default Constructor
    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: //Page number 1
                return NewsFragment.newInstance();
            case 1: //Page number 2
                return UsersFragment.newInstance();
            case 2: //Page number 3
                return CampagneFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: //Page number 1
                return "Fil d'actualité";
            case 1: //Page number 2
                return "Profil";
            case 2: //Page number 3
                return "Paramètre";
            default:
                return null;
        }
    }
}
