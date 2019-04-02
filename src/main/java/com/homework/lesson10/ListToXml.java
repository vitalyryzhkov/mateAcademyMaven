package com.homework.lesson10;

import org.apache.log4j.Logger;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListToXml {
    private static final Logger LOGGER = Logger.getLogger(ListToXml.class.getName());

    public void listToXml() {

        List<Map<List<Set<Integer>>, String>> mapList = new ArrayList<>();

        int elemForSet = 7;
        Set<Integer> set = new HashSet<>();
        set.add(elemForSet);

        List<Set<Integer>> setList = new ArrayList<>();
        setList.add(set);

        Map<List<Set<Integer>>, String> map = new HashMap<>();
        map.put(setList, "TestPR");

        mapList.add(map);

        convertListToXml(mapList);
    }

    public void convertListToXml(List list) {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("listToXml.xml"))) {
            encoder.writeObject(list);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
