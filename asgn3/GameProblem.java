/*
 * CSC349
 * Max Blau(mbblau) Jacob Territo(jterrito)
 * Assignment 3: Dynamic Programming
 *
 * 2/16/18
 */
import java.util.*;
import java.io.*;

public class GameProblem {

   public static void main(String[] args) throws Exception{
      Scanner in = new Scanner(System.in);
      File file;

      System.out.print("Enter input file: ");
      try {
         file = new File(in.next());
      } 
      catch(Exception e) {
         System.out.println(e.getMessage());
         return;
      }

      in = new Scanner(file);
      int[][] A  = new int[in.nextInt()][in.nextInt()];
      for(int i = 0; i < A.length; i++){
         for(int j = 0; j < A[0].length; j++){
            A[i][j] = in.nextInt();
         }
      }

      game(A.length, A[0].length, A);
   }

   public static void game(int n, int m, int[][] A) {
      int[][] S = new int[n][m];
      char[][] R = new char[n][m];
      int max_i = n-1;
      int max_j = m-1;
      
      for(int i = n-1; i >= 0; i--) {
         for(int j = m-1; j >= 0; j--) {
            if(j == m-1 && i == n-1) {
               S[i][j] = A[i][j];
               R[i][j] = 'e';
            }
            else if(j == m-1) {
               if(S[i+1][j] > 0) {
                  S[i][j] = S[i+1][j] + A[i][j];
                  R[i][j] = 'd';
               }
               else {
                  S[i][j] = A[i][j];
                  R[i][j] = 'e';
               }
            }
            else if(i == n-1) {
                if(S[i][j+1] > 0) {
                  S[i][j] = S[i][j+1] + A[i][j];
                  R[i][j] = 'r';
               }
               else {
                  S[i][j] = A[i][j];
                  R[i][j] = 'e';
               }              
            }
            else {
               if(S[i][j+1] > S[i+1][j]) {
                  S[i][j] = S[i][j+1] + A[i][j];
                  R[i][j] = 'r';
               }
               else {
                  S[i][j] = S[i+1][j] + A[i][j];
                  R[i][j] = 'd';
               }
            }
            
            if(S[i][j] > S[max_i][max_j]) {
               max_i = i;
               max_j = j;
            }
         }
      }

      int i = max_i;
      int j = max_j;
      System.out.printf("Best score: %d\nBest route: ", S[i][j]);
      while(R[i][j] != 'e') {
         System.out.printf("[%d,%d] to ", i+1, j+1);
         if(R[i][j] == 'd') {
            i++;
         }
         else if(R[i][j] == 'r') {
            j++;
         }
      }
      System.out.printf("[%d,%d] to exit\n", i+1, j+1);
   }

   private int findMax(int val1, int val2) {
      if(val1 > val2) return val1;
      return val2;
   }

}
