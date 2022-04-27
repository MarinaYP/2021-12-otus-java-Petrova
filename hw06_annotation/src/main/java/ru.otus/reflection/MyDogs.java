package ru.otus.reflection;

public class MyDogs extends  MyPets {
    public MyDogs(String name, char sex, int age, int weight, String character) {
        super("Dog", name, sex, age, weight, character);
        sumDogsWeight += weight;
    }

    public static int sumDogsWeight = 0;

    @Override
    public void printInfo() {
        petsPrint();
        dogsWeightPrint();
    }

    @Override
    public void setWeight(int weight) throws Exception{
        if (weight <= 0) { sumDogsWeight = 0;
            throw new Exception("Weight can not be zero or negative!");}
        System.out.println("Dog change weight: "+super.getWeight()+ " (was), "+weight + "(became)");
        sumDogsWeight -= super.getWeight();
        super.setWeight(weight);
        sumDogsWeight += weight;
    }

    public static void dogsWeightPrint(){
        System.out.println(">> sumDogsWeight = "+sumDogsWeight);
    }
}