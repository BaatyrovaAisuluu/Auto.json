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
import java.util.*;
//public static final AutoJson AUTOPARK=new AutoJson();
//public static final AutoBase AUTOPARK_1=new AutoBase();
//public static final Driver DRIVER=new Driver();
//public static final AutoBase2 AUTO_BASE_2=new AutoBase2();
//
//
//public static void main(String[] args) throws IOException {
//
//// AUTOPARK.writeJson(AutoJson.Auto());
//        AutoBase.readerJson(AUTOPARK_1);
//        // Driver.Auto();
//        //DRIVER.writeJson(Driver.Auto());
//        Driver.driver(DRIVER);
////AutoBase2.Auto();
//        AUTO_BASE_2.writeJson(AutoBase2.Auto());
//        AUTO_BASE_2.readerJson2(AUTO_BASE_2);
//        }
//
//        }


public class AutoJson  {
    private String id;
    private String name;
    private String driver;
    private String state;

    public AutoJson() {
    }

    public AutoJson(String id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }
    public static final GsonBuilder BUILDER=new GsonBuilder();
    public static final Gson GSON=BUILDER.setPrettyPrinting().create();
    public static final Path WRITER_PATH= Paths.get("./Autopark.json");

    public String getId() {
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Autopark{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public  static AutoJson makeAutopark(String id, String name, String driver, String state){
        AutoJson autopark=new AutoJson();
        autopark.id=id;
        autopark.name=name;
        autopark.driver=driver;
        autopark.state=state;
        return autopark;
    }
    public static String Auto(){
        AutoJson[] autoparks = {
                AutoJson.makeAutopark("1", "Renault Magnum", "","base"),
                AutoJson.makeAutopark("2", "Volvo", "", "base"),
                AutoJson.makeAutopark("3", "DAF XT", "", "base"),
        };
        String s = GSON.toJson(autoparks);
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
        String p="";
        try {
            FileReader fileReader=new FileReader(String.valueOf(WRITER_PATH));
            int f;
            while ((f=fileReader.read())!=-1){
                p+=(char)f;
            }
            return p;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
    public static AutoJson  readerJson(AutoJson autoBase) throws IOException {

        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Auto.json\\Autopark.json")));
        JSONArray jsonArray = new JSONArray(data);
        Map<String, AutoJson> autoBases = new LinkedHashMap();
        List<AutoJson> autoBases2 = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String print = jsonArray.get(i).toString();
            JSONObject jsonObject = new JSONObject(print);
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String driver = jsonObject.getString("driver");
            String state = jsonObject.getString("state");

            AutoJson autoBase2 = new AutoJson(id, name, driver, state);
            autoBases2.add(autoBase2);
        }
        System.out.println("~~~~~~~~~~~~~~~~Биринчи этап~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("#  | Bus             |  Driver     |  State");
        System.out.println("———————————+—————————————+————————————+————————");
        for (int j = 0; j < autoBases2.size(); j++) {
            System.out.println();
            System.out.print(autoBases2.get(j).getId() + "  |");
            System.out.printf("%18s", autoBases2.get(j).getName() + "   |");
            System.out.printf("%15s", autoBases2.get(j).getDriver() + "      | ");
            System.out.printf("%5s", autoBases2.get(j).getState());
            System.out.println();
        }
        return autoBase;
    }}
