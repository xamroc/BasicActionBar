package com.example.basicactionbar;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar ab = getActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = ab.newTab().setText(R.string.frag1).setTabListener(new MyTabListener(this, Fragment1.class.getName()));
		ab.addTab(tab);
		
		tab = ab.newTab().setText(R.string.frag2).setTabListener(new MyTabListener(this, Fragment2.class.getName()));
		ab.addTab(tab);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class MyTabListener implements ActionBar.TabListener
	{
		private Fragment mFragment;
		private final Activity mActivity;
		private final String mFragName;
		
		public MyTabListener(Activity activity, String fragName) {
			mActivity = activity;
			mFragName = fragName;
		}

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mFragment = Fragment.instantiate(mActivity, mFragName);
			ft.add(android.R.id.content, mFragment);
			
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			ft.remove(mFragment);
			mFragment = null;
			
		}
		
	}

}
