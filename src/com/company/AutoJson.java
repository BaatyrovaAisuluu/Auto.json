package com.company;

import com.company.AutoInter.JsonImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AutoJson implements JsonImpl {
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
                AutoJson.makeAutopark("1", "Renault Magnum", "", "base"),
                AutoJson.makeAutopark("2", "Volvo", "", "base"),
                AutoJson.makeAutopark("3", "DAF XT", "", "base"),
        };
        String s = GSON.toJson(autoparks);
        System.out.println(s);
        return s;
    }

    @Override
    public void writeJson(String print) {

        Path paths = Paths.get(String.valueOf(WRITER_PATH));
        try {
            Files.writeString(paths, print, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
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

}
