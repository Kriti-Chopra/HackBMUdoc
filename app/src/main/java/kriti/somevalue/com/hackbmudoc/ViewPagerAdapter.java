package kriti.somevalue.com.hackbmudoc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch(i){
            case 0: return new Fragment1();
            case 1: return new Fragment2();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
