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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        List<?> list = (List<?>) o;
        return listLength == list.listLength && Objects.equals(head, list.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, listLength);
    }

    public int getSize() {
        return listLength;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public ListItem<T> getItem(int index) {
        int i = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }

            ++i;
        }

        return null;
    }

    public T getValue(int index) {
        return getItem(index).getDate();
    }

    public T setValue(int index, T value) {
        ListItem<T> p = getItem(index);

        T changedValue = p.getDate();

        p.setDate(value);

        return changedValue;
    }

    public T remove() {
        T remoteValue = head.getDate();

        head = head.getNext();

        --listLength;

        return remoteValue;
    }

    public T removeByIndex(int index) {
        T remoteValue = null;

        if (index == 0) {
            remoteValue = remove();
        } else {
            ListItem<T> p = getItem(index - 1);

            p.setNext(p.getNext().getNext());

            --listLength;
        }

        return remoteValue;
    }

    public void add(T date) {
        head = new ListItem<>(date, head);

        ++listLength;
    }

    public void addByIndex(int index, T date) {
        if (index == 0) {
            add(date);
        } else {
            ListItem<T> p = getItem(index - 1);

            p.setNext(new ListItem<>(date, p.getNext()));

            ++listLength;
        }
    }

    public boolean isRemoveByIndex(T date) {
        if (Objects.equals(date, head.getDate())) {
            remove();

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

    public void addNext(T date, ListItem<T> listItem ) {
        if (listItem == null){
            add(date);
        } else {
            listItem.setNext(new ListItem<>(date, listItem.getNext()));

            ++listLength;
        }
    }

    public List<T> copy() {
        if (head == null) {
            return new List<>();
        }

        List<T> listCopy = new List<>(new ListItem<>(head.getDate(), null));

        ListItem<T> h = listCopy.getHead();

        for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
            listCopy.addNext( p.getDate(),h);

            h = h.getNext();
        }

        return listCopy;
    }
}