package DoubleCircularLinkedList;

public class Node {
    Integer data;
     Node previous;
     Node next;

    public Integer getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public Node(Integer data) {
        this.data = data;

    }
}
