 package com.example.campus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SampleListAdapter1 extends BaseAdapter{
	TextToSpeech t1;
	Context b;
	LayoutInflater lf;
    Marks sec;
	Calendar cal = Calendar.getInstance();
	String outdate,reformattedStr1;
    ArrayList<HashMap<String, String>> ll = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> hash = new HashMap<String, String>();
	
	public SampleListAdapter1(ArrayList<HashMap<String, String>> result,
			Context context) {
		this.b = context;
		this.ll = result;
	      sec=new Marks();
	   
	
	   
		
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
	
		
		
		
		return ll.size();
	}

	@Override
	public Object getItem(int position) {

		return ll.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		lf = (LayoutInflater) b
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		convertView = lf.inflate(R.layout.markdetails, null);

		TextView p1 = (TextView) convertView.findViewById(R.id.im1);
		TextView p2 = (TextView) convertView.findViewById(R.id.im2);
		TextView p3 = (TextView) convertView.findViewById(R.id.im3);
		TextView p4 = (TextView) convertView.findViewById(R.id.im4); 
		TextView p5 = (TextView) convertView.findViewById(R.id.im5);
	
		hash = ll.get(position);

		String pr1 = hash.get("p1");
		String pr2=hash.get("p2");
		String pr3=hash.get("p3");
		String pr4=hash.get("p4");
		String pr5=hash.get("p5");
		
			p1.setText("Semester: "+pr1);
			p2.setText("Subject Id: "+pr2);
		    p3.setText("Course: "+pr3);
		    p4.setText("Marks: "+pr4);
			p5.setText("Date: "+pr5);
			
		
		return convertView;
	}

	public class ViewHolder {

		public TextView name,mobile,location;

	}
	

}
