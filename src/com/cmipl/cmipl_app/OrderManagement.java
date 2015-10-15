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

public class OrderManagement extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_management);
		final Button route = (Button) findViewById(R.id.btnOrderManagementRoute);
		final Button near = (Button) findViewById(R.id.btnOrderManagementNear);
		final Button map = (Button) findViewById(R.id.btnOrderManagementMap);
		
		
	
		
		
		FragmentManager fm = getFragmentManager();
	final	Fragment frag_route = fm.findFragmentById(R.id.fragmentOrderManagment_Route);
	final	Fragment frg_near = fm.findFragmentById(R.id.fragmentOrderManagment_Near);
	final Fragment  frg_map = fm.findFragmentById(R.id.fragmentOrdermanagmentMap);
	
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
					      ft.show(frg_near) ;
					      ft.hide(frag_route);
					      ft.hide(frg_map);
					      ft.commit();
					      map.setBackgroundColor(Color.rgb(0, 176, 240));
					      route.setBackgroundColor(Color.rgb(0, 176, 240));
					      near.setBackgroundColor(Color.WHITE);
				}
			});
		
		    route.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					FragmentTransaction ft = getFragmentManager().beginTransaction();
				      ft.show(frag_route) ;
				      ft.hide(frg_near);
				      ft.hide(frg_map);
				      ft.commit();
				      map.setBackgroundColor(Color.rgb(0, 176, 240));
				      near.setBackgroundColor(Color.rgb(0, 176, 240));
				      route.setBackgroundColor(Color.WHITE);
				}
			});
		    
		    
		    map.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					FragmentTransaction ft = getFragmentManager().beginTransaction();
					      ft.hide(frag_route) ;
					      ft.hide(frg_near);
					      ft.show(frg_map);
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
		getMenuInflater().inflate(R.menu.order_management, menu);
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
