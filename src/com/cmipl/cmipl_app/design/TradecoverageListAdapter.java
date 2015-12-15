package com.cmipl.cmipl_app.design;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cmipl.cmipl_app.R;
import com.cmipl.cmipl_app.ServiceHandler;
import com.cmipl.cmipl_app.TradeCoverage;
import com.cmipl.cmipl_app.TradersOptions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TradecoverageListAdapter extends ArrayAdapter {
	private final Activity context;

	private final String[]  trader;
	private final String[]  road;
	private final String[]  visitno;
	private final String[] storeid;
	 String selectedDistId;
	 String distname;
	
	public TradecoverageListAdapter(Activity context,String storeid[],String[] trader, String[] road,String[] visitno) {
	super(context, R.layout.tradelist_design, trader);
	this.context = context;
	
	this.trader = trader;
    this.storeid = storeid;
	this.road = road;
	this.visitno = visitno;
	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.tradelist_design, null, true);
	RelativeLayout relative = (RelativeLayout) rowView.findViewById(R.id.relativeContainer);
	TextView tradername= (TextView) rowView.findViewById(R.id.txtTradecoverageListTraderName);
	TextView roadname= (TextView) rowView.findViewById(R.id.txtTradercoverageListRoad);
	TextView visit = (TextView) rowView.findViewById(R.id.txtTradecoverageListVisitNo);
	
	
	tradername.setText(trader[position]);
	roadname.setText(road[position]);
	if(visitno == null){
		visit.setText("");	
	}
	else
	{visit.setText(visitno[position]);}
	
	relative.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			try{
				distname = TradeCoverage.spinnerDist.getSelectedItem().toString();
				selectedDistId = TradeCoverage.distMap.get(distname);
			   }catch(Exception e){Toast.makeText(context, selectedDistId+distname+"this is error", Toast.LENGTH_LONG).show();}  
			
			Intent i = new Intent(context, TradersOptions.class);
			String tradername = trader[position];
			String visit;
			if(visitno == null){
			   visit ="";	
			}
			else{
		      visit= visitno[position];
			}
			i.putExtra("storeid", storeid[position]);
			i.putExtra("tradername", tradername);
			i.putExtra("visit", visit);
			i.putExtra("distId", selectedDistId);
			
			context.startActivity(i);
		}
	});
	
  

	return rowView;
	}
	
	}