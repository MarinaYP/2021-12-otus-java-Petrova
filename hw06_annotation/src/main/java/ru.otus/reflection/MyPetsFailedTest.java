package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

import static ru.otus.reflection.MyDogs.dogsWeightPrint;

public class MyPetsFailedTest {
    public MyPetsFailedTest(){}

    @Before
    public void canCreatePet()
    {
        System.out.println("Failed Test start - canCreatePet");
        dog= new MyDogs("Other", 'M', 10, 120, "other");
        dog.printInfo();
        System.out.println("Failed Test end - canCreatePet");
    }

    @Test
    public void canChangeWeight() throws Exception {
        System.out.println("Failed Test start - canChangeWeight");
        dog.setWeight(-100); //Тут должен упасть, вес не может быть отрицательным
        System.out.println("Failed Test end - canChangeWeight");
    }

    @After
    public void canPrintNewWeight(){
        System.out.println("Failed Test start - canPrintNewWeight");
        dogsWeightPrint();
        System.out.println("Failed Test end - canPrintNewWeight");
    }

    private MyDogs dog;
}
