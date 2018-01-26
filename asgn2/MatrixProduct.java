import java.lang.*;

public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) throws Exception{
      checkIfValid(A, B);
      return matrixProduct_DAC(A, 0, 0, B, 0, 0, A.length);
   }

   private static int[][] matrixProduct_DAC(int[][] A, int rowA, int colA, int[][] B, int rowB, int colB, int n) {
      int[][] C = new int[n][n];
      if(n == 1) {
         C[1][1] = A[rowA][colA] * B[rowB][colB];
         return C;
      }
      int[][] C11, C12, C21, C22;
      C11 = add(matrixProduct_DAC(A, rowA, colA, B, rowB, colB, n/2), matrixProduct_DAC(A, rowA, colA + (n/2), B, rowB + (n/2), colB, n/2));
      C12 = add(matrixProduct_DAC(A, rowA, colA, B, rowB, colB + (n/2), n/2), matrixProduct_DAC(A, rowA, colA + (n/2), B, rowB + (n/2), colB + (n/2), n/2));
      C21 = add(matrixProduct_DAC(A, rowA+(n/2), colA, B, rowB, colB, n/2), matrixProduct_DAC(A, rowA+(n/2), colA + (n/2), B, rowB + (n/2), colB, n/2));
      C22 = add(matrixProduct_DAC(A, rowA+(n/2), colA, B, rowB, colB+(n/2), n/2), matrixProduct_DAC(A, rowA+(n/2), colA + (n/2), B, rowB + (n/2), colB+(n/2), n/2));
      fillC(C, C11, C12, C21, C22);
      return C;
   }

   private static int[][] add(int[][] A, int[][] B) {
      int[][] result = new int[A.length][B.length];

      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < B.length; j++) {
            result[i][j] = A[i][j] + B[i][j];
         }
      }
      return result;
   }

   private static void fillC(int[][] C, int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
      for(int i = 0; i < C.length; i++) {
         for(int j = 0; j < C.length; j++) {
            if(i < C.length/2 && j < C.length/2) {
               C[i][j] = C11[i][j];
            }            
            if(i < C.length/2 && j >= C.length/2) {
               C[i][j] = C12[i][j];
            }
            if(i >= C.length/2 && j < C.length/2) {
               C[i][j] = C21[i][j];
            }
            if(i >= C.length/2 && j >= C.length/2) {
               C[i][j] = C22[i][j];
            }
         }
      }
   }

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) throws Exception{
      checkIfValid(A, B);
      return null;
   }

   private static void checkIfValid(int[][] A, int[][] B) throws Exception{
      if(A.length != A[0].length || B.length != B[0].length || A.length != B.length) {
         throw new IllegalArgumentException();
      }
      double log2A = Math.log(A.length) / Math.log(2);
      if(Math.floor(log2A) != Math.ceil(log2A)) {
         throw new IllegalArgumentException();
      }
   }

}
