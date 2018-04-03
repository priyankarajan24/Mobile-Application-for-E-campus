package com.example.campus;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
  public static void main(String[] argv) throws Exception {
    Format formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
    String today = formatter.format(new Date());
    System.out.println("Today : " + today);
  }
}