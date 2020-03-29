package ru.academits.suvorov.list;

import ru.academits.suvorov.list_item.ListItem;

import java.util.Objects;

public class List<T> {
    private ListItem<T> head;
    private int listLength;

    public List() {
        listLength = 0;
    }

    public List(ListItem<T> head) {
        this.head = head;
        this.listLength = 1;
    }

    public ListItem<T> getHead() {
        return head;
    }

    @Override
    public String toString() {
        if (listLength == 0) {
            return "Список пуст";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.toString()).append(", ");
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

        return listLength == list.listLength && Objects.equals(head, list.head);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + listLength;
        hash = prime * hash + (head != null ? head.hashCode() : 0);

        return hash;
    }

    // Получение размера списка
    public int getSize() {
        return listLength;
    }

    // Получение значение первого элемента
    public T getFirstElementValue() {
        return head.getDate();
    }

    // Получение узла по индексу
    public ListItem<T> getItemByIndex(int index) {
        if (index >= listLength || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index < " + listLength);
        }

        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }

            ++i;
        }

        return null;
    }

    // Получение значения по указанному индексу
    public T getValue(int index) {
        //TODO Не знаю тут нужно кидать иключение, если проверка идет в методе ниже
        return getItemByIndex(index).getDate();
    }

    // Изменение значения по указанному индексу
    public T setValue(int index, T value) {
        //TODO Не знаю тут нужно кидать иключение, если проверка идет в методе ниже
        ListItem<T> p = getItemByIndex(index);

        T changedValue = p.getDate();

        p.setDate(value);

        return changedValue;
    }

    // Удаление первого элемента, пусть выдает значение элемента
    public T removeHead() {
        T remoteValue = head.getDate();

        head = head.getNext();

        --listLength;

        return remoteValue;
    }

    // Удаление элемента по индексу, пусть выдает значение элемента
    public T removeByIndex(int index) {
        //TODO Не знаю тут нужно кидать иключение, если проверка идет в методе ниже
        T remoteValue = getItemByIndex(index).getDate();

        if (index == 0) {
            remoteValue = removeHead();
        } else {
            ListItem<T> p = getItemByIndex(index - 1);

            p.setNext(p.getNext().getNext());

            --listLength;
        }

        return remoteValue;
    }

    // Вставка элемента в начало
    public void addHead(T date) {
        head = new ListItem<>(date, head);

        ++listLength;
    }

    // Вставка элемента по индексу
    public void addByIndex(int index, T date) {
        if (index >= listLength || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно."
                    + " Для значения должно выполняться условие 0 <= index < " + listLength);
        } else if (index == 0) {
            addHead(date);
        } else {
            ListItem<T> p = getItemByIndex(index - 1);

            p.setNext(new ListItem<>(date, p.getNext()));

            ++listLength;
        }
    }

    // Удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean isRemoveByIndex(T date) {
        if (Objects.equals(date, head.getDate())) {
            removeHead();

            return true;
        }

        for (ListItem<T> p = head; p.getNext() != null; p = p.getNext()) {
            if (Objects.equals(date, p.getNext().getDate())) {
                p.setNext(p.getNext().getNext());

                --listLength;

                return true;
            }
        }

        return false;
    }

    // Разворот списка за линейное время
    public void reverse() {
        if (head != null) {
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
    }

    public void addNext(T date, ListItem<T> listItem) {
        if (listItem == null) {
            addHead(date);
        } else {
            listItem.setNext(new ListItem<>(date, listItem.getNext()));

            ++listLength;
        }
    }

    // Копирование списка
    public List<T> copy() {
        if (head == null) {
            return new List<>();
        }

        List<T> listCopy = new List<>(new ListItem<>(head.getDate(), null));

        for (ListItem<T> p = head.getNext(), h = listCopy.getHead(); p != null; p = p.getNext(), h = h.getNext()) {
            listCopy.addNext(p.getDate(), h);
        }

        return listCopy;
    }
}