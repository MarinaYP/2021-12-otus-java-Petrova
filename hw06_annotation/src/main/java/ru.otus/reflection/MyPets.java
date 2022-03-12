package ru.otus.reflection;
// Класс с моими домашними животными. Сеттеров на поля кто это, имя и пол нет специально, тк эти поля неизменны в течение жизни.
public abstract class MyPets {
    protected MyPets(String whoIsIt, String name, char sex, int age, int weight, String character) {
        this.whoIsIt = whoIsIt;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.character = character;
    }

    public void petsPrint() {
        System.out.println("This is " + getwhoIsIt() + ", name is " + getName() + ", sex is "+ getSex() +
                ", age is "+ getAge() + ", weight is "+ getWeight() + ", character is "+ getCharacter());
    }
    protected void setWeight(int weight) {
        this.weight = weight;
    }

    protected void setCharacter(String character) {
        this.character = character;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected String getwhoIsIt(){
        return whoIsIt;
    }

    protected String getName(){
        return name;
    }

    protected char getSex(){
        return sex;
    }

    protected int getAge(){
        return age;
    }

    protected int getWeight(){
        return weight;
    }

    protected String getCharacter(){
        return character;
    }

    private final String whoIsIt;
    private final String name;
    private final char sex;
    private int age;
    private int weight;
    private String character;
}



