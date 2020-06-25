package jasonwu;

import java.util.*;

public class NO15ThreeNumberSum {
    public static void main(String[] args) {
//        int nums[] = {-2, 0, 1, 1, 2};
//        int nums[] = {-1, 0, 1, 0};
        int nums[] = {-1, 0, 1, 2, -1, -4};
//        int nums[] = {0, 0};
        List<List<Integer>> results = new NO15ThreeNumberSum().threeSum(nums);
        System.out.println(results);
        /*for (List<Integer> result : results) {
            System.out.println(result.get(0) + " + " + result.get(1) + " = " + result.get(2));
        }*/
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//遍历到正数时即退出
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {//防止从复,前一个元素已经已经和本元素组合过
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k && j < nums.length; ) {
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> matched = new ArrayList<>(3);
                    matched.add(nums[i]);
                    matched.add(nums[j]);
                    matched.add(nums[k]);
                    results.add(matched);
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return results;
    }
}
