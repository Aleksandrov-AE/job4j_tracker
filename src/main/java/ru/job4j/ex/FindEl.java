package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        if (value == null) {
            throw new ElementNotFoundException("Value cannot be null ");
        }
        if (key == null) {
            throw new ElementNotFoundException("Key cannot be null ");
        }
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }

        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] value = null;
            String key = "";
            System.out.println(indexOf(value, key));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}