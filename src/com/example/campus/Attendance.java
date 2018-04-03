package com.example.campus;

import java.util.ArrayList;
import java.util.HashMap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class Attendance extends Activity {
	 String sname,regno;
	 Button Search;
	 String dat,sem,p1,p2,p3,p4,p5,p6,p7,p8;
	 ListView list;
	 HashMap<String, String> data;
	 Spinner sp;
	 ArrayList<HashMap<String, String>> myArraylist = new ArrayList<HashMap<String, String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_attendance);
		sp=(Spinner)findViewById(R.id.asems);
		Search=(Button)findViewById(R.id.Search);
		Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	      StrictMode.setThreadPolicy(policy);
	      
	      Search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				 SoapGetmobno();
					myArraylist = SoapGetmobno();
					SampleListAdapter sample = new SampleListAdapter(myArraylist,
							getApplicationContext());
			      
					list = (ListView) findViewById(R.id.listView1);
					//list.cle
					list.setAdapter(sample);	
				
			}
		});
	     
	      
	}
	private ArrayList<HashMap<String, String>> SoapGetmobno() {
		ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
		try{
			String SOAP_ACTION = "http://tempuri.org/SpLoad1a";
			String METHOD_NAME = "SpLoad1a";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("regno", regno);
			request.addProperty("name", sname);
			request.addProperty("Sem", sp.getSelectedItem().toString());
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			for (int i = 0; i < response.getPropertyCount(); i++) {
				SoapObject aresponse = (SoapObject) response.getProperty(i);
				dat= aresponse.getProperty("created_at").toString();
				sem=aresponse.getProperty("sem").toString();
				p1=aresponse.getProperty("period1").toString();
				p2=aresponse.getProperty("period2").toString();
				p3=aresponse.getProperty("period3").toString();
				p4=aresponse.getProperty("period4").toString();
				p5=aresponse.getProperty("period5").toString();
				p6=aresponse.getProperty("period6").toString();
				p7=aresponse.getProperty("period7").toString();
				p8=aresponse.getProperty("period8").toString();
				
				data = new HashMap<String, String>();
				data.put("date", dat);
				data.put("sem", sem);
				data.put("p1", p1);
				data.put("p2", p2);
				
				data.put("p3", p3);
				data.put("p4", p4);
				
				data.put("p5", p5);
				data.put("p6", p6);
				data.put("p7", p7);
				data.put("p8", p8);
				lista.add(data);
				
				Log.e("Values",p1+"   "+dat);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return lista;
		
		
	}
}
