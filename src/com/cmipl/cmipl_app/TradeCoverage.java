package com.cmipl.cmipl_app;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cmipl.cmipl_app.design.TradecoverageListAdapter;

import URL.Url;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class TradeCoverage extends Activity {
    
	public static Spinner spinnerDist;
	ProgressDialog progress;
	static Activity act;
	Fragment frag_route;
	ListView listofRetailers;
	JSONArray resultRetailers;
	
	public static HashMap<String, String> distMap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trade_coverage);
		
		act = this;
		
		 final Button route  = (Button) findViewById(R.id.btnTradecoverageRoute);
		 final Button near   = (Button) findViewById(R.id.btnTradecoverageNear);
		 final Button map    = (Button) findViewById(R.id.btnTradecoverageMap);
		 listofRetailers     = (ListView)findViewById(R.id.listTradeCoverageRetailrs);
		 spinnerDist         = (Spinner) findViewById(R.id.spinnerTradeCoverageDist);
		 distMap             =  new HashMap<String,String>();
		 progress            =  ProgressDialog.show(TradeCoverage.this, "", "Loading Data...");
		 new LoadDist().execute(Url.URL+"DistributorForSO.php?so_id="+Url.soID+"");
		 new LoadStoreJSON().execute(Url.URL+"StoreFromRoute.php?routeid=1");
		 new LoadStoreData().execute(Url.URL+"StoreFromRoute.php?routeid=1");
		 
		
		//FragmentManager fm = getFragmentManager();
		//frag_route = fm.findFragmentById(R.id.fragmentTradecoverage_route);
		//Fragment frg_near = fm.findFragmentById(R.id.fragmentTradecoverage_Near);
		//Fragment frg_map = fm.findFragmentById(R.id.fragmentTradeCoverageMap);
		  //FragmentTransaction ft = getFragmentManager().beginTransaction();
	      //ft.show(frag_route) ;
	      //ft.hide(frg_near);
	      //ft.hide(frg_map);
	      //ft.commit();
	      //route.setBackgroundColor(Color.WHITE);
	       try{
		 
	       }catch(Exception e){};  
		    near.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				  Toast.makeText(TradeCoverage.this, "This module is under construction", Toast.LENGTH_LONG).show();
				}
			});
		    map.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Toast.makeText(TradeCoverage.this, "This module is under construction", Toast.LENGTH_LONG).show();
					
				}
			});
	        
		    spinnerDist.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					LoadDistributors(spinnerDist.getSelectedItem().toString());
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
			});
	     
		    
		    
	}

	protected void LoadDistributors(String distributor) {
		// TODO Auto-generated method stub
		try{
			String[] storeId  = new String[resultRetailers.length()];
			String[] store    = new String[resultRetailers.length()];
			String[] city     = new String[resultRetailers.length()];
			
		for(int i=0;i<resultRetailers.length();i++){
			JSONObject obj = resultRetailers.getJSONObject(i);
			if(obj.getString("distID").equals(distMap.get(distributor))){
				storeId[i] = obj.getString("storeId");
				store[i]   = obj.getString("storeName");
				city[i]    = obj.getString("city");
			}
		}
		TradecoverageListAdapter adapter = new TradecoverageListAdapter(TradeCoverage.this, storeId, store, city, null);
		listofRetailers.setAdapter(adapter);
		
		}catch(Exception e){//Toast.makeText(TradeCoverage.this, e.toString(), Toast.LENGTH_LONG).show();
			
		}
		
	}

	private class LoadDist extends AsyncTask<String, Void, HashMap<String, String>>{

		@Override
		protected HashMap<String, String> doInBackground(String... params) {
			// TODO Auto-generated method stub
			HashMap<String, String> distList = new HashMap<String, String>();
			try
			  {
					ServiceHandler sh = new ServiceHandler();
					String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
					JSONArray  jarray = new JSONArray(json);
					for(int i= 0; i < jarray.length(); i++ )
						{
							JSONObject obj = jarray.getJSONObject(i);
							//distList.add(obj.getString("name"));
							distList.put(obj.getString("name"), obj.getString("distID"));
						}
			  }
			catch(Exception e)
				{
				
				}
			return distList;
		}
		
		@Override
		protected void onPostExecute(HashMap<String, String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(result == null){
				Toast.makeText(TradeCoverage.this, "No Distributor found for SO, Order cannot be placed", Toast.LENGTH_LONG).show();
		        
			}
			distMap = result;
			ArrayList<String> list = new ArrayList<String>();
			for(String val: result.keySet())
				{
					list.add(val);
				}
			ArrayAdapter<String> adt = new ArrayAdapter<String>(TradeCoverage.this, android.R.layout.simple_list_item_1, list);
			spinnerDist.setAdapter(adt);
			
			
			
		}
		
	}
	

	private class LoadStoreJSON  extends AsyncTask<String, Void, JSONArray>{

		@Override
		protected JSONArray doInBackground(String... params) {
			// TODO Auto-generated method stub
			JSONArray result = null;
			try{
				ServiceHandler sh = new ServiceHandler();
				String json = sh.makeServiceCall(params[0], ServiceHandler.GET);
				result = new JSONArray(json);
			}
			catch(Exception e){}
			
			return result;
		}
		
		@Override
		protected void onPostExecute(JSONArray result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			try{
			resultRetailers = result;
			progress.dismiss();
			}catch(Exception e){}
		}
		
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
			
			TradecoverageListAdapter tadt = new TradecoverageListAdapter(TradeCoverage.this,storeId, store, city, null);
			listofRetailers.setAdapter(tadt);
			
			
		}
		
	}

	
	 public static void finishActivity(){
		 act.finish();
	 }
}
