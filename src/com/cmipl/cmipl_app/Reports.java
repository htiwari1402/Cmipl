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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Reports extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reports);
		final Button b = (Button) findViewById(R.id.btnMMPR);
		final Button b2 = (Button) findViewById(R.id.btnMDC);
		final Button b3 = (Button) findViewById(R.id.btnDUMTR);
		final Button b4 = (Button) findViewById(R.id.btnTop10);
		final Button b5 = (Button) findViewById(R.id.btnMumtr);
		
		final TextView t = (TextView) findViewById(R.id.txtReportTitle);
		FragmentManager fm = getFragmentManager();
		final Fragment mumtr = fm.findFragmentById(R.id.fragment1);
		final Fragment dumtr = fm.findFragmentById(R.id.fragment2);
		
		  FragmentTransaction ft = getFragmentManager().beginTransaction();
	      ft.show(mumtr) ;
	      ft.hide(dumtr);
	     
	      ft.commit();
	      
	      b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				 FragmentTransaction ft = getFragmentManager().beginTransaction();
			      ft.show(mumtr) ;
			      ft.hide(dumtr);
			     
			      ft.commit();
			      t.setText("My Monthly Performance Reports");
			}
		});
	      b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = getFragmentManager();
				 FragmentTransaction ft = getFragmentManager().beginTransaction();
			      ft.show(dumtr) ;
			      ft.hide(mumtr);
			     
			      ft.commit();
			      t.setText("Daily Under My Team Report");
			}
		});
	      
	      b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(Reports.this, "This Module is under construction", Toast.LENGTH_LONG).show();
			}
		});
	      b4.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(Reports.this, "This Module is under construction", Toast.LENGTH_LONG).show();
				}
			});
	      b5.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(Reports.this, "This Module is under construction", Toast.LENGTH_LONG).show();
				}
			});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reports, menu);
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
