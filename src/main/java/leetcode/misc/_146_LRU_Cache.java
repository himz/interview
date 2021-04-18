package leetcode.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Medium
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 *     LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *     int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *     void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 *
 * Constraints:
 *
 *     1 <= capacity <= 3000
 *     0 <= key <= 3000
 *     0 <= value <= 104
 *     At most 3 * 104 calls will be made to get and put.
 *     https://leetcode.com/problems/lru-cache/
 */

/**
 * Algo: Key points to rememeber
 * 1 - HashMap to Double linked list storing value
 * 2 - head and tail dummy nodes
 */
public class _146_LRU_Cache {
    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public _146_LRU_Cache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(); // dummy node
        this.tail = new Node(); // dummy node
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int value = -1;

        if(map.containsKey(key)) {
            Node n = map.get(key);
            value = n.val;
            // move the node to top of the list
            removeNode(n);
            insertAtHead(n);
        }

        return value;
    }

    public void put(int key, int value) {
        Node n;
        if(map.containsKey(key)) {
            //replace operation
            n = map.get(key);
            n.val = value;
            // move it to the top
            removeNode(n);
            insertAtHead(n);
            return;
        }

        if(map.size() >= capacity) {
            // remove tail node
            Node tailPrev = tail.prev;
            map.remove(tailPrev.key);
            removeNode(tailPrev);
        }

        // insert new node
        n = new Node(key, value);
        insertAtHead(n);
        map.put(key, n);

    }

    void insertAtHead(Node n) {
        n.next = head.next;
        n.prev = head;

        head.next = n;
        n.next.prev = n;

    }




    void removeNode(Node n) {
        Node after = n.next;
        Node before = n.prev;

        after.prev = before;
        before.next = after;

        // remove dangling pointers
        n.next = null;
        n.prev = null;
    }


}



class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    public Node() {

    }
    public Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
