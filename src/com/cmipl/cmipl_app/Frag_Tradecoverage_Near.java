package com.cmipl.cmipl_app;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.cmipl.cmipl_app.design.TradecoverageListAdapter;

public class Frag_Tradecoverage_Near extends Fragment {
	ListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		View v= inflater.inflate(R.layout.fragment_tradecoverage_near, container,false);
	    list = (ListView) v.findViewById(R.id.listTradecoverageNear);
	    new LoadStoreData().execute("http://cmiplonline.com/wb_services/NearStores.php?routeid=1&lat=10.2491&long=20.5692");
	    return v;
	}
	
	private class LoadStoreData extends AsyncTask<String, Void, ArrayList<String[]>>{

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> resultList= new ArrayList<String[]>();
			try{
					ServiceHandler sh = new ServiceHandler();
					String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
					JSONArray  jarray = new JSONArray(json);
					String[] storeId  = new String[jarray.length()];
					String[] store    = new String[jarray.length()];
					String[] city     = new String[jarray.length()];
					for(int i =0; i< jarray.length(); i++){
						JSONObject jobj = jarray.getJSONObject(i);
						storeId[i]= jobj.getString("storeId");
						store[i] = jobj.getString("storeName");
						city[i] = jobj.getString("city");
					}
					
					resultList.add(0,storeId);
					resultList.add(1,store);
					resultList.add(2,city);
			   }
			catch(Exception e){}
			return resultList;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String[]> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			String[] storeId = result.get(0);
			String[] store   = result.get(1);
			String[] city    = result.get(2);
			
			TradecoverageListAdapter tadt = new TradecoverageListAdapter(getActivity(),storeId, store, city, null);
			list.setAdapter(tadt);
			
			
		}
		
	}


}