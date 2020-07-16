public class NO153FindMin {
    public static void main(String[] args) {
//        int[] nums = {3,4,5,1,2};
//        int[] nums = {2, 3, 4, 5, 1};
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = new NO153FindMin().findMin(nums);
        System.out.println(result);
    }

    private int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (right - left == 1) {
            return nums[left] < nums[right] ? nums[left] : nums[right];
        }
        int mid = left + (right - left) / 2;
        if (mid == nums.length - 1 || mid == 0) {
            return nums[mid];
        }
        if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
            return nums[mid];
        }
        //说明前半段有序，并且最小值一定在后半段，则查找后半段
        if (nums[mid] > nums[left] && nums[left] > nums[right]) {
            left = mid + 1;
            return find(nums, left, right);
        }
        right = mid;
        return find(nums, left, right);
    }
}
