package com.example.juancho.lab5;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import  android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;





//public class MainActivity extends AppCompatActivity  implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    public class MainActivity extends AppCompatActivity  implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager) findViewById(R.id.pager);//pager es la principal
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);


        viewPager.setOnPageChangeListener(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setIcon(R.drawable.map).setTabListener(this);
        actionBar.addTab(tab);

      //  ActionBar.Tab tab = actionBar.newTab().setText("Cine").setTabListener(this);
        tab = actionBar.newTab().setIcon(R.drawable.cine2).setTabListener(this);
        actionBar.addTab(tab);

        //  tab = actionBar.newTab().setText("Teatro").setTabListener(this);
        tab = actionBar.newTab().setIcon(R.drawable.teatro).setTabListener(this);
        actionBar.addTab(tab);

        //tab = actionBar.newTab().setText("Restaurante").setTabListener(this);
        tab = actionBar.newTab().setIcon(R.drawable.restaurante).setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setIcon(R.drawable.beer1).setTabListener(this);
        actionBar.addTab(tab);

        //tab = actionBar.newTab().setText("Lugares").setTabListener(this);
        tab = actionBar.newTab().setIcon(R.drawable.conocer2).setTabListener(this);
        actionBar.addTab(tab);


    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        getSupportActionBar().setSelectedNavigationItem(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    public class PagerAdapter extends FragmentPagerAdapter{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new Fragment_Mapa();
                case 1:
                    return new Fragment_cine();
                case 2:
                    return new Fragment_teatro();
                case 3:
                    return new Fragment_restaurante();
                case 4:
                    return new Fragment_rumba();
                case 5:
                    return new Fragment_ambiebte();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 6; //Se retorna el numero total de fragments de la app
        }
    }

}
