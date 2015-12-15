package com.cmipl.cmipl_app;

import java.text.SimpleDateFormat;
import java.util.Date;

import URL.Url;
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
import android.widget.Spinner;
import android.widget.Toast;

public class NewRetailer2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_retailer2);
		
	try{EditText FSSAIno = (EditText) findViewById(R.id.txtfssaino);
		EditText RouteName = (EditText) findViewById(R.id.txtRouteBitname);
		Spinner retailerType = (Spinner) findViewById(R.id.spinnerNewRetailerType);
		Spinner underbrand = (Spinner) findViewById(R.id.spinnerNewRetailerUnderBrand);
		Spinner storetype = (Spinner) findViewById(R.id.spinnerNewRetailerStoreType);
		Spinner storesize = (Spinner) findViewById(R.id.spinnerNewRetailerStoreSize);
		Spinner assSaleOfficer = (Spinner) findViewById(R.id.spinnerNewRetailerAssociateSaleOfficer);
		Spinner assDistributer = (Spinner) findViewById(R.id.spinnerNewRetailerAssociatedDistributr);
		
		RelativeLayout save = (RelativeLayout) findViewById(R.id.relativeNewUserSave);
		
		Intent i = getIntent();
		
		
		final String name    		= i.getStringExtra("name");
		final String address 		= i.getStringExtra("address");
		final String state 			= i.getStringExtra("state");
		final String district 		= i.getStringExtra("district");
		final String area    	    = i.getStringExtra("area");
		final String city 			= i.getStringExtra("city");
		final String contactno 		= i.getStringExtra("contactno");
		final String contactPerson	= i.getStringExtra("contactPerson");
		final String email			= i.getStringExtra("email");
		final String vat 			= i.getStringExtra("vat");
		final String pan 			= i.getStringExtra("pan");
		final String pincode		= i.getStringExtra("pincode");
		final String cst            = i.getStringExtra("CST");
		
		final String FSSAI      = FSSAIno.getText().toString();
		final String retailType = retailerType.getSelectedItem().toString();
		final String underbrnd  = underbrand.getSelectedItem().toString();
		final String stype      = storetype.getSelectedItem().toString();
		final String ssize      = storesize.getSelectedItem().toString();
		final String assSaleoff = assSaleOfficer.getSelectedItem().toString();
		final String assDist    = assDistributer.getSelectedItem().toString();
		final String route      = RouteName.getText().toString();
		final String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		Button back = (Button) findViewById(R.id.btnNewRetailer2back);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ServiceHandler sh = new ServiceHandler();
				sh.makeServiceCall(Url.URL+"AddRetailer.php?storeName="+name+"&address="+address+"&city="+city+"&state="+state+"&district="+district+"&country=india&retaileradddate="+date+"&details=details&retailerType="+retailType+"&ownerType=owner&ownerTypeID=typeID&pincode="+pincode+"&contactnumber="+contactno+"&email="+email+"&vattinnumber="+vat+"&csttinnumber="+cst+"&pannumber="+pan+"&fssainumber="+FSSAI+"&area="+area+"&retailertypeid=1&brandid=5&salesofficeid=7&routeid=1&distID=5", ServiceHandler.POST);
				Toast.makeText(NewRetailer2.this, "New Retailer Inserted", Toast.LENGTH_LONG).show();
				finish();
			}
		});
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	catch(Exception e){Toast.makeText(NewRetailer2.this, e.toString(), Toast.LENGTH_LONG).show();}
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_retailer2, menu);
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
