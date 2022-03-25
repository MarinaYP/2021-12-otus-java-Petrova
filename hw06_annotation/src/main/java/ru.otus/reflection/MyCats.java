package ru.otus.reflection;

public class MyCats extends MyPets{
    public MyCats(String name, char sex, int age, int weight, String character){
        super("Cat", name, sex, age, weight, character);
        sumCatsWeight += weight;
    }

    public static int sumCatsWeight = 0;

    @Override
    public void printInfo() {
        petsPrint();
        catsWeightPrint();
    }

    @Override
    public void setWeight(int weight)  throws Exception{
        if (weight <= 0) {throw new Exception("Weight can not be zero or negative!");}
        System.out.println("Cat change weight: "+super.getWeight()+ " (was), "+weight + "(became)");
        sumCatsWeight -= super.getWeight();
        super.setWeight(weight);
        sumCatsWeight += weight;
    }

    public static void catsWeightPrint(){
        System.out.println(">>sumCatsWeight = "+sumCatsWeight);
    }
}

