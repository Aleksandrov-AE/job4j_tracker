package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer lastCustomer = null;
        for (int i = 0; i < count; i++) {
            lastCustomer = queue.poll();
        }
        return lastCustomer.name();
    }

    public String getFirstUpsetCustomer() {
        Customer firstUpsetCustomer = null;
        for (int i = 0; i < count + 1; i++) {
            firstUpsetCustomer = queue.poll();
        }

        return count <= queue.size() ? firstUpsetCustomer.name() : "no firstUpsetCustomer";
    }
}