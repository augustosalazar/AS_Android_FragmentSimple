package com.uninorte.androidfragmenttest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class MainActivity extends ActionBarActivity implements Fragment1.Callback {

    private Fragment1 mFrag1;
    private Fragment2 mFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment1())
                    .commit();
        }


        mFrag2 = new Fragment2();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFordward(int val) {
        Bundle args = new Bundle();
        args.putInt("someInt", val);
        mFrag2.setArguments(args);

        FragmentTransaction ft = this
                .getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, mFrag2)
                .addToBackStack("mFragment2").commit();

    }
}
