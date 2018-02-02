import java.util.*;
import java.io.*;
import java.lang.*;

public class TestArray {
   
   public static void make() throws Exception{
      PrintWriter fw = new PrintWriter("test_array.txt", "UTF-8");
      Random gen = new Random();
      fw.println("16 16");
      for(int i = 0; i < 16; i++) {
         for(int j = 0; j < 16; j++) {
            fw.printf("%d ", gen.nextInt(201)-100);
         }
         fw.println();
      }
      fw.println("16 16");
      for(int i = 0; i < 16; i++) {
         for(int j = 0; j < 16; j++) {
            fw.printf("%d ", gen.nextInt(201)-100);
         }
         fw.println();
      }
      fw.close();
   }
}
