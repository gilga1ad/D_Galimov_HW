package collection;


import java.util.*;

public class ArrayList<T> implements List<T> {

    private T[] m;

    private int size;

    public ArrayList() {
        this.m = (T[]) new Object[10];
    }

    public ArrayList(final int initialCapacity) {
        this.m = (T[]) new Object[initialCapacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (m[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (m[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator();
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    /** Проверяет, достаточно ли места в массиве для вставки нового элемента */
    private void ensureCapacity(final int minCapacity) {
        if(minCapacity == m.length) {
            final T[] oldM = m;
            m = (T[]) new Object[this.size() * 2];
            System.arraycopy(oldM, 0, m, 0, oldM.length);
        }
    }

    @Override
    public boolean add(final T e) {
        ensureCapacity(this.size + 1);
        m[size++] = e;
        return true;
    }

    @Override
    public void add(final int index, final T e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) { throw new IndexOutOfBoundsException(); }
        ensureCapacity(this.size + 1);
        System.arraycopy(m, index, m, index+1, size()-index);
        m[index] = e;
        this.size++;
    }

    @Override
    public T remove(final int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) { throw new IndexOutOfBoundsException(); }
        final T e = m[index];
        System.arraycopy(m, index+1, m, index, size()-index-1);
        this.size--;
        return e;
    }

    @Override
    public boolean remove(final Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (m[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (m[i].equals(o)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.m = (T[]) new Object[10];
        this.size = 0;
    }

    @Override
    public T get(final int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) { throw new IndexOutOfBoundsException(); }
        return m[index];
    }

    @Override
    public T set(final int index, final T e) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) { throw new IndexOutOfBoundsException(); }
        T oldE = m[index];
        m[index] = e;
        return oldE;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) throws NullPointerException {
        if (c == null) {
            throw new NullPointerException();
        }
        Object[] a = c.toArray();
        final int lengthA = a.length;
        ensureCapacity(size + lengthA);
        System.arraycopy(a, 0, m, size, lengthA);
        size+=lengthA;
        return lengthA != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) throws NullPointerException,
            IndexOutOfBoundsException {
        if (c == null) { throw new NullPointerException(); }
        if (index < 0 || index > size()) { throw new IndexOutOfBoundsException(); }
        Object[] a = c.toArray();
        final int lengthA = a.length;
        ensureCapacity(size + lengthA);
        System.arraycopy(m, size, m, index+lengthA, size-index);
        System.arraycopy(a, 0, m, index, lengthA);
        size+=lengthA;
        return lengthA != 0;
    }

    @Override
    public boolean 	containsAll(Collection<?> c) throws NullPointerException {
        if (c == null) { throw new NullPointerException(); }
        for (Object o: c) {
            if(!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(m, size);
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        if (a.length < size) {
            return (T1[]) Arrays.copyOf(m, size, a.getClass());
        }
        System.arraycopy(m, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size(); i++) {
                if (m[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size(); i++) {
                if (o.equals(m[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Object o) { return -1; }

    @Override
    public boolean equals(final Object o) { return false; }

    @Override
    public int hashCode() { return -1; }

    @Override
    public boolean removeAll(Collection<?> c) { return false; }

    @Override
    public boolean retainAll(Collection<?> c) { return false; }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) { return null; }

    private class ElementsIterator implements ListIterator<T> {

        private int cursor;     /** Индекс следующего элемента */

        private int last = -1;  /** Индекс последнего элемента, возвращенного итератором */

        public ElementsIterator(final int cursor) {
            this.cursor = cursor;
        }

        public ElementsIterator() {
            this(0);
        }

        @Override
        public boolean hasNext() {
            return ArrayList.this.size() > cursor;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            last = cursor;
            return ArrayList.this.m[cursor++];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            if(cursor == 0) return -1;
            return cursor-1;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public T previous() {
            if(!hasPrevious()) {
                throw new NoSuchElementException();
            }
            last = previousIndex();
            cursor--;
            return ArrayList.this.m[last];
        }

        @Override
        public void add(final T e) {
            ArrayList.this.add(cursor, e); /** Вставка между last и cursor */
        }

        /** Заменяет последний элемент, возвращенный next() или previous() */
        @Override
        public void set(final T e) {
            if (last == -1) throw new IllegalStateException();
            ArrayList.this.m[last] = e;
        }

        /** Удаляет последний элемент, возвращенный next() или previous() */
        @Override
        public void remove() {
            if (last == -1)
                throw new IllegalStateException();
            ArrayList.this.remove(last);
            cursor--;
            last = -1;
        }

    }

}
