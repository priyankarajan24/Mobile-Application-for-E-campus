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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends Activity {
	 String sname,regno;
	 EditText e1;
	 Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		e1=(EditText)findViewById(R.id.et_feedback);
		b1=(Button)findViewById(R.id.dialogButtonOK);
		Intent intent = getIntent();
		  regno= intent.getStringExtra("regno");
		  sname= intent.getStringExtra("sname");
		  
		  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	      StrictMode.setThreadPolicy(policy);
	      
	      b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 sendEmail();
				
				
//				  try {
//		       			String SOAP_ACTION = "http://tempuri.org/InsertService";
//		       			String METHOD_NAME = "InsertService";
//		       			String NAMESPACE = "http://tempuri.org/";
//		       			String URL = "http://localhost/android/campus/Service.asmx";
//		       			
//
//		       			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
//		       	        request.addProperty("regno", regno);
//		       			
//		       			request.addProperty("feedback", e1.getText().toString());
//		       			
//		       			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
//		       					SoapEnvelope.VER11);
//		       			envelope.dotNet = true;
//		       			envelope.setOutputSoapObject(request);
//		       			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
//		       			androidHttpTransport.call(SOAP_ACTION, envelope);
//		       			final Object result = (Object) envelope.getResponse();
//                      Log.e("result", result.toString());	
//		       			if (result.toString().equals("1")) {
//
//		       				
//		       				
//		       				
//		       				Toast.makeText(getApplicationContext(), "Sucessfully Send",
//		       						Toast.LENGTH_LONG).show();
//		       			
//		       			} else if (result.toString().equals("2")) {
//		       				Toast.makeText(getApplicationContext(), "Not Send",
//		       						Toast.LENGTH_LONG).show();
//		       			} 
//
//		       		} catch (Exception e) {
//		       			e.printStackTrace();
//
//		       		}
			}
		});
	}
	
	  private void sendEmail() {
	        //Getting content for email
	        String email = "ecampuskgisl@gmil.com";
	        String subject = "Feedback";
	        String message =e1.getText().toString() +"by "+regno;
	        
	        //Creating SendMail object 
	        SendMail sm = new SendMail(this, email, subject, message);
	        
	        //Executing sendmail to send email
	        sm.execute();
	        e1.setText("");
	    }
	 
}
