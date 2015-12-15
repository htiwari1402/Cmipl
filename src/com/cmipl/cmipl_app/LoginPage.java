package com.cmipl.cmipl_app;

import URL.Url;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends Activity {
	EditText edit ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
		Button loginbtn= (Button) findViewById(R.id.btnLoginPagelogin);
	final	EditText username = (EditText) findViewById(R.id.edittxtLoginPageUsername);
		final EditText password = (EditText) findViewById(R.id.edittxtLoginPagePassword);
		
	final	AlertDialog.Builder optalert = new AlertDialog.Builder(LoginPage.this);
		LayoutInflater inflater = LayoutInflater.from(LoginPage.this);
		View v = inflater.inflate(R.layout.activity_otpcheck,null);
	  edit	= (EditText) v.findViewById(R.id.editxtOtp);
	  edit.setText(Url.URL);
		optalert.setView(v);
		
		
		optalert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			/*	String otp = edit.getText().toString();
				
				if(otp.equals("1234")){
					Intent i = new Intent(LoginPage.this, HomePage.class);
					startActivity(i);
					finish();
				}
				else
					{Toast.makeText(LoginPage.this, "Incorrect OTP, Please try again", Toast.LENGTH_LONG).show();
				    Intent i = new Intent(LoginPage.this, LoginPage.class);
				    startActivity(i);
				    finish();
					}*/
				
				String newURL = edit.getText().toString();
				Url.URL = newURL;
				
				
			}
		});
		
		optalert.show();
		
		
        loginbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					String user = username.getText().toString();
					String pass = password.getText().toString();
				    ServiceHandler sh = new ServiceHandler();
				    String response = sh.makeServiceCall(Url.URL+"LoginService.php?login="+user+"&pass="+pass+"",ServiceHandler.GET);
				    if(response.equals("000000")) {
				    	Toast.makeText(LoginPage.this, "Username or Password is incorrect, Please try again", Toast.LENGTH_LONG).show();
				    }
				    else{
				    	 Url.soID = response;
					 }
				    Intent i = new Intent(LoginPage.this, HomePage.class);
					startActivity(i);
					finish();
				}
				catch(Exception e){
					  Toast.makeText(LoginPage.this, e.toString()+"Insert Username and Password", Toast.LENGTH_LONG).show();
					}
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
