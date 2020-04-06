package ru.academits.suvorov.list;

import java.util.Objects;

class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if (data == null) {
            return "null";
        }

        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListItem<?> listItem = (ListItem<?>) o;

        return Objects.equals(data, listItem.data) && Objects.equals(next, listItem.next);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = prime * hash + (int) data;
        hash = prime * hash + (next != null ? next.hashCode() : 0);

        return hash;
    }
}