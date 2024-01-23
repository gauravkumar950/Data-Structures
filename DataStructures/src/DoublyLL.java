public class DoublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //addFirst
    public void addFirst(int data){
        size++;
        if(head == null){
            head = tail = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }
    //print next
    public void print(Node head){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    //to print preivous
    public void printPrev(Node head){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    //removeFirst
    public void removeFirst(){
        if(head ==null){
            System.out.println("LL is empty");
            return;
        }
        if(head.next == null){
            head = tail = null;

        }
        head = head.next;
        head.prev = null;
        size--;

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print(head);
        dll.removeFirst();
        dll.print(head);


    }
}