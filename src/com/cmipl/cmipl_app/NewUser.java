package com.cmipl.cmipl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_user);
		
		RelativeLayout rnext         = (RelativeLayout) findViewById(R.id.relativeNewUserNext);
		final EditText name          = (EditText) findViewById(R.id.editxtNewRetailerName);
    	final EditText address       = (EditText) findViewById(R.id.editxtNewRetailerAddressLine);
	 	final EditText state         = (EditText) findViewById(R.id.editxtNewRetailerState);
		final EditText district      = (EditText) findViewById(R.id.EditxtNewRetailerDistrict);
		final EditText area          = (EditText) findViewById(R.id.editxtNewRetailerArea);
		final EditText pincode       = (EditText) findViewById(R.id.editxtNewRetailerPincode);
		final EditText contactno     = (EditText) findViewById(R.id.editxtNewRetailerContactNo);
		final EditText contactPerson = (EditText) findViewById(R.id.editxtNewRetailerContactPerson);
		final EditText city          = (EditText) findViewById(R.id.editxtNewRetailerCity);
		final EditText email         = (EditText) findViewById(R.id.edittxtNewRetailerEmail);
		final EditText vat           = (EditText) findViewById(R.id.edittxtNewRetailerVatTinNo);
		final EditText pan           = (EditText) findViewById(R.id.edittxtNewRetailerPan);
		final EditText cst           = (EditText) findViewById(R.id.edittxtNewRetailerCstTinNo);
		Button back                  = (Button)   findViewById(R.id.btnNewUserBack);
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		rnext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(NewUser.this, NewRetailer2.class);
				try{i.putExtra("name", name.getText().toString());
				i.putExtra("address", address.getText().toString());
				i.putExtra("state", state.getText().toString());
				i.putExtra("district", district.getText().toString());
				i.putExtra("area", area.getText().toString());
				i.putExtra("city", city.getText().toString());
				i.putExtra("contactno", contactno.getText().toString());
				i.putExtra("contactPerson", contactPerson.getText().toString());
				i.putExtra("email", email.getText().toString());
				i.putExtra("vat", vat.getText().toString());
				i.putExtra("pan", pan.getText().toString());
				i.putExtra("pincode", pincode.getText().toString());
				i.putExtra("CST", cst.getText().toString());
				}
				catch(Exception e){Toast.makeText(NewUser.this, e.toString(), Toast.LENGTH_LONG).show();}
				startActivity(i);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_user, menu);
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
