package ru.academits.suvorov.array_list_main;

import ru.academits.suvorov.array_list.ArrayList;

import java.util.Arrays;

public class ArrayListMain {
    public static void main(String[] args) {
        // Пустой arrayList с размерностью 10
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        System.out.println("Пустой arrayList1 с размерностью 10: ");
        System.out.println(arrayList1);
        System.out.println("-----------------------------------------------------------------------------------------");

        // arrayList с заданной вместимостью с добавлением указанного элемента в конец списка
        ArrayList<Integer> arrayList2 = new ArrayList<>(10);

        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(3);
        arrayList2.add(4);
        arrayList2.add(5);
        arrayList2.add(6);
        arrayList2.add(2);
        arrayList2.add(6, 7);
        arrayList2.add(5, 9);

        System.out.println("arrayList2 с заданной вместимостью с добавлением указанного элемента в конец списка: ");
        System.out.println(arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Количество элементов в списке
        System.out.println("Количество элементов в arrayList2: " + arrayList2.size());
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает true, если этот список не содержит элементов
        System.out.println("Возвращает true, если arrayList1 не содержит элементов: " + arrayList1.isEmpty());
        System.out.println("Возвращает true, если arrayList2 не содержит элементов: " + arrayList2.isEmpty());
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает true, если этот список содержит указанный элемент
        System.out.println("Возвращает true, если arrayList1 содержит указанный элемент: " + arrayList1.contains(5));
        System.out.println("Возвращает true, если arrayList2 содержит указанный элемент: " + arrayList2.contains(5));
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности
        System.out.println("Возвращает массив, содержащий все элементы arrayList2 в правильной последовательности: ");
        System.out.println(Arrays.toString(arrayList2.toArray()));
        System.out.println();

        System.out.println(Arrays.toString(arrayList2.toArray(new Integer[12])));
        System.out.println("-----------------------------------------------------------------------------------------");

        //Удаляет элемент в указанной позиции в этом списке
        System.out.println("Значение удаленного элемента: " + arrayList2.remove(5));

        System.out.println("Список после удаления: " + arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает индекс первого вхождения указанного элемента в этом списке или -1,
        // если этот список не содержит элемент
        System.out.println("Индекс первого вхождения указанного элемента в этом списке или -1, " +
                "если этот список не содержит элемент: " + arrayList2.indexOf(2));
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает индекс последнего вхождения указанного элемента в этом списке или -1,
        // если этот список не содержит элемент
        System.out.println("Возвращает индекс последнего вхождения указанного элемента в этом списке или -1, " +
                "если этот список не содержит элемент: " + arrayList2.lastIndexOf(2));
        System.out.println("-----------------------------------------------------------------------------------------");

        // Заменяет элемент в указанной позиции в этом списке на указанный элемент
        arrayList2.set(0, 10);

        System.out.println("Список после замены элемента: " + arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Возвращает элемент в указанной позиции в этом списке
        System.out.println("Значение элемента по индексу: " + arrayList2.get(0));
        System.out.println("-----------------------------------------------------------------------------------------");

        // Сохраняет только элементы в этом списке, которые содержатся в указанной коллекции
        arrayList1.add(3);
        arrayList1.add(4);
        arrayList1.add(5);

        arrayList2.retainAll(arrayList1);

        System.out.println("Сохраненые элементы, которые содержались в указанной коллекции: " + arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции
        arrayList2.addAll(1, arrayList1);

        System.out.println("Вставка всех элементов из указанной коллекции: " + arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        //Добавляет все элементы в указанной коллекции в конец этого списка в том порядке,
        // в котором они возвращаются итератором указанной коллекции
        arrayList2.addAll(arrayList1);

        System.out.println("Вставка всех элементов в конец этого списка: " + arrayList2);
        System.out.println("-----------------------------------------------------------------------------------------");

        //Возвращает true, если этот список содержит элемент из указаной коллекции
        System.out.println("Возвращает true, если arrayList2 содержит элемент из коллекции arrayList1: "
                + arrayList2.containsAll(arrayList1));
        System.out.println("-----------------------------------------------------------------------------------------");

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("one");
        stringArrayList.add("two");
        stringArrayList.add("three");
        stringArrayList.add("four");

        System.out.println("Список строк: " + stringArrayList);
        System.out.println();

        System.out.println("Возвращает true, если этот список содержит указанный элемент: "
                + stringArrayList.contains("two"));
        System.out.println();

        System.out.println("Удаление первого вхождения указанного элемента: " + stringArrayList.remove("two"));
        System.out.println();

        System.out.println("Список после удаления элемента: " + stringArrayList);
        System.out.println("-----------------------------------------------------------------------------------------");

        // Обрезает емкость этого экземпляра ArrayList2 до текущего размера списка
        arrayList2.trimToSize();

        // Удаляет все элементы из этого списка. Список будет пустым после возврата этого вызова
        arrayList2.clear();

        System.out.println("Список arrayList2 после удаления всех элементов: " + arrayList2);

    }
}