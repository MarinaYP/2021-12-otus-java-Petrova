package ru.otus;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//класс Хранилище
 class Storage {
    private final TreeMap<Denoms, Cell> cells;

    protected Storage(Denoms[] denomCases){
        cells = new TreeMap<>(Comparator.reverseOrder());
        for(Denoms dc: denomCases) {
            cells.put(dc, new Cell());
        }
    }

    protected void putMoney(Denoms denom, int count) {
        cells.get(denom).putMoney(count);
    }

    /*protected int getMoneybyDenom(Denoms denom, int count){
        if (cells.get(denom).getCount() >= count) {
            cells.get(denom).getMoney(count);
            return count;
        } //если столько купюр номинала нет - возвращаем 0
        else return 0;
    }*/

    //тут ничего не снимаем, а только проверяем
    protected TreeMap<Denoms, Cell> canGetMoney(int sum){
        TreeMap<Denoms, Cell> res = new TreeMap<>(Comparator.reverseOrder());
        int delta = sum;
        int count;

        //двигаемся от большего номинала к меньшему
        for(Map.Entry<Denoms, Cell> cell : cells.entrySet()) {
            //если номинал не больше суммы и купюры есть
            if (delta >= cell.getKey().getDenom() && cell.getValue().getCount() > 0) {
                    count =  delta / cell.getKey().getDenom(); //считаем количество нужных купюр
                    if (count > cell.getValue().getCount()) count = cell.getValue().getCount();
                    res.put(cell.getKey(), new Cell(count)); //формируем результат возврата
                    delta -= count* cell.getKey().getDenom(); //вычитаем, что сформировали
            }
        }
        if (delta == 0) {return res;}
        else {
            System.out.println("delta = " + delta);
            return null;
        }
    }

    //тут производим снятие
    protected void getMoney(TreeMap<Denoms,Cell> getM){
        for(Map.Entry<Denoms, Cell> one : getM.entrySet()) {
           cells.floorEntry(one.getKey()).getValue().giveMoney(one.getValue().getCount());
           System.out.println("Get denomination "+ one.getKey() + ", count " + one.getValue().getCount());
        }
    }

    //возвращает количество валют по заданному номиналу
    protected int getBalancebyDenom(Denoms denom){
        return denom.getDenom()*cells.get(denom).getCount();
    }

    protected int getBalance(){
        int res = 0;
        for(Map.Entry<Denoms, Cell> cell : cells.entrySet()){
            res += cell.getKey().getDenom() * cell.getValue().getCount();
        }
        return res;
    }

    protected void printStorage(){
        for(Map.Entry<Denoms, Cell> cell : cells.entrySet()){
            System.out.println("key = "+cell.getKey().getDenom()+", count = " + cell.getValue().getCount());
        }
    }
}
