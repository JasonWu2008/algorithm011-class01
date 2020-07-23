import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class NO239MaxSlidingWindow {
    public static void main(String[] args) {
        //new NO239MaxSlidingWindow().testDeque();
        int k = 3;
        int[] inputNumbers = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] results = new NO239MaxSlidingWindow().maxSlidingWindow3(inputNumbers, k);
        for (int result : results) {
            System.out.println(result);
        }
    }

    private void testDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 100; i++) {
            deque.addLast(i);
        }
        System.out.println(deque.size());
    }

    //Heap实现leetCode已经不再推荐,17/18 case 10万的元素,和5万的窗口,无法通过
    //log(k)每次移动需要"挤出"和"加入"元素,所以时间复杂度是O(2nlog(k))
    //remove log(K)//窗口已满,每次滑动一位会挤出最老元素,需要移除n次,时间复杂度nlog(k)
    //offer log(K)//加入新元素,需要操作n次,时间复杂度nlog(k)
    //peek O(1)

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] results = new int[nums.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; ++i) {
            if (i - k >= 0) {//窗口已满,每次滑动一位会挤出最老元素
                window.remove(nums[i - k]);
            }
            window.offer(nums[i]);
            if (window.size() == k) {
                results[i - k + 1] = window.peek();
            }
        }
        return results;
    }


    //用双端队列实现 Deque
    //窗口滑动时,将划过窗口内的元素挤出,也就是i-k=窗口的头元素(Deque.getFirst())
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] results = new int[nums.length - k + 1];
        ArrayDeque<Integer> window = new ArrayDeque<>();
        //窗口还没有滑入列表
        for (int i = 0; i < k; i++) {
            removeSmaller(nums, i, window);
            window.addLast(i);
        }
        //窗口刚好与列表重合,第一个结果即为窗口最左边的元素
        results[0] = nums[window.peek()];
        //窗口划过
        for (int i = k; i < nums.length; i++) {
            //由于"挤出"的操作，window内的元素不一定都是满的，
            //只有当window的第一个元素索引与"i-k"一样时表示队列已满
            if (window.getFirst() == i - k) {
                window.removeFirst();
            }
            removeSmaller(nums, i, window);
            window.addLast(i);
            results[i - k + 1] = nums[window.peek()];
        }
        return results;
    }

    //移除比i上小的元素
    private void removeSmaller(int[] nums, int i, Deque<Integer> window) {
        while (!window.isEmpty() && nums[i] > nums[window.getLast()]) {
            window.removeLast();
        }
    }
}
