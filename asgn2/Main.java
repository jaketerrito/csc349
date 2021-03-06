import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception{
      File file;
      Scanner in;
      TestArray.make();

      try {
         file = new File("test_array.txt");
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
      int[][] C,D;
      
      try {
         C = MatrixProduct.matrixProduct_Strassen(A,B);
      } catch (Exception e){
         e.printStackTrace(System.out);
         return;
      }
      
      try {
         D = MatrixProduct.matrixProduct_DAC(A,B);
      } catch (Exception e){
         e.printStackTrace(System.out);
         return;
      }

      System.out.println(Arrays.deepEquals(C,D));
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
