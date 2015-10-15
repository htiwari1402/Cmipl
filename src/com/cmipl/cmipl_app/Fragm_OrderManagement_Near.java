package com.cmipl.cmipl_app;

import java.util.ArrayList;

import com.cmipl.cmipl_app.design.OrderManagmentAdapter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragm_OrderManagement_Near extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_ordermanagement_near, container,false);
		ListView l = (ListView) v.findViewById(R.id.listOrderManagmentNear);
		
		final ArrayList<String> trader = new ArrayList<String>();
		ArrayList<String> road = new ArrayList<String>();
		final ArrayList<String> visit = new ArrayList<String>();
		ArrayList<String> noofpic = new ArrayList<String>();
		ArrayList<String> value = new ArrayList<String>();
		
	
		
		trader.add("Jala Ram Brothers");
		trader.add("Tanvi Super Market");
		trader.add("Lucky Store");
		trader.add("Apollo Pharmacy");
		trader.add("Agrawal Brothers");
		
		road.add("Link Road");
		road.add("jb Nagar Road");
		road.add("makwana Road");
		road.add("Link Road");
		road.add("Link Road");
		
		visit.add(" 300");
		visit.add(" 300");
		visit.add(" 300");
		visit.add(" 300");
		visit.add(" 300");
		
		noofpic.add("10");
	
		noofpic.add("10");
		noofpic.add("10");
		noofpic.add("10");
		noofpic.add("10");
		
		value.add("200");
		value.add("200");
		value.add("200");
		value.add("200");
		value.add("200");
		
		OrderManagmentAdapter tadt = new OrderManagmentAdapter(getActivity(), trader, noofpic,value,road, visit);
		l.setAdapter(tadt);
		
		
		
		return v;
	}
	
}
