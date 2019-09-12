package linkedList;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @author csp
 * @description: 双向链表实现LRU缓存淘汰算法
 * @date 2019/9/12 20:49
 */
public class LRUDoubleLinkedList<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private int maxSize;
    private HashMap<K, Node> map;

    public LRUDoubleLinkedList(int maxSize) {
        this.maxSize = maxSize;
        this.map = new HashMap<>(maxSize * 4 / 3);
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRUDoubleLinkedList<String, String> lru = new LRUDoubleLinkedList<>(3);
        lru.put("name", "csp");
        lru.put("age", "123");
        lru.put("addr", "java");
        lru.put("tel", "123");
    }

    private void put(K key, V value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            unlink(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        insertToHead(node);
        if (map.size() > maxSize) {
            Node toRemove = removeTail();
            map.remove(toRemove.key);
        }
    }

    /**
     * 移除尾部结点
     *
     * @return
     */
    private Node removeTail() {
        Node node = tail.pre;
        Node pre = node.pre;
        tail.pre = pre;
        pre.next = tail;
        return node;
    }

    /**
     * 删除重复结点
     *
     * @param node
     */
    private void unlink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 头插法
     *
     * @param node
     */
    private void insertToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private class Node {
        Node pre;
        Node next;
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}
