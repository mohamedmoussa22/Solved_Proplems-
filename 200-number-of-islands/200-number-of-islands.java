class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (visited[row][col] || grid[row][col] == '0') continue ;
                if (grid[row][col] == '1') {
                    numOfIslands += numIslandsDFS(grid, row, col, visited) + 1  ;
                }
            }
        }
        return numOfIslands;
    }
    
    public static int numIslandsDFS(char[][] grid, int row, int col, boolean[][] visited) {

        if ( col >= grid[0].length || col  < 0 || row < 0 || row >= grid.length || grid[row][col] == '0' ) {
            return 0;
        }
        if (visited[row][col])
            return 0;
        visited[row][col] = true;
        return numIslandsDFS(grid, row, col + 1, visited) + numIslandsDFS(grid, row + 1, col, visited)
                + numIslandsDFS(grid, row, col - 1, visited)
                + numIslandsDFS(grid, row - 1, col, visited);

    }
}