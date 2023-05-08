package e08_Collection.ArrayDeque.Queue.onlineShop;

import e08_Collection.ArrayDeque.PriorityQueue.onlineShop.Order;
import e08_Collection.ArrayDeque.PriorityQueue.onlineShop.Priority;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("Order 1", Priority.MEDIUM);
        Order order2 = new Order("Order 2", Priority.MEDIUM);
        Order order3 = new Order("Order 3", Priority.HIGH);
        Order order4 = new Order("Order 4", Priority.LOW);

        OnlineShop emag = new OnlineShop("eMAG");
        emag.displayOrders();

        emag.addOrder(order4);
        emag.addOrder(order3);
        emag.addOrder(order1);
        emag.addOrder(order2);
        emag.addOrder(order3);
        emag.addOrder(order2);

        emag.displayOrders();
        emag.removeAllOrders();

        emag.removeOrder();
    }
}
