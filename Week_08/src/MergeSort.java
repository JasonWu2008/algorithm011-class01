public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 6, 9, 1, 7, 5};
        int[] tmpArray = new int[numbers.length];
        new MergeSort().mergeSort(numbers, tmpArray, 0, numbers.length - 1);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    //rightEnd index included
    void mergeSort(int[] sourceArray, int[] tmpArray, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1; //等价于:(leftPos + rightEnd) / 2
            mergeSort(sourceArray, tmpArray, left, mid);
            mergeSort(sourceArray, tmpArray, mid + 1, right);
            merge(sourceArray, tmpArray, left, mid + 1, right);
        }
    }

    void merge(int[] source, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        //对比相同索引位置的值，小的先放大的后放
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (source[leftPos] < source[rightPos]) {
                tmpArray[tmpPos++] = source[leftPos++];
            } else {
                tmpArray[tmpPos++] = source[rightPos++];
            }
        }
        //处理左边多出部分，左边长度为奇数个数时会出现
        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = source[leftPos++];
        }
        //处理右边多出部分
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = source[rightPos++];
        }
        //将临时数组放回原数组
        for (int i = 0; i < numElements; i++, rightEnd--) {
            source[rightEnd] = tmpArray[rightEnd];
        }
    }
}
