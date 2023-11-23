package com.fatykhov.linkedList;

import com.fatykhov.MyListInterface;

import java.util.Iterator;

public class MyLinkedList<E> implements MyListInterface<E> {
    /**
     * First Node of this linked list
     */
    private Node<E> head;
    /**
     * Last Node of this linked list
     */
    private Node<E> tail;
    /**
     * Size of this linked list
     */
    private int size;

    /**
     * Constructs empty linked list.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Adds element to the beginning of this linked list.
     * @param item element to add to the beginning of this linked list
     */
    public void addFirst(E item) {
        // Новый узел
        Node<E> temp = new Node<>(item);

        if (isEmpty()) {
            tail = temp; // ? or head
        } else {
            head.prev = temp;
        }

        temp.next = head;
        head = temp;

        size++;
    }

    public void print() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    /**
     * Adds element to the end of this linked list.
     * @param item element to add to the end of this linked list
     */
    @Override
    public void add(E item) {
        Node<E> temp = new Node<>(item);

        if (isEmpty()) {
            head = temp;
        } else {
            tail.next = temp;
        }

        temp.prev = tail;
        tail = temp;

        size++;
    }

    /**
     * Adds element to the transferred index of this linked list.
     * First checks if custom index is not out of bounds.
     * @see MyLinkedList#checkIndex(int)
     *
     * @param index index which is used to add the element at
     * @param item element to add
     */
    @Override
    public void add(int index, E item) {
        checkIndex(index);

        if (index == 0) {
            addFirst(item);
            return;
        }

        Node<E> current = head;

        //  Переменная c будет служить для нахождения индекса
        int c = 0;

        while (current != null && c != index) {
            current = current.next;
            c++;
        }
        //  После цикла current ссылается на ноду на место которой мы хотим вставить новую ноду

        Node<E> temp = new Node<>(item);

        //  current.prev.next означает, что мы берем текущую ноду, находим предыдущую ей ноду и назначаем
        //  ей в качестве следующей - ту ноду которую мы хотим вставить
        current.prev.next = temp;
        temp.prev = current.prev;
        current.prev = temp;
        temp.next = current;

        size++;
    }



    @Override
    public E get(int index) {
        return null;
    }

    /**
     * Removes first element of this linked list.
     */
    public void removeFirst() {
        if (isEmpty()) {
            return;
        } else if (head.next == null) {
            tail = null;
        } else {
            head.next.prev = null;
        }

        head = head.next;
        size--;
    }

    /**
     * Removes last element of this linked list.
     */
    public void removeLast() {
        if (isEmpty()) {
            return;
        } else if (head.next == null) { // ? or tail.prev == null
            head = null;
        } else {
            tail.prev.next = null;
        }
        tail = tail.prev;

        size--;
    }

    /**
     * Removes element at transferred index from this linked list.
     * @param index index to remove
     */
    @Override
    public void remove(int index) {
        checkIndex(index);

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node<E> current = head;
            int c = 0;

            while (current != null && c != index) {
                current = current.next;
                c++;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    /**
     * Returns current linked list size.
     * @return current linked list size
     */
    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, E item) {

    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {

    }

    @Override
    public void sort() {

    }

    /**
     * Checks if transferred index is not out of bounds. If yes, throws IndexOutOfBoundsException.
     *
     * @param index index to check
     * @throws IndexOutOfBoundsException if transferred index is out of list's bounds
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index out of bounds");
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
