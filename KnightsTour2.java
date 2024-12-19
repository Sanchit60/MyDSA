import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception     {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] chess = new int[n][n];
        chess[r][c] = 1;
        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int move) 
    {
        // Write your code here
        int n = chess.length;

        int[] rowMove = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};

        if(move == n * n){
            displayBoard(chess);
            return;
        }

        for(int i = 0; i < 8; i++){
            int newRow = r + rowMove[i];
            int newCol = c + colMove[i];
            if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && chess[newRow][newCol] == 0){
                chess[newRow][newCol] = move + 1;
                printKnightsTour(chess, newRow, newCol, move + 1);
                chess[newRow][newCol] = 0;
            }

        }
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
