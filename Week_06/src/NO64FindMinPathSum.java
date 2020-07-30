public class NO64FindMinPathSum {
    public static void main(String[] args) {
        /*int[][] grid = new int[3][3];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};*/
        int[][] grid = new int[3][2];
        grid[0] = new int[]{1, 2};
        grid[1] = new int[]{5, 6};
        grid[2] = new int[]{1, 1};
        int minPathSum = new NO64FindMinPathSum().minPathSum(grid);
        System.out.println(minPathSum);
    }

    //dp方程: newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]) + grid[i][j];
    int minPathSum(int[][] grid) {
        int[][] newGrid = new int[grid.length][grid[0].length];
        newGrid[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            newGrid[0][i] = newGrid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            newGrid[i][0] = newGrid[i - 1][0] + grid[i][0];
            for (int j = 1; j < grid[i].length; j++) {
                newGrid[i][j] = Math.min(newGrid[i - 1][j], newGrid[i][j - 1]) + grid[i][j];
            }
        }
        return newGrid[grid.length - 1][grid[0].length - 1];
    }
}
