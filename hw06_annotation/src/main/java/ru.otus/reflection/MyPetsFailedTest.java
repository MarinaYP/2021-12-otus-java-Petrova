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
        System.out.println("FailedTest start - canCreatePet");
        dog= new MyDogs("Other", 'M', 10, 120, "other");
        dog.printInfo();
        System.out.println("FailedTest end - canCreatePet");
    }

    @Test
    public void canChangeWeight() throws Exception {
        System.out.println("FailedTest start - canChangeWeight");
        dog.setWeight(-100); //Тут должен упасть, вес не может быть отрицательным
        System.out.println("FailedTest end - canChangeWeight");
    }

    @Test
    public void canChangeWeight_2() throws Exception {
        System.out.println("FailedTest start - canChangeWeight_2");
        dog.setWeight(100); //Тут не должен упасть
        System.out.println("FailedTest end - canChangeWeight_2");
    }

    @Test
    public void canChangeWeight_3() throws Exception {
        System.out.println("FailedTest start - canChangeWeight_3");
        dog.setWeight(0); //Тут должен упасть, вес не может быть нулевым
        System.out.println("FailedTest end - canChangeWeight_3");
    }

    @After
    public void canPrintNewWeight(){
        System.out.println("FailedTest start - canPrintNewWeight");
        dogsWeightPrint();
        System.out.println("FailedTest end - canPrintNewWeight");
    }

    private MyDogs dog;
}
