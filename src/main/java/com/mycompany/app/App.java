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

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            String inputArr1 = req.queryParams("inputParam1Arr");
            java.util.Scanner sc1 = new java.util.Scanner(inputArr1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext()) {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }

            String inputArr2 = req.queryParams("inputList2");
            java.util.Scanner sc2 = new java.util.Scanner(inputArr2);
            sc2.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
            while (sc2.hasNext()) {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList2.add(value);
            }

            int[] inputParam1Arr = new int[inputList.size()];
            for (int i = 0; i < inputParam1Arr.length; i++) {
                inputParam1Arr[i] = inputList.get(i);
            }

            String input2 = req.queryParams("input2AsInt").replaceAll("\\s","");
            if (input2.equals("")) // is empty
                input2 = "0"; // set to zero
            int input2AsInt = Integer.parseInt(input2);

            String inputBool = req.queryParams("valid").replaceAll("\\s","");
            if (inputBool.equals("")) // is empty
                inputBool = "0"; // set to zero

            int inputBoolAsInt = Integer.parseInt(inputBool);

            boolean valid = false;
            if (inputBoolAsInt == 1) valid = true;

            double result = calculateAverage(inputList, inputParam1Arr);

            Map<String, Object> map = new HashMap<>();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());

        get("/compute", (rq, rs) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("result", "not computed yet!");
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static double calculateAverage(ArrayList<Integer> list, int[] array) {
        // Listeden ve diziden alınan sayıların ortalamasını hesaplar
        int sumList = 0;
        for (int num : list) {
            sumList += num;
        }

        int sumArray = 0;
        for (int num : array) {
            sumArray += num;
        }

        double average =  (double) (sumList + sumArray) / (list.size() + array.length);
        return average;
    }


    }



