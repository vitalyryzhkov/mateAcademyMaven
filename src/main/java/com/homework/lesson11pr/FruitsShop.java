
package com.homework.lesson11pr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class FruitsShop {
    private List<Fruits> fruitsArrayList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public void addFruits(String pathToJsonFile) throws IOException {
        List<Fruits> fruitsList;
        fruitsList = (objectMapper.readValue(new File(pathToJsonFile), new TypeReference<List<Fruits>>() {
        }));
        fruitsArrayList.addAll(fruitsList);
    }

    public void save(String pathToJsonFile) throws IOException {
        objectMapper.writeValue(new File(pathToJsonFile), fruitsArrayList);
    }

    public void load(String pathToJsonFile) throws IOException {
        fruitsArrayList.clear();

        fruitsArrayList.add(objectMapper.readValue(new File(pathToJsonFile), new TypeReference<List<Fruits>>() {
        }));
    }

    public List<Fruits> getSpoiledFruits(LocalDate localDate) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits x : fruitsArrayList) {
            if (parseDate(x)
                    .isBefore(localDate)) {
                list.add(x);
            }
        }
        return list;
    }

    public List<Fruits> getSpoiledFruits(LocalDate targetDate, FruitsType type) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits x : fruitsArrayList) {
            if (parseDate(x)
                    .isBefore(targetDate) && x.getType().equals(type)) {
                list.add(x);
            }
        }
        return list;
    }

    public List<Fruits> getAvailableFruits(LocalDate targetDate) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits x : fruitsArrayList) {
            if (parseDate(x).isAfter(targetDate)) {
                list.add(x);
            }
        }
        return list;
    }

    public List<Fruits> getAvailableFruits(LocalDate targetDate, FruitsType type) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits x : fruitsArrayList) {
            if (parseDate(x).isAfter(targetDate)) {
                list.add(x);
            }
        }
        return list;
    }

    private LocalDate parseDate(Fruits fruits) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return LocalDate.parse(fruits.getDateDelivery(), formatter).plusDays(fruits.getShelfLife());
    }
}
