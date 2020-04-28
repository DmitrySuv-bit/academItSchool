package ru.academits.suvorov.hash_table_main;

import ru.academits.suvorov.hash_table.HashTable;

import java.util.Arrays;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<Integer> hashTable = new HashTable<>(10);

        hashTable.add(5);
        hashTable.add(55);
        hashTable.add(565);
        hashTable.add(58989);
        hashTable.add(556465);
        hashTable.add(5565);
        hashTable.add(585);

        hashTable.remove(5);

        System.out.println(hashTable);
        for (Integer element : hashTable) {
            System.out.print(element + ", ");
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

    }
}
