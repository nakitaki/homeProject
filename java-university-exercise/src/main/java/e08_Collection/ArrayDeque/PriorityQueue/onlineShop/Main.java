package e08_Collection.ArrayDeque.PriorityQueue.onlineShop;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("Order 1", Priority.MEDIUM);
        Order order2 = new Order("Order 2", Priority.MEDIUM);
        Order order3 = new Order("Order 3", Priority.HIGH);
        Order order4 = new Order("Order 4", Priority.LOW);

        OnlineShop topShop = new OnlineShop("Top Shop");

        topShop.displayOrders();

        topShop.addOrder(order4);
        topShop.addOrder(order3);
        topShop.addOrder(order1);
        topShop.addOrder(order2);
        topShop.addOrder(order1);
        topShop.addOrder(order3);
        topShop.addOrder(order2);

        topShop.displayOrders();
        topShop.removeAllOrders();
        System.out.println(topShop.removeOrder());
        topShop.displayOrders();

        //use priorityQueue as parameter in constructor
        Queue<Order> orders = new PriorityQueue<>(Order.ComparatorByOrderPriority.thenComparing(Order.ComparatorByOrderName));
        topShop.addOrder(order4);
        topShop.addOrder(order3);
        topShop.addOrder(order1);
        topShop.addOrder(order2);
        topShop.addOrder(order1);
        topShop.addOrder(order3);
        topShop.addOrder(order2);

        OnlineShop topShop2 = new OnlineShop("Top Shop 2", orders);
        topShop.displayOrders();
        topShop.removeAllOrders();
    }
}
