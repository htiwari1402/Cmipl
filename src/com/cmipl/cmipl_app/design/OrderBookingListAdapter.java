package com.cmipl.cmipl_app.design;

import java.util.ArrayList;
import java.util.HashMap;

import com.cmipl.cmipl_app.OrderBooking;
import com.cmipl.cmipl_app.OrderBooking_Map;
import com.cmipl.cmipl_app.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class OrderBookingListAdapter extends ArrayAdapter   {
	private final Activity context;

	private final String[]  product;
	private final String[]  productId;
	private final String[]  rate;
	private final String retailername;
	private final HashMap<String, String> map;
	static int value;
	
	public OrderBookingListAdapter(Activity context,String[] product, String[]  productId, String retailername,HashMap<String, String> m,String[] rate) {
	super(context, R.layout.orderbooking_listdesign, product);
	this.context = context;
	this.productId = productId;
	this.product = product;
	this.retailername = retailername;
	this.map = m;
	this.rate = rate;

	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.orderbooking_listdesign, null, true);
	TextView producttxt = (TextView) rowView.findViewById(R.id.txtOrderBooking_ListProduct);
	RelativeLayout relativeListItem = (RelativeLayout) rowView.findViewById(R.id.relativeOrderBookingListItem);
	RelativeLayout relativeProduct = (RelativeLayout) rowView.findViewById(R.id.relativelayoutOrderBookingItemName);
	final EditText    Pcs = (EditText) rowView.findViewById(R.id.edittxtOrderBookingOrderNo);
	
	
	 
	relativeListItem.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			OrderBooking.setPrice(rate[position]);
		}
	});
	
	 
	 Pcs.setOnFocusChangeListener(new OnFocusChangeListener() {
		
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			//OrderBooking_Map.order.put(product.get(position), Pcs.getText().toString());
			if(hasFocus==false)
			  {
				final EditText  test = (EditText) v.findViewById(R.id.edittxtOrderBookingOrderNo);
				if(!test.getText().toString().equals(""))
				  {
					value = Integer.parseInt(test.getText().toString());
				    OrderBooking_Map.order.put(productId[position].toString(), test.getText().toString());
				    OrderBooking_Map.order2.put(product[position], Pcs.getText().toString());
				    try{
				    	map.put(""+position, test.getText().toString());
				    	OrderBooking.setTotal();
				       }
				    catch(Exception e)
				       {
				    	 Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
				       }
				  }
				
			  }
		}
	});
	 Pcs.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
			if(!Pcs.getText().toString().equals(""))
			   { int val = Integer.parseInt(Pcs.getText().toString());
			    	 
			     OrderBooking_Map.order.put(productId[position].toString(), Pcs.getText().toString());
			     OrderBooking_Map.order2.put(product[position], Pcs.getText().toString());
			     map.put(""+position, Pcs.getText().toString());
			     OrderBooking.setquantity(""+val);
			    
			   }
			
		}
	});
 
	 if(map!=null){
		Pcs.setText(map.get(""+position));	
	 }
	producttxt.setText(product[position]);
	return rowView;
 }
	
	
	
	
	
	}