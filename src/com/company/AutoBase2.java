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


public class AutoBase2 {
    private String id;
    private String name;
    private String driver;
    private String state;
boolean die=false;
public static final AutoBase2 AUTO_BASE_2=new AutoBase2();
Random random =new Random();
    public AutoBase2() {
    }

    public AutoBase2(String id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;

    }

    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITER_PATH = Paths.get("./Autopark.json");


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

    public static AutoBase2 makeAutopark(String id, String name, String driver, String state) {
        AutoBase2 autopark = new AutoBase2();
        autopark.id = id;
        autopark.name = name;
        autopark.driver = driver;
        autopark.state = state;
        return autopark;
    }

    public static String Auto() {
        AutoBase2[] autoparks = {
                AutoBase2.makeAutopark("1", "Renault Magnum", "", "base"),
                AutoBase2.makeAutopark("2", "Volvo", "", "base"),
                AutoBase2.makeAutopark("3", "DAF XT", "", "base"),
        };
        String s = GSON.toJson(autoparks);
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


    public String readerJson(AutoBase2 autoBase2) {
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

    public AutoBase2 readerJson2(AutoBase2 autoBase) throws IOException {


        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Auto.json\\Autopark.json")));
        JSONArray jsonArray = new JSONArray(data);
        String[] s = {"1", "2", "3"};
        Map<String, AutoBase2> autoBases = new LinkedHashMap();
        List<AutoBase2> autoBase2List = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            String print = jsonArray.get(i).toString();
            JSONObject jsonObject = new JSONObject(print);
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String driver = jsonObject.getString("driver");
            String state = jsonObject.getString("state");


            AutoBase2 autoBase2 = new AutoBase2("1", "Renault Magnum", "", "base");
            AutoBase2 autoBase3 = new AutoBase2("2", "Volvo", "", "base");
            AutoBase2 autoBase4 = new AutoBase2("3", "DAF XT", "", "base");

            autoBases.put("1", autoBase2);
            autoBases.put("2", autoBase3);
            autoBases.put("3", autoBase4);
            AutoBase2 autoBas = new AutoBase2(id, name, driver, state);
            autoBase2List.add(autoBas);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        }

        System.out.println();
        System.out.println("#  | Bus             |  Driver     |  State");
        System.out.println("———————————+—————————————+————————————+————————");
        for (int i = 0; i < autoBase2List.size(); i++) {
            System.out.print(autoBase2List.get(i).getId() + "  |");
            System.out.printf("%18s", autoBase2List.get(i).getName() + "   |");
            System.out.printf("%15s", autoBase2List.get(i).getDriver() + "      | ");
            System.out.printf("%5s", autoBase2List.get(i).getState());
            System.out.println();
        }
        System.out.println();
while (AUTO_BASE_2.died()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("AutoBase танданыз < 1 , 2 , 3");
            String id = scanner.nextLine();

            System.out.println();

            String driverJson = new String(Files.readAllBytes(Paths.get("C:\\Users\\User" +
                    "\\IdeaProjects\\ddd\\Driver.json")));
            JSONArray jsonArray2 = new JSONArray(driverJson);
            List<Driver> drivers = new ArrayList<>();
            for (int i = 0; i < jsonArray2.length(); i++) {
                String string = jsonArray2.get(i).toString();
                JSONObject jsonObject = new JSONObject(string);

                String id1 = jsonObject.getString("id");
                String name = jsonObject.getString("name");

                Driver driverOne = new Driver(id1, name);
                drivers.add(driverOne);

                String data1 = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\Auto.json\\Autopark.json")));
                JSONArray jsonArray1 = new JSONArray(data1);

                List<AutoBase2> autoBaseList = new ArrayList<>();
                for (int g = 0; g < jsonArray.length(); g++) {
                    String print = jsonArray1.get(i).toString();
                    JSONObject jsonObject1 = new JSONObject(print);
                    String id2 = jsonObject1.getString("id");
                    String name1 = jsonObject1.getString("name");
                    String driver1 = jsonObject1.getString("driver");
                    String state = jsonObject1.getString("state");

                    AutoBase2 autoBase1 = new AutoBase2("1", "Renault Magnum", "", "base");
                    AutoBase2 autoBase2 = new AutoBase2("2", "Volvo", "", "base");
                    AutoBase2 autoBase3 = new AutoBase2("3", "DAF XT", "", "base");

                    autoBases.put("1", autoBase1);
                    autoBases.put("2", autoBase2);
                    autoBases.put("3", autoBase3);
                    AutoBase2 autoBaseOne = new AutoBase2(id2, name1, driver1, state);
                    autoBaseList.add(autoBaseOne);


                }



                List<AutoBase2> list = new ArrayList<>();
                AutoBase2 autoBase1 = new AutoBase2("1", "Renault Magnum", "", "base");
                AutoBase2 autoBase2 = new AutoBase2("2", "Volvo", "", "base");
                AutoBase2 autoBase3 = new AutoBase2("3", "DAF XT", "", "base");
                List<Driver> driver = new ArrayList<>();

                list.add(autoBase1);
                list.add(autoBase2);
                list.add(autoBase3);
                driver.add(Driver.makeDriver("driver-1", "Petr"));
                driver.add(Driver.makeDriver("driver-2", "Askar"));
                driver.add(Driver.makeDriver("driver-3", "Uson"));

                if (id.equals("1")) {
                    System.out.println("Айдоочу танданыз < Uson , Askar , Petr >");
                    String driv = scanner.nextLine();

                    for (Map.Entry<String, AutoBase2> autoBase2Entry : autoBases.entrySet()) {
                        for (AutoBase2 d : autoBase2List) {
                            if (id.equals(autoBase2Entry.getKey())) {
                                if (id.equals(d.getId())) {

                                    System.out.println("N:\t    " + autoBase2Entry.getKey() + "\n" + "id \t    " + d.getId() +
                                            "\n" + "name\t" + d.getName() + "\n" +
                                            "driver:\t" + d.getDriver() + "\n" + "state:\t" + d.getState());


                                }
                            }
                        }

                    }



                    switch (driv) {

                        case "Petr":
                            System.out.println();
                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(0).getId() + "  |\t" + "%10s", list.get(0).getName() +
                                    "\t|" + driver.get(0).getName() + "   " +
                                    "    |\t" + random());
                            autoBase1.g(id);

                            break;

                        case "Askar":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(0).getId() + "  |\t" + "%10s", list.get(0).getName() +
                                    "\t|" + driver.get(1).getName() + "   " +
                                    "    |\t" + random());
                            ;autoBase1.g(id);

                            break;
                        case "Uson":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(0).getId() + "  |\t" + "%10s", list.get(0).getName() +
                                    "\t|" + driver.get(2).getName() + "   " +
                                    "    |\t" + random());

                            autoBase1.g(id);
                            break;
                        default:
                            System.out.println();
                            System.out.println("Мындай айдоочу жо");
                            autoBase1.g(id);
                    }

                } else if (id.equals("2")) {
                    System.out.println();
                    System.out.println("Айдоочу танданыз < Uson , Askar , Petr >");
                    String driv = scanner.nextLine();
                    for (Map.Entry<String, AutoBase2> autoBase2Entry : autoBases.entrySet()) {
                        for (AutoBase2 d : autoBase2List) {
                            if (id.equals(autoBase2Entry.getKey())) {
                                if (id.equals(d.getId())) {

                                    System.out.println("N:\t    " + autoBase2Entry.getKey() + "\n" + "id \t    " + d.getId() +
                                            "\n" + "name\t" + d.getName() + "\n" +
                                            "driver:\t" + d.getDriver() + "\n" + "state:\t" + d.getState());


                                }
                            }
                        }
                    }

                    switch (driv) {

                        case "Petr":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(1).getId() + "  |\t" + "%10s", list.get(1).getName() +
                                    "\t|" + driver.get(0).getName() + "   " +
                                    "    |\t" + random());

                            autoBase1.g(id);

                            break;

                        case "Askar":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(1).getId() + "  |\t" + "%10s", list.get(1).getName() +
                                    "\t|" + driver.get(1).getName() + "   " +
                                    "    |\t" + random());

                            autoBase1.g(id);

                            break;
                        case "Uson":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(1).getId() + "  |\t" + "%10s", list.get(1).getName() +
                                    "\t|" + driver.get(2).getName() + "   " +
                                    "    |\t" + random());
                            autoBase1.g(id);
                            break;
                        default:
                            System.out.println("Мындай айдоочу жок");
                            autoBase1.g(id);
                    }
                } else if (id.equals("3")) {
                    System.out.println();
                    System.out.println("Айдоочу танданыз < Uson , Askar , Petr >");
                    String driv = scanner.nextLine();
                    for (Map.Entry<String, AutoBase2> autoBase2Entry : autoBases.entrySet()) {
                        for (AutoBase2 d : autoBase2List) {
                            if (id.equals(autoBase2Entry.getKey())) {
                                if (id.equals(d.getId())) {

                                    System.out.println("N:\t    " + autoBase2Entry.getKey() + "\n" + "id \t    " + d.getId() +
                                            "\n" + "name\t" + d.getName() + "\n" +
                                            "driver:\t" + d.getDriver() + "\n" + "state:\t" + d.getState());


                                }
                            }
                        }
                    }



                    switch (driv) {

                        case "Petr":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(2).getId() + "  |\t" + "%10s", list.get(2).getName() +
                                    "\t|" + driver.get(0).getName() + "   " +
                                    "    |\t" + random());
                            System.out.println();
                            autoBase1.g(id);

                            break;

                        case "Askar":
                            System.out.println();

                            System.out.println("#  | Bus           |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(2).getId() + "  |\t" + "%10s", list.get(2).getName() +
                                    "\t|" + driver.get(1).getName() + "   " +
                                    "    |\t" + random());
                            System.out.println();
                            autoBase1.g(id);

                            break;
                        case "Uson":
                            System.out.println();

                            System.out.println("#  | Bus          |  Driver     |  State");
                            System.out.println("———————————+—————————————+————————————+————————");
                            System.out.printf(list.get(2).getId() + "  |\t" + "%10s", list.get(2).getName() +
                                    "\t|" + driver.get(2).getName() + "   " +
                                    "    |\t" + random());
                            autoBase1.g(id);
                            break;
                        default:

                            System.out.println(" Мындай айдоочу жок");
autoBase1.g(id);
                    }
                } else {
                    System.out.println("Мындай AutoBase жок");
autoBase1.g(id);
                }
            }}
            return autoBase;
        }

public static String random(){
        String one="base";
        String two="route";
        String three="repair";
        String[]g={one,two,three};
        Random random=new Random();
        int ff= random.nextInt(g.length);
        
        return g[ff];
}
   public AutoBase2 g(String id) throws IOException {
        AutoBase2 autoBase2=new AutoBase2();

return readerJson2(autoBase2);
   }
    public boolean died(){

        AutoBase2 autoBase2=new AutoBase2();
        if(readerJson(autoBase2)==null){
            die=false;
        }else {
            die=true;
        }
        return die;
    }
}




