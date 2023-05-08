package e08_Collection.ArrayDeque.Queue.onlineShop;

import e08_Collection.ArrayDeque.PriorityQueue.onlineShop.Order;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineShop {
    private String name;
    private Deque<Order> arrayDequeOfOrders;

    //TODO - why cant i remove <>
    public OnlineShop() {
        this.name = "No Name";
        this.arrayDequeOfOrders = new ArrayDeque<>();
    }

    public OnlineShop(String name) {
        this.name = name;
        this.arrayDequeOfOrders = new ArrayDeque<>();
    }

    public OnlineShop(String name, Deque<Order> arrayDequeOfOrders) {
        this.name = name;
        this.arrayDequeOfOrders = arrayDequeOfOrders;
    }

    public String getName() {
        return name;
    }

    public void displayOrders(){
        if(arrayDequeOfOrders.isEmpty()){
            System.out.println("There are no orders!");
        } else {
            System.out.println(arrayDequeOfOrders);
        }
    }

    public void removeOrder(){
        if (arrayDequeOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            System.out.println(arrayDequeOfOrders.remove());
        }
    }

    public void removeAllOrders() {
        if (arrayDequeOfOrders.isEmpty()) {
            System.out.println("There are no orders!");
        } else {
            for (Order order : arrayDequeOfOrders) {
                System.out.println(arrayDequeOfOrders.remove());
            }
        }
    }

    public void addOrder(Order order) {
        arrayDequeOfOrders.offer(order);
    }
}
