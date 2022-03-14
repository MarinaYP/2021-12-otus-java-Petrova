package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class MyDogs extends  MyPets {
    public MyDogs(String name, char sex, int age, int weight, String character) {
        super("Dog", name, sex, age, weight, character);
        sumDogsWeight += weight;
    }

    public static int sumDogsWeight = 0;

    @Before
    public void printInfo() {
        System.out.println("-----------------------------------");
        System.out.println("My dog is crazy, just listen!");
        petsPrint();
        System.out.println("Now sumDogsWeight = "+sumDogsWeight);
    }

    @Override
    @Test
    public void setWeight(int weight){
        sumDogsWeight -= super.getWeight();
        super.setWeight(weight);
        sumDogsWeight += weight;
    }

    @After
    public void dogsPrint(){
        System.out.println(">> sumDogsWeight = "+sumDogsWeight);
    }
}