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

public class Marks extends Activity {
      Button imark;  
      String sname,regno;
 	 	ListView list;
 	 	String p1,p2,p3,p4,p5,p6,p7,p8;
 	 HashMap<String, String> data;
 	 Spinner sp;
 	 ArrayList<HashMap<String, String>> myArraylist = new ArrayList<HashMap<String, String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marks);
		imark=(Button)findViewById(R.id.imark);
		Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	      StrictMode.setThreadPolicy(policy);
	      
		imark.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 SoapGetmobno();
					myArraylist = SoapGetmobno();
					SampleListAdapter1 sample = new SampleListAdapter1(myArraylist,
							getApplicationContext());
			      
					list = (ListView) findViewById(R.id.listView2);
					//list.cle
					list.setAdapter(sample);
				
			}
		});
	}
	protected ArrayList<HashMap<String, String>> SoapGetmobno() {
		ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String, String>>();
		String SOAP_ACTION = "http://tempuri.org/imarks1";
		String METHOD_NAME = "imarks1";
		String NAMESPACE = "http://tempuri.org/";
		String URL = "http://localhost/android/campus/Service.asmx";
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		try{
			request.addProperty("regno", regno);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			for (int i = 0; i < response.getPropertyCount(); i++) {
				SoapObject aresponse = (SoapObject) response.getProperty(i);
				p1=aresponse.getProperty("pp1").toString();
				p2=aresponse.getProperty("pp2").toString();
				p3=aresponse.getProperty("pp3").toString();
				p4=aresponse.getProperty("pp4").toString();
				p5=aresponse.getProperty("pp5").toString();
				data = new HashMap<String, String>();
				data.put("p1", p1);
				data.put("p2", p2);
				
				data.put("p3", p3);
				data.put("p4", p4);
				
				data.put("p5", p5);
				lista.add(data);
				
				Log.e("Values",p1+"   "+p1);
			}	
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return lista;
		
		
	}
	
	
	
	
	
	
	
}
