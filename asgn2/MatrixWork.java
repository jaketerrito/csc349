import java.lang.*;

public class MatrixWork {

   public static void main(String[] args) throws Exception{
      Scanner in = new Scanner(System.in);
      File file;

      System.out.print("Enter input file: ");
      try() {
         file = new File(in.next());
      } 
      catch(Exception e) {
         System.out.println(e.getMessage());
         return;
      }

      int[][] A;
      int[][] B;
      
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
