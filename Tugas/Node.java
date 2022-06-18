package Tugas;

public class Node {
    int data;
    Node prev, next;

    Node(Node prev, int source, Node next){
        this.prev=prev;
        this.data=source;
        this.next=next;
    }
}

