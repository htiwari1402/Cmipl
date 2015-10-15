package com.cmipl.cmipl_app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Reports extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reports);
		final Button b = (Button) findViewById(R.id.btnMMPR);
		final Button b2 = (Button) findViewById(R.id.btnMDC);
		final Button b3 = (Button) findViewById(R.id.btnDUMTR);
		final Button b4 = (Button) findViewById(R.id.btnTop10);
		final Button b5 = (Button) findViewById(R.id.btnMumtr);
		final RelativeLayout r1 = (RelativeLayout) findViewById(R.id.relativeReport1);
		final RelativeLayout r2 = (RelativeLayout) findViewById(R.id.relativeReport2);
		final RelativeLayout r3 = (RelativeLayout) findViewById(R.id.relativeReport3);
		final RelativeLayout r4 = (RelativeLayout) findViewById(R.id.relativetop10);
		final TextView t = (TextView) findViewById(R.id.txtReportTitle);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				b.setBackgroundColor(Color.WHITE);
				b2.setBackgroundColor(Color.rgb(0, 176, 240));
				b3.setBackgroundColor(Color.rgb(0, 176, 240));
				b4.setBackgroundColor(Color.rgb(0, 176, 240));
				b5.setBackgroundColor(Color.rgb(0, 176, 240));
				
				r1.setVisibility(View.VISIBLE);
				r2.setVisibility(View.INVISIBLE);
				r3.setVisibility(View.INVISIBLE);
				r4.setVisibility(View.INVISIBLE);
				t.setText("My Monthly Performance Report");
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b2.setBackgroundColor(Color.WHITE);
				b.setBackgroundColor(Color.rgb(0, 176, 240));
				b3.setBackgroundColor(Color.rgb(0, 176, 240));
				b4.setBackgroundColor(Color.rgb(0, 176, 240));
				b5.setBackgroundColor(Color.rgb(0, 176, 240));
				
				r1.setVisibility(View.INVISIBLE);
				r2.setVisibility(View.VISIBLE);
				r3.setVisibility(View.INVISIBLE);
				r4.setVisibility(View.INVISIBLE);
				t.setText("My Daily Closing");
			}
		});
		
		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b3.setBackgroundColor(Color.WHITE);
				b2.setBackgroundColor(Color.rgb(0, 176, 240));
				b.setBackgroundColor(Color.rgb(0, 176, 240));
				b4.setBackgroundColor(Color.rgb(0, 176, 240));
				b5.setBackgroundColor(Color.rgb(0, 176, 240));
				
				r1.setVisibility(View.INVISIBLE);
				r2.setVisibility(View.INVISIBLE);
				r3.setVisibility(View.VISIBLE);
				r4.setVisibility(View.INVISIBLE);
				t.setText("Daily Uder My Team Report");
			}
		});
		
		
		 b4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b4.setBackgroundColor(Color.WHITE);
				b2.setBackgroundColor(Color.rgb(0, 176, 240));
				b.setBackgroundColor(Color.rgb(0, 176, 240));
				b3.setBackgroundColor(Color.rgb(0, 176, 240));
				b5.setBackgroundColor(Color.rgb(0, 176, 240));
				
				r1.setVisibility(View.INVISIBLE);
				r2.setVisibility(View.INVISIBLE);
				r3.setVisibility(View.INVISIBLE);
				r4.setVisibility(View.VISIBLE);
				t.setText("Top 10");
				
			}
		});
		 
		 
		 b5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				b5.setBackgroundColor(Color.WHITE);
				b2.setBackgroundColor(Color.rgb(0, 176, 240));
				b.setBackgroundColor(Color.rgb(0, 176, 240));
				b4.setBackgroundColor(Color.rgb(0, 176, 240));
				b3.setBackgroundColor(Color.rgb(0, 176, 240));
				
				r1.setVisibility(View.INVISIBLE);
				r2.setVisibility(View.INVISIBLE);
				r3.setVisibility(View.VISIBLE);
				r4.setVisibility(View.INVISIBLE);
				t.setText("Monthly Under My Team Report");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reports, menu);
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
