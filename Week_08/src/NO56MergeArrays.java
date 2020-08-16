import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NO56MergeArrays {
    public static void main(String[] args) {
//        int[][] results = new NO56MergeArrays().merge(new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}});
//        int[][] results = new NO56MergeArrays().merge(new int[][]{{1, 4}, {4, 5}});
//        int[][] results = new NO56MergeArrays().merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
        int[][] results = new NO56MergeArrays().merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});
        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }
    }

    int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {//only one merge situation
                intervals[i + 1][0] = intervals[i][0];
                int end = Math.max(intervals[i + 1][1], intervals[i][1]);
                intervals[i + 1][1] = end;
            } else {
                results.add(intervals[i]);
            }
        }
        results.add(intervals[intervals.length - 1]);
        int[][] mergedArray = new int[results.size()][2];
        for (int i = 0; i < results.size(); i++) {
            mergedArray[i] = results.get(i);
        }
        return mergedArray;
    }

    /*int[][] splitArray(int[][] intervals, int left, int right) {
        if (left == right) {
            return new int[][]{intervals[left]};
        }
        if (left + 1 == right) {
            return mergeArray(intervals[left], intervals[right]);
        }
        int mid = (left + right) >> 1;
        int[][] leftArray = splitArray(intervals, left, mid);
        int[][] rightArray = splitArray(intervals, mid + 1, right);
        boolean isMergeable = isMergeable(leftArray[leftArray.length - 1], rightArray[0]);
        return isMergeable ? merge(leftArray, rightArray) : union(leftArray, rightArray);
    }

    int[][] merge(int[][] leftArray, int[][] rightArray) {
        int tmpIndex = 0;
        int[][] newArray = new int[leftArray.length + rightArray.length][2];
        while (tmpIndex < leftArray.length && tmpIndex < rightArray.length) {
            boolean isMergeable = isMergeable(leftArray[tmpIndex], rightArray[tmpIndex]);
            int maxEnd = Math.max(leftArray[leftArray.length - 1][1], rightArray[rightArray.length - 1][1]);
            leftArray[tmpIndex] = new int[]{leftArray[tmpIndex][0], maxEnd};
        }
    }

    int[][] union(int[][] leftArray, int[][] rightArray) {
        int[][] newArray = new int[leftArray.length + rightArray.length][2];
        int tmpIndex = 0;
        for (int[] ints : leftArray) {
            newArray[tmpIndex++] = ints;
        }
        for (int[] ints : rightArray) {
            newArray[tmpIndex++] = ints;
        }
        return newArray;
    }

    int[][] merge(int[][] leftArray, int[][] rightArray) {
        int[][] newArray;
        int tmpIndex = 0;
        newArray = new int[leftArray.length + rightArray.length - 1][2];
        System.arraycopy(leftArray, 0, newArray, 0, leftArray.length - 1);
        int start = leftArray[leftArray.length - 1][0];
        int end = Math.max(leftArray[leftArray.length - 1][1], rightArray[rightArray.length - 1][1]);
        newArray[leftArray.length - 1] = new int[]{start, end};
        System.arraycopy(rightArray, 1, newArray, 1 + tmpIndex - 1, rightArray.length - 1);
        return newArray;
    }

    boolean isMergeable(int[] leftArray, int[] rightArray) {
        int leftEnd = leftArray[1];
        int rightStart = rightArray[0];
        return leftEnd >= rightStart;
    }

    int[][] mergeArray(int[] leftArray, int[] rightArray) {
        int leftEnd = leftArray[1];
        int rightStart = rightArray[0];
        //只有此情况不合并左数组右侧与右数组左侧不重合时
        if (leftEnd < rightStart) {
            return new int[][]{leftArray, rightArray};
        }
        return new int[][]{{leftArray[0], Math.max(leftArray[1], rightArray[1])}};
    }*/
}
