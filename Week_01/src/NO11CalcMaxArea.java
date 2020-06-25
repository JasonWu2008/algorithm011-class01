public class NO11CalcMaxArea {
    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        System.out.println(new NO11CalcMaxArea().maxArea(heights));
        System.out.println(new NO11CalcMaxArea().maxArea2(heights));
    }

    //暴力求解
    public int maxArea(int[] height) {
        int maxArea = -1;
        for (int blackIndex = 0; blackIndex < height.length - 1; blackIndex++) {
            for (int redIndex = blackIndex + 1; redIndex < height.length; redIndex++) {
                int newArea = (redIndex - blackIndex) * Math.min(height[blackIndex], height[redIndex]);
                if (newArea > maxArea) {
                    maxArea = newArea;
                }
            }
        }
        return maxArea;
    }

    //两端夹逼法,
    public int maxArea2(int[] height) {
        int maxArea = -1;
        for (int leftIndex = 0, rightIndex = height.length - 1; leftIndex < rightIndex; ) {
            int leftH = height[leftIndex];
            int rightH = height[rightIndex];
            int newArea = Math.min(leftH, rightH) * (rightIndex - leftIndex);
            if (newArea > maxArea) {
                maxArea = newArea;
            }
            if (leftH < rightH) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxArea;
    }
}
