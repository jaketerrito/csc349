/*
 * CSC349
 * Max Blau(mbblau) Jacob Territo(jterrito)
 * Assignment 4: Change Making Proble
 *
 * 2/23/18
 */
import java.util.*;
import java.io.*;

public class Tester {
   public static void main(String[] args) {
      int[] us_denom = {100, 50, 25, 10, 5, 1};
      int[] sov_denom = {100, 50, 20, 15, 10, 5, 3, 2, 1};
      int[] two_denom = {64, 32, 16, 8, 4, 2, 1};
      int[] nick_denom = {100, 50, 25, 10, 1};
      int[] rand_denom = {66, 35, 27, 18, 10, 1};
      int[][] testing_array = {us_denom, sov_denom, two_denom, nick_denom, rand_denom};
      int[] count = {0, 0, 0, 0, 0};
      int[] c;
      System.out.println("Testing change_DP and change_greedy algorithms");
      for(int i = 1; i <= 200; i++) {
         for(int j = 0; j < 5; j++) {
            c = ChangeMaker.change_DP(i, testing_array[j]);
            int k = c.length-1;
            int dp = 0;
            int greedy = 0;
            while(k >= 0) {
               dp += c[k--];
            }
            c = ChangeMaker.change_greedy(i, testing_array[j]);
            k = c.length-1;
            while(k >= 0) {
               greedy += c[k--];
            }
            if(greedy == dp) {
               count[j] += 1;
            }
         }
      }
      for(int i = 1; i < 6; i++){
         System.out.printf("Testing set%d: %d matches in 200 tests\n",i,count[i-1]);
      }
   }
}

