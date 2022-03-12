package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class MyDogs extends  MyPets {
    @Before
    public MyDogs(String name, char sex, int age, int weight, String character) {
        super("Dog", name, sex, age, weight, character);
        sumDogsWeight += weight;
    }

    public static int sumDogsWeight;

    @Override
    @Test
    public void setWeight(int weight){
        sumDogsWeight -= super.getWeight();
        super.setWeight(weight);
        sumDogsWeight += weight;
    }

    @After
    public void dogsPrint(){
        petsPrint();
        System.out.println("sumDogsWeight="+sumDogsWeight);
    }
}