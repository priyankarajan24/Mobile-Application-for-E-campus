package com.example.campus;

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
import android.widget.TextView;

public class TimeTable extends Activity {
	String sname,regno;
	TextView m1,m2,m3,m4,m5,m6,m7,m8;
	TextView tu1,tu2,tu3,tu4,tu5,tu6,tu7,tu8;
	TextView w1,w2,w3,w4,w5,w6,w7,w8;
	TextView th1,th2,th3,th4,th5,th6,th7,th8;
	TextView fr1,fr2,fr3,fr4,fr5,fr6,fr7,fr8;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_time_table);
		m1=(TextView)findViewById(R.id.mp1);
		m2=(TextView)findViewById(R.id.mp2);
		m3=(TextView)findViewById(R.id.mp3);
		m4=(TextView)findViewById(R.id.mp4);
		m5=(TextView)findViewById(R.id.mp5);
		m6=(TextView)findViewById(R.id.mp6);
		m7=(TextView)findViewById(R.id.mp7);
		m8=(TextView)findViewById(R.id.mp8);
		tu1=(TextView)findViewById(R.id.tup1);
		tu2=(TextView)findViewById(R.id.tup2);
		tu3=(TextView)findViewById(R.id.tup3);
		tu4=(TextView)findViewById(R.id.tup4);
		tu5=(TextView)findViewById(R.id.tup5);
		tu6=(TextView)findViewById(R.id.tup6);
		tu7=(TextView)findViewById(R.id.tup7);
		tu8=(TextView)findViewById(R.id.tup8);
		w1=(TextView)findViewById(R.id.wp1);
		w2=(TextView)findViewById(R.id.wp2);
		w3=(TextView)findViewById(R.id.wp3);
		w4=(TextView)findViewById(R.id.wp4);
		w5=(TextView)findViewById(R.id.wp5);
		w6=(TextView)findViewById(R.id.wp6);
		w7=(TextView)findViewById(R.id.wp7);
		w8=(TextView)findViewById(R.id.wp8);
		th1=(TextView)findViewById(R.id.thp1);
		th2=(TextView)findViewById(R.id.thp2);
		th3=(TextView)findViewById(R.id.thp3);
		th4=(TextView)findViewById(R.id.thp4);
		th5=(TextView)findViewById(R.id.thp5);
		th6=(TextView)findViewById(R.id.thp6);	
		th7=(TextView)findViewById(R.id.thp7);
		th8=(TextView)findViewById(R.id.thp8);
		fr1=(TextView)findViewById(R.id.frp1);
		fr2=(TextView)findViewById(R.id.frp2);
		fr3=(TextView)findViewById(R.id.frp3);
		fr4=(TextView)findViewById(R.id.frp4);
		fr5=(TextView)findViewById(R.id.frp5);
		fr6=(TextView)findViewById(R.id.frp6);	
		fr7=(TextView)findViewById(R.id.frp7);
		fr8=(TextView)findViewById(R.id.frp8);
		
		Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	      StrictMode.setThreadPolicy(policy);
	      mday();
	      tuday();
	      wday();
	      thday();
	      frday();
	      
	}
	private void mday() {
		
		try {
			
			String SOAP_ACTION = "http://tempuri.org/mdayservice";
			String METHOD_NAME = "mdayservice";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			request.addProperty("day", "Monday");
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call("http://tempuri.org/mdayservice", envelope);
			SoapObject response = (SoapObject) envelope.getResponse();;
			Log.e("a",response.getProperty(0).toString() );
			Log.e("b", response.getProperty(1).toString());
			Log.e("c", response.getProperty(2).toString());
			Log.e("d", response.getProperty(3).toString());
			String b=response.getProperty(1).toString();
			
			m1.setText(response.getProperty(0).toString());
			m2.setText(response.getProperty(1).toString());
			m3.setText(response.getProperty(2).toString());
			m4.setText(response.getProperty(3).toString());
			m5.setText(response.getProperty(4).toString());
			m6.setText(response.getProperty(5).toString());
			m7.setText(response.getProperty(6).toString());
			m8.setText(response.getProperty(7).toString());
			
			}
			catch (Exception e) {
				e.printStackTrace();

			}
	}

	private void tuday() {
		try {
			
			String SOAP_ACTION = "http://tempuri.org/mdayservice";
			String METHOD_NAME = "mdayservice";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			request.addProperty("day", "Tuesday");
			
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			Log.e("a",response.getProperty(0).toString() );
			Log.e("b", response.getProperty(1).toString());
			Log.e("c", response.getProperty(2).toString());
			Log.e("d", response.getProperty(3).toString());
	
			

			tu1.setText(response.getProperty(0).toString());
			tu2.setText(response.getProperty(1).toString());
			tu3.setText(response.getProperty(2).toString());
			tu4.setText(response.getProperty(3).toString());
			tu5.setText(response.getProperty(4).toString());
			tu6.setText(response.getProperty(5).toString());
			tu7.setText(response.getProperty(6).toString());
			tu8.setText(response.getProperty(7).toString());
		
			}
			catch (Exception e) {
				e.printStackTrace();

			}
	
		
	}
	private void wday() {
		try {
			
			String SOAP_ACTION = "http://tempuri.org/mdayservice";
			String METHOD_NAME = "mdayservice";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			request.addProperty("day", "Wednesday");
			
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			Log.e("a",response.getProperty(0).toString() );
			Log.e("b", response.getProperty(1).toString());
			Log.e("c", response.getProperty(2).toString());
			Log.e("d", response.getProperty(3).toString());
	
			

			w1.setText(response.getProperty(0).toString());
			w2.setText(response.getProperty(1).toString());
			w3.setText(response.getProperty(2).toString());
			w4.setText(response.getProperty(3).toString());
			w5.setText(response.getProperty(4).toString());
			w6.setText(response.getProperty(5).toString());
			w7.setText(response.getProperty(6).toString());
			w8.setText(response.getProperty(7).toString());
		
			}
			catch (Exception e) {
				e.printStackTrace();

			}
		
	}
	private void thday() {
try {
			
			String SOAP_ACTION = "http://tempuri.org/mdayservice";
			String METHOD_NAME = "mdayservice";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			request.addProperty("day", "Thursday");
			
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			Log.e("a",response.getProperty(0).toString() );
			Log.e("b", response.getProperty(1).toString());
			Log.e("c", response.getProperty(2).toString());
			Log.e("d", response.getProperty(3).toString());
	
			

			th1.setText(response.getProperty(0).toString());
			th2.setText(response.getProperty(1).toString());
			th3.setText(response.getProperty(2).toString());
			th4.setText(response.getProperty(3).toString());
			th5.setText(response.getProperty(4).toString());
			th6.setText(response.getProperty(5).toString());
			th7.setText(response.getProperty(6).toString());
			th8.setText(response.getProperty(7).toString());
		
			}
			catch (Exception e) {
				e.printStackTrace();

			}
	}
	private void frday() {
try {
			
			String SOAP_ACTION = "http://tempuri.org/mdayservice";
			String METHOD_NAME = "mdayservice";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			request.addProperty("day", "Friday");
			
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.dotNet = true;
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject response = (SoapObject) envelope.getResponse();
			Log.e("a",response.getProperty(0).toString() );
			Log.e("b", response.getProperty(1).toString());
			Log.e("c", response.getProperty(2).toString());
			Log.e("d", response.getProperty(3).toString());
	
			

			fr1.setText(response.getProperty(0).toString());
			fr2.setText(response.getProperty(1).toString());
			fr3.setText(response.getProperty(2).toString());
			fr4.setText(response.getProperty(3).toString());
			fr5.setText(response.getProperty(4).toString());
			fr6.setText(response.getProperty(5).toString());
			fr7.setText(response.getProperty(6).toString());
			fr8.setText(response.getProperty(7).toString());
		
			}
			catch (Exception e) {
				e.printStackTrace();

			}
		
	}

	


}
