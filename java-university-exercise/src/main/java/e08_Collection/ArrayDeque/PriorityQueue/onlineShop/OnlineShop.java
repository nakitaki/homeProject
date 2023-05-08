package e08_Collection.ArrayDeque.PriorityQueue.onlineShop;

import java.util.PriorityQueue;
import java.util.Queue;

public class OnlineShop {

    private String name;
    private Queue<Order> queueOfOrders;

    public OnlineShop() {
        this.name = "No Name";
        this.queueOfOrders = new PriorityQueue<>();
    }

    public OnlineShop(String name) {
        this.name = name;
        this.queueOfOrders = new PriorityQueue<>(Order.ComparatorByOrderPriority);
    }

    public OnlineShop(String name, Queue<Order> queueOfOrders) {
        this.name = name;
        this.queueOfOrders = queueOfOrders;
    }

    public String getName() {
        return name;
    }

    void addOrder(Order order) {
        this.queueOfOrders.offer(order);
    }

    public void displayOrders() {
        if (queueOfOrders.isEmpty()) {
            System.out.println("There is no orders!");
        } else {
            System.out.println(queueOfOrders);
        }
    }

    public Order removeOrder() {
        return queueOfOrders.poll();
    }

    public void removeAllOrders() {
        if (queueOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            Order polled;
            while((polled = queueOfOrders.poll()) != null){
                System.out.println(polled);
            }
        }
    }
}
