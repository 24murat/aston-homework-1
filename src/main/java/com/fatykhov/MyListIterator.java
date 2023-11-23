package com.fatykhov;

import java.util.Iterator;
import java.util.NoSuchElementException;

//  Реализуем класс итератор, чтобы мы могли итерироваться по нашему ArrayList

/**
 * My realization of iterator for my custom list.
 * @param <E> type of elements in list
 */
public class MyListIterator<E> implements Iterator<E> {

    private int index = 0;
    private E[] list;

    public MyListIterator(E[] list) {
        this.list = list;
    }

    //  Проверяет, дошли ли мы до конца ArrayList
    @Override
    public boolean hasNext() {
        return index < list.length;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return list[index++];
    }

}
