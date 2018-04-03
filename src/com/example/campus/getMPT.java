//package com.example.campus;
//
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//
//
//public class getMPT {
//	String inputString,dat2,dat1,dat,deviceid,digit1,digit2,digit;
//	String devuicetype = null;
//	String nameOfDay,days = null,reformattedStr1; 
//	String  Log1MPT,Log12MPT,dose1MPT,dose12MPT,max1MPT,max12MPT,log5minMPT;  
//	ArrayList arrayMPT=new ArrayList();
//	 String x;
//		public String getMPT1(String intString) {
//		
//		 try{	
//		 this.inputString=intString;
//		 dat1=inputString.substring(0, 8);
//	     dat2=inputString.substring(8, 16);
//	     dat=dat1+" "+dat2;
//	     
//	     deviceid=inputString.substring(16, 27);
//	     digit1=inputString.substring(27, 30);
//	     digit2=inputString.substring(30, 31);
//	     digit=digit1+"."+digit2; 
//	     SimpleDateFormat fromUser = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
//	     SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	     
//	     // System.out.println("Device ID     "+deviceid);  
//	     String reformattedStr = myFormat.format(fromUser.parse(dat));
//	     
//	     //Get Device type
//	     
//	     logmethods lm=new logmethods();
//	     devuicetype=lm.findTYPE(deviceid);		   
//	     // System.out.println(devuicetype);
//	     
//	     
//	     //get Name of day
//		 SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//         java.util.Date convertedCurrentDate = sdf.parse(dat1);
//         nameOfDay=sdf.format(convertedCurrentDate );
//         // System.out.println("date"+nameOfDay);
//         SimpleDateFormat fromUser1 = new SimpleDateFormat("yy-MM-dd"); 
//         SimpleDateFormat myFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//         reformattedStr1 = myFormat1.format(fromUser1.parse(dat1));
//         // System.out.println("reformattedStr1    "+reformattedStr1);
//         java.util.Date date=myFormat1.parse(reformattedStr1);
//         myFormat1 = new SimpleDateFormat("EEEE");
//         nameOfDay=myFormat1.format(date);
//         // System.out.println(nameOfDay);
//        
//         
//         //check sunday
//         if(nameOfDay.equalsIgnoreCase("sunday"))
//         {
//             days="H";
//            // System.out.println(nameOfDay+"  :   "+days+"     Status sunday Holiday");
//         }
//        
//         
//         //check holiday
//         else if(!nameOfDay.equalsIgnoreCase("sunday"))
//         {
//          
//        	days= lm.findHoliday(reformattedStr1);
//        	if(days.equalsIgnoreCase("H")){
//   
//        	// System.out.println(nameOfDay+"  :   "+days+"     Status festival Holiday");
//         
//        	}
//        	else{
//        	// System.out.println(nameOfDay+"  :   "+days+"     Not a holyday");	
//        	}
//         }
//         
//   
//         
//         
//         arrayMPT= lm.getAllMpt(dat2,devuicetype,days);
//         
//         // System.out.println(arrayMPT);
//         Log1MPT=(String) arrayMPT.get(0);
//         Log12MPT=(String) arrayMPT.get(1);
//         dose1MPT=(String) arrayMPT.get(2);
//         dose12MPT=(String) arrayMPT.get(3);
//         max1MPT=(String) arrayMPT.get(4);
//         max12MPT=(String) arrayMPT.get(5);
//         log5minMPT=(String) arrayMPT.get(6);
//         
//         
//          System.out.println("Log1MPT    "+Log1MPT);
//          System.out.println("Log12MPT    "+Log12MPT);
//          System.out.println("dose1MPT    "+dose1MPT);
//          System.out.println("dose12MPT    "+dose12MPT);
//          System.out.println("max1MPT    "+max1MPT);
//          System.out.println("max12MPT    "+max12MPT);
//         
//
//        NoiseServicesImpl one=new NoiseServicesImpl();
//       /* if(!Log1MPT.isEmpty())
//        {
//        	
//        }*/
////        one.log1hcalc(days,devuicetype,Log1MPT,dat1,dat2,reformattedStr, deviceid, digit,log5minMPT);
////        
////        if(!Log12MPT.equalsIgnoreCase(""))
////        {
////        	one.log12hcalc(days,devuicetype,Log12MPT,dat1,dat2,reformattedStr, deviceid, digit);
////        }
////        
////        if(!max1MPT.equalsIgnoreCase(""))
////        {
////        	one.max1hcalc(days,devuicetype,max1MPT,dat1,dat2,reformattedStr, deviceid, digit);
////        }
////        
////        if(!max12MPT.equalsIgnoreCase(""))
////        {
////        	 one.max12hcalc(days,devuicetype,max12MPT,dat1,dat2,reformattedStr, deviceid, digit);
////        }
////        
////        
////       
////        if(!dose1MPT.equalsIgnoreCase(""))
////        {
////        	one.dose1hcalc(days,devuicetype,dose1MPT,dat1,dat2,reformattedStr, deviceid, digit);
////        }
////        if(!dose12MPT.equalsIgnoreCase(""))
////        {
////        	one.dose12hcalc(days,devuicetype,dose12MPT,dat1,dat2,reformattedStr, deviceid, digit);
////        }
//        
//        
//        if(!max1MPT.equalsIgnoreCase(""))
//        {
//        	one.max1hcalc(days,devuicetype,max1MPT,dat1,dat2,reformattedStr, deviceid, digit);
//        }
//        
//        if(!max12MPT.equalsIgnoreCase(""))
//        {
//        	 one.max12hcalc(days,devuicetype,max12MPT,dat1,dat2,reformattedStr, deviceid, digit);
//        }
//        
//        
//       
//        if(!dose1MPT.equalsIgnoreCase(""))
//        {
//        	one.dose1hcalc(days,devuicetype,dose1MPT,dat1,dat2,reformattedStr, deviceid, digit);
//        }
//        if(!dose12MPT.equalsIgnoreCase(""))
//        {
//        	one.dose12hcalc(days,devuicetype,dose12MPT,dat1,dat2,reformattedStr, deviceid, digit);
//        }
//        if(!Log12MPT.equalsIgnoreCase(""))
//        {
//        	one.log12hcalc(days,devuicetype,Log12MPT,dat1,dat2,reformattedStr, deviceid, digit);
//        }
//        
//        
//         one.log1hcalc(days,devuicetype,Log1MPT,dat1,dat2,reformattedStr, deviceid, digit,log5minMPT);
//        
//        
//      
//        x= one.display();
//		 }
//		 catch(Exception ex)
//	     {
//	           ex.printStackTrace();
//	     }
//	     
//		 finally{
//	       
//	     }
//		return x;
//		
//	}
//		
//  
//}
