package ru.academits.suvorov.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private T[] items;
    private int listLength;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[10];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Переданное значение capacity = " + capacity + " , должно быть >= 0");
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private final int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < listLength;
        }

        @Override
        public T next() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Коллекция была модифицирована во время итерирования по ней");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("В текущей коллекции больше нет элементов");
            }

            ++currentIndex;

            return items[currentIndex];
        }
    }

    @Override
    public String toString() {
        if (listLength == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < listLength; ++i) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.setLength(stringBuilder.length() - 2);
        stringBuilder.append("}");

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

        ArrayList<?> arrayList = (ArrayList<?>) o;

        return Arrays.equals(items, arrayList.items);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = hash * prime + Arrays.hashCode(items);

        return hash;
    }

    // Увеличивает емкость этого ArrayList.
    public void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    // Обрезает емкость этого экземпляра ArrayList до текущего размера списка.
    public void trimToSize() {
        if (items.length > listLength) {
            items = Arrays.copyOf(items, listLength);
        }
    }

    // Возвращает количество элементов в этом списке.
    @Override
    public int size() {
        return listLength;
    }

    // Возвращает true, если этот список не содержит элементов.
    @Override
    public boolean isEmpty() {
        return listLength == 0;
    }

    // Возвращает true, если этот список содержит указанный элемент.
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    // Возвращает итератор для элементов в этом списке в правильной последовательности.
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности.
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, listLength);
    }

    // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности.
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < listLength) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, listLength, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, listLength);

        if (a.length > listLength) {
            a[listLength] = null;
        }

        return a;
    }

    // Добавляет указанный элемент в конец этого списка.
    @Override
    public boolean add(T t) {
        add(listLength, t);

        return true;
    }

    // Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
    @Override
    public boolean remove(Object o) {
        int indexOf = indexOf(o);

        if (indexOf == -1) {
            return false;
        }

        remove(indexOf);

        return true;
    }

    //Возвращает true, если этот список содержит элемент из указаной коллекции.
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    // Добавляет все элементы в указанной коллекции в конец этого списка в том порядке,
    // в котором они возвращаются итератором указанной коллекции.+
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(listLength, c);
    }

    // Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции.
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkIndexBoundsToAdd(index);

        if (c.size() == 0) {
            return false;
        }

        ensureCapacity(listLength + c.size());

        System.arraycopy(items, index, items, index + c.size(), listLength - index);

        int i = index;

        for (T e : c) {
            items[i] = e;
            ++i;
        }

        listLength += c.size();
        ++modCount;

        return true;
    }

    // Удаляет из этого списка все его элементы, которые содержатся в указанной коллекции.
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean deletedElementsCount = false;

        for (Object element : c) {
            for (int i = 0; i < listLength; ++i) {
                if (Objects.equals(items[i], element)) {
                    remove(i);

                    --i;
                    deletedElementsCount = true;
                }
            }
        }

        return deletedElementsCount;
    }

    // Сохраняет только элементы в этом списке, которые содержатся в указанной коллекции.
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean deletedElementsCount = false;

        for (int i = 0; i < listLength; ++i) {
            if (!c.contains(items[i])) {
                remove(i);

                --i;
                deletedElementsCount = true;
            }
        }

        return deletedElementsCount;
    }

    // Удаляет все элементы из этого списка. Список будет пустым после возврата этого вызова.
    @Override
    public void clear() {
        for (int i = 0; i < listLength; ++i) {
            items[i] = null;
        }

        listLength = 0;
        ++modCount;
    }

    // Возвращает элемент в указанной позиции в этом списке.
    @Override
    public T get(int index) {
        checkIndexBounds(index);

        return items[index];
    }

    // Заменяет элемент в указанной позиции в этом списке на указанный элемент.
    @Override
    public T set(int index, T element) {
        checkIndexBounds(index);

        T oldValue = items[index];

        items[index] = element;

        return oldValue;
    }

    // Вставляет указанный элемент в указанную позицию в этом списке.
    @Override
    public void add(int index, T element) {
        checkIndexBoundsToAdd(index);

        if (listLength >= items.length) {
            ensureCapacity(items.length * 2 + 5);
        }

        if (index != listLength) {
            System.arraycopy(items, index, items, index + 1, listLength - index);
        }

        items[index] = element;

        ++modCount;
        ++listLength;
    }

    // Удаляет элемент в указанной позиции в этом списке.
    @Override
    public T remove(int index) {
        checkIndexBounds(index);

        T oldValue = items[index];

        if (index < listLength - 1) {
            System.arraycopy(items, index + 1, items, index, listLength - index - 1);
        }

        --listLength;
        ++modCount;

        items[listLength] = null;

        return oldValue;
    }

    // Возвращает индекс первого вхождения указанного элемента в этом списке или -1,
    // если этот список не содержит элемент.
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listLength; ++i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    // Возвращает индекс последнего вхождения указанного элемента в этом списке или -1,
    // если этот список не содержит элемент.
    @Override
    public int lastIndexOf(Object o) {
        for (int i = listLength - 1; i >= 0; --i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //noinspection ConstantConditions
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //noinspection ConstantConditions
        return null;
    }

    private void checkIndexBounds(int index) {
        if (index >= listLength || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index < " + listLength);
        }
    }

    private void checkIndexBoundsToAdd(int index) {
        if (index > listLength || index < 0) {
            throw new IndexOutOfBoundsException("Переданное значение index = " + index + " некорректно." +
                    " Для значения должно выполняться условие 0 <= index <= " + listLength);
        }
    }
}