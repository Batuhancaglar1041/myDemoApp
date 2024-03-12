package com.mycompany.app;


import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App
{
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, Jumboss World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            String input1 = req.queryParams("inputlist1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList1.add(value);
            }
            System.out.println(inputList1);










            String input2 = req.queryParams("inputlist2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }
            System.out.println(inputList2);






            String inputint1 = req.queryParams("input1").replaceAll("\\s","");
            int input1AsInt = Integer.parseInt(inputint1);
            System.out.println(input1AsInt);

            String inputint2 = req.queryParams("input2").replaceAll("\\s","");
            int input2AsInt = Integer.parseInt(inputint2);
            System.out.println(input2AsInt) ;


            int result = App.customMethod(inputList1,inputList2,input1AsInt ,input2AsInt);

            Map map = new HashMap();
            map.put("ggggggggggggg", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }




    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static int customMethod( ArrayList<Integer> list1, ArrayList<Integer> list2,int num1, int num2) {
        // Örnek bir işlem yapalım, iki sayının toplamını ve iki liste arasındaki eleman sayılarının çarpımını döndürelim
        int sum = num1 + num2;
        int product = list1.size() * list2.size();
        return sum * product;
    }




    }



