package ru.otus;

import java.util.TreeMap;

// класс Банкомат
public class ATM implements atmInterface{
    private final Storage storage;

    public ATM(Denoms[] denom) {
        storage = new Storage(denom);
    }

    public void putMoney(Denoms denom, int count){
      System.out.println("Put money: denomination = "+ denom.getDenom() + ", count = "+ count);
        storage.putMoney(denom, count);
    }

    public void giveMoney(int sum){
        System.out.println("Get money: "+ sum);
        TreeMap<Denoms, Cell>  getM = storage.canGetMoney(sum);
        if (getM == null) {System.out.println("Can't give that amount.");}
        else {storage.giveMoney(getM);}
    }

    public void printBalance(){
        System.out.println("Balance is " + storage.getBalance());
    }

    public void printStorage() { storage.printStorage(); }
}
