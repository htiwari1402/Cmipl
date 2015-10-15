package com.cmipl.cmipl_app;

import java.util.ArrayList;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.cmipl.cmipl_app.design.TradecoverageListAdapter;

public class Frag_Tradecoverage_Near extends Fragment {
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View v= inflater.inflate(R.layout.fragment_tradecoverage_near, container,false);
	
		ListView list = (ListView) v.findViewById(R.id.listTradecoverageNear);
		
		final ArrayList<String> trader = new ArrayList<String>();
		ArrayList<String> road = new ArrayList<String>();
	final	ArrayList<String> visit = new ArrayList<String>();
		
	
		
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
		
		visit.add("visit: 300");
		visit.add("visit: 300");
		visit.add("visit: 300");
		visit.add("visit: 300");
		visit.add("visit: 300");
		
		TradecoverageListAdapter tadt = new TradecoverageListAdapter(getActivity(), trader, road, visit);
		list.setAdapter(tadt);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(getActivity(), TradersOptions.class);
				String tradername = trader.get(position);
				String visitno= visit.get(position);
				i.putExtra("tradername", tradername);
				i.putExtra("visit", visitno);
				startActivity(i);
			}
		});
		
		
		return v;
	}

}