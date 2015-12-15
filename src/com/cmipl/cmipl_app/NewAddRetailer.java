package com.cmipl.cmipl_app;

import URL.Url;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class NewAddRetailer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_add_retailer);
		
		final EditText editName =( EditText) findViewById(R.id.editxtAddNewRetailerName);
		final EditText editAddres =( EditText) findViewById(R.id.editxtAddNewRetailerAddressLine);
		final EditText editcity =( EditText) findViewById(R.id.editxtAddNewRetailerCity);
		final EditText editDistrict =( EditText) findViewById(R.id.EditxtAddNewRetailerDistrict);
		final EditText editState =( EditText) findViewById(R.id.editxtAddNewRetailerState);
		final EditText editCountry =( EditText) findViewById(R.id.editxtAddNewRetailerArea);
		
		RelativeLayout reladd = (RelativeLayout)findViewById(R.id.relativeAddNewRetailerAdd);
		
		reladd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				String name     = editName.getText().toString();
				String address  = editAddres.getText().toString();
				String city     = editcity.getText().toString();
				String District = editDistrict.getText().toString();
				String state    = editState.getText().toString();
				String country  = editCountry.getText().toString();
				
				ServiceHandler sh = new ServiceHandler();
				sh.makeServiceCall(Url.URL+"AddRetailer.php?storeName="+name+"&address="+address+"&city="+city+"&district="+District+"&state="+state+"&country="+country+"", ServiceHandler.POST);
				Toast.makeText(NewAddRetailer.this, "Retailer Added", Toast.LENGTH_LONG).show();
				finish();
				}catch(Exception e){
					Toast.makeText(NewAddRetailer.this, "Enter Correct Values", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_add_retailer, menu);
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
