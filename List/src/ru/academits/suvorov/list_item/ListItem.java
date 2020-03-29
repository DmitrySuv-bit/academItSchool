package ru.academits.suvorov.list_item;

public class ListItem<T> {
    private T date;
    private ListItem<T> next;

    public ListItem(T date) {
        this.date = date;
        this.next = null;
    }

    public ListItem(T date, ListItem<T> next) {
        this.date = date;
        this.next = next;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (date == null) {
            return null;
        }

        return date.toString();
    }
}