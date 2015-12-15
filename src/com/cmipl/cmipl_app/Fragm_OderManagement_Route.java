package com.cmipl.cmipl_app;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import URL.Url;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.cmipl.cmipl_app.design.OrderManagmentAdapter;
import com.cmipl.cmipl_app.design.TradecoverageListAdapter;

public class Fragm_OderManagement_Route extends Fragment {
	
	ListView list;
	ProgressDialog progress;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View v = inflater.inflate(R.layout.fragment_ordermanagement_route, container,false);
		list = (ListView) v.findViewById(R.id.listOrderManagmentRouteList);
		progress = ProgressDialog.show(getActivity(), "","Loading data...");
		new LoadData().execute(Url.URL+"OrderMgmt.php?routeid=1");
		return v;
	}
	
	
	private class LoadData extends AsyncTask<String, Void, ArrayList<String[]>>{

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> masterList = new ArrayList<String[]>();
			try
			  {
				 ServiceHandler sh = new ServiceHandler();
				 String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
				 JSONArray jarray  = new JSONArray(json);
				 String[] retailer = new String[jarray.length()];
				 String[] visit    = new String[jarray.length()];
				 String[] value    = new String[jarray.length()];
				 String[] noofPics = new String[jarray.length()];
				 for(int i=0; i<jarray.length(); i++)
				     {
					    JSONObject jobt = jarray.getJSONObject(i);
					    retailer[i]     = jobt.getString("storeName");
					    visit[i]        = jobt.getString("countVisit");
					    value[i]        = jobt.getString("sumAmount");
					    noofPics[i]     = jobt.getString("noPic");
				     }
				 masterList.add(0,retailer);
				 masterList.add(1,visit);
				 masterList.add(2,value);
				 masterList.add(3,noofPics);
			  }
			catch(Exception e){}
			return masterList;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String[]> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String retailer[] = result.get(0);
			String visit[]    = result.get(1);
			String value[]    = result.get(2);
			String noofPics[] = result.get(3);
			
			OrderManagmentAdapter omadt = new OrderManagmentAdapter(getActivity(), retailer, noofPics, value, null, visit);
			list.setAdapter(omadt);
			progress.dismiss();
		}
		
	}

}
