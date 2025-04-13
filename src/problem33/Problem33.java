package problem33;

import java.util.HashMap;

public class Problem33 {

    static class LRUCache {

        static class Node {
            private Node next;
            private Node prev;
            private int key;
            private int value;

            public Node(Node prev, Node next, int key, int value) {
                this.prev = prev;
                this.next = next;
                this.key = key;
                this.value = value;
            }

            public int getValue() {
                return value;
            }

            public Node getNext() {
                return next;
            }

            public Node getPrev() {
                return prev;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public int getKey() {
                return key;
            }
        }

        private final int capacity;
        private HashMap<Integer, Node> cache;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = null;
            this.tail = null;
        }

        private void remove(Node node) {
            Node prev = node.getPrev();
            Node next = node.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        }

        private void enqueue(Node node) {
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {

            }
        }

        public int get(int key) {
            if(!cache.containsKey(key)) {
                return -1;
            }
            Node node = cache.get(key);
            remove(node);
            enqueue(node);
            return node.getValue();
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                remove(node);
            }
            Node node = new Node(null, null, key, value);
            cache.put(key, node);
            enqueue(node);

            if (cache.size() > capacity) {
                // Evict the least recently used node
                int evictableKey = tail.getKey();
                remove(tail);
                cache.remove(evictableKey);
            }
        }
    }
}
