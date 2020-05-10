package ru.academits.suvorov.hash_table_main;

import ru.academits.suvorov.hash_table.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<String> stringHashTable = new HashTable<>();

        stringHashTable.add("one");
        stringHashTable.add("two");
        stringHashTable.add("three");
        stringHashTable.add("four");

        System.out.println("HashTable строк: ");

        for (String element : stringHashTable) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        HashTable<Integer> hashTable = new HashTable<>(10);

        hashTable.add(5);
        hashTable.add(55);
        hashTable.add(565);
        hashTable.add(58989);
        hashTable.add(556465);
        hashTable.add(5565);
        hashTable.add(585);

        hashTable.remove(5);

        System.out.println("HashTable чисел: ");

        for (Integer element : hashTable) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Колличество элементов в хеш-таблице: " + hashTable.size());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Возвращает true, если этот список не содержит элементов: " + hashTable.isEmpty());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Возвращает true, если этот список содержит указанный элемент: " + hashTable.contains(55));
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Возвращает массив, содержащий все элементы hastTable в правильной последовательности: ");

        System.out.println(Arrays.toString(hashTable.toArray()));
        System.out.println();

        System.out.println(Arrays.toString(hashTable.toArray(new Object[10])));
        System.out.println("-----------------------------------------------------------------------------------------");

        ArrayList<Integer> list = new ArrayList<>();

        list.add(66);
        list.add(58989);
        list.add(556465);
        list.add(5565);
        list.add(585);

        System.out.println("Возвращает true, если hashTable содержит все элементы из коллекции list: "
                + hashTable.containsAll(list));
        System.out.println("-----------------------------------------------------------------------------------------");

        hashTable.addAll(list);

        System.out.println("hashTable после копирования всех элементов коллекции list: ");

        for (Integer element : hashTable) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        hashTable.removeAll(list);

        System.out.println("hashTable после удаления всех элементов коллекции list: ");

        for (Integer element : hashTable) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");

        hashTable.add(77);
        hashTable.add(88);
        hashTable.add(99);

        list.add(77);
        list.add(88);
        list.add(88);

        hashTable.retainAll(list);

        System.out.println("Сохраненые элементы, которые содержались в коллекции list: " + hashTable.retainAll(list));

        for (Integer element : hashTable) {
            System.out.print(element + " ");
        }
    }
}