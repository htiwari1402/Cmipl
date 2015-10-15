package com.cmipl.cmipl_app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TradeCoverage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trade_coverage);
		
		final Button route = (Button) findViewById(R.id.btnTradecoverageRoute);
		final Button near = (Button) findViewById(R.id.btnTradecoverageNear);
		final Button map = (Button) findViewById(R.id.btnTradecoverageMap);
		
		
		
		
		
		FragmentManager fm = getFragmentManager();
	final	Fragment frag_route = fm.findFragmentById(R.id.fragmentTradecoverage_route);
	final	Fragment frg_near = fm.findFragmentById(R.id.fragmentTradecoverage_Near);
	final	Fragment frg_map = fm.findFragmentById(R.id.fragmentTradeCoverageMap);
		  FragmentTransaction ft = getFragmentManager().beginTransaction();
	      ft.show(frag_route) ;
	      ft.hide(frg_near);
	      ft.hide(frg_map);
	      ft.commit();
	      route.setBackgroundColor(Color.WHITE);
	       
		    
		    
		    near.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					FragmentTransaction ft = getFragmentManager().beginTransaction();
				      ft.hide(frag_route) ;
				      ft.show(frg_near);
				      ft.hide(frg_map);
				      ft.commit();
				      route.setBackgroundColor(Color.rgb(0, 176, 240));
				      map.setBackgroundColor(Color.rgb(0, 176, 240));
				      near.setBackgroundColor(Color.WHITE);
				}
			});
		
		    route.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					FragmentTransaction ft = getFragmentManager().beginTransaction();
				      ft.hide(frg_near) ;
				      ft.show(frag_route);
				      ft.hide(frg_map);
				      ft.commit();
				      near.setBackgroundColor(Color.rgb(0, 176, 240));
				      map.setBackgroundColor(Color.rgb(0, 176, 240));
				      route.setBackgroundColor(Color.WHITE);
				}
			});
		    
		    
		    map.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					FragmentTransaction ft = getFragmentManager().beginTransaction();
				      ft.hide(frag_route) ;
				      ft.show(frg_map);
				      ft.hide(frg_near);
				      ft.commit();
				      route.setBackgroundColor(Color.rgb(0, 176, 240));
				      near.setBackgroundColor(Color.rgb(0, 176, 240));
				      map.setBackgroundColor(Color.WHITE);
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.trade_coverage, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
