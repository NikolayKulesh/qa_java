package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    public Lion(String sex) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean isHasMane() {
        return hasMane;
    }

    private Kittens kittens;
    private Predator predator;

    public Lion (Feline feline) {
        this.kittens = feline;
        this.predator = feline;
    }

    public int addKittens() {
        return kittens.getKittens();
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

}
