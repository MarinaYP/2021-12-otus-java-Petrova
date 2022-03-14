package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class MyCats extends MyPets{
    public MyCats(String name, char sex, int age, int weight, String character){
        super("Cat", name, sex, age, weight, character);
        sumCatsWeight += weight;
    }

    public static int sumCatsWeight = 0;

    @Before
    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println("I want to tell you about the Cats!");
        petsPrint();
        System.out.println("Now sumCatsWeight = "+sumCatsWeight);
    }

    @Override
    @Test
    public void setWeight(int weight) {
        System.out.println("Cat change weight: "+super.getWeight()+ " (was), "+weight + "(became)");
        sumCatsWeight -= super.getWeight();
        super.setWeight(weight);
        sumCatsWeight += weight;
    }

    @After
    public void catsPrint(){
        System.out.println(">>sumCatsWeight = "+sumCatsWeight);
    }
}

