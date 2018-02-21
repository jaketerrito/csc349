/*
 * CSC349
 * Max Blau(mbblau) Jacob Territo(jterrito)
 * Assignment 4: Change Making Proble
 *
 * 2/20/18
 */
import java.util.*;
import java.io.*;

public class ChangeMaker {
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.println("Enter number of coin-denominations and the set of coing values:");
      int k = in.nextInt();
      int[] d = new int[k];
      for(int i = 0; i < k; i ++){
         d[i] = in.nextInt();
      }
      int n;      
      int[] c;
      while(true){
         System.out.println("\nEnter a positive amount to be changed (enter 0 to quit): ");
         n = in.nextInt();
         if(n <= 0)break;
         c = change_DP(n,d);
         System.out.println("\nDP algorithm results");
         System.out.println("Amount: " + n);
         System.out.print("Optimal distribution: ");
         int sum = 0;
         int count = 0;
         for(int i = 0; i < k; i++){
            sum += c[i]*d[i];
            count += c[i];
            if(c[i] > 0){
               System.out.printf("%d*%dc",c[i],d[i]);
               if(sum < n){
                  System.out.print(" + ");
               }
            }
         }
         System.out.printf("\nOptimal coin count: %d\n",count);

         c = change_greedy(n,d);
         System.out.println("\nGreedy algorithm results");
         System.out.println("Amount: " + n);
         System.out.print("Optimal distribution: ");
         sum = 0;
         count = 0;
         for(int i = 0; i < k; i++){
            sum += c[i]*d[i];
            count += c[i];
            if(c[i] > 0){
               System.out.printf("%d*%dc",c[i],d[i]);
               if(sum < n){
                  System.out.print(" + ");
               }
            }
         }
         System.out.printf("\nOptimal coin count: %d\n",count);
      }
      System.out.println("Thanks for playing, Good Bye.");
   }

   public static int[] change_DP(int n, int[] d){
      int[] c = new int[n+1];
      int[] a = new int[n+1];
      int[] res = new int[d.length];
      //change_DP_Rec(0, d, c, a);

      for(int j = 0; j < n+1; j++) {
         if(j == 0) {
            c[j] = 0;
         }
         else {
            int min = Integer.MAX_VALUE;
            int m = 0;
            for(int i = 0; i < d.length; i++) {
               if(j-d[i] < 0) continue;
               if(min > c[j-d[i]]) {
                  min = c[j-d[i]];
                  m = i;
               }
            }
            a[j] = m;
            c[j] = 1 + min;
         }        
      }

      int i = n;
      while(i > 0) {
         res[a[i]] += 1;
         i = i - d[a[i]];
      }

      return res;
   }

   /*private static int change_DP_Rec(int j, int[] d, int[] c, int[] a) {
      if(j < 0) {
         return Integer.MAX_VALUE;
      }
      else if(j == 0) {
         return 0;
      }
      
      int min = Integer.MAX_VALUE;
      int m = 0;
      int temp;
      for(int i = 0; i < d.length; i++) {
         temp = change_DP_Rec(j-d[i], d, c, a) 
         if(min > temp) {
            min = temp;
            m = i;
         }
      }
      a[j] = m;
      c[j] = 1 + min;
      return c[j];
   }

   private static void change_DP_Rec(int j, int[] d, int[] c, int[] a) {
      if(j < 0) {
         //c[j] = Integer.MAX_VALUE;
         return;
      }
      else if(j == 0) {
         c[j] = 0;
      }
      else {
         int min = Integer.MAX_VALUE;
         int m = 0;
         for(int i = 0; i < d.length; i++) {
            if(j-d[i] < 0) continue;
            if(min > c[j-d[i]]) {
               min = c[j-d[i]];
               m = i;
            }
         }
         a[j] = m;
         c[j] = 1 + min;
      }
      change_DP_Rec(j+1, d, c, a);
   }*/

   public static int[] change_greedy(int n, int[] d){
      int value = n;
      int[] c = new int[d.length];
      for(int i = 0; i < d.length; i++){
         c[i]= value/d[i];
         value = value%d[i];
      }
      return c;
   }
}
