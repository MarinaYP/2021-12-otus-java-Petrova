package homework;


import java.util.*;

public  class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны

   private  TreeMap<Customer, String> custServMap = new TreeMap<>(Comparator.comparingLong(o -> o.getScores()));

   private Map.Entry<Customer, String> getNewEntry(Map.Entry<Customer, String> entry){
       if (entry == null) return null;
       Customer newCust = entry.getKey();
       Map.Entry<Customer, String> result = new AbstractMap.SimpleEntry<>(new Customer(newCust.getId(), newCust.getName(), newCust.getScores()), entry.getValue());
       return result;
   }

    public Map.Entry<Customer, String> getSmallest() {
        //Возможно, чтобы реализовать этот метод, потребуется посмотреть как Map.Entry сделан в jdk
        return getNewEntry(custServMap.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
       return getNewEntry(custServMap.higherEntry(customer));
    }

    public void add(Customer customer, String data) {
        custServMap.put(customer, data);
    }

}
