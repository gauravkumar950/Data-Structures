import javax.swing.*;
import java.util.*;
public class Stacks {
    //stack implementation using Linked List
//    static class Node{
//        int data;
//        Node next;
//        Node(int data){
//
//            this.data = data;
//            this.next = null;
//        }
//
//    }
//    public static Node head;
//
//    void push(int data){
//        Node newN = new Node(data);
//        newN.next = head;
//        head = newN;
//    }
//    Node pop(){
//        if(head == null){
//            System.out.println("Stack is empty");
//            return head;
//        }
//        Node temp;
//        temp = head;
//        head = head.next;
//        System.out.println(temp.data);
//        return temp;
//    }
//
//    Node peek(){
//        System.out.println(head.data);
//        return head;
//    }
//
//    boolean isEmpty(){
//        return head == null;
//    }





    //Stack implementation using ArrayList
//    public static  class stackB{
//        static ArrayList<Integer> list = new ArrayList<>();
//        static boolean isEmpty(){
//            return list.size() == 0;
//        }
//        public static void push(int data){
//            list.add(data);
//        }
//        static void pop(){
//            if(list.isEmpty()==true){
//                System.out.println("Stack is empty");
//                return;
//            }
//            int top = list.get(list.size()-1);
//            list.remove(list.size()-1);
//            System.out.println(top);
//        }
//        static void peek(){
//            System.out.println(list.get(list.size()-1));
//        }
//    }

    //push at Bottom of Stack
    static void pushAtB(Stack<Integer> s , int data){
        if(s.isEmpty()==true){
            s.push(data);
            return;
        }
        int top = s.pop();

        pushAtB(s,data);


        s.push(top);


    }

    //reverse a Stack
    static void reverse(Stack<Integer> s){
        if(s.isEmpty()==true){
            return;
        }
        int top = s.pop();
        reverse(s);
        pushAtB(s,top);

    }

    static void revStr(Stack<Character> s, String str){
        for(int i = 0;i<str.length();i++){
            s.push(str.charAt(i));
        }
        for(int i = 0;i<str.length();i++){
            System.out.print(s.pop());
        }
    }
    static void displayy(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    //Stock Span Problem
    static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stock.length; i++) {
            while (!s.isEmpty() && stock[i] > stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    //Next Greater Element
    static void nextGre(int arr[]){

        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] nextGre = new int[n];
        for(int i = n-1;i>=0;i--){
            while(!s.isEmpty()){
                if(arr[i]<s.peek()){
                    break;
                }
                s.pop();
            }
            if(s.isEmpty()){
                nextGre[i] = -1;
            }
            else{
                nextGre[i] = s.peek();
            }
            s.push(arr[i]);

        }
        for(int i = 0;i<n;i++){
            System.out.print(nextGre[i]+" ");
        }
    }
    public static void display(int arr[]){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Max Area in a Histogram
    public static void maxArea(int arr[]){
        int maxArea = 0;
        int n = arr.length;
        int[] nsr = new int[arr.length];
        int [] nsl = new int[arr.length];
        //Next smaller right
        Stack<Integer> s1 = new Stack<>();
//        s1.push(n);
        for(int i = n-1;i>=0;i--){
            while(!s1.isEmpty()){
                if(arr[i]>arr[s1.peek()]){
                    break;
                }
                s1.pop();
            }
            if(s1.isEmpty()){
                nsr[i] = n;
            }
            else{
                nsr[i] = s1.peek();
            }
            s1.push(i);
        }
        s1.clear();

        //next smaller left
        for(int i = 0;i<n;i++){
            while(!s1.isEmpty()){
                if(arr[i]>arr[s1.peek()]){
                    break;
                }
                s1.pop();
            }
            if(s1.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s1.peek();
            }
            s1.push(i);
        }
        display(nsr);
        display(nsl);


        int area;
        int height;
        int width;
        for(int i = 0;i<n;i++){
            height = arr[i];
            width = nsr[i]-nsl[i]-1;
            area = height*width;
            if(area>maxArea){
                maxArea = area;
            }
        }
        System.out.println("Maximum Area is: "+ maxArea);

    }







    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        maxArea(arr);



    }

}
