
package com.cmipl.cmipl_app;

import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONObject;

import com.cmipl.cmipl_app.design.ConfirmOrderAdapter;

import URL.Url;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmOrder extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirm_order);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		
		ListView list = (ListView) findViewById(R.id.listConfirmOrderList);
		Button cancel = (Button) findViewById(R.id.btnConfirmOrderCancel);
		Button save = (Button) findViewById(R.id.btnConfirmOrderSave);
		
		TextView txtname = (TextView) findViewById(R.id.txtOrderConfirmStoreName);
		
		ArrayList<String> product = new ArrayList<String>();
		ArrayList<String> quantity = new ArrayList<String>();
		Intent i = getIntent();
		String retailername = i.getStringExtra("retailername");
		final String storeid  = i.getStringExtra("storeId");
		
		txtname.setText(retailername);
		for(String  p: OrderBooking_Map.order2.keySet() ){
			product.add(p);
		}
		
		for(String v:OrderBooking_Map.order2.values()){
			quantity.add(v);
		}
		
		ConfirmOrderAdapter  cadt = new ConfirmOrderAdapter(ConfirmOrder.this, product, quantity);
		list.setAdapter(cadt);
		
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
                     JSONObject obj = new JSONObject(OrderBooking_Map.order);
                     ServiceHandler sh = new ServiceHandler();
					 String t=URLEncoder.encode(obj.toString(),"UTF-8");
					 String response = sh.makeServiceCall(Url.URL+"OrderEntry.php?new_order="+t, ServiceHandler.GET);
					 String response2 = sh.makeServiceCall(Url.URL+"SOVisitServiceAdd.php?so_id="+Url.soID+"&store_id="+storeid+"&image=no&order=yes&lat=100&long=200", ServiceHandler.GET);
					// Toast.makeText(ConfirmOrder.this, response2, Toast.LENGTH_LONG).show();
					 OrderBooking.finishActivity();
					TradeCoverage.finishActivity();
					 TradersOptions.finishActivity();
					
					 AlertDialog.Builder alert = new AlertDialog.Builder(ConfirmOrder.this);
					 alert.setMessage("Your Order is Saved");
					 alert.setCancelable(false);
					 alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Intent i = new Intent(ConfirmOrder.this, TradeCoverage.class);
							startActivity(i);
							finish();
						}
					});
					 alert.show();
					
					 
					 
					
				}catch(Exception e){Toast.makeText(ConfirmOrder.this, e.toString(), Toast.LENGTH_LONG).show();}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm_order, menu);
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
