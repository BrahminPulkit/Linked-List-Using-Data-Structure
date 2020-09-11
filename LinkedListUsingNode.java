package CoronaTimePracticeLinkedList;

public class LinkedListUsingNode {
    private Node head ;
    private Node tail;
    private int size = 0;

    public class Node{
        private int value;
        private Node next;
        public Node(int value ){
            this.value  = value;
           // this.next = next;
        }
    }
    public boolean isEmpty(){
        return this.size == 0;
    }
    public void addFirst(int value){
        Node n = new Node(value);
        n.next = head;
        head = n;

        size++;
        if (tail ==  null){
            tail = head;
        }
    }
    public void addLast(int value){
        if (size<1){
            addFirst(value);
            return;
        }
        Node n = new Node(value);
        tail.next = n;
        tail = n;
        size++;
    }
    public int deleteFirst(){
        if (size == 0){
            System.out.println("Khaali hai be");
            return 0;
        }
        int temp =  head.value;
        head = head.next;
        size--;

        return temp;
    }
    public int deleteLast(){
        Node temp = head;
        while (temp.next != tail){
            temp = temp.next;
        }

        int del = temp.next.value;
        tail = temp;
        tail.next = null;
        size--;

        return del;
    }
    public void duplicate(){
     Node temp = head;
     while (temp.next != null){
         if (temp.value == temp.next.value){
             temp.next = temp.next.next;
             size--;
         }else {
             temp = temp.next;
         }
     }
    }
    public Node get(int index){
        Node temp = head;

        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void insertBetween(int value , int index){
        if (index == 0){
            addFirst(value);
            return;
        }
        if (index == size){
            addLast(value);
            return;
        }

        Node prev = get(index-1);
        Node node = new Node(value);
        node.next = prev.next;
        size++;
    }
    public int kthFromLast(int k){
        Node slow = head;
        Node fast = head;
        for (int i = 0; i <k ; i++) {
            fast = fast.next;
        }
        while (fast!= null){
            slow= slow.next;
            fast= fast.next;
        }
        return slow.value;
    }
    public Node mid(){
        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next.next;
        }
        return slow;
    }
    public LinkedListUsingNode mergeSort(LinkedListUsingNode  list){
        if (list.size == 1){
            return list;
        }

        Node mid = list.mid();
        LinkedListUsingNode first = new LinkedListUsingNode();
        first.head = list.head;
        first.tail = mid;
        first.size = (list.size+1/2);

        LinkedListUsingNode second = new LinkedListUsingNode();
        second.head = mid.next;
        second.tail = list.tail;
        second.size = (list.size/2);

        mid.next = null;

        first = mergeSort(first);
        second = mergeSort(second);
        return merge(first,second);
    }

    public LinkedListUsingNode merge(LinkedListUsingNode first , LinkedListUsingNode second){
        LinkedListUsingNode list = new LinkedListUsingNode();

        Node f = first.head;
        Node s =second.head;

        while (f != null && s != null){
            if (f.value < s.value){
                list.addLast(f.value);
                f = f.next;
            }else {
                list.addLast(s.value);
                s = s.next;
            }
        }
        while (f != null){
            list.addLast(f.value);
            f = f.next;
        }
        while (s != null){
            list.addLast(s.value);
            s = s.next;
        }
        return list;
    }

    public void display(){
        Node temp  = head;
        while (temp != null){
            System.out.print(temp.value +"->");
            temp = temp.next;
        }
        System.out.println();
    }
}
