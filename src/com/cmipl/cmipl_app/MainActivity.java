package com.cmipl.cmipl_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;


public class MainActivity extends Activity {
	//Introduce an delay
    private final int WAIT_TIME = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	setContentView(R.layout.activity_main);
	
	
	new Handler().postDelayed(new Runnable(){ 
	@Override 
	    public void run() { 
              //Simulating a long running task
              try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
              
	    
	  /* Create an Intent that will start the ProfileData-Activity. */
              Intent mainIntent = new Intent(MainActivity.this,LoginPage.class); 
	    MainActivity.this.startActivity(mainIntent); 
	    MainActivity.this.finish(); 
	} 
	}, WAIT_TIME);
      }}
   