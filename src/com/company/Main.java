package com.company;


import java.io.IOException;

public class Main {

public static final AutoJson AUTOPARK=new AutoJson();
//public static final AutoBase AUTOPARK_1=new AutoBase();
public static final Driver DRIVER=new Driver();
public static final AutoBase2 AUTO_BASE_2=new AutoBase2();


    public static void main(String[] args) throws IOException {

// AUTOPARK.writeJson(AutoJson.Auto());
//AutoBase.readerJson(AUTOPARK_1);
AutoJson.readerJson(AUTOPARK);
  //      Driver.Auto();
   //  DRIVER.writeJson(Driver.Auto());
       Driver.driver(DRIVER);
//AutoBase2.Auto();
    //   AUTO_BASE_2.writeJson(AutoBase2.Auto());
    AUTO_BASE_2.readerJson2(AUTO_BASE_2);

    }

    }

