package com.cmipl.cmipl_app.design;

import java.util.ArrayList;

import com.cmipl.cmipl_app.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConfirmOrderAdapter extends ArrayAdapter {
	private final Activity context;

	private final ArrayList<String>  product;
	private final ArrayList<String>  quantity;
	
	
	public ConfirmOrderAdapter(Activity context,ArrayList<String> product,ArrayList<String> quantity) {
	super(context, R.layout.confirmorderbooking_listdesign, product);
	this.context = context;
	
	this.product = product;
	this.quantity = quantity;


	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.confirmorderbooking_listdesign, null, true);
	TextView producttxt = (TextView) rowView.findViewById(R.id.txtConfirmOrderBooking_Listproduct);
	TextView quantitytxt = (TextView) rowView.findViewById(R.id.txtConfirmOrder_quantity);
	
	
	producttxt.setText(product.get(position));
	quantitytxt.setText(quantity.get(position));
	
	

	return rowView;
	}
	}