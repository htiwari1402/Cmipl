package com.cmipl.cmipl_app;

import database.Database;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OderDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oder_details);
		
		
		Intent i = getIntent();
		final String name = i.getStringExtra("product");
		final String retailername = i.getStringExtra("retailername");
		
		final EditText ordernotxt = (EditText) findViewById(R.id.edittxtOrderDetailNoofOrders);
		EditText schemetxt = (EditText) findViewById(R.id.edittxtOrderDetailScheme);
		EditText Discounttxt = (EditText) findViewById(R.id.edittxtOrderDetailDiscount);
		
		final TextView producttxt = (TextView) findViewById(R.id.txtOrderDetilProductname);
		final TextView retailertxt = (TextView) findViewById(R.id.txtOrderDetailsRetailerName);
		
		Button save = (Button) findViewById(R.id.btnOrderDetailSave);
		Button cancel = (Button) findViewById(R.id.btnOrderDetailCancel);
		
		
		
		
		retailertxt.setText(retailername);
		producttxt.setText(name);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Toast.makeText(OderDetails.this, "Value inserted", Toast.LENGTH_SHORT).show();
				finish();
			
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.oder_details, menu);
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
