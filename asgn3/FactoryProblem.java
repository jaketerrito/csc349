import java.util.*;
import java.io.*;

public class FactoryProblem {
   public static void main(String[] args) {
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
      int n = in.nextInt();
      int e1 = in.nextInt();
      int e2 = in.nextInt();
      int x1 = in.nextInt();
      int x2 = in.nextInt();   
      int[][] a =new int[2][n];
      for(int i = 0; i < n; i ++){
         a[0][i] = in.nextInt();
      }
      for(int i = 0; i < n; i ++){
         a[1][i] = in.nextInt();
      }        

      int[][] t = new int[2][n-1];
      for(int i = 0; i < n-1; i ++){
         t[0][i] = in.nextInt();
      }
      for(int i = 0; i < n-1; i ++){
         t[1][i] = in.nextInt();
      }

      //bottom up dynamic program
      int[][] d = new int[2][n-1];
      int [] ans = solveFactory(n,e1,e2,x1,x2,a,t,d);
      printFactorySolution(ans,d);
   }
   
   private int[] solveFactory(int n, int e1, int e2, int x1, int x2, int[][] a, int[][] t, int[][] d){
      int top = x1 + a[0][n-1];
      int bottom = x2 + a[1][n-1];
      int temptop;
      int tempbot;
      for(int i = n-2; i > 0; i--){
         //Top
         if(top < bot + t[0][i-1]){
            temptop = top + a[0][i];
            d[0][i] = 0;
         }else{
            temptop = bot + t[0][i-1] + a[0][i];
            d[0][i] = 1;
         }
         if(bot < top + t[1][i-1]){
            tempbot = bot + a[1][i];
            d[1][i] = 1;
         }else{
            tempbot = top + t[1][i-1] + a[1][i];
            d[1][i] = 0;
         }
         top = temptop;
         bot = tempbot;
      }
      if(bot+e2 < top+e1){
         return new int[] {bot+e2,1};
      }else{
         return new int[] {top+e1,0};
      }
   }

   private void printFactorySolution(int[] ans,int[][] d){
      System.out.println("Fastest time is: " + ans[0] + "\n");
      System.out.println("The optimal route is:");
      System.out.println("station 1, line " + ans[1]);
      int line = ans[1];
      for(int i = 1; i < d[0].length+1; i ++){
         line = d[line][i-1]
         System.out.printf("station %d, line %d\n", i+1, line + 1);
      }
   }

}
