package ru.academits.suvorov.list_main;

import ru.academits.suvorov.list.List;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        System.out.println(list);
        System.out.println("-----------------------------------------------");

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        System.out.println("My list: " + list);
        System.out.println("-----------------------------------------------");

        list.reverse();
        System.out.println("Разворот списка за линейное время: " + list);
        System.out.println("-----------------------------------------------");

        System.out.println("Размер списка: " + list.getSize());
        System.out.println("-----------------------------------------------");

        System.out.println("Значение первого элемента: " + list.getHead());
        System.out.println("-----------------------------------------------");

        int index1 = 0;

        System.out.println("Получение значения по указанному индексу = " + index1 + ": " + list.getValue(index1));
        System.out.println("-----------------------------------------------");

        int index2 = 0;
        Integer value = 10;

        System.out.println("Изменение значения по указанному индексу = " + index2 + ": " + list.setValue(index2, value));
        System.out.println("-----------------------------------------------");

        int index3 = 0;

        System.out.println("Удаление элемента по индексу = " + index3 + ": " + list.removeByIndex(index3));
        System.out.println(list);
        System.out.println("-----------------------------------------------");

        int index4 = 0;
        Integer value1 = 12;

        list.addByIndex(index4, value1);
        System.out.println("Добавление значения = " + value1 + " по индексу = " + index4 + ": " + list);
        System.out.println("-----------------------------------------------");

        System.out.println("Удаление узла по значению, пусть выдает true, если элемент был удален: "
                + list.isRemoveByIndex(5));
        System.out.println(list);
        System.out.println("-----------------------------------------------");

        List<Integer> list1 = list.copy();
        System.out.println("Копирование списка: "  + list1);
        System.out.println("-----------------------------------------------");
    }
}