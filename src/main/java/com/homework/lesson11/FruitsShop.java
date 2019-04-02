package com.homework.lesson11;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class FruitsShop {
    private List<Fruits> fruitsArrayList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    public void addFruits(String pathToJsonFile) throws IOException {
        List<Fruits> fruitsList = (objectMapper.readValue(new File(pathToJsonFile), new TypeReference<List<Fruits>>() {
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
        return fruitsArrayList.stream().filter(x -> parseDate(x)
                .isBefore(localDate)).collect(Collectors.toList());
    }

    public List<Fruits> getSpoiledFruits(LocalDate targetDate, FruitsType type) {
        return fruitsArrayList.stream().filter(x -> parseDate(x)
                .isBefore(targetDate) && x.getType().equals(type)).collect(Collectors.toList());
    }

    public List<Fruits> getAvailableFruits(LocalDate targetDate) {
        return fruitsArrayList.stream().filter(x -> parseDate(x).isAfter(targetDate)).collect(Collectors.toList());
    }

    public List<Fruits> getAvailableFruits(LocalDate targetDate, FruitsType type) {
        return fruitsArrayList.stream().filter(x -> parseDate(x).isAfter(targetDate)).collect(Collectors.toList());
    }

    private LocalDate parseDate(Fruits fruits) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        return LocalDate.parse(fruits.getDateDelivery(), formatter).plusDays(fruits.getShelfLife());
    }
}
