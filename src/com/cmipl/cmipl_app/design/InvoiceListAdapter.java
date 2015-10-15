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

public class InvoiceListAdapter extends ArrayAdapter {
	private final Activity context;

	private final ArrayList<String>  invoiceNo;
	private final ArrayList<String>  invoicePcs;
	private final ArrayList<String>  invoiceVal;
	
	public InvoiceListAdapter(Activity context,ArrayList<String> invoiceNo,ArrayList<String> invoicePcs,ArrayList<String> invoiceVal) {
	super(context, R.layout.invoice_listdesign, invoiceNo);
	this.context = context;
	
	this.invoiceNo = invoiceNo;
	this.invoicePcs = invoicePcs;
	this.invoiceVal = invoiceVal;

	
	}
	@Override
	public View getView(final int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.invoice_listdesign, null, true);
	TextView invoiceNotxt = (TextView) rowView.findViewById(R.id.txtInvoiceListInvoiceNo);
	TextView invoicePcstxt = (TextView) rowView.findViewById(R.id.txtInvoiceListInvoicePcs);
	TextView invoiceValtxt = (TextView) rowView.findViewById(R.id.txtInvoiceListInvoiceValue);
	
	invoiceNotxt.setText(invoiceNo.get(position));
	invoicePcstxt.setText(invoicePcs.get(position));
	invoiceValtxt.setText(invoiceVal.get(position));
	

	return rowView;
	}
	}