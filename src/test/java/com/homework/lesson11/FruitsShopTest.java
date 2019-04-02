package com.homework.lesson11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homework.lesson11pr.Fruits;
import com.homework.lesson11pr.FruitsShop;
import com.homework.lesson11pr.FruitsType;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FruitsShopTest {

    ObjectMapper objectMapper;
    private FruitsShop fruitsShop;
    private List<Fruits> fruitsList;

    @Before
    public void setUp() {
        fruitsShop = new FruitsShop();
    }

    @Test
    public void addFruits() {
        try {
            fruitsShop.addFruits("src/main/resources/fruitApple.json");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void save() {
        try {
            fruitsShop.save("src/main/resources/fruitApple.json");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void load() {
        try {
            fruitsShop.load("src/main/resources/fruitApple.json");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Test
    public void getSpoiledFruits() {
        int countSpoiledFruits = fruitsShop.getSpoiledFruits(LocalDate.of(2017, 1, 1)).size();
        assertEquals((countSpoiledFruits), 0);
    }

    @Test
    public void getSpoiledFruitsWithType() {
        int countSpoiledFruitsWithType = fruitsShop.getSpoiledFruits(LocalDate.of(2019, 1, 1), FruitsType.APPLE).size();
        assertEquals((countSpoiledFruitsWithType), 0);
    }

    @Test
    public void getAvailableFruits() {
        int countAvailableFruits = fruitsShop.getAvailableFruits(LocalDate.of(2019, 2, 2)).size();
        assertEquals((countAvailableFruits), 1);
    }

    @Test
    public void getAvailableFruitsWithType() {
        int countAvailableFruitsWithType = fruitsShop.getAvailableFruits(LocalDate.of(2019, 2, 2), FruitsType.APPLE).size();
        assertEquals((countAvailableFruitsWithType), 1);
    }
}