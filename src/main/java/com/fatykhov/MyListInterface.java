package com.fatykhov;

public interface MyListInterface<E> extends Iterable<E> {
    void add(E item);
    void add(int index, E item);
    E get(int index);
    void remove(int index);
    void remove(E item);
    int size();
    void set(int index, E item);
    boolean isEmpty();
    void clear();
    void sort();
}
