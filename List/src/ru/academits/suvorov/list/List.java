package ru.academits.suvorov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> {
    private ListItem<T> head;
    private int length;

    public List() {
        length = 0;
    }

    public List(ListItem<T> data) {
        head = data;
        length = 1;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "{ }";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        List<?> list = (List<?>) o;

        return length == list.length && Objects.equals(head.getData(), list.head.getData())
                && Objects.equals(head.getNext(), list.head.getNext());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + length;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            hash = prime * hash + (head.getNext() != null ? head.getNext().hashCode() : 0);
            hash = prime * hash + (int) head.getData();
        }

        return hash;
    }

    // Получение размера списка
    public int getSize() {
        return length;
    }

    // Получение значение первого элемента
    public T getFirstElementData() {
        if (length == 0) {
            throw new NoSuchElementException("Получить значение первого элемента невозможно, " +
                    "количество элементов в списке = 0");
        }

        return head.getData();
    }

    private ListItem<T> getItemByIndex(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index < " + length);
        }

        ListItem<T> p = head;

        for (int i = 0; i != index; ++i) {
            p = p.getNext();
        }

        return p;
    }

    // Получение значения по указанному индексу------------------------------
    public T getData(int index) {
        return getItemByIndex(index).getData();
    }

    // Изменение значения по указанному индексу-----------------------
    public T setData(int index, T data) {
        ListItem<T> p = getItemByIndex(index);

        T changedData = p.getData();

        p.setData(data);

        return changedData;
    }

    // Удаление первого элемента, пусть выдает значение элемента
    public T removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException("Удаление невозможно, количество элементов в списке = 0");
        }

        T remoteData = head.getData();

        head = head.getNext();

        --length;

        return remoteData;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента---------------------------
    public T removeByIndex(int index) {
        if (index != 0) {
            ListItem<T> p = getItemByIndex(index - 1);

            T remoteData = p.getNext().getData();

            p.setNext(p.getNext().getNext());

            --length;

            return remoteData;
        }

        return removeFirst();
    }

    // Вставка элемента в начало
    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        ++length;
    }

    // Вставка элемента по индексу
    public void addByIndex(int index, T data) {
        if (index >= length + 1 || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index <= " + length);
        }

        if (index == 0) {
            addFirst(data);
        } else {
            ListItem<T> p = getItemByIndex(index - 1);

            p.setNext(new ListItem<>(data, p.getNext()));

            ++length;
        }
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeByData(T data) {
        if (length == 0) {
            throw new NoSuchElementException("Удаление по значению невозможно, количество элементов в списке = 0");
        }

        if (Objects.equals(data, head.getData())) {
            removeFirst();

            return true;
        }

        for (ListItem<T> p = head; p.getNext() != null; p = p.getNext()) {
            if (Objects.equals(data, p.getNext().getData())) {
                p.setNext(p.getNext().getNext());

                --length;

                return true;
            }
        }

        return false;
    }

    // Разворот списка за линейное время
    public void reverse() {
        if (head == null) {
            return;
        }

        ListItem<T> p = head;
        ListItem<T> q = head.getNext();

        p.setNext(null);

        while (q != null) {
            ListItem<T> h = q;
            q = h.getNext();
            h.setNext(p);
            p = h;
        }

        head = p;
    }

    // Копирование списка
    public List<T> copy() {
        if (head == null) {
            return new List<>();
        }

        List<T> listCopy = new List<>(new ListItem<>(head.getData(), null));

        listCopy.length = this.length;

        for (ListItem<T> copyListItem = head.getNext(), prevListItem = listCopy.head; copyListItem != null; copyListItem = copyListItem.getNext(), prevListItem = prevListItem.getNext()) {
            prevListItem.setNext(new ListItem<>(copyListItem.getData(), prevListItem.getNext()));
        }

        return listCopy;
    }
}