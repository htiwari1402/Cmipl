package com.cmipl.cmipl_app;

import java.util.ArrayList;

import com.cmipl.cmipl_app.design.OrderBookingListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class OrderBooking extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_booking);
		
		Intent i = getIntent();
		final String retailername = i.getStringExtra("retailername");
		
		ListView list= (ListView) findViewById(R.id.listOrderBooking_List);
		Button save = (Button) findViewById(R.id.btnOrderbookingSave);
		
		ArrayList<String> product= new ArrayList<String>();
		product.add("Figaro pure 100ml");
		product.add("Figaro pure 200ml");
		product.add("Figaro EV 250ml");
		product.add("Bertoli Classic 500ml");
		product.add("Bertoli EV 200ml");
		product.add("Bertoli EV 2000ml");
		final OrderBookingListAdapter oadt= new OrderBookingListAdapter(OrderBooking.this, product,retailername);
		list.setAdapter(oadt);
	
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(OrderBooking.this, ConfirmOrderBooking.class);
				i.putExtra("retailername", retailername);
				startActivity(i);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order_booking, menu);
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
