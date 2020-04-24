package ru.academits.suvorov.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> {
    private ListItem<T> head;
    private int length;

    public List() {
        length = 0;
    }

    public List(T data) {
        head = new ListItem<>(data);
        length = 1;
    }

    @Override
    public String toString() {
        if (length == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).append("}");

        return stringBuilder.toString();
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
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index < " + length);
        }

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> p = getItemByIndex(index - 1);

        T oldData = p.getNext().getData();

        p.setNext(p.getNext().getNext());

        --length;

        return oldData;
    }

    // Вставка элемента в начало
    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        ++length;
    }

    // Вставка элемента по индексу
    public void addByIndex(int index, T data) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index <= " + length);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> p = getItemByIndex(index - 1);

        p.setNext(new ListItem<>(data, p.getNext()));

        ++length;
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeByData(T data) {
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

        ListItem<T> currentListItem = head;
        ListItem<T> nextListItem = head.getNext();

        currentListItem.setNext(null);

        while (nextListItem != null) {
            ListItem<T> previousListItem = nextListItem;
            nextListItem = previousListItem.getNext();
            previousListItem.setNext(currentListItem);
            currentListItem = previousListItem;
        }

        head = currentListItem;
    }

    // Копирование списка
    public List<T> copy() {
        if (head == null) {
            return new List<>();
        }

        List<T> listCopy = new List<>(head.getData());

        listCopy.length = this.length;

        for (ListItem<T> initialListItem = head.getNext(), newListItem = listCopy.head; initialListItem != null;
             initialListItem = initialListItem.getNext(), newListItem = newListItem.getNext()) {
            newListItem.setNext(new ListItem<>(initialListItem.getData(), newListItem.getNext()));
        }

        return listCopy;
    }
}