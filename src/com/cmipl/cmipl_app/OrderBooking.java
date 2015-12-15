package com.cmipl.cmipl_app;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cmipl.cmipl_app.design.OrderBookingListAdapter;

import URL.Url;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderBooking extends Activity {
	ListView list;
    String retailername;
    ProgressDialog progress;
    Spinner brandSpinner, categorySpinner, subcategorySpinner;
    static String SelectedCategory, SelectedBrand, SelectedSubCategory;
    boolean isBrandSpinnerTouched =false,isCategoryEventTouched =false , isSubcategoryEventTouched = false;
    static int total =0;
    static TextView txtTotal;
    TextView txtTotalValue;
    HashMap<String, String> map;
    String storeid,distId,visitRef;
    static int t=0;
    static TextView pricetxt,quantitytxt;
    static Activity act;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_order_booking);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		act = this;
		map = new HashMap<String, String>();
		Intent i = getIntent();
		retailername = i.getStringExtra("retailername");
		storeid = i.getStringExtra("storeid");
		distId = i.getStringExtra("distId");
		visitRef = i.getStringExtra("visitRef");
		
		String visit = i.getStringExtra("visitno");
		Button saveOrder = (Button) findViewById(R.id.btnOrderbookingSave);
		progress=ProgressDialog.show(OrderBooking.this, "","Loading Product Data, Please wait...", true);
		list= (ListView) findViewById(R.id.listOrderBooking_List);
		brandSpinner = (Spinner) findViewById(R.id.spinOrderBookingBrand);
		categorySpinner = (Spinner) findViewById(R.id.spinOrderBookingCategory);
		subcategorySpinner = (Spinner) findViewById(R.id.spinOrderBookingSubCategory);
		txtTotal = (TextView) findViewById(R.id.txtOrderBookingTotal);
		txtTotalValue =(TextView) findViewById(R.id.txtOrderBookingTotalvalues);
		pricetxt = (TextView) findViewById(R.id.txtOrderBookingPrice);
		quantitytxt = (TextView) findViewById(R.id.txtOrderBookingOquantity);
		TextView txtvisit = (TextView)findViewById(R.id.txtOrderBookingVisitNo);
		Button canelOrder = (Button) findViewById(R.id.btnOrderBookingCanel);
		
		
		txtvisit.setText(visit);
		txtTotal.setText("0");
	    Log.i(Url.URL,"aaaaaaaaaaaaaaaaaaaassssssssssssssss");
		new LoadProductData().execute(Url.URL+"allProducts.php");
		
		
		canelOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		categorySpinner.setOnTouchListener(new  OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				isCategoryEventTouched = true;
				
				return false;
				
				
			}
		});
		categorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
			if(isCategoryEventTouched) 
			  {	
					SelectedCategory = categorySpinner.getSelectedItem().toString();
					if(position > 0)
						{ 
							Toast.makeText(OrderBooking.this, "Selected item All", Toast.LENGTH_LONG).show();
							new LoadSubCat().execute(Url.URL+"allProducts.php");
							isCategoryEventTouched= false;
						}
					else
						{
						   new  LoadProductData().execute(Url.URL+"allProducts.php");
						   isCategoryEventTouched= false;
						}
			  }
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		brandSpinner.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				isBrandSpinnerTouched = true;
				return false;
			}
		});
		brandSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(isBrandSpinnerTouched)
				   {
					SelectedBrand = brandSpinner.getSelectedItem().toString();
					if(position > 0)
					  {
						new LoadProductBrandWise().execute(Url.URL+"allProducts.php");
						isBrandSpinnerTouched= false;
					  }	
					else
						{
						 new LoadProductData().execute(Url.URL+"allProducts.php"); 
						 isBrandSpinnerTouched= false;
						}
					
				   }
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		subcategorySpinner.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				isSubcategoryEventTouched = true;
				return false;
			}
		});
	    subcategorySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(isSubcategoryEventTouched)
				  {
					SelectedSubCategory = subcategorySpinner.getSelectedItem().toString();
					if(position >0)
					  {
						new LoadProductforSubCat().execute(Url.URL+"allProducts.php");
						isSubcategoryEventTouched = false;
					  }
					else
						{
						  new LoadProductData().execute(Url.URL+"allProducts.php");
						  isSubcategoryEventTouched = false;
						}
				  }
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	
	    saveOrder.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				OrderBooking_Map.order.put("storeId", storeid);
				OrderBooking_Map.order.put("distId", distId);
				OrderBooking_Map.order.put("so_id", Url.soID);
				OrderBooking_Map.order.put("visitRef", visitRef);
				//Toast.makeText(OrderBooking.this, distId, Toast.LENGTH_LONG).show();
				try {
					Intent i = new Intent(OrderBooking.this, ConfirmOrder.class);
					 i.putExtra("retailername", retailername);
					 i.putExtra("storeId", storeid);
					 
					 startActivity(i);
				    } 
				catch (Exception e) 
				      {
					    Toast.makeText(OrderBooking.this, e.toString(), Toast.LENGTH_LONG).show();  
				       }
			}
		});
	
	
	}
	 public static void setTotal(){
		 
		try{
		 
		 if(OrderBooking_Map.order!=null){
		  int tot =0;
		 for(String i : OrderBooking_Map.order.values()){
			 
			 tot = tot + Integer.parseInt(i);
		 }
		 txtTotal.setText(""+tot);
		 }
		}catch(Exception e){}
	 }
	 
	 public static void setPrice(String value){
		 
		 pricetxt.setText(value);
		 
	 }
	 
	 public static void setquantity(String val){
		 quantitytxt.setText(val);
	 }
	 
	 public static void finishActivity(){
		
		 act.finish();
		 
	 }
	 
	 @Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		OrderBooking_Map.order.clear();
		OrderBooking_Map.order2.clear();
		
	}
	 
	
	 
	 
	////////////////////////////////////////////////////////////////////////////////////////////////
	private class LoadProductData extends AsyncTask<String, Void, ArrayList<String []>> {

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> productDetails = new ArrayList<String[]>();
			
			try
			  {
					ServiceHandler servicehandler = new ServiceHandler();
					String jsonString = servicehandler.makeServiceCall(params[0], ServiceHandler.GET);
					if(jsonString!= null)
					{
						JSONArray jsonArray = new JSONArray(jsonString);
						String[] brand      = new String[jsonArray.length()];
						String[] category   = new String[jsonArray.length()];
						String[] product    = new String[jsonArray.length()];
						String[] productId  = new String[jsonArray.length()];
						String[] rate       = new String[jsonArray.length()];
					    for(int i=0; i<jsonArray.length();i++)
							{
								JSONObject jsonObject = jsonArray.getJSONObject(i);
								product[i]  =  jsonObject.getString("itemDesc");
								brand[i]    =  jsonObject.getString("brand");
								category[i] =  jsonObject.getString("productCategory");
								productId[i]=  jsonObject.getString("itemCode");
								rate[i]     =  jsonObject.getString("salesRate");
							}
						productDetails.add(0,product);
						productDetails.add(1,brand);
						productDetails.add(2,category);
						productDetails.add(3,productId);
						productDetails.add(4,rate);
					}
					else return null;
			    }
			catch(Exception e)
			         { }
			   return productDetails;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String[]> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(result!=null)
			  {
				String[] product     = result.get(0);
				String[] brandArry   = result.get(1);
				String[] categoryArry= result.get(2);
				String[] productid   = result.get(3);
				String[] rate        = result.get(4);
				ArrayList<String> brand = new ArrayList<String>();
				ArrayList<String> category = new ArrayList<String>();
				
				
				try
					{
					 brand = createArry(brandArry);
					 category = createArry(categoryArry);
					}
			
				catch(Exception e){}
				brand.add(0,"All Brands");
				category.add(0,"All Cat");
				
				OrderBookingListAdapter orderlistadt = new OrderBookingListAdapter(OrderBooking.this, product,productid, retailername,map,rate);
				list.setAdapter(orderlistadt);
		
				ArrayAdapter<String> adtbrand = new ArrayAdapter<String>(OrderBooking.this, android.R.layout.simple_list_item_1, brand);
			
				ArrayAdapter<String> adtcategory = new ArrayAdapter<String>(OrderBooking.this, android.R.layout.simple_list_item_1, category);
			
				brandSpinner.setAdapter(adtbrand);
			
				categorySpinner.setAdapter(adtcategory);
			
			    progress.dismiss();
			  }
			else{}
			
			
			
			
		}
		
		 public ArrayList<String> createArry(String[] array){
				
				ArrayList<String> resultarry = new ArrayList<String>(array.length);
				for(int i =0; i< array.length;i++)
					{
					  if(!resultarry.contains(array[i]))
					     {
						   resultarry.add(array[i]);
					     }
					}
				return resultarry;
		 }
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	 private class LoadSubCat extends AsyncTask<String, Void, ArrayList<String[]>>{

	@Override
	protected ArrayList<String[]> doInBackground(String... params) {
		// TODO Auto-generated method stub
		ArrayList<String[]> superList = new ArrayList<String[]>();
		try
		  {
			ServiceHandler httphandler = new ServiceHandler();
			String jsondata            = httphandler.makeServiceCall(params[0], ServiceHandler.GET);
			JSONArray jsonarray        = new JSONArray(jsondata);
			String[] subcat            = new String[jsonarray.length()];
			String[] product           = new String[jsonarray.length()];
			String[] productId         = new String[jsonarray.length()];
			String[] rate              = new String[jsonarray.length()];
			for(int i =0; i< jsonarray.length(); i++)
			   {
				 JSONObject jsonobject = jsonarray.getJSONObject(i);
				 if(jsonobject.getString("productCategory").equals(SelectedCategory))
				   {
					 product[i] = jsonobject.getString("itemDesc");
					 subcat[i]  = jsonobject.getString("subCategory");
					 productId[i] = jsonobject.getString("itemCode");
					 rate[i] = jsonobject.getString("salesRate");
				   } 
			    }
			superList.add(0,product);
			superList.add(1,subcat);
			superList.add(2,productId);
			superList.add(3,rate);
		  }catch(Exception e)
		        {}
		
		return superList;
	}
	
	@Override
	protected void onPostExecute(ArrayList<String[]> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		if(result!=null)
		  {
			try
			   { 
				 String[] product = result.get(0);
				 String[] subcat  = result.get(1);
				 String[] productId = result.get(2);
				 String[] rate      = result.get(3);
				 ArrayList<String> newResult = getArrayList(subcat);
				 ArrayAdapter adt = new ArrayAdapter(OrderBooking.this, android.R.layout.simple_list_item_1, newResult);
				 subcategorySpinner.setAdapter(adt);
				 
				 OrderBookingListAdapter oadt = new OrderBookingListAdapter(OrderBooking.this, product, productId,retailername,map,rate);
				 list.setAdapter(oadt);
		       }catch(Exception e) 
		             {
		    	       Toast.makeText(OrderBooking.this, "Error", Toast.LENGTH_LONG).show();
		             }
		  }
		 
	 }
	
	   ArrayList<String> getArrayList(String[] list){
		   
		   ArrayList<String> newList = new ArrayList<String>(list.length);
		   for(int i =0; i< list.length; i++)
		      {
			     if(!newList.contains(list[i]))
			     	{
			    	  newList.add(list[i]);
			    	}
			  }
		   return newList;
	   }
  }
	private  class LoadProductBrandWise extends AsyncTask<String, Void, ArrayList<String[]>>{

			@Override
			protected ArrayList<String[]> doInBackground(String... params) {
				// TODO Auto-generated method stub
				ArrayList<String[]> product = new ArrayList<String[]>();
				try
				  {
					ServiceHandler  sh  = new ServiceHandler();
					String json         = sh.makeServiceCall(params[0],ServiceHandler.GET);
					JSONArray jsonArray = new JSONArray(json);
					 String[] productname =  new String[jsonArray.length()];
					 String[] productId = new String[jsonArray.length()];
					 String[] rate = new String[jsonArray.length()];
					for(int i=0; i<jsonArray.length();i++)
						{
						  JSONObject jobject = jsonArray.getJSONObject(i);
						  if(jobject.getString("brand").equals(SelectedBrand))
						  	{
							  productname[i] = jobject.getString("itemDesc");
							  productId[i]   = jobject.getString("itemCode");
							  rate[i]        = jobject.getString("salesRate");
						  	}
						}
					product.add(0,productname);
					product.add(1,productId);
					product.add(2,rate);
				  }catch(Exception e){}
				
				return product;
			}
			
			
			@Override
			protected void onPostExecute(ArrayList<String[]> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			if(result != null)
			  { 
				String[] product = result.get(0);
				String[] productId = result.get(1);
				String[] rate     = result.get(2);
				
				OrderBookingListAdapter oadt = new OrderBookingListAdapter(OrderBooking.this, product,productId,retailername,map,rate);
				list.setAdapter(oadt);
				oadt.notifyDataSetChanged();
			  }
			}
	    }
	private class LoadProductforSubCat extends AsyncTask<String, Void, ArrayList<String[]>> {

		@Override
		protected ArrayList<String[]> doInBackground(String... params) {
			// TODO Auto-generated method stub
			ArrayList<String[]> product= new ArrayList<String[]>();
			try
			  {
				ServiceHandler sh = new ServiceHandler();
				String json       = sh.makeServiceCall(params[0], ServiceHandler.GET);
				JSONArray  jarray = new JSONArray(json);
				String[] productname = new String[jarray.length()];
				String[] productId   = new String[jarray.length()];
				String[] rate   = new String[jarray.length()];
				for(int i=0;i<jarray.length();i++)
				   {
					JSONObject jobj = jarray.getJSONObject(i);
					if(jobj.getString("subCategory").equals(SelectedSubCategory))
					   {
						productname[i]= jobj.getString("itemDesc");
						productId[i] = jobj.getString("itemCode");
						rate[i] = jobj.getString("salesRate");
								
					   }
				   }
				product.add(0,productname);
				product.add(1, productId);    
				product.add(2,rate);
			  }catch(Exception e){}
			
			return product;
		}
		
		@Override
		protected void onPostExecute(ArrayList<String[]> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String product[] = result.get(0);
			String productId[] = result.get(1);
			String rate[] = result.get(2);
			
			OrderBookingListAdapter odt = new OrderBookingListAdapter(OrderBooking.this, product, productId,retailername,map,rate);
			list.setAdapter(odt);
		
		}
		
		
	}   

}
     
     
    