package ru.academits.suvorov.list_main;

import ru.academits.suvorov.list.List;

public class ListMain {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        System.out.println(list);
        System.out.println("-----------------------------------------------------------------------------------------");

        list.addHead(10);
        list.addHead(9);
        list.addHead(8);
        list.addHead(7);
        list.addHead(6);
        list.addHead(5);
        list.addHead(4);
        list.addHead(3);
        list.addHead(2);
        list.addHead(1);

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


        System.out.println("Значение первого элемента: " + list.getFirstElementValue());
        System.out.println("-----------------------------------------------------------------------------------------");

        int index1 = 1;

        System.out.println("Получение значения по указанному индексу = " + index1 + ": " + list.getValue(index1));
        System.out.println("-----------------------------------------------------------------------------------------");

        int index2 = 5;
        Integer value = 150;

        System.out.println("Изменение значения по указанному индексу = " + index2 + ": Значение = "
                + list3.setValue(index2, value) + " изменено на значение = " + value);
        System.out.println();

        System.out.println("Список после изменения значения: " + list3);
        System.out.println("-----------------------------------------------------------------------------------------");

        int index3 = 8;

        System.out.println("Удаление элемента по индексу = " + index3 + ": Значение = " + list4.removeByIndex(index3)
                + " удалено");
        System.out.println();

        System.out.println("Список после удаления элемента: " + list4);
        System.out.println("-----------------------------------------------------------------------------------------");

        int index4 = 2;
        Integer value1 = 300;

        list5.addByIndex(index4, value1);

        System.out.println("Добавление значения = " + value1 + " по индексу = " + index4);
        System.out.println();

        System.out.println("Список после добавления значения: " + list5);
        System.out.println("-----------------------------------------------------------------------------------------");

        Integer value2 = 3;
        boolean isRemove = list6.isRemoveByIndex(value2);

        System.out.println("Удаление узла по значению = " + value2 + ": " + isRemove);
        System.out.println();

        if (isRemove) {
            System.out.println("Список после удаления узла: " + list6);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}