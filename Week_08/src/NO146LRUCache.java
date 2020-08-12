import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class NO146LRUCache {
    private int capacity;
    private ArrayDeque<Integer> deque;
    private Map<Integer, Integer> hashMap = new HashMap<>();

    public NO146LRUCache(int capacity) {
        this.capacity = capacity;
        deque = new ArrayDeque<>(capacity);
    }

    public static void main(String[] args) {
        new NO146LRUCache(2).testCase2();
    }

    void testCase1() {
        NO146LRUCache no146LRUCache = new NO146LRUCache(2);
        no146LRUCache.put(1, 1);
        no146LRUCache.put(2, 2);
        System.out.println(no146LRUCache.get(1));
        no146LRUCache.put(3, 3);
        System.out.println(no146LRUCache.get(2));
        no146LRUCache.put(4, 4);
        System.out.println(no146LRUCache.get(1));
        System.out.println(no146LRUCache.get(3));
        System.out.println(no146LRUCache.get(4));
    }

    void testCase2() {
        NO146LRUCache no146LRUCache = new NO146LRUCache(2);
        no146LRUCache.put(2, 1);
        no146LRUCache.put(1, 1);
        no146LRUCache.put(2, 3);
        no146LRUCache.put(4, 1);
        System.out.println(no146LRUCache.get(1));
        System.out.println(no146LRUCache.get(2));
    }

    public int get(int key) {
        Integer result;
        if ((result = hashMap.get(key)) != null) {
            deque.remove(key);
            deque.addFirst(key);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)) {
            deque.addFirst(key);
            if (deque.size() > capacity) {
                Integer last = deque.removeLast();
                if (last != null) {
                    hashMap.remove(last);
                }
            }
        } else {
            deque.remove(key);
            deque.addFirst(key);
        }
        hashMap.put(key, value);
    }
}
