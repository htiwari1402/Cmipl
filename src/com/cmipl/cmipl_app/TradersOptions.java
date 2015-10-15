package com.cmipl.cmipl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TradersOptions extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traders_options);
		
		TextView tradername= (TextView)findViewById(R.id.txtTraderOptionsStoreName);
		TextView visitno = (TextView)findViewById(R.id.txtTraderOptionsStoreVisitNo);
		
		Intent i = getIntent();
		final String trader = i.getStringExtra("tradername");
		final String visit=i.getStringExtra("visit");
		
		tradername.setText(trader);
		visitno.setText("Visit No-"+visit);
		Button btnOrderBooking= (Button)findViewById(R.id.btnTradersOption_OrederBooking);
		Button btnOrderEdit= (Button)findViewById(R.id.btnTradeOption_OrderEdit);
		Button btnInvoice= (Button)findViewById(R.id.btnTradeOption_Invoice);
		Button btnVisibility= (Button)findViewById(R.id.btnTradeOption_visibility);
		btnOrderBooking.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(TradersOptions.this, OrderBooking.class);
				i.putExtra("retailername", trader);
				startActivity(i);
				
			}
		});
	
	    btnOrderEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TradersOptions.this, OrderEdit.class);
				startActivity(i);
				
			}
		});
	    
	    btnInvoice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TradersOptions.this, Invoice.class);
				i.putExtra("Retailer", trader);
				startActivity(i);
			}
		});
	   
	    btnVisibility.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(TradersOptions.this, Visibility.class);
				i.putExtra("Retailer", trader);
				startActivity(i);
			}
		});
	
	
	
	}
	
	
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.traders_options, menu);
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
