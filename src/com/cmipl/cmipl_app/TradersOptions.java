package com.cmipl.cmipl_app;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import URL.Url;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TradersOptions extends Activity {
	
	static Activity act;
	TextView visitno;
	static String visitRef;
	ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traders_options);
		
		act = this;
		progress = new ProgressDialog(TradersOptions.this).show(TradersOptions.this, "", "loading Data..");
		TextView tradername= (TextView)findViewById(R.id.txtTraderOptionsStoreName);
		visitno = (TextView)findViewById(R.id.txtTraderOptionsStoreVisitNo);
		
		Intent i = getIntent();
		final String trader = i.getStringExtra("tradername");
		final String visit=i.getStringExtra("visit");
		final String storeid = i.getStringExtra("storeid");
		final String distId  = i.getStringExtra("distId");
				
		
		tradername.setText(trader);
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
				i.putExtra("storeid", storeid);
				i.putExtra("distId", distId);
				i.putExtra("visitRef", visitRef);
				i.putExtra("visitno",visitno.getText().toString());
				startActivity(i);
				
			}
		});
	
	    btnOrderEdit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(TradersOptions.this, "Module under construction", Toast.LENGTH_LONG).show();
			//	Intent i = new Intent(TradersOptions.this, OrderEdit.class);
				//startActivity(i);
				
			}
		});
	    
	    btnInvoice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(TradersOptions.this, "Module under construction", Toast.LENGTH_LONG).show();
				
				//Intent i = new Intent(TradersOptions.this, Invoice.class);
				//i.putExtra("Retailer", trader);
				//startActivity(i);
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
	
	   new LoadVisitNo().execute(Url.URL+"SOVisitServiceAdd.php?so_id="+Url.soID+"&store_id="+storeid+"&image=no&order=no&lat=100&long=200");
		
	
	}
	
	public static void finishActivity(){
		act.finish();
	}
	
	
	private class LoadVisitNo extends AsyncTask<String, Void, ArrayList<String>>{

		@Override
		protected ArrayList<String> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String> result= new ArrayList<String>();
			try{
				ServiceHandler sh = new ServiceHandler();
				String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
				JSONArray  jary   = new JSONArray(json);
				JSONObject jobj   =  jary.getJSONObject(0);
				result.add(0,jobj.getString("numVisits"));
				result.add(1,jobj.getString("visitRef"));
				
			}catch(Exception e){}
			return result;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			visitno.setText("Visit No- "+result.get(0));
			visitRef = result.get(1);
			progress.dismiss();
		}
		
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
