package com.cmipl.cmipl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ConfirmOrderBooking extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_order_booking);
		
		Intent i = getIntent();
		final String retailername = i.getStringExtra("retailername");
		
		TextView retailernametxt = (TextView) findViewById(R.id.txtConfirmOrderBookingRetailerName);
		retailernametxt.setText(retailername);
		
		ListView list = (ListView) findViewById(R.id.listConfirmOrderBookingList);
		Button edit = (Button) findViewById(R.id.btnConfirmOrderBookingEdit);
		Button confirm = (Button) findViewById(R.id.btnConfirmOrderBookingConfirm);
		
	  String a[] ={"Figaro       2","Bertoli     3"};
	  
	  ArrayAdapter<String> adt= new ArrayAdapter<String>(ConfirmOrderBooking.this, android.R.layout.simple_list_item_1, a);
	  list.setAdapter(adt);
	  
	  edit.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(ConfirmOrderBooking.this, OrderBooking.class);
			i.putExtra("retailername", retailername);
			startActivity(i);
		}
	});
	  
	  confirm.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(ConfirmOrderBooking.this, TradeCoverage.class);
			startActivity(i);
		}
	});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_order_booking, menu);
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
