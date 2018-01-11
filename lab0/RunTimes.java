/*
 * CSC 349
 * Max Blau and Jacob Territo
 * Lab0: RunTimes
 */


public class RunTimes{
   public static void main(String args[]){
      System.out.println("Logarithmic algorithm running times:");
      long startTime;
      long runTime;/*
      for(long i = 1000; i < 100000000; i *= 2){
         startTime = System.nanoTime();
         Algorithms.logarithmicAlgorithm(i);
         runTime = (System.nanoTime() - startTime);
         System.out.printf("T(%d) = %d\n",i,runTime/1000000);
      }

      System.out.println("Linear algorithm running times:");
      for(long i = 1000; i < 100000000; i *= 2){
         startTime = System.nanoTime();
         Algorithms.linearAlgorithm(i);
         runTime = (System.nanoTime() - startTime);
         System.out.printf("T(%d) = %d\n",i,runTime/1000000);
      }

      System.out.println("NLogN algorithm running times:");
      for(long i = 1000; i < 100000000; i *= 2){
         startTime = System.nanoTime();
         Algorithms.NLogNAlgorithm(i);
         runTime = (System.nanoTime() - startTime);
         System.out.printf("T(%d) = %d\n",i,runTime/1000000);
      }

      System.out.println("Quadratic algorithm running times:");
      for(long i = 1000; i < 512000; i *= 2){
         startTime = System.nanoTime();
         Algorithms.quadraticAlgorithm(i);
         runTime = (System.nanoTime() - startTime);
         System.out.printf("T(%d) = %d\n",i,runTime/1000000);
      }
*/
      System.out.println("Cubic algorithm running times:");
      for(long i = 1000; i <= 8000; i *= 2){
         startTime = System.nanoTime();
         Algorithms.cubicAlgorithm(i);
         runTime = (System.nanoTime() - startTime);
         System.out.printf("T(%d) = %d\n",i,runTime/1000000);
      }
   }
}
