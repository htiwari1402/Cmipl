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

public class TradecoverageListAdapter extends ArrayAdapter {
	private final Activity context;

	private final ArrayList<String>  trader;
	private final ArrayList<String>  road;
	
	private final ArrayList<String>  visitno;
	
	public TradecoverageListAdapter(Activity context,ArrayList<String> trader, ArrayList<String> road,ArrayList<String> visitno) {
	super(context, R.layout.tradelist_design, trader);
	this.context = context;
	
	this.trader = trader;

	this.road = road;
	this.visitno = visitno;
	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.tradelist_design, null, true);
	TextView tradername= (TextView) rowView.findViewById(R.id.txtTradecoverageListTraderName);
	TextView roadname= (TextView) rowView.findViewById(R.id.txtTradercoverageListRoad);
	TextView visit = (TextView) rowView.findViewById(R.id.txtTradecoverageListVisitNo);
	tradername.setText(trader.get(position));
	roadname.setText(road.get(position));
	visit.setText(visitno.get(position));
	
	
  

	return rowView;
	}
	}