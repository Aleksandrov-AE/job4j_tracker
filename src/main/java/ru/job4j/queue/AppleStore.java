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
        if (count == 0 || queue.size() == 0) {
            return "";
        }
        Customer lastCustomer = null;
        for (int i = 0; i < count; i++) {
            lastCustomer = queue.poll();
        }
        return lastCustomer.name();
    }

    public String getFirstUpsetCustomer() {
        if (count == 0 || queue.size() == 0 || count >= queue.size()) {
            return "";
        }
        Customer firstUpsetCustomer = null;
        for (int i = 0; i < count + 1; i++) {
            firstUpsetCustomer = queue.poll();
        }

        return firstUpsetCustomer.name();
    }
}