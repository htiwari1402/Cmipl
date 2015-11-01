package com.cmipl.cmipl_app.design;

import java.io.File;
import java.util.ArrayList;

import com.cmipl.cmipl_app.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VisibilityListAdapter extends BaseAdapter{
	
	private static Context con;
	
	private static ArrayList<String> title;
	private static String retailer;
	
	public VisibilityListAdapter(Context con, ArrayList<String> title, String retailer){
		
		this.con =con;
	
		this.title= title;
		this.retailer = retailer;
		
	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return title.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		  View grid;
          LayoutInflater inflater = (LayoutInflater) con
              .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

          if (convertView == null) {

              grid = new View(con);
              grid = inflater.inflate(R.layout.gridviewdesign, null);
              TextView textView = (TextView) grid.findViewById(R.id.txtVisibilityListPicTitle);
              ImageView imageView = (ImageView)grid.findViewById(R.id.imgVisibilityListpic);
              textView.setText(title.get(position).replace(".jpg", ""));
          	File f = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailer+"/" , title.get(position));
          	if(f.exists()){
          		
          		Bitmap picture = BitmapFactory.decodeFile(f.getAbsolutePath());
          		imageView.setImageBitmap(picture);
          		
          		
          	}
        	
              
          } else {
              grid = (View) convertView;
          }

         
		return grid;
	}

}
