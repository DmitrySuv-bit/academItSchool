package ru.academits.suvorov.list_main;

import ru.academits.suvorov.list.List;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        System.out.println(list);
        System.out.println("-----------------------------------------------------------------------------------------");

        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        System.out.println("My list: " + list);
        System.out.println("-----------------------------------------------------------------------------------------");

        List<Integer> list1 = list.copy();
        List<Integer> list2 = list.copy();
        List<Integer> list3 = list.copy();
        List<Integer> list4 = list.copy();
        List<Integer> list5 = list.copy();
        List<Integer> list6 = list.copy();

        System.out.println("Копирование списка: " + list1);
        System.out.println("-----------------------------------------------------------------------------------------");

        list2.reverse();
        System.out.println("Разворот списка за линейное время: " + list2);
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Размер списка: " + list.getSize());
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Значение первого элемента: " + list.getFirstElementData());
        System.out.println("-----------------------------------------------------------------------------------------");

        int index1 = 0;

        System.out.println("Получение значения по указанному индексу = " + index1 + ": " + list.getData(index1));
        System.out.println("-----------------------------------------------------------------------------------------");

        int index2 = 0;
        Integer value = 150;

        System.out.println("Изменение значения по указанному индексу = " + index2 + ": Значение = "
                + list3.setData(index2, value) + " изменено на значение = " + value);
        System.out.println();

        System.out.println("Список после изменения значения: " + list3);
        System.out.println("-----------------------------------------------------------------------------------------");

        int index3 = 5;

        System.out.println("Удаление элемента по индексу = " + index3 + ": Значение = " + list4.removeByIndex(index3)
                + " удалено");
        System.out.println();

        System.out.println("Список после удаления элемента: " + list4);
        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println(list5);
        int index4 = 10;
        Integer value1 = 300;

        list5.addByIndex(index4, value1);

        System.out.println("Добавление значения = " + value1 + " по индексу = " + index4);
        System.out.println();

        System.out.println("Список после добавления значения: " + list5);
        System.out.println("-----------------------------------------------------------------------------------------");

        Integer value2 = 5;

        boolean isRemove = list6.removeByData(value2);

        System.out.println("Удаление узла по значению = " + value2 + ": " + isRemove);
        System.out.println();

        if (isRemove) {
            System.out.println("Список после удаления узла: " + list6);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}