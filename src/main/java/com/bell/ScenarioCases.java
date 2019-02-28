package com.bell;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ScenarioCases {
    public List<Map<String, String>> getCases() {
        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> list = new LinkedList<>();
        map.put("6449013711","ООО \"ПРИМЕР\"");
        map.put("7707329152","ФНС РОССИИ");
        map.entrySet().forEach(entry -> {
            Map<String, String> mapTemp = new HashMap<String, String>();
            mapTemp.put("key", entry.getKey());
            mapTemp.put("value", entry.getValue());
            list.add(mapTemp);
        });
        return  list;
    }
}
