package com.homework.lesson11;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class FruitsShopTest {

    ObjectMapper objectMapper;
    private FruitsShop fruitsShop;
    private List<Fruits> fruitsList = new ArrayList<>();

    @Before
    public void setUp() {
        Fruits pear = new Fruits();
        fruitsShop = new FruitsShop();
        pear.setType(FruitsType.PEAR);
        pear.setDateDelivery(2019, 3, 7);
        pear.setPrice(30);
        fruitsList.add(pear);
    }

//    @Test
//    public void addFruits() {
//        fruitsShop.addFruits("src/main/resources/fruitApple.json");
//        assertEquals(4, fruitsShop.getFruitsArrayList().size());
//    }
//
//    @Test
//    public void save() {
//        fruitsShop.save("src/main/resources/fruitApple.json");
//        assertEquals(4, fruitsShop.getFruitsArrayList().size());
//    }
//
//    @Test
//    public void load() {
//        fruitsShop.load("src/main/resources/fruitApple.json");
//        assertEquals(4, fruitsShop.getFruitsArrayList().size());
//    }

    @Test
    public void getSpoiledFruits() {
        int countSpoiledFruits = fruitsShop.getSpoiledFruits(LocalDate.of(2017, 1, 1)).size();
        int countSpoiledFruits2 = fruitsShop.getSpoiledFruits(LocalDate.of(2019, 5, 5)).size();
        assertEquals((countSpoiledFruits), 0);
        assertEquals((countSpoiledFruits2), 1);
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