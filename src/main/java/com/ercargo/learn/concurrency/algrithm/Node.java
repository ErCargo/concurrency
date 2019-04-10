package com.ercargo.learn.concurrency.algrithm;

/**
 * @author ercargo  on 2019/4/9
 * @DESCRIBE
 */
public class Node {
    public int value;
    public Node next;


    public Node(int value) {
        this.value = value;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }


        /**
         * head 1 head.next = 2 temp = 2
         * newHead = reverse(2)  ====>   head = 2 , head.next = 3 temp = 3
         * newHead = reverse(3)====> head = 3 head.next = 4 temp = 4
         * newHead = reverse(4) ====> head = 4 head.next = null  递归退出，返回4
         * newHead = 4
         *
         *
         *
         */
        Node temp = head.next; //  head=3, head.next=4  temp = 4
        Node newHead = reverse(head.next);  //4
        temp.next = head;   // 4.next = 3
        head.next = null;  //3.next = null
        return newHead;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
    }
}
