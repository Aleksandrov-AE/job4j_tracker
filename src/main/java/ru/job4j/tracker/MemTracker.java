package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MemTracker implements Store {
    private final List<Item> store = new ArrayList<>();
    private int ids = 1;

    @Override
    public Item add(Item item) {
        store.add(item);
        item.setId(ids++);
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId() == id) {
                item.setId(id); // сохраняем старый id
                store.set(i, item); // заменяем
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < store.size(); i++) {
            if (store.get(i).getId() == id) {
                store.remove(i);
                break;
            }
        }

    }

    @Override
    public List<Item> findAll() {
        return new ArrayList<>(store);
    }

    @Override
    public List<Item> findByName(String key) {

        return store.stream().filter(item -> item.getName().equals(key)).toList();
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        for (Item value : store) {
            if (value.getId() == id) {
                item = value;
            }
        }
        if (item == null) {
            throw new NoSuchElementException();
        }
        return item;
    }

    @Override
    public void close() throws Exception {

    }
}