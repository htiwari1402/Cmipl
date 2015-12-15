package com.cmipl.cmipl_app;

import java.util.ArrayList;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cmipl.cmipl_app.design.ReportMMPRAdapter;

import URL.Url;
import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class FragReportDUMTR extends Fragment {
	ListView l;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_dumtrreport, container, false);
		l= (ListView) v.findViewById(R.id.listDumtr);
		try{
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			 if(month == 12){
				 month =1;
			 }else{
				 month=month+1;
			 }
		new LoadDumtr().execute(Url.URL+"DUMTR.php?empID=8&month="+month+"&year="+year+"");
		}catch(Exception e){Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();}
		return v;
	}
  private class LoadDumtr extends AsyncTask<String, Void, ArrayList<String[]>>{

	@Override
	protected ArrayList<String[]> doInBackground(String... params) {
		// TODO Auto-generated method stub
		ArrayList<String[]> list = new ArrayList<String[]>();
		try{
			ServiceHandler sh = new ServiceHandler();
			String json = sh.makeServiceCall(params[0], ServiceHandler.GET);
			JSONArray ary = new JSONArray(json);
			String[] name = new String[ary.length()];
			String[] target = new String[ary.length()];
			String[] ach    = new String[ary.length()];
			for(int i =0; i< ary.length();i++){
				JSONObject obj = ary.getJSONObject(i);
				name[i]= obj.getString("empName");
				Log.i(name[i], obj.toString());
				JSONObject obj2 = obj.getJSONObject("0");
				target[i] = obj2.getString("targetcode");
				ach[i] = obj2.getString("targetcodeachieved");
				
			}
			list.add(0,name);
			list.add(1,target);
			list.add(2,ach);
			
		}catch(Exception e){}
		return list;
	}
	@Override
	protected void onPostExecute(ArrayList<String[]> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		try{
		
			String[] itemcode = result.get(0);
		String[] target   = result.get(1);
		String[] achieved = result.get(2);
		
		
		
		ReportMMPRAdapter adt = new ReportMMPRAdapter(getActivity(), itemcode, target, achieved);
		l.setAdapter(adt);
		}catch(Exception e){}
	} 
  }
}
