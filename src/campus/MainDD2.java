package campus;

import java.util.Scanner;

/**
 * Created by Yang on 2017/5/7.
 */
public class MainDD2 {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        return result;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {

        if (row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && !visited[row][col]
                && grid[row][col] == '1') {

            visited[row][col] = true;
            bfs(grid, visited, row - 1, col);
            bfs(grid, visited, row, col + 1);
            bfs(grid, visited, row + 1, col);
            bfs(grid, visited, row, col - 1);

        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String []st=new String[n];
        for(int i=0;i<n;i++)st[i]=sc.next();
        char[][]num=new char[n][m];

        for(int i=0;i<n;i++){
            char[]ch=st[i].toCharArray();
            for(int j=0;j<m;j++)num[i][j]=ch[j];
        }
        System.out.println(numIslands(num));
    }
}
