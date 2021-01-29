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
        stack.pop();
        stack.peek();

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

