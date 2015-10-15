package com.cmipl.cmipl_app;

import java.util.ArrayList;

import com.cmipl.cmipl_app.design.InvoiceListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Invoice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.invoice_layout);
		
		TextView txtretailer = (TextView)findViewById(R.id.textInvoiceRetailerName);
		Intent i = getIntent();
		String retailer = i.getStringExtra("Retailer");
		txtretailer.setText(retailer);
		Button btnAllinvoice = (Button) findViewById(R.id.btnInvoiceAllInvoice);
		Button btnEditedinvoice = (Button) findViewById(R.id.btnInvoiceEditedInvoice);
		Button btnPendinginvoice = (Button) findViewById(R.id.btnInvoicePendingOrder);
		ListView l = (ListView) findViewById(R.id.listInvoice);
		
		ArrayList<String> allno = new ArrayList<String>();
		ArrayList<String> allpcs = new ArrayList<String>();
		ArrayList<String> allval = new ArrayList<String>();
		
		ArrayList<String> editno = new ArrayList<String>();
		ArrayList<String> editpcs = new ArrayList<String>();
		ArrayList<String> editval = new ArrayList<String>();
		
		ArrayList<String> pendno = new ArrayList<String>();
		ArrayList<String> pendpcs = new ArrayList<String>();
		ArrayList<String> pendval = new ArrayList<String>();
		
		
		
		allno.add("F001");
		allno.add("F002");
		allno.add("F003");
		allno.add("F004");
		allno.add("F005");
		allno.add("F006");
		allno.add("F007");
		allno.add("F008");
		
		
		allpcs.add("123");
		allpcs.add("23");
		allpcs.add("12");
		allpcs.add("4");
		allpcs.add("23");
		allpcs.add("12");
		allpcs.add("54");
		allpcs.add("6");
		
		allval.add("6456");
		allval.add("4545");
		allval.add("3344");
		allval.add("234");
		allval.add("45234");
		allval.add("234");
		allval.add("1235");
		allval.add("1313");
		
		InvoiceListAdapter adt = new InvoiceListAdapter(Invoice.this, allno, allpcs, allval);
		l.setAdapter(adt);
		
		
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.invoice, menu);
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
