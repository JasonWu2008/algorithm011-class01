import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NO200CalcLandNumber {
    //注意：int[][]不要被LeetCode题解中坐标轴误导！！这里的"向右""向下"表示数组的位置
    private static final int[] RIGHT = {0, 1};//行不变，列加1
    private static final int[] BOTTOM = {1, 0};
    private static final int[] LEFT = {0, -1};
    private static final int[] ABOVE = {-1, 0};

    private static final List<int[]> DIRECTIONS = new ArrayList<>();
    private int rows = 0;
    private int columns = 0;
    private boolean[][] visited;
    private Deque<Point> deque = new ArrayDeque<>();

    static {
        DIRECTIONS.add(RIGHT);
        DIRECTIONS.add(BOTTOM);
        DIRECTIONS.add(LEFT);
        DIRECTIONS.add(ABOVE);
    }

    //参考Java版本的深度优先遍历法
    public static void main(String[] args) {
        char[][] grids = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        char[][] grids2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        char[][] grids3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(new NO200CalcLandNumber().processBFS(grids2));
    }

    private int processBFS(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        columns = grid[0].length;
        visited = new boolean[rows][columns];
        int islandNumber = 0;
        //rows
        for (int i = 0; i < grid.length; i++) {
            //columns
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islandNumber++;
                    Point point = new Point(i, j);
                    deque.addLast(point);
                    bfs(grid);
                }
            }
        }
        return islandNumber;
    }

    private void bfs(char[][] grids) {
        while (!deque.isEmpty()) {
            Point point = deque.pop();
            visited[point.rowIndex][point.columnIndex] = true;
            System.out.println("pop: row:" + point.rowIndex + ", column:" + point.columnIndex);
            for (int[] bfsDirection : DIRECTIONS) {
                int rowIndex = point.rowIndex + bfsDirection[0];
                int columnIndex = point.columnIndex + bfsDirection[1];
                if (isInArea(rowIndex, columnIndex) && !visited[rowIndex][columnIndex] && grids[rowIndex][columnIndex] == '1') {
                    Point newPoint = new Point(rowIndex, columnIndex);
                    deque.addLast(newPoint);
                    System.out.println("addLast: row:" + rowIndex + ", column:" + columnIndex);
                    bfs(grids);
                }
            }
        }
    }

    private class Point {
        private int rowIndex;
        private int columnIndex;

        private Point(int rowIndex, int columnIndex) {
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
    }

    //网格移动的"驱动"是通过i*j次的循环完成的，虽然每次的dfs可能会标记很多"已访问"的节点，
    //但前进的路径依然会逐行扫，路径数目不会少，只不过不会进入dfs
    private int processDFS(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        rows = grid.length;
        columns = grid[0].length;
        visited = new boolean[rows][columns];
        int islandNumber = 0;
        //rows
        for (int i = 0; i < grid.length; i++) {
            //columns
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islandNumber++;
                    dfs(i, j, grid);
                }
            }
        }
        return islandNumber;
    }

    //如果在"区域内"且该点的为"岛屿"则继续下探,
    //下探是根据四个方向"顺时针"找，即"右->下->左->上"的顺序,（实际顺序无所谓，但这个顺序比较符合人的习惯）
//    下探时会优先找右边的元素，如果右边元素碰到边界或者不是岛屿则会按上述顺序再继续找
    //这里的"回溯"是通过递归自动完成的，因为每个节点本来需要走四步，最内层走完后，会一层一层回到最外层直到到达最初i,j的位置
    private void dfs(int i, int j, char[][] grids) {
        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int rowIndex = i + direction[0];
            int columnIndex = j + direction[1];
            if (isInArea(rowIndex, columnIndex) && !visited[rowIndex][columnIndex] && grids[rowIndex][columnIndex] == '1') {
                dfs(rowIndex, columnIndex, grids);
            }
        }
    }

    //x,y预算后没有越界且在网格内
    private boolean isInArea(int x, int y) {
        return x >= 0 && y >= 0 && y <= columns - 1 && x <= rows - 1;
    }
}
