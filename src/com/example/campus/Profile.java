package com.example.campus;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Profile extends Activity {
	 String sname,regno;
	 
	 TextView rno,name,fname,dob,gen,add,email,cour,sem,clas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
		rno=(TextView)findViewById(R.id.preno);
		name=(TextView)findViewById(R.id.pname);
		fname=(TextView)findViewById(R.id.pfname);
		dob=(TextView)findViewById(R.id.pdob);
		gen=(TextView)findViewById(R.id.pgen);
		add=(TextView)findViewById(R.id.padd);
		email=(TextView)findViewById(R.id.pemail);
		cour=(TextView)findViewById(R.id.pcur);
		sem=(TextView)findViewById(R.id.psem);
		clas=(TextView)findViewById(R.id.pclass);
		
		Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	      StrictMode.setThreadPolicy(policy);
	     getProfileDetail();
	}
	
	
	private void getProfileDetail() {
		try {
			
			String SOAP_ACTION = "http://tempuri.org/Service1";
			String METHOD_NAME = "Service1";
			String NAMESPACE = "http://tempuri.org/";
			String URL = "http://athidharman.in/android/campus/Service.asmx";
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("reg", regno);
			
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
			String b=response.getProperty(1).toString();
			
			Log.e("name",b);
			
			
			rno.setText("RegNo: "+response.getProperty(0).toString());
			name.setText("Name: "+response.getProperty(1).toString());
			fname.setText("Father Name: "+response.getProperty(2).toString());
			dob.setText("DOB: "+response.getProperty(3).toString());
			gen.setText("Gender: "+response.getProperty(4).toString());
			add.setText("Address: "+response.getProperty(5).toString());
			email.setText("Email: "+response.getProperty(6).toString());
			cour.setText("Course: "+response.getProperty(7).toString());
			sem.setText("Semester: "+response.getProperty(8).toString());
			clas.setText("Class: "+response.getProperty(9).toString());
			
		
			}
			catch (Exception e) {
				e.printStackTrace();

			}
		
	}
}
