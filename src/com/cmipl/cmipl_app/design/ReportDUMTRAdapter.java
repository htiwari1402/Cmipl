package com.cmipl.cmipl_app.design;

import java.util.ArrayList;

import com.cmipl.cmipl_app.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ReportDUMTRAdapter extends ArrayAdapter {
	private final Activity context;

	private final String[] itemcode;
	private final String[] target;
	private final String[] achieved;
	
	
	public ReportDUMTRAdapter(Activity context,String[] itemcode,String[] target,String[] achieved) {
	super(context, R.layout.design_reportmmpr, itemcode);
	this.context = context;
	
	this.itemcode = itemcode;
	this.target = target;
	this.achieved = achieved;


	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.design_reportmmpr, null, true);
	TextView itemcodetxt = (TextView) rowView.findViewById(R.id.txtDesignReportMMprItem);
	TextView targettxt = (TextView) rowView.findViewById(R.id.txtDesignReportMMprTarget);
	TextView percenttxt = (TextView) rowView.findViewById(R.id.txtDesignReportMMprpercent);
	
	itemcodetxt.setText(itemcode[position]);
	targettxt.setText(target[position]+"/"+achieved[position]);
	int t = Integer.parseInt(target[position]);
	int a = Integer.parseInt(achieved[position]);
	long p = (a/t)*100;
	percenttxt.setText(""+p);
	

	return rowView;
	}
	}
