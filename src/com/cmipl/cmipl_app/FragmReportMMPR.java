package com.cmipl.cmipl_app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cmipl.cmipl_app.design.ReportMMPRAdapter;

import URL.Url;
import android.app.Fragment;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class FragmReportMMPR extends Fragment{
	ListView listbertoli;
	ListView listfigaro;
	
	TextView brand,totaltarget,totalpercentage,brand2,totaltarget2,totalpercentage2;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_report_mmpr, container, false);
		 listfigaro = (ListView) v.findViewById(R.id.listReportsMMPR);
		 listbertoli =(ListView) v.findViewById(R.id.listReportsMMpr2);
		 brand = (TextView) v.findViewById(R.id.txtfragment_report_mmpr_Item1);
		 totaltarget = (TextView) v.findViewById(R.id.txtfragment_report_mmpr_target1);
		 totalpercentage = (TextView)v.findViewById(R.id.txtfragment_report_mmpr_percent1);
		 TextView txtmonth = (TextView) v.findViewById(R.id.txtdumMonth);
		 
		 brand2 = (TextView) v.findViewById(R.id.txtfragment_report_mmpr_Item2);
		 totaltarget2 = (TextView) v.findViewById(R.id.txtfragment_report_mmpr_target1);
		 totalpercentage2 = (TextView)v.findViewById(R.id.txtfragment_report_mmpr_percent1);
		 
		 brand.setText("Figaro");
		// brand2.setText("Bertoli");
		 Calendar c = Calendar.getInstance(TimeZone.getDefault());
		 int year = c.get(Calendar.YEAR);
		 int month = c.get(Calendar.MONTH);
		 
		 if(month == 12){
			 month =1;
		 }else{
			 month=month+1;
		 }
		 SimpleDateFormat month_date = new SimpleDateFormat("MMMM");
		 String month_name = month_date.format(c.getTime());
		 txtmonth.setText(month_name);
		// Toast.makeText(getActivity(), "month:-"+month, Toast.LENGTH_LONG).show();
		 new LoadReportDataFigaro().execute(Url.URL+"MMPR.php?soid="+Url.soID+"&month="+month+"&year="+year+"");
		 new LoadReportDataBertoli().execute(Url.URL+"MMPR.php?soid="+Url.soID+"&month="+month+"&year="+year+"");
		
		
		return v;
	}
	

	private class LoadReportDataFigaro extends AsyncTask<String, Void, ArrayList<String[]>>{

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> result = new ArrayList<String[]>();
			try{
				ServiceHandler sh = new ServiceHandler();
				String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
				JSONArray jary    = new JSONArray(json);
				String[] itemcode = new String[jary.length()];
				String[] target   = new String[jary.length()];
				String[] achieved = new String[jary.length()];
				for(int i=0;i<jary.length();i++){
					JSONObject obj = jary.getJSONObject(i);
					if(obj.getString("brand").equals("Figaro")){
						itemcode[i] = obj.getString("itemCode");
						target[i]   = obj.getString("targetcode");
						achieved[i] = obj.getString("targetcodeachieved");
					}
				}
				result.add(0,itemcode);
				result.add(1,target);
				result.add(2,achieved);
			}catch(Exception e){
				
			}
			
			return result;
		}
		
	@Override
	protected void onPostExecute(ArrayList<String[]> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		try{
		String[] itemcode = result.get(0);
		String[] target   = result.get(1);
		String[] achieved = result.get(2);
		int totaltr =0,totalach=0;
		for(int i =0; i<target.length;i++){
			totaltr = totaltr + Integer.parseInt(target[i]);
			totalach = totalach + Integer.parseInt(achieved[i]);
		}
		totaltarget.setText(""+totaltr+"/"+totalach);
		double pert= (totalach/totaltr)*100;
	    totalpercentage.setText(""+pert);
		
		ReportMMPRAdapter adt = new ReportMMPRAdapter(getActivity(), itemcode, target, achieved);
		listfigaro.setAdapter(adt);
		}catch(Exception e){}
	}
		
	}
	
	private class LoadReportDataBertoli extends AsyncTask<String, Void, ArrayList<String[]>>{

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> result = new ArrayList<String[]>();
			try{
				ServiceHandler sh = new ServiceHandler();
				String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
				JSONArray jary    = new JSONArray(json);
				String[] itemcode = new String[jary.length()];
				String[] target   = new String[jary.length()];
				String[] achieved = new String[jary.length()];
				for(int i=0;i<jary.length();i++){
					JSONObject obj = jary.getJSONObject(i);
					if(obj.getString("brand").equals("Bertoli")){
						itemcode[i] = obj.getString("itemCode");
						target[i]   = obj.getString("targetcode");
						achieved[i] = obj.getString("targetcodeachieved");
					}
				}
				result.add(0,itemcode);
				result.add(1,target);
				result.add(2,achieved);
			}catch(Exception e){
				
			}
			
			return result;
		}
		
	@Override
	protected void onPostExecute(ArrayList<String[]> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		try{String[] itemcode = result.get(0);
		String[] target   = result.get(1);
		String[] achieved = result.get(2);
		int totaltr =0,totalach=0;
		for(int i =0; i<target.length;i++){
			totaltr = totaltr + Integer.parseInt(target[i]);
			totalach = totalach + Integer.parseInt(achieved[i]);
		}
		totaltarget2.setText(""+totaltr+"/"+totalach);
		double pert= (totalach/totaltr)*100;
	    totalpercentage2.setText(""+pert);
		ReportMMPRAdapter adt = new ReportMMPRAdapter(getActivity(), itemcode, target, achieved);
		listbertoli.setAdapter(adt);
		}catch(Exception e){}
	}
		
	}
	
}
