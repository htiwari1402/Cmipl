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

	private final String[]  retailer;
	private final String[]  noofpics;
	private final String[]  values;
	private final String[]  road;
	private final String[]  visit;
	
	
	public OrderManagmentAdapter(Activity context,String[] retailer,String[] noofpics,String[] values,String[] road,String[] visit) {
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
	
	
	retailertxt.setText(retailer[position]);
	noofpic.setText(noofpics[position]);
	value.setText(values[position]);
	if(road!=null)
		{
		  roadvisit.setText(road[position]+"No. of Visit    :"+visit[position]);
		}
	else
	    {
		 roadvisit.setText(""+"No. of Visit   :"+visit[position]);
	    }

	return rowView;
	}
	}