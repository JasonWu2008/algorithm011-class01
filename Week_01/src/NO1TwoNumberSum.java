import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NO1TwoNumberSum {
    public static void main(String[] args) {
//        int[] nums = {15, 7, 11, 2};
//        int[] nums = {3, 2, 4};
        int[] nums = {3, 3};
//        int[] nums = {3, 7, 3};
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {-3, 4, 3, 90};
//        int[] nums = {-10, -1, -18, -19};
        int target = 6;
        int result[] = new NO1TwoNumberSum().twoSum3(nums, target);
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

    private int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer[]> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Integer[] indexes;
            if ((indexes = numMap.get(num)) == null) {
                indexes = new Integer[2];
                indexes[0] = i;
                numMap.put(num, indexes);
                continue;
            }
            indexes[1] = i;
        }
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; j >= 0; ) {
            if (nums[i] + nums[j] == target) {
                if (nums[i] == nums[j]) {
                    Integer[] numArray = numMap.get(nums[i]);
                    return numArray[0] > numArray[1] ? new int[]{numArray[1], numArray[0]} : new int[]{numArray[0], numArray[1]};
                } else {
                    int indexA = numMap.get(nums[i])[0];
                    int indexB = numMap.get(nums[j])[0];
                    return indexA > indexB ? new int[]{indexB, indexA} : new int[]{indexA, indexB};
                }
            }
            if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }
}
