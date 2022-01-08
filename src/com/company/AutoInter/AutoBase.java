package com.company.AutoInter;

import com.google.gson.JsonArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AutoBase {
    private String id;
    private String name;
    private String driver;
    private String state;


    public AutoBase() {
    }

    public AutoBase(String id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state=state;

}



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
        return "Autopark1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", driver='" + driver + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
 public void readerJson() throws IOException {
        String data=new String(Files.readAllBytes(Paths.get("./Autopark")));



 }

    public static void print(List<AutoBase>autoBases){
        for (int i = 0; i < 3; i++) {
            System.out.println();
            System.out.print(autoBases.get(i).getId()+"  |");
            System.out.printf("%18s",autoBases.get(i).getName()+"   |");
            System.out.printf("%15s",autoBases.get(i).getName()+"  | On");
            System.out.printf("%5s",autoBases.get(i).getState());
        }

    }
}
