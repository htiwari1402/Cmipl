package com.cmipl.cmipl_app;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cmipl.cmipl_app.design.VisibilityListAdapter;

import URL.Url;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class Visibility extends Activity {
	
	private static int TAKE_PICTURE = 1;
	private Uri imageUri;
	private String retailername;
	 int count=0;
	GridView gridlist;
	VisibilityListAdapter adt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visibility);
		
		Intent i            =     getIntent();
		retailername        =     i.getStringExtra("Retailer");
		gridlist            = (GridView)findViewById(R.id.gridviewVisibility);
		Button btnUploadPic = (Button) findViewById(R.id.btnUploadPic);
		Button btnExit = (Button) findViewById(R.id.btnvisibilityExit);
		
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	//	new LoadImage().execute();
		
		
		
		
		
	  btnUploadPic.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		  try
		  {
	         File fcmipl = new File(Environment.getExternalStorageDirectory()+"/cmipl");
	         if(!fcmipl.exists())
	         {
	            fcmipl.mkdir();
	         }
			 File f = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailername+"");
			 if(f.exists() && f.isDirectory())
			 {
				File imagefile = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailername+"/");
				for (File file : imagefile.listFiles()) 
				{
			         if (file.isFile() && file.getName().endsWith(".jpg")) 
			         {
			            count++;
			         }
			    }        
				  
						 takePhoto(v);
			  }
			   else
			       if(!f.exists())
			       {
					  f.mkdir();
					  count =0;
					  takePhoto(v);
				   }
			
		   }
		   catch(Exception e)
		   { 
			   Toast.makeText(Visibility.this, "code not right", Toast.LENGTH_LONG).show();
		   }
		
		}
	  });
	}
	
	private void takePhoto(View v) 
	{
		// TODO Auto-generated method stub
		Intent i = new Intent("android.media.action.IMAGE_CAPTURE");
		ServiceHandler sh = new ServiceHandler();
		//sh.makeServiceCall(Url.URL+"SOVisitServiceAdd.php?so_id=""&store_id=23&image=yes&order=no", ServiceHandler.GET);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		int newcount= count+1;
		File f = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailername+"/" , "pic"+newcount+date+".jpg");
		imageUri = Uri.fromFile(f);
	    i.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
	    startActivityForResult(i, TAKE_PICTURE);
	    count=0;
	}
	
	public void onActivityResult(int requestCode , int resultCode , Intent i)
	{
		super.onActivityResult(requestCode, resultCode, i);
		if(resultCode == Activity.RESULT_OK) 
		{
			Uri selectedimage = imageUri;
			Visibility.this.getContentResolver().notifyChange(selectedimage, null);
			new LoadImage().execute();
		}
	}

	private class LoadImage extends AsyncTask<Void, Void, ArrayList<String>> {

		@Override
		protected ArrayList<String> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<String> title =new ArrayList<String>();
	  try{
			
			File f = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailername+"");
			if(f.exists())
			{
			   File imgfolder = new File(Environment.getExternalStorageDirectory()+"/cmipl/"+retailername+"/");
			   for(File file:imgfolder.listFiles())
			   {
				   if(file.isFile() && file.getName().endsWith(".jpg"))
				   {
						   title.add(file.getName());
				   }
			   }
			 }
	      }
	  catch(Exception e){Toast.makeText(Visibility.this, "No Pictures uploaded for"+retailername, Toast.LENGTH_LONG).show();}
			return title;
	}
		
		@Override
		protected void onPostExecute(ArrayList<String> result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			adt = new VisibilityListAdapter(Visibility.this, result, retailername);
			System.gc();
			gridlist.setAdapter(adt);
			
			
		}
		
	}

}
	
	
	
	
	
	

