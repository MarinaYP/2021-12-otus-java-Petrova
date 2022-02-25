package homework;


import java.util.*;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    //private LinkedHashMap<Customer, String> custReverseOrder = new LinkedHashMap<>();
    private List<Customer> list = new LinkedList<>();
    private ListIterator<Customer> iterator = list.listIterator();


    public void add(Customer customer) {
        iterator.add(customer);
    }

    public Customer take() {
        if (iterator.hasPrevious()) return (Customer) iterator.previous();
        else return null;
        //return null; // это "заглушка, чтобы скомилировать"
    }
    /*public void printCust(Customer cust){
        System.out.println("Customer{" +
                "id=" + cust.getId() +
                ", name='" + cust.getName() + '\'' +
                ", scores=" + cust.getScores() +
                '}');
    }
    public void printAllCust(){
        System.out.println(list.size());
        System.out.println(list);
    }*/
}
