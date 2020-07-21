import java.util.Stack;

public class NO283MoveZeros {
    private int noneZeroCount = 0;

    public static void main(String[] args) {
        int[] nums = {0, 0, 1};
//        int[] nums = {0, 1, 0, 3, 12};
        new NO283MoveZeros().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private void moveZeroes(int[] nums) {
        ZeroCountPair zeroCountPair = findZeroCount(nums);
        noneZeroCount = nums.length;
        while (!zeroCountPair.zeroCounts.isEmpty()) {
            moveNumbers(zeroCountPair.zeroCounts.pop(), nums);
        }
    }

    private void moveNumbers(ZeroCount zeroCount, int[] nums) {
        int numMoveStartIndex = zeroCount.startIndex + zeroCount.count;
        for (int i = numMoveStartIndex; i < noneZeroCount; i++) {
            nums[i - zeroCount.count] = nums[i];
            nums[i] = 0;
        }
        noneZeroCount = noneZeroCount - zeroCount.count;
    }

    private ZeroCountPair findZeroCount(int[] nums) {
        int totalZero = 0;
        Stack<ZeroCount> zeroCounts = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                continue;
            }
            totalZero++;
            ZeroCount zeroCount = zeroCounts.isEmpty() ? null : zeroCounts.peek();
            if (zeroCount == null || i - 1 != zeroCount.startIndex) {
                zeroCounts.add(new ZeroCount(i, 1));
            } else {
                zeroCount.increaseCount();
            }
        }
        return new ZeroCountPair(totalZero, zeroCounts);
    }

    private class ZeroCountPair {
        int totalZero;
        Stack<ZeroCount> zeroCounts = new Stack<>();

        ZeroCountPair(int totalZero, Stack<ZeroCount> zeroCounts) {
            this.totalZero = totalZero;
            this.zeroCounts = zeroCounts;
        }
    }

    private class ZeroCount {
        private int startIndex;
        private int count;

        ZeroCount(int startIndex, int count) {
            this.startIndex = startIndex;
            this.count = count;
        }

        private void increaseCount() {
            count++;
        }
    }
}
