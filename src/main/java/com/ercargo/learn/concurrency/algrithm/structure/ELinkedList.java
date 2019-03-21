package com.ercargo.learn.concurrency.algrithm.structure;

import java.util.Objects;

/**
 * @author ercargo  on 2019/1/27
 * @DESCRIBE
 */
public class ELinkedList<T> implements EList<T> {
    private int size;
    private Node<T> head;
    private Node<T> last;

    public ELinkedList() {
        this.head = new Node<T>(null);
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
    public boolean contains(T o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T o) {
        if(this.last == null){
            this.last = new Node<>(o);
            this.last.pre = this.head;
            this.head.next = this.last;
        }else{
            Node<T> oldLast = this.last;
            this.last = new Node<>(o);
            this.last.pre = oldLast;
            oldLast.next = this.last;
        }
        this.size++;
        return true;
    }

    @Override
    public int indexOf(T o) {
        return 0;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public T remove(int index) {

        return null;
    }

    @Override
    public boolean remove(T o) {
        Node node = this.head;
        while(node.next != null){
            node = node.next;
            if(Objects.equals(node.data, o)){
                node.pre.next = node.next;
                if(node.next != null){
                    node.next.pre = node.pre;
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    /**
     * 静态类， 这个Node节点和LinkedList 类作绑定
     *
     * @param <T>
     */
    private static class Node<T> {
        T data;
        Node<T> pre;
        Node<T> next;

        Node(T data) {
            this.data = data;

        }

    }
}
