package ru.otus;

public interface atmInterface {
    void putMoney(Denoms denom, int count);
    void giveMoney(int sum);
    void printBalance();
}
