package javaLearn;

import java.util.*;

public class Human {
    String name;
    int age;
    public static void main(String [] args) {
        Stack s1 = new Stack();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();
        //stack.push();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println("Stack Peek: " + stack.peek());
        System.out.println("Stack Peek Last: " + stack.peekLast());
        System.out.println("Stack pop:" + stack.pop());


        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
        System.out.println("Q peek: " + queue.peek());
        System.out.println("Q peekLast: " + queue.peekLast());
        System.out.println("Q poll:" + queue.poll());

        HashMap map;

        //queue.offer();
        queue.poll();
        queue.peek();
        PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(a > b) {
                    return 1;
                } else {
                    return -1;
                }
            }});


        HashMap<Integer, PriorityQueue<Integer>> h = new HashMap<>();

    }

    class Animal implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}

