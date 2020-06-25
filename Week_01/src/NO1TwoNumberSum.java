import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO1TwoNumberSum {
    public static void main(String[] args) {
        int[] nums = {15,7, 11, 2};
//        int[] nums = {3, 2, 4};
//        int[] nums = {3, 3};
        int target = 13;
        int result[] = new NO1TwoNumberSum().twoSum2(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.containsKey(target - num)) {
                result[0] = numMap.get(target - num);
                result[1] = i;
                return result;
            }
            numMap.put(num, i);
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] newArray = new int[nums.length];
        Map<Integer, Integer> valueAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
            valueAndIndexMap.put(nums[i], i);
        }
        Arrays.sort(newArray);
        int valueA = 0, valueB = 0;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            if (newArray[i] + newArray[j] == target) {
                valueA = newArray[i];
                valueB = newArray[j];
                break;
            }
            if (newArray[i] + newArray[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        int[] result = {-1, -1};
        if (valueAndIndexMap.get(valueA) == null || valueAndIndexMap.get(valueB) == null) {
            return result;
        }
        result[0] = valueAndIndexMap.get(valueA);
        result[1] = valueAndIndexMap.get(valueB);
        return result;
    }
}
