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

public class SampleListAdapter extends BaseAdapter{
	TextToSpeech t1;
	Context b;
	LayoutInflater lf;
    Attendance sec;
	Calendar cal = Calendar.getInstance();
	String outdate,reformattedStr1;
    ArrayList<HashMap<String, String>> ll = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> hash = new HashMap<String, String>();
	
	public SampleListAdapter(ArrayList<HashMap<String, String>> result,
			Context context) {
		this.b = context;
		this.ll = result;
	      sec=new Attendance();
	   
	
	   
		
		
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

		convertView = lf.inflate(R.layout.viewatt, null);
		
		
		
        

        try{
		
		
		
		TextView vname = (TextView) convertView.findViewById(R.id.dates);
		TextView vmob = (TextView) convertView.findViewById(R.id.sem);
		TextView p1 = (TextView) convertView.findViewById(R.id.p1);
		TextView p2 = (TextView) convertView.findViewById(R.id.p2);
		TextView p3 = (TextView) convertView.findViewById(R.id.p3);
		TextView p4 = (TextView) convertView.findViewById(R.id.p4); 
		TextView p5 = (TextView) convertView.findViewById(R.id.p5);
		TextView p6 = (TextView) convertView.findViewById(R.id.p6);
		TextView p7 = (TextView) convertView.findViewById(R.id.p7);
		TextView p8 = (TextView) convertView.findViewById(R.id.p8);
		hash = ll.get(position);
		String date = hash.get("date");
		String Sem = hash.get("sem");
		String pr1 = hash.get("p1");
		String pr2=hash.get("p2");
		String pr3=hash.get("p3");
		String pr4=hash.get("p4");
		String pr5=hash.get("p5");
		String pr6=hash.get("p6");
		String pr7=hash.get("p7");
		String pr8=hash.get("p8");

		//Mar 19 2018 
		String bdate=date.substring(0,11);
		
		//img.setImageBitmap(bm);
		
		SimpleDateFormat to = new SimpleDateFormat("MMM dd yyyy");
		SimpleDateFormat from = new SimpleDateFormat("MMM-dd-yyyy");

		Date dates = to.parse(bdate);
		String result = from.format(dates);
				
		

			vname.setText(result +"      ");

		
		
		vmob.setText("Sem: "+Sem);
//		p1.setText(pr1);
//		p2.setText(hash.get("p2"));
//		p3.setText(hash.get("p3"));
//		p4.setText(hash.get("p4"));
//		p5.setText(hash.get("p5"));
//		p6.setText(hash.get("p6"));
//		p7.setText(hash.get("p7"));
//		p8.setText(hash.get("p8"));
		Log.e("REcived vaule ",  "pr1: "+pr1);
		Log.e("REcived vaule ",  "pr2: "+pr2);
		Log.e("REcived vaule ",  "pr3: "+pr3);
		Log.e("REcived vaule ",  "pr4: "+pr4);
		Log.e("REcived vaule ",  "pr5: "+pr5);
		Log.e("REcived vaule ",  "pr6: "+pr6);
		Log.e("REcived vaule ",  "pr7: "+pr7);
		Log.e("REcived vaule ",  "pr8: "+pr8);
		
		
		
		
		
		
		
		if(pr1.equalsIgnoreCase("1")){
			
			p1.setBackgroundResource(R.drawable.roundedbutton1);
			//p1.setBackgroundColor(Color.GREEN);
			p1.setText("P1");
			Log.e("p1 check",  "pr1: "+pr1);
	     }
		if(pr1.equalsIgnoreCase("0")){
			
			p1.setBackgroundResource(R.drawable.roundedbutton);
			//p1.setBackgroundColor(Color.RED);
			p1.setText("P1");
			Log.e("p1 check",  "pr1: "+pr1);
		     }
		
		
		
		
		if(pr2.equalsIgnoreCase("1")){
			p2.setBackgroundResource(R.drawable.roundedbutton1);
			//p2.setBackgroundColor(Color.GREEN);
			p2.setText("P2");
		     }
	     
		if(pr2.equalsIgnoreCase("0")){
			p2.setBackgroundResource(R.drawable.roundedbutton);
			//	p2.setBackgroundColor(Color.RED);
				p2.setText("P2");
			     }
			
		
		
		
		
		if(pr3.equalsIgnoreCase("1")){
				p3.setBackgroundResource(R.drawable.roundedbutton1);
				p3.setText("P3");
			     }
		
		if(pr3.equalsIgnoreCase("0")){
					p3.setBackgroundResource(R.drawable.roundedbutton);
					p3.setText("P3");
				     }
					
		
		
		if(pr4.equalsIgnoreCase("1")){
					p4.setBackgroundResource(R.drawable.roundedbutton1);
					p4.setText("P4");
				     }
					
		if(pr4.equalsIgnoreCase("0")){
						p4.setBackgroundResource(R.drawable.roundedbutton);
						p4.setText("P4");
					     }
					
		
		
		
		if(pr5.equalsIgnoreCase("1")){
						p5.setBackgroundResource(R.drawable.roundedbutton1);
						p5.setText("P5");
					     }
						
		if(pr5.equalsIgnoreCase("0")){
							p5.setBackgroundResource(R.drawable.roundedbutton);
							p5.setText("P5");
						     }
						
	
		
		if(pr6.equalsIgnoreCase("1")){
							p6.setBackgroundResource(R.drawable.roundedbutton1);
							p6.setText("P6");
						     }
							
		if(pr6.equalsIgnoreCase("0")){
								p6.setBackgroundResource(R.drawable.roundedbutton);
								p6.setText("P6");
								
							     }
							
		
		
		if(pr7.equalsIgnoreCase("1")){
								p7.setBackgroundResource(R.drawable.roundedbutton1);
								p7.setText("P7");
							     }
								
		if(pr7.equalsIgnoreCase("0")){
									p7.setBackgroundResource(R.drawable.roundedbutton);
									p7.setText("P7");
								     }

								
								
		if(pr8.equalsIgnoreCase("1")){
		p8.setBackgroundResource(R.drawable.roundedbutton1);
		p8.setText("P8");
		}							
	        if(pr8.equalsIgnoreCase("0")){
			p8.setBackgroundResource(R.drawable.roundedbutton);;
			p8.setText("P8");
				 }
	
        }							
		catch(Exception e){
			
		}
		
		return convertView;
	}

	public class ViewHolder {

		public TextView name,mobile,location;

	}
	

}
