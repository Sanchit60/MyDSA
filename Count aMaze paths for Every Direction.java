import java.util.*;

public class Main {
    static int countAllPath(int n, int m)
    {
        //Write your code here
        boolean[][] visited = new boolean[n][m]; 
        return countPaths(0, 0, n, m, visited);
    }

    static int countPaths(int i, int j, int n, int m, boolean[][] visited){
        if(i == n - 1 && j == m - 1){
            return 1;
        }


        visited[i][j] = true;
        int paths = 0;
        // Horizontal: right and left
        if(j + 1 < m && !visited[i][j+1]){
            paths += countPaths(i, j+1, n, m, visited);
        }
        if(j - 1 >= 0 && !visited[i][j-1]){
            paths += countPaths(i, j-1, n, m, visited);
        }
        //Vertical: top and left
        if(i+1 < n && !visited[i+1][j]){
            paths += countPaths(i+1, j, n, m, visited);
        }

        if(i-1 >= 0 && !visited[i-1][j]){
            paths += countPaths(i-1, j, n, m, visited);
        }
        // Diagonal : All 4 moves
        if(i+1 < n && j+1 < m && !visited[i+1][j+1]){
            paths += countPaths(i+1, j+1, n, m, visited);
        }
        if(i-1 >= 0 && j-1 >= 0 && !visited[i-1][j-1]){
            paths += countPaths(i-1, j-1, n, m, visited);
        }
        if(i-1 >= 0  && j+1 < m && !visited[i-1][j+1]){
            paths += countPaths(i-1, j+1, n, m, visited);
        }
        if(i+1 < n && j-1 >= 0 && !visited[i+1][j-1]){
            paths += countPaths(i+1, j-1, n, m, visited);
        }

        visited[i][j] = false;
        return paths;        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        System.out.println(countAllPath(n,m));
    }
}
