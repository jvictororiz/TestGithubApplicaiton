package br.com.cabal.testgithubapplicaiton.view.adapters;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.cabal.testgithubapplicaiton.view.fragment.SuperFragment;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private final List<SuperFragment> listFragments = new ArrayList<>();
    private final List<String> titles = new ArrayList<>();

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void add(SuperFragment fragment, String title) {
        listFragments.add(fragment);
        titles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragments.get(position);
    }
    @Override
    public int getCount() {
        return listFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}