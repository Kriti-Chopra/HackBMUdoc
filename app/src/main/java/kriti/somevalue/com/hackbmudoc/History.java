package kriti.somevalue.com.hackbmudoc;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class History extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        bottomNavigationView=(BottomNavigationView) findViewById(R.id.bottomNavBar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_one: viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_two: viewPager.setCurrentItem(1);
                        break;
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch(i)
                {
                    case 0: bottomNavigationView.setSelectedItemId(R.id.menu_one);
                        //Toast.makeText(MainActivity.this, "One selected", Toast.LENGTH_SHORT).show();
                        break;
                    case 1: bottomNavigationView.setSelectedItemId(R.id.menu_two);
                        break;

                }


            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

}
