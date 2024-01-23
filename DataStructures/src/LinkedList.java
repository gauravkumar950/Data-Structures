import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }


    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        size++;
        if(head == null){
            head = tail = new Node(data);

            return;
        }
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        size++;
        if(head == null){
            head = tail = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        tail.next = newNode;
        tail = newNode;
    }
    // To print
    public void print(){
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        else{
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data +"-->");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }
    //to set newdata to the node at specified index
    public void set(int index,int newdata){
        if(head == null && index!=0){
            System.out.println("LL is empty and Enter index correclty");
            return;
        }
        else if(head==null && index==0){
            addFirst(2);
            return;

        }
        Node temp = head;
        int idx=0;
        while(idx<index+1){
            if(idx == index){
                temp.data = newdata;
                return;
            }
            temp = temp.next;
            idx++;
        }
    }
    //to add a new node at the specified index
    public void add(int index,int newdata){

        if(index == 0){
            addFirst(newdata);
            return;
        }
        size++;
        Node temp = head;
        int idx = 0;
        while(idx <index+1){
            if(idx==index-1){
                Node newNode = new Node(newdata);
                newNode.next = temp.next;
                temp.next= newNode;
                return;
            }
            temp = temp.next;
            idx++;
        }
    }
    //remove firsta and last in Linked List
    public void removeFirst(){
        if(size==0){
            System.out.println("Linked list is empty");
            return;
        }
        else if(size ==1){
            head = tail = null;
            size--;
            return;
        }
        head = head.next;
        size--;
    }
//    public void  removeLast(){
//        tail =
//    }
    //searching for a key in a linked list(Iteravtive method)
    public int searchite(int key){
        Node temp = head;
        int i = 0;
        while(temp!=null){
            if(temp.data == key) {
                return i;
            }
            temp= temp.next;
            i++;
        }
        return -1;
    }
    //searching for a key in Linked lIst using Recursion
    public int search(int key,Node temp,int i){

        if(temp==null){
            return -1;
        }
        if(temp.data == key){
            return i;
        }
        i++;
        int idx = search(key,temp.next,i++);
        if(idx == -1){
            return -1;
        }
        return idx;
    }
    // To delete Nth element from last of a linked list
    public void delte(int n){
        if(n==size){
            head = head.next;
        }
        Node temp = head;
        int i  = 0;
        while(i<size-n){
            if(i == size-n-1){
                temp.next =temp.next.next;
            }
            i++;

            temp = temp.next;

        }
    }
    //to find the midNode of a LinkedList
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //to check if Linked list is Palindrome is not
    public boolean checkPalindrome(){
        if(head == null || head.next ==null){
            return true;
        }
        //Step 1
        Node mid = findMid(head);
        //Step 2
        Node prev = null;
        Node curr = mid;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        //Step 3
        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            right=  right.next;
            left = left.next;
        }
        return true;
    }


    //to reverse a linked list
    public void reverse(){
        Node prev = null;
        Node curr =tail= head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //to detect a loop/cycle in a Linked List using ArrayList
    ArrayList<Node> list = new ArrayList<>();
    public boolean checkLoop(){
        Node temp = head;
        while(temp!=null){
            if(list.contains(temp)==true){
                return true;
            }
            list.add(temp);
            temp = temp.next;
        }
        return false;
    }
    //to detect a Loop/cycle in Linked List
    public boolean checkCycle(){
        Node slow = head;
        Node fast = head;
        if(head==null){
            return false;
        }
        else if(head.next==null){
            return false;
        }
        else{
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }

        }
        return false;
        }
    }

    //to delete a  Cycle from a Linked List
    public void deleteLoop(){
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                slow = head;
                break;
            }

        }

        while(slow!=fast){
            slow= slow.next;
            fast = fast.next;
        }
        Node prev = fast;
        fast = fast.next;
        while(slow!=fast){
            prev = fast;
            fast =fast.next;
        }
        prev.next = null;

    }
    //find Midnode for MergeSort
    public Node midNode(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //MergeSort
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //Step1
        Node mid = midNode(head);
        //Step 2
        Node head1 = head;
        Node head2 = mid.next;
        mid.next = null;
        //Step 3
        Node newleft = mergeSort(head);
        Node newright = mergeSort(head2);
        return merge(newleft,newright);

    }

    public Node merge(Node head1,Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;
        while(head1!=null && head2!=null){
            if(head1.data <= head2.data){
                temp.next= head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

        }
        while(head1!=null){
            temp.next= head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next= head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    //Zig-Zag Linked List
    public Node zigZag(Node head){
        if(head == null || head.next==null){
            return head;
        }
        //Step 1
        Node mid = midNode(head);
        //Step 2
        Node prev = null;
        Node curr = mid.next;
        Node next;
        mid.next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node head2 = prev;

        //Step 3
        Node zigzag = new Node(-1);
        Node temp = zigzag;
        int i =1;
        while(i<size+1){

           if(i%2==0){
               temp.next = head2;
               head2 = head2.next;
               temp = temp.next;
           }
           else{
               temp.next = head;
               head = head.next;
               temp = temp.next;
           }
           i++;
        }


        return zigzag.next;
    }

    //to find the intersection of a linked list
    public Node findIntersection(Node head1,Node head2){
        ArrayList<Node> list = new ArrayList<>();
        Node temp = head1;
        while(temp!= null){
            list.add(temp);
            temp = temp.next;
        }
        temp = head2;
        while(temp!= null){
            if(list.contains(temp) == true){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    //Delete N nodes after M nodes of a LL
    public void deleteM(Node head,int M,int N){
        int i = 1;
        Node temp = head;
        try {
            while (temp != null) {
                if (i >= M && i < M + N) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
                i++;
            }
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException");
        }
    }

    //Swapping Nodes in a Linked List
    public  void swap(int x,int y){
        Node temp = head;
        Node ptr1 = head;
        Node ptr2 = head;
        Node newNode;

        while(temp.next!=null){
            if(temp.next.data == x){
                ptr1 = temp;
            }
            else if(temp.next.data == y){
                ptr2 = temp;
            }
            temp = temp.next;
        }
        System.out.println(ptr1.data);
        System.out.println(ptr2.data);
        if(x==1) {

            newNode = ptr1;
            head = ptr2.next;
            ptr2.next = newNode;
        }
        else if(y==1) {

            newNode = ptr2;
            head = ptr1.next;
            ptr1.next = newNode;
        }
        else{
            Node n1 = ptr1.next;
            Node n2 = ptr2.next;
            newNode = ptr1.next;
            ptr1.next = ptr2.next;
            ptr2.next = newNode;
            ptr1.next.next = n1.next;
            ptr2.next = n2.next;

//            ptr2.next.next = p3.next;


        }

    }

    public static void main(String[] args) {
        // Create a HashMap
        LinkedList ll = new LinkedList();
//
//        ll.addFirst(6);
//        ll.addFirst(5);
//        ll.addFirst(4);
//        ll.addFirst(3);
//        ll.addFirst(2);
//        ll.addFirst(1);
//        ll.print();
//        ll.swap(2,6);
        System.out.println(head.data    );
        ll.print();
//        head = new Node(1);
//        head.next = new Node(2);
//        head.next.next =new Node(3);
//        head.next.next.next = new Node(4);
//        head.next.next.next.next = head;


    }
}