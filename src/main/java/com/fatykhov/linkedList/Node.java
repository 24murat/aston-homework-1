package com.fatykhov.linkedList;

public class Node<E> {
    //    Node - это узел
    E item;        // хранит объект в текущем узле
    Node<E> next;  // хранит ссылку на следующий узел
    Node<E> prev;  // хранит ссылку на предыдущий узел


    public Node(E item) {
        this.item = item;
    }

}
