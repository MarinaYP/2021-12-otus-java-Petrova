package ru.otus.reflection;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;
import static ru.otus.reflection.MyCats.catsWeightPrint;
import static ru.otus.reflection.MyDogs.dogsWeightPrint;

//Класс для тестирования
public class MyPetsTest {
    public MyPetsTest(){
        arrPets = new MyPets[4] ;
    }

    @Before
    public void canCreatePet()
    {
        System.out.println("-----------------------------------");
        System.out.println("Test start - canCreatePet");
        arrPets[0]= new MyCats("Murzik", 'F', 1, 3, "funny");
        arrPets[1]= new MyCats("Nora", 'F', 5, 5, "lazy");
        arrPets[2] = new MyDogs("Ezhi", 'F', 2, 4, "crazy");
        arrPets[3]= new MyCats("Graf", 'M', 9, 5, "important");
        printInfo();
        System.out.println("Test end - canCreatePet");
    }

    @Test
    public void canChangeWeight() throws Exception {
        System.out.println("-----------------------------------");
        System.out.println("Test start - canChangeWeight");
        arrPets[0].setWeight(2);
        arrPets[1].setWeight(6);
        arrPets[2].setWeight(4);
        arrPets[3].setWeight(6);
        System.out.println("Test end - canChangeWeight");
    }

    @After
    public void canPrintNewWeight(){
        System.out.println("-----------------------------------");
        System.out.println("Test start - canPrintNewWeight");
        catsWeightPrint();
        dogsWeightPrint();
        System.out.println("Test end - canPrintNewWeight");
    }

    private MyPets[] arrPets;

    private void printInfo(){
        for (int i = 0; i < arrPets.length; i++) {
            arrPets[i].printInfo();
        }
    }
}