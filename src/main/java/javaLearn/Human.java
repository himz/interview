package javaLearn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Human {
    String name;
    int age;
    public static void main(String [] args) {
        Stack s1 = new Stack();

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> queue = new ArrayDeque<>();

        stack.push();
        stack.pop();
        stack.peek();


        queue.offer();
        queue.poll();
        queue.peek();

    }
}

