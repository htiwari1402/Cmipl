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

public class OrderManagmentAdapter extends ArrayAdapter {
	private final Activity context;

	private final ArrayList<String>  retailer;
	private final ArrayList<String>  noofpics;
	private final ArrayList<String>  values;
	private final ArrayList<String>  road;
	private final ArrayList<String>  visit;
	
	
	public OrderManagmentAdapter(Activity context,ArrayList<String> retailer,ArrayList<String> noofpics,ArrayList<String> values,ArrayList<String> road,ArrayList<String> visit) {
	super(context, R.layout.ordermanagement_listdesign, retailer);
	this.context = context;
	
	this.retailer = retailer;
	this.noofpics = noofpics;
	this.values = values;
	this.road = road;
	this.visit = visit;
	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.ordermanagement_listdesign, null, true);
	TextView retailertxt = (TextView) rowView.findViewById(R.id.txtOrde);
	TextView noofpic = (TextView) rowView.findViewById(R.id.txtOrderManagementNoofPics);
	TextView value = (TextView) rowView.findViewById(R.id.txtOrderManagementValues);
	TextView roadvisit = (TextView) rowView.findViewById(R.id.txtOrderManagementRoadVisit);
	
	
	retailertxt.setText(retailer.get(position));
	noofpic.setText(noofpics.get(position));
	value.setText(values.get(position));
	roadvisit.setText(road.get(position)+"No. of Visit"+visit.get(position));

	return rowView;
	}
	}