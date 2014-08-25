package mx.yobibytelabs.matrices;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import mx.yobibytelabs.matrices.adapters.MyPagerAdapter;


public class MainActivity extends ActionBarActivity {

    MyPagerAdapter adapter;
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager  = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(myPagerAdapter);
    }



}
