package com.example.ravi.eshopdesign;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class Category extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

       /* actionBar  = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));*/
// add Contextual Mode Button
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager =(ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }
// add Contextual Mode Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewpager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ClothsFragment(), "Cloths");
        adapter.addFragment(new BeautyFragment(), "Beauty");
        adapter.addFragment(new AppliancesFragment(), "Appliances");
        adapter.addFragment(new BooksFragment(), "Books");
        adapter.addFragment(new ShoesFragment(), "Shoes");
        adapter.addFragment(new SlippersFragment(), "Slippers");
        adapter.addFragment(new GogglesFragment(), "Goggles");
        viewpager.setAdapter(adapter);
    }

    public void indian(View v ){
        Intent i = new Intent(Category.this,Indian_Wear.class);
        startActivity(i);
    }

    public void western(View v ){
        Intent i1 = new Intent(Category.this,Western_Wear.class);
        startActivity(i1);
    }

    public void foot(View v ){
        Intent i2 = new Intent(Category.this,Foot_Wear.class);
        startActivity(i2);
    }

    public void lingerie(View v ){
        Intent i3 = new Intent(Category.this,Lingerie_Sleepwear.class);
        startActivity(i3);
    }

    public void watches(View v ){
        Intent i4 = new Intent(Category.this,Watches_Wearables.class);
        startActivity(i4);
    }


}