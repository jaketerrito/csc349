import java.lang.*;
import java.util.*;
import java.io.*;
public class MatrixWork {

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
      int[][] B  = new int[in.nextInt()][in.nextInt()];
      for(int i = 0; i < B.length; i++){
         for(int j = 0; j < B[0].length; j++){
            B[i][j] = in.nextInt();
         }
      }
      int[][] C;
      
      try {
         C = matrixProduct(A,B);
      } catch (Exception e){
         System.out.println(e.getMessage());
         return;
      }

      printMatrix(C);
   }

   public static int[][] matrixProduct(int[][] A, int[][] B) throws Exception{

      if(A[0].length != B.length) {
         throw new IllegalArgumentException();
      }

      int[][] C = new int[A.length][B[0].length];

      for(int i = 0; i < C.length; i++) {
         for(int j = 0; j < C[0].length; j++) {
            int sum = 0;
            for(int k = 0; k < B.length; k++) {
               sum += A[i][k] * B[k][j];
            }
            C[i][j] = sum;
         }
      }

      return C;
   }

   private static void printMatrix(int[][] mat) {
      System.out.println("Product Matrix:");
      for(int i = 0; i < mat.length; i++) {
         for(int j = 0; j < mat[0].length; j++) {
            System.out.print(mat[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();
   }

}
