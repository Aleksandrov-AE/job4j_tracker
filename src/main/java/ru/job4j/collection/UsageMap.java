package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("alexndrov@yandex.ru", "Anatoliy Aleksandrov");
        map.put("alex246@yandex.ru", "Anatoliy Aleksandrov");
        map.put("alex@yandex.ru", "Anatoliy Aleksandrov");
        map.put("alex@yandex.ru", "Anatolii Aleksandrv");
        map.put("avasser@yandex.ru", "Anatoliy Vasserman");
        for (String key : map.keySet()) {
            System.out.println(key + "\t" + map.get(key));
        }
    }
}