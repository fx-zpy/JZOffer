package BackTracking;

/**
 * JZ13 机器人的运动范围
 * 地上有一个 rows 行和 cols 列的方格。坐标从 [0,0] 到 [rows-1,cols-1] 。
 * 一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。
 * 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，因为 3+5+3+7 = 18。但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。
 * 请问该机器人能够达到多少个格子？
 */
public class bt2 {
    public int movingCount(int threshold, int rows, int cols) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[rows][cols];
        return dfs(0, 0, rows, cols, threshold, visited);
    }

    public int dfs(int i, int j, int rows, int cols, int threshold, boolean[][] visited) {
        //i >= rows || j >= cols是边界条件的判断，threshold < sum(i, j)判断当前格子坐标是否
        // 满足条件，visited[i][j]判断这个格子是否被访问过
        if (i >= rows || j >= cols || threshold < sum(i, j) || visited[i][j]) {
            return 0;
        }
        //标注这个格子被访问过
        visited[i][j] = true;
        //沿着当前格子的右边和下边继续访问
        return 1 + dfs(i + 1, j, rows, cols, threshold, visited) +
                dfs(i, j + 1, rows, cols, threshold, visited);
    }

    //计算两个坐标数字的和
    private int sum(int i, int j) {
        int sum = 0;
        //计算坐标i所有数字的和
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        //计算坐标j所有数字的和
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
