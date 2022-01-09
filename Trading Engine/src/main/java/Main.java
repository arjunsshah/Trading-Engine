package src.main.java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user0 = new User("user0");
        User user1 = new User("user1");
        Order order0 = new Order(10, 1.00, user0.getID(), 0);
        Order order1 = new Order(10, 1.00, user1.getID(), 1);
        Orderbook book = new Orderbook();

        book.Process(order0, book);
        book.Process(order1, book);
        System.out.println(book.getBuyOrders());

    }
}
