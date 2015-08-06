package com.example.actiontabexample;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Context;
import android.widget.Toast;

public class DummyTabListener implements TabListener {
	
    public Context context;

    public DummyTabListener(Context context) {
	// TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
                Toast.makeText(context, "Reselected!", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
                Toast.makeText(context, "Selected!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
                Toast.makeText(context, "Unselected!", Toast.LENGTH_SHORT).show();
    }
    
}
