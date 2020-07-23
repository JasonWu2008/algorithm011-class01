import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO18FourNumberSum {
    public static void main(String[] args) {
        int[] nums = {2, 0, 3, 0, 1, 2, 4};
//        int[] nums = {-3, -1, 0, 2, 4, 5, 0};
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 7;
        List<List<Integer>> results = new NO18FourNumberSum().fourSum(nums, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }
    }

    //参考LeetCodeNO18,双指针解法
    //其中考试第一题
    private List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length - 1; j > i + 1; j--) {
                int leftInnerCursor = i + 1;
                int rightInnerCursor = j - 1;
                while (rightInnerCursor > leftInnerCursor) {
                    int sum = nums[i] + nums[leftInnerCursor] + nums[rightInnerCursor] + nums[j];
                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[leftInnerCursor], nums[rightInnerCursor], nums[j]);
                        if (!results.contains(list)) {
                            results.add(list);
                        }
                        while (rightInnerCursor > leftInnerCursor && nums[rightInnerCursor - 1] == nums[rightInnerCursor]) {
                            rightInnerCursor--;
                        }
                        while (rightInnerCursor > leftInnerCursor && nums[leftInnerCursor + 1] == nums[leftInnerCursor]) {
                            leftInnerCursor++;
                        }
                        leftInnerCursor++;
                        rightInnerCursor--;
                    }
                    if (sum > target) {
                        rightInnerCursor--;
                    }
                    if (sum < target) {
                        leftInnerCursor++;
                    }
                }
            }
        }
        return results;
    }
}
