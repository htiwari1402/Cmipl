package com.cmipl.cmipl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class HomePage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		ImageView imgTradecoverage = (ImageView) findViewById(R.id.imgTradecoverage);
		ImageView imgOrder         = (ImageView) findViewById(R.id.imgOrderManagment);
		ImageView imgreports       = (ImageView) findViewById(R.id.imgreports);
		ImageView imghelp          = (ImageView) findViewById(R.id.imgHelp);
		ImageView imgNew           = (ImageView) findViewById(R.id.imgHomePageNew);
		ImageView imglocation      = (ImageView) findViewById(R.id.imgLoc);
		ImageView imgnew      = (ImageView) findViewById(R.id.imageView2);
		ImageView imgnot     = (ImageView) findViewById(R.id.imageView3);
		ImageView imgsyn      = (ImageView) findViewById(R.id.imageView10);
		imglocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			
				Intent i= new Intent(HomePage.this, MyLocation.class);
				startActivity(i);
			}
		});
		
		
		imgNew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomePage.this, NewAddRetailer.class);
				startActivity(i);
			}
		});
imgsyn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(HomePage.this, "Under Construction", Toast.LENGTH_LONG).show();
				//Intent i = new Intent(HomePage.this, Help.class);
				//startActivity(i);
			}
		});
imgnot.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(HomePage.this, "Under Construction", Toast.LENGTH_LONG).show();
				//Intent i = new Intent(HomePage.this, Help.class);
				//startActivity(i);
			}
		});
imgnew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(HomePage.this, "Under Construction", Toast.LENGTH_LONG).show();
				//Intent i = new Intent(HomePage.this, Help.class);
				//startActivity(i);
			}
		});
		imghelp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Toast.makeText(HomePage.this, "Under Construction", Toast.LENGTH_LONG).show();
				//Intent i = new Intent(HomePage.this, Help.class);
				//startActivity(i);
			}
		});
		imgTradecoverage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomePage.this, TradeCoverage.class);
				startActivity(i);
				
			}
		});
		
		imgOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(HomePage.this, OrderManagement.class);
				startActivity(i);
			}
		});
		
		imgreports.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(HomePage.this, Reports.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
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
