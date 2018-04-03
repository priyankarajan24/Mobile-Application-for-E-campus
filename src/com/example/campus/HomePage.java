package com.example.campus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HomePage extends Activity {
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5;
    
    String sname,regno;
    Button lg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		imageView1=(ImageView)findViewById(R.id.imageView1);
		imageView2=(ImageView)findViewById(R.id.imageView2);
		
		imageView3=(ImageView)findViewById(R.id.imageView3);
		imageView4=(ImageView)findViewById(R.id.imageView4);
		imageView5=(ImageView)findViewById(R.id.imageView5);
	    lg=(Button)findViewById(R.id.lgss);
		 Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  lg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,MainActivity.class);
				startActivity(in);
				finish();
			}
		});
		imageView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,Profile.class);
   				in.putExtra("regno",regno);
   				in.putExtra("sname",sname);
   				startActivity(in);
				
			}
		});
		imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,Attendance.class);
   				in.putExtra("regno",regno);
   				in.putExtra("sname",sname);
   				startActivity(in);
				
			}
		});
		imageView3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,Marks.class);
   				in.putExtra("regno",regno);
   				in.putExtra("sname",sname);
   				startActivity(in);
				
			}
		});
		imageView4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,TimeTable.class);
   				in.putExtra("regno",regno);
   				in.putExtra("sname",sname);
   				startActivity(in);
				
			}
		});
		imageView5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in=new Intent(HomePage.this,Feedback.class);
   				in.putExtra("regno",regno);
   				in.putExtra("sname",sname);
   				startActivity(in);
				
			}
		});
	}
}
