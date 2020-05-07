package ru.academits.suvorov.hash_table;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private final ArrayList<T>[] hashTable;
    private int size;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        hashTable = new ArrayList[100];
    }

    public HashTable(int arrayLength) {
        if (arrayLength <= 0) {
            throw new IllegalArgumentException("Переданное значение capacity = " + arrayLength + " , должно быть > 0");
        }

        //noinspection unchecked
        hashTable = new ArrayList[arrayLength];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = getIndexInHashTable(o);

        return hashTable[index] != null && hashTable[index].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];

        int i = 0;

        for (T element : this) {
            array[i] = element;

            ++i;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {
        int index = getIndexInHashTable(t);

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        hashTable[index].add(t);

        ++size;
        ++modCount;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndexInHashTable(o);

        if (hashTable[index] == null) {
            return false;
        }
        if (hashTable[index].remove(o)) {
            --size;
            ++modCount;

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean status = false;

        for (T element : c) {
            add(element);

            status = true;
        }

        return status;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean deletedElementsCount = false;

        for (Object element : c) {
            while (remove(element)) {
                deletedElementsCount = true;
            }
        }

        return deletedElementsCount;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean deletedElementsCount = false;
        size = 0;

        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                list.retainAll(c);

                size += list.size();
                ++modCount;

                deletedElementsCount = true;
            }
        }

        return deletedElementsCount;
    }

    @Override
    public void clear() {
        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                list.clear();

                ++modCount;
            }
        }

        size = 0;
    }

    private int getIndexInHashTable(Object o) {
        if (o == null) {
            return 0;
        }

        return Math.abs(o.hashCode() % hashTable.length);
    }

    private class MyHashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int initialModCount = modCount;
        private int currentListIndex = 0;
        private int currentHashIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Попытка модифицировать коллекцию " +
                        "во время итерирования по ней");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("В текущем коллекции больше нет элементов");
            }

            for (int i = currentHashIndex; i < hashTable.length; ++i) {
                currentHashIndex = i;

                if (hashTable[i] != null && hashTable[i].size() > 0) {
                    T data = hashTable[i].get(currentListIndex);

                    ++currentIndex;
                    ++currentListIndex;

                    if (hashTable[i].size() == currentListIndex) {
                        ++currentHashIndex;
                        currentListIndex = 0;
                    }

                    return data;
                }
            }

            return null;
        }
    }
}