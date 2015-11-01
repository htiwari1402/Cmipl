package com.cmipl.cmipl_app;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyLocation extends Activity {
	
	GoogleMap googlemap;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		
	AlertDialog.Builder alertbox = new AlertDialog.Builder(MyLocation.this);
		alertbox.setIcon(R.drawable.ic_launcher);
		alertbox.setTitle("GPS not Active");
		alertbox.setMessage("Enable GPS Location in your mobile");
		alertbox.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Intent callGPSSettingIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
				startActivity(callGPSSettingIntent);
			}
		});
		
		alertbox.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		
		LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE );
		 boolean statusOfGPS = manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		 
		 if(!statusOfGPS){
			 
			 alertbox.show();
			 
			
			 
		 }
		
		googlemap = ((MapFragment) getFragmentManager().findFragmentById(
                R.id.MapfragmentLocation)).getMap();
		
		googlemap.setMyLocationEnabled(true);
		LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
		Criteria criteria = new Criteria();
		String provider = service.getBestProvider(criteria, false);
		Location location = service.getLastKnownLocation(provider);
		
		double a= location.getLatitude();
		double b = location.getLongitude();
		
		Toast.makeText(MyLocation.this, ""+a+b, Toast.LENGTH_LONG).show();
		
	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location, menu);
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
