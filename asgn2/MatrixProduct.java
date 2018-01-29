/*
 * CSC349
 * Max Blau(mbblau) Jacob Territo(jterrito)
 * Assignment 2: Matrix Multiplication
 *
 * 1/29/18
 */

import java.lang.*;

public class MatrixProduct {

   public static int[][] matrixProduct_DAC(int[][] A, int[][] B) throws Exception{
      checkIfValid(A, B);
      return matrixProduct_DAC(A, 0, 0, B, 0, 0, A.length);
   }

   private static int[][] matrixProduct_DAC(int[][] A, int rowA, int colA, int[][] B, int rowB, int colB, int n) {
      int[][] C = new int[n][n];
      if(n == 1) {
         C[0][0] = A[rowA][colA] * B[rowB][colB];
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

   public static int[][] matrixProduct_Strassen(int[][] A, int[][] B) throws Exception{
      checkIfValid(A, B);
      return matrixProduct_Strassen(A,0,0,B,0,0,A.length);
   }
   
   private static int[][] matrixProduct_Strassen(int[][] A, int rowA, int colA, int[][] B, int rowB, int colB, int n) {
      int[][] C = new int[n][n];
      if(n == 1) {
         C[0][0] = A[rowA][colA] * B[rowB][colB];
         return C;
      }
      int[][] S0,S1,S2,S3,S4,S5,S6,S7,S8,S9;
      S0 = subtract(B,rowB,colB+n/2,B,rowB+n/2,colB+n/2,n/2);
      S1 = add(A,rowA,colA,A,rowA,colA+n/2,n/2);
      S2 = add(A,rowA+n/2,colA,A,rowA+n/2,colA+n/2,n/2);
      S3 = subtract(B,rowB+n/2,colB,B,rowB,colB,n/2);
      S4 = add(A,rowA,colA,A,rowA+n/2,colA+n/2,n/2);
      S5 = add(B,rowB,colB,B,rowB+n/2,colB+n/2,n/2);
      S6 = subtract(A,rowA,colA+n/2,A,rowA+n/2,colA+n/2,n/2);
      S7 = add(B,rowB+n/2,colB,B,rowB+n/2,colB+n/2,n/2);
      S8 = subtract(A,rowA,colA,A,rowA+n/2,colA,n/2);
      S9 = add(B,rowB,colB,B,rowB,colB+n/2,n/2);
      
      int[][] P0,P1,P2,P3,P4,P5,P6;
      P0 = matrixProduct_Strassen(A,rowA,colA,S0,0,0,n/2);
      P1 = matrixProduct_Strassen(S1,0,0,B,rowB+n/2,colB+n/2,n/2);
      P2 = matrixProduct_Strassen(S2,0,0,B,rowB,colB,n/2);
      P3 = matrixProduct_Strassen(A,rowA +n/2,colA+n/2,S3,0,0,n/2);
      P4 = matrixProduct_Strassen(S4,0,0,S5,0,0,n/2);
      P5 = matrixProduct_Strassen(S6,0,0,S7,0,0,n/2);
      P6 = matrixProduct_Strassen(S8,0,0,S9,0,0,n/2);

      int[][] C11,C12,C21,C22;
      C11 = add(subtract(add(P4,P3),P1),P5);
      C12 = add(P0,P1);
      C21 = add(P2,P3);
      C22 = subtract(subtract(add(P4,P0),P2),P6); 
      
      fillC(C, C11, C12, C21, C22);
      
      return C;
   }

   private static int[][] add(int[][] A, int rowA,int colA,int[][] B,int rowB,int colB, int n) {
      int[][] result = new int[n][n];

      for(int i = 0; i < n; i++) {
         for(int j = 0; j < n; j++) {
            result[i][j] = A[rowA+i][colA+j] + B[rowB+i][colB+j];
         }
      }
      return result;
   }

   private static int[][] subtract(int[][] A, int rowA,int colA,int[][] B,int rowB,int colB, int n) {
      int[][] result = new int[n][n];

      for(int i = 0; i < n; i++) {
         for(int j = 0; j < n; j++) {
            result[i][j] = A[rowA+i][colA+j] - B[rowB+i][colB+j];
         }
      }
      return result;
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

   private static int[][] subtract(int[][] A, int[][] B) {
      int[][] result = new int[A.length][B.length];

      for(int i = 0; i < A.length; i++) {
         for(int j = 0; j < B.length; j++) {
            result[i][j] = A[i][j] - B[i][j];
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
               C[i][j] = C12[i][j-(C.length/2)];
            }
            if(i >= C.length/2 && j < C.length/2) {
               C[i][j] = C21[i-(C.length/2)][j];
            }
            if(i >= C.length/2 && j >= C.length/2) {
               C[i][j] = C22[i-(C.length/2)][j-(C.length/2)];
            }
         }
      }
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
