import java.util.Comparator;
import java.util.PriorityQueue;

public class NO239MaxSlidingWindow {
    public static void main(String[] args) {
        /*PriorityQueue<Integer> window = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o2 - o1);
        window.add(1);
        window.add(3);
        window.add(-1);
        System.out.println("size:"+window.size());
        window.add(-3);
        window.add(5);
        window.add(3);
        window.add(6);
        window.add(7);
        Integer val;
        while ((val=window.poll())!=null){
            System.out.println(val);
        }*/
        int k = 3;
        int[] inputNumbers = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] results = new NO239MaxSlidingWindow().maxSlidingWindow2(inputNumbers, k);
        for (int result : results) {
            System.out.println(result);
        }
    }

    //Heap实现
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] results = new int[nums.length - k + 1];
        PriorityQueue<Integer> window = new PriorityQueue<>((Comparator<Integer>) (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; ++i) {
            if (i - k >= 0) {//窗口已满了,每次滑动一位会挤出最老元素
                window.remove(nums[i - k]);
            }
            window.offer(nums[i]);
            if (window.size() == k) {
                results[i - k + 1] = window.peek();
            }
        }
        return results;
    }
}
