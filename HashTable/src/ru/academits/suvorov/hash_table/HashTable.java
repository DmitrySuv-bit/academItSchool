package ru.academits.suvorov.hash_table;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private final ArrayList<T>[] hashTable;
    private int tableLength;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        hashTable = new ArrayList[100];
    }

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Переданное значение capacity = " + capacity + " , должно быть >= 0");
        }

        //noinspection unchecked
        hashTable = new ArrayList[capacity];
    }

    @Override
    public int size() {
        return tableLength;
    }

    @Override
    public boolean isEmpty() {
        return tableLength == 0;
    }

    @Override
    public boolean contains(Object o) {
        return hashTable[getIndexInHashTable(o)] != null && hashTable[getIndexInHashTable(o)].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[tableLength];

        int indexArray = 0;

        for (T element : this) {
            array[indexArray] = element;

            ++indexArray;
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < tableLength) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(toArray(), tableLength, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(toArray(), 0, a, 0, tableLength);

        if (a.length > tableLength) {
            a[tableLength] = null;
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

        ++tableLength;
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
            --tableLength;
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
            status = this.add(element);
        }

        return status;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int deletedElementsCount = 0;

        for (Object element : c) {
            while (remove(element)) {
                ++deletedElementsCount;
            }
        }

        return deletedElementsCount != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int deletedElementsCount = 0;

        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); ++i) {
                    if (!c.contains(list.get(i))) {
                        list.remove(list.get(i));

                        --i;
                        --tableLength;
                        ++deletedElementsCount;
                    }
                }
            }
        }

        return deletedElementsCount != 0;
    }

    @Override
    public void clear() {
        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                list.clear();

                ++modCount;
            }
        }

        tableLength = 0;
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
            return currentIndex + 1 < tableLength;
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

            T data;

            for (int i = currentHashIndex; i < hashTable.length; ++i) {
                currentHashIndex = i;

                if (hashTable[i] != null && hashTable[i].size() > 0) {
                    data = hashTable[i].get(currentListIndex);

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