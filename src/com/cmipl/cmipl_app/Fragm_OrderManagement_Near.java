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
		
	
		
		return v;
	}
	
}
