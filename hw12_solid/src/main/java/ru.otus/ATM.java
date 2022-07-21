package ru.otus;

import java.util.TreeMap;

// класс Банкомат
public class ATM {

    private final String name;
    private Storage storage;

    public ATM(String name) {
        this.name = name;
        storage = new Storage();
    }

    public void putMoney(int denom, int count){
      System.out.println("Put money: denomination = "+ denom + ", count = "+ count);
        storage.putMoney(denom, count);
    }

    public void getMoney(int sum){
        System.out.println("Get money: "+ sum);
        TreeMap<Integer, Cell>  getM = storage.canGetMoney(sum);
        if (getM == null) System.out.println("Can't give that amount.");
        else storage.getMoney(getM);
    }

    public void printBalancebyDenom(int denom)
    {
        System.out.println("Denomination is " + denom + ", balance by denomination is "+ storage.getBalancebyDenom(denom));
    }

    public void printBalance(){
        System.out.println("Balance is " + storage.getBalance());
    }

    public void printStorage() { storage.printStorage(); }
}
