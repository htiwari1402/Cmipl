package com.cmipl.cmipl_app.design;

import java.util.ArrayList;

import com.cmipl.cmipl_app.OderDetails;
import com.cmipl.cmipl_app.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager.OnActivityResultListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrderBookingListAdapter extends ArrayAdapter   {
	private final Activity context;

	private final ArrayList<String>  product;
	TextView Pcs;
	
	private final String retailername;
	
	public OrderBookingListAdapter(Activity context,ArrayList<String> product, String retailername) {
	super(context, R.layout.orderbooking_listdesign, product);
	this.context = context;
	
	this.product = product;
	this.retailername = retailername;

	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.orderbooking_listdesign, null, true);
	TextView producttxt = (TextView) rowView.findViewById(R.id.txtOrderBooking_ListProduct);
	RelativeLayout relativeListItem = (RelativeLayout) rowView.findViewById(R.id.relativeOrderBookingListItem);
	RelativeLayout relativeProduct = (RelativeLayout) rowView.findViewById(R.id.relativelayoutOrderBookingItemName);
	
	          Pcs = (TextView) rowView.findViewById(R.id.edittxtOrderBookingOrderNo);
	 TextView Sch = (TextView) rowView.findViewById(R.id.edittxtOrderBookingScheme);
	 TextView Dis = (TextView) rowView.findViewById(R.id.edittxtOderBookingDiscount);
	
	  Pcs.setId(position);
	  
    
	producttxt.setText(product.get(position));
	
   relativeProduct.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		
		
	}
});
	
	
	
	return rowView;
	}
	
	
	
	
	
	}