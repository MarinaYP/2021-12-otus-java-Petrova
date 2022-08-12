package ru.otus;

import java.util.TreeMap;

// класс Банкомат
public class ATM {
    private final Storage storage;

    public ATM() {
        storage = new Storage();
    }

    public void putMoney(/*int denom*/Denoms denom, int count){
      System.out.println("Put money: denomination = "+ denom.getDenom() + ", count = "+ count);
        storage.putMoney(denom, count);
    }

    public void getMoney(int sum){
        System.out.println("Get money: "+ sum);
        TreeMap<Denoms, Cell>  getM = storage.canGetMoney(sum);
        if (getM == null) System.out.println("Can't give that amount.");
        else storage.getMoney(getM);
    }

    public void printBalancebyDenom(Denoms denom)
    {
        System.out.println("Denomination is " + denom.getDenom() + ", balance by denomination is "+ storage.getBalancebyDenom(denom));
    }

    public void printBalance(){
        System.out.println("Balance is " + storage.getBalance());
    }

    public void printStorage() { storage.printStorage(); }
}
