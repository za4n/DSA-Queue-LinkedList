package DoubleCircularLinkedList;

public class DoubleCircularLinkedList {
     private int size;
     private Node head;
     private Node tail;
    public boolean isListEmpty(){
        return (size == 0);
    }
    public int getSize() {
        return size;
    }


    private void listEmptyInsertion(Node n){
        head = n;
        tail = n;
        head.next = tail;
        tail.previous = head;
    }
    public void insertionAtStart(int value){
        Node n = new Node(value);
        if(head == null) listEmptyInsertion(n);
        else
        {
            n.next = head;
            n.previous = tail;
            head.previous = n;
            tail.next = n;
            head = n;
        }
        size++;
    }
    public void insertionAtEnd(Node n){;
        if(head == null) listEmptyInsertion(n);
        else {
           n.next = head;
           n.previous = tail;
            tail.next = n;
            head.previous = n;
            tail = n;
        }
        size++;
    }
    public void insertAtAnyIndex(int index ,int value){
        if(index >= 0 && index < size){
            if(index == 0) {insertionAtStart(value);return;}
            else {
                Node n = new Node(value);
                Node prev = head;
                for (int i = 0;i< index-1;i++) prev = prev.next;
                Node next = prev.next;
                next.previous = n;
                n.next = next;
                prev.next = n;
            }
            size++;
        }
    }
    public void reverse(){
        Node previous = null;
        Node next = null;
        Node h = head;
        do{
            previous = h.previous;
            next = h.next;
            h.next = previous;
            h.previous = next;
            h = next;
        }while (h!=head);
       head = previous.previous;
    }
    public int deleteAtStart(){
        if(head != null){
        Node temp = head;
        head = head.next;
        head.previous = tail;
        tail.next = head;
        size--;
        return temp.data;
        }
        return -1;
    }
    public int deleteAtEnd(){
        if(head !=null){
            Node temp = tail;
            tail = temp.previous;
            tail.next = head;
            head.previous = tail;
            size--;
            return temp.data;
        }
        return -1;
    }
    public DoubleCircularLinkedList clone(){
        Node next;
        Node h = head;
        do{
            next = h.next;
            Node n = new Node(h.data);
            h.next = n;
            n.previous = h;
            n.next = next;
            h = next;
        }while (h!=head);
        DoubleCircularLinkedList new1 = new DoubleCircularLinkedList();
        Node h2 = head;
        do{
            next = h2.next;
            h2.next = next.next;
            next.next.previous = h2;
            new1.insertionAtEnd(next);
            h2 = h2.next;
        }while (h2!=head);
    return new1;


    }
    public int deleteAtSpecificIndex(int index){
        int rtn;
        if(index >= 0 && index < size ){
            if(index == 0){ rtn = deleteAtStart(); return rtn;}
            else {
                Node prev = head;
                for (int i = 0;i< index-1;i++) prev = prev.next;
                Node next = prev.next.next;
                Node del = prev.next;
                prev.next = next;
                next.previous = prev;
                size--;
                return del.data;
            }
        }
        return -1;
    }
    public void bubbleSort(){
        Node h = head;
        Node n = h.next;
        for(int i = 0;i<size-1;i++){
            for (int j = i+1;j<size;j++){
                if(h.data.compareTo(n.data) > 0){
                    Integer temp = h.data;
                    h.data = n.data;
                    n.data = temp;
                }
                n = n.next;
            }
            h = h.next;
            n = h.next;
        }
    }
    public void mergeList(DoubleCircularLinkedList newLinkedList){
        if(newLinkedList.head != null){
            tail.next = newLinkedList.head;
            newLinkedList.head.previous=tail;
            tail = newLinkedList.tail;
            tail.next = head;
            head.previous = tail;
            size+=newLinkedList.size;
        }
    }
    public Node search(int value){
        Node temp = head;
      do{
          if(temp.data == value) return temp;
          temp = temp.next;
      }while (temp !=head);
        return null;
    }
    public void updateNode(int oldValue, int newValue){
        Node old = search(oldValue);
        if(old != null){
            Node temp = head;{
                do{
                    if(temp == old )
                    {temp.data = newValue;}temp = temp.next;}while (temp !=head);
            }
        }
        else System.out.println("Element Not found");
    }

    public void traverseList(){
        Node t = head;
        if(!isListEmpty())
            do{System.out.println(t.data);t = t.next;}while (t!=head);
    }
}
