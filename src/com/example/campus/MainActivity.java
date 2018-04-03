package com.example.campus;

import java.util.Calendar;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
     Button signin;
     EditText rno,pass,dob;
 	private Calendar cal;
 	private int day;
 	private int month;
 	private int year;

 	public int DATE_PICKER_ID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rno=(EditText)findViewById(R.id.reno);
        pass=(EditText)findViewById(R.id.pass);
        dob=(EditText)findViewById(R.id.Dob);
        signin=(Button)findViewById(R.id.Sign);
        cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		dob.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				;
//				DATE_PICKER_ID = 1;
//				showDialog(DATE_PICKER_ID);
			}
		});
		
		signin.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
		           String dat,regno,upass;
		           dat=dob.getText().toString();
		           regno=rno.getText().toString();
		           upass=pass.getText().toString();
		           if(!dat.equalsIgnoreCase("")&&!regno.equalsIgnoreCase("")&&!upass.equalsIgnoreCase("")){
		        	   
		        	   try {
		       			String SOAP_ACTION = "http://tempuri.org/dlogin1";
		       			String METHOD_NAME = "dlogin1";
		       			String NAMESPACE = "http://tempuri.org/";
		       			String URL = "http://localhost/android/campus/Service.asmx";
		       			

		       			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		       	        request.addProperty("name", regno);
		       			request.addProperty("password", upass);
		       			request.addProperty("dob", dat);
		       			 Log.e(dat, pass.getText().toString()+"       "+regno);
		       			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
		       					SoapEnvelope.VER11);
		       			envelope.dotNet = true;
		       			envelope.setOutputSoapObject(request);
		       			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		       			androidHttpTransport.call(SOAP_ACTION, envelope);
		       			final Object result = (Object) envelope.getResponse();
                        Log.e("result", result.toString());	
		       			if (result.toString().equals("1")) {

		       				Intent in=new Intent(MainActivity.this,HomePage.class);
		       				in.putExtra("regno",regno);
		       				in.putExtra("sname",upass);
		       				startActivity(in);
		       				finish();
		       				
		       				Toast.makeText(getApplicationContext(), "Welcome To User Home",
		       						Toast.LENGTH_LONG).show();
		       			
		       			} else if (result.toString().equals("2")) {
		       				Toast.makeText(getApplicationContext(), "Please Enter Vaild Information",
		       						Toast.LENGTH_LONG).show();
		       			} 

		       		} catch (Exception e) {
		       			e.printStackTrace();

		       		}
		        	   
		        	
		           }
		           else{
		        	   Toast.makeText(getApplicationContext(), "Please Select All value", 3000).show();
		           }
			}
		});
    }
	protected Dialog onCreateDialog(int id) {

		switch (id) {
		case 1: {
			return new DatePickerDialog(this, datePickerListener, year, month,
					day);
		}
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			dob.setText(selectedDay + "/" + (selectedMonth + 1) + "/"
					+ selectedYear);
		}
	};
}
