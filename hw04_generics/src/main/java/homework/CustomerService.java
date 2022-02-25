package homework;


import java.util.*;

public  class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

    /*SortedMap<Integer, String> custServMap = new TreeMap<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) { //scores - это long. Надо поменять на long или перед передачей приводить тип!
            return o1 - o2;
        }
    });*/
   private  TreeMap<Customer, String> custServMap = new TreeMap<>(Comparator.comparingLong(o -> o.getScores()));
    //SortedMap<Customer, String> custServMap = new TreeMap<>();



    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        Map.Entry<Customer, String> sEntry = custServMap.firstEntry();
        if (sEntry == null) return null;
        Customer newCust = sEntry.getKey();
        Map.Entry<Customer, String> result = new AbstractMap.SimpleEntry<>(new Customer(newCust.getId(), newCust.getName(), newCust.getScores()), sEntry.getValue());
        return result;
        //return null; // это "заглушка, чтобы скомилировать
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> hEntry = custServMap.higherEntry(customer);
        if (hEntry == null) return null;
        Customer newCust = hEntry.getKey();
        Map.Entry<Customer, String> result = new AbstractMap.SimpleEntry<>(new Customer(newCust.getId(), newCust.getName(), newCust.getScores()), hEntry.getValue());
        return result;
        //return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        custServMap.put(customer, data);
    }

    /*public void printCust(Customer cust){
        System.out.println("Customer{" +
                "id=" + cust.getId() +
                ", name='" + cust.getName() + '\'' +
                ", scores=" + cust.getScores() +
                '}');
    }
public void printAllCust(){
    System.out.println(custServMap);
}*/
}
