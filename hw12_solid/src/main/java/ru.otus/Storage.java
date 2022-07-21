package ru.otus;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//класс Хранилище
 class Storage {
    private TreeMap<Integer, Cell> cells;

    protected Storage(){
        cells = new TreeMap<>(Comparator.reverseOrder());
        cells.put(50, new Cell());
        cells.put(100, new Cell());
        cells.put(200, new Cell());
        cells.put(500, new Cell());
        cells.put(1000, new Cell());
        cells.put(2000, new Cell());
        cells.put(5000, new Cell());
    }

    protected void putMoney(int denom, int count) {
        cells.get(denom).putMoney(count); //тут проверить на null (может написать тесты??)
    }

    protected int getMoneybyDenom(int denom, int count){
        if (cells.get(denom).getCount() >= count) {
            cells.get(denom).getMoney(count);
            return count;
        } //если столько купюр номинала нет - возвращаем 0
        else return 0;
    }

    //тут ничего не снимаем, а только проверяем
    protected TreeMap<Integer, Cell> canGetMoney(int sum){
        TreeMap<Integer, Cell> res = new TreeMap<>(Comparator.reverseOrder());
        int delta = sum;
        int count = 0;

        //двигаемся от большего номинала к меньшему
        for(Map.Entry<Integer, Cell> cell : cells.entrySet()) {
            //если номинал не больше суммы и купюры есть
            if (delta >= cell.getKey() && cell.getValue().getCount() > 0) {
                    count =  delta / cell.getKey(); //считаем количество нужных купюр
                    if (count > cell.getValue().getCount()) count = cell.getValue().getCount();
                    res.put(cell.getKey(), new Cell(count)); //формируем результат возврата
                    delta -= count* cell.getKey(); //вычитаем, что сформировали
            }
        }
        if (delta == 0) return res;
        else {
            System.out.println("delta = " + delta);
            return null;
        }
    }

    //тут производим снятие
    protected void getMoney(TreeMap<Integer,Cell> getM){
        for(Map.Entry<Integer, Cell> one : getM.entrySet()) {
           cells.floorEntry(one.getKey()).getValue().getMoney(one.getValue().getCount());
           System.out.println("Get denomination "+ one.getKey() + ", count " + one.getValue().getCount());
        }
    }

    //возвращает количество валют по заданному номиналу
    protected int getBalancebyDenom(int denom){
        return denom*cells.get(denom).getCount();
    }

    protected int getBalance(){
        int res = 0;
        for(Map.Entry<Integer, Cell> cell : cells.entrySet()){
            res += cell.getKey() * cell.getValue().getCount();
        }
        return res;
    }

    protected void printStorage(){
        for(Map.Entry<Integer, Cell> cell : cells.entrySet()){
            System.out.println("key = "+cell.getKey()+", count = " + cell.getValue().getCount());
        }
    }
}
