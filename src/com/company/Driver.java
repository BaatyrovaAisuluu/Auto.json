package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Driver {

        private  String id;
        private String name;

    public Driver() {
        }

    public Driver(String id, String name) {
            this.id = id;
            this.name = name;
        }
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITER_PATH = Paths.get("./Driver.json");

        public  String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return
                    "id='" + id + '\'' +
                            ", name='" + name + '\'' +
                            '}';
        }
    public static Driver makeDriver(String id, String name) {
        Driver autopark = new Driver();
        autopark.id = id;
        autopark.name = name;
        return autopark;
    }

    public static String Auto() {
        Driver[] drivers = {
               Driver.makeDriver("driver-1","Petr"),
               Driver.makeDriver("driver-2","Askar"),
               Driver.makeDriver("driver-3","Uson"),
        };
        String s = GSON.toJson(drivers);
        System.out.println(s);
        return s;
    }


    public void writeJson(String print) {

        Path paths = Paths.get(String.valueOf(WRITER_PATH));
        try {
            Files.writeString(paths, print, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String readerJson() {
        String p = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITER_PATH));
            int f;
            while ((f = fileReader.read()) != -1) {
                p += (char) f;
            }
            return p;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;

}
        public static Driver driver(Driver driver) throws IOException {
            String driverJson= new String(Files.readAllBytes(Paths.get("C:\\Users\\User" +
                    "\\IdeaProjects\\ddd\\Driver.json")));
            JSONArray jsonArray=new JSONArray(driverJson);
            List<Driver>drivers=new ArrayList<>();
            for (int i = 0; i <jsonArray.length(); i++) {
                String string=jsonArray.get(i).toString();
                JSONObject jsonObject=new JSONObject(string);

                String id=jsonObject.getString("id");
                String name=jsonObject.getString("name");

                Driver driverOne=new Driver(id,name);
                drivers.add(driverOne);

            }
            System.out.println();

            System.out.println("~~~~~~~~~~~~~~~~~~Экинчи этап~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("#  | Driver   | base        |");
            System.out.println("———————————+—————————+—————————+———————");
            for (int i = 0; i <drivers.size(); i++) {
                System.out.println();
                System.out.print(drivers.get(i).getId()+"  | ");
                System.out.printf("%5s",drivers.get(i).getName()+"    |");
                System.out.println("             |");
            }
//            String data=new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Auto.json\\Autopark.json")));
//            JSONArray jsonArray1=new JSONArray(data);
//
//            List<AutoBase> autoBases=new ArrayList<>();
//            for (int i = 0; i <jsonArray.length(); i++) {
//                String print=jsonArray1.get(i).toString();
//                JSONObject jsonObject1=new JSONObject(print);
//                String id=jsonObject1.getString("id");
//                String name=jsonObject1.getString("name");
//                String driver1=jsonObject1.getString("driver");
//                String state=jsonObject1.getString("state");
//
//                AutoBase autoBase1=new AutoBase(id,name,driver1,state);
//                autoBases.add(autoBase1);
//            }
//            System.out.println("~~~~~~~~~~~~~~~~Биринчи этап~~~~~~~~~~~~~~~~~~~~");
//            System.out.println();
//            System.out.println("#  | Bus             |  Driver     |  State");
//            System.out.println("———————————+—————————————+————————————+————————");
////            for (int j= 0; j < autoBases.size(); j++) {
////                System.out.println();
////                System.out.print(autoBases.get(j).getId()+"  |");
////                System.out.printf("%18s",autoBases.get(j).getName()+"   |");
////                System.out.printf("%15s",autoBases.get(j).getDriver()+"      | ");
////                System.out.printf("%5s",autoBases.get(j).getState());
////                System.out.println();
//


                return  driver;

        }
        public static void jj() throws IOException {

            }

            }

