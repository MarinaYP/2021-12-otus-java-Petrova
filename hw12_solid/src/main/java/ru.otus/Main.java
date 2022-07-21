package ru.otus;

//запускалка банкомата
public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM("Банкомат МойБанк");
        //заполняем банкомат рублями
        atm.putMoney(5000, 1);
        atm.putMoney(1000, 5);
        atm.putMoney(500, 10);
        atm.putMoney(100, 20);
        //печать баланса денег и печать размещения в хранилище
        atm.printBalance();
        atm.printStorage();
        //попытка снять неверную сумму
        atm.getMoney(11150);
        //попытка снять верную сумму
        atm.getMoney(11100);
        //печать остаточного баланса денег и печать размещения в хранилище
        atm.printStorage();
        atm.printBalance();
    }
}
