public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 6, 9, 1, 7, 5};
        new SelectionSort().sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    void sort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = tmp;
            }
        }
    }
}
