package com.collectors;

import java.util.HashMap;
import java.util.TreeMap;

public class MapValueTest {

    public static void main(String[] args) {
        HashMap<String,Double> scores = new HashMap<>();
        scores.put("Chinese",89.0);
        scores.put("Math",83.0);
        scores.put("English",99.0);
        System.out.println(scores.values());
        System.out.println(scores.values().getClass());
        TreeMap<String,Double> health = new TreeMap<>();
        health.put("height",173.5);
        health.put("weight",74.0);
        System.out.println(health.values());
        System.out.println(health.values().getClass());
    }



}
