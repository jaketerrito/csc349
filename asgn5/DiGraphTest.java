import java.io.*;
import java.util.*;

public class DiGraphTest{
   public static void main(String[] args) throws Exception{
      Scanner s = new Scanner(System.in);
      System.out.println("Number of vertices?");
      int count = s.nextInt();
      DiGraph graph = new DiGraph(count);
      options();
      String input = s.next();
      while(!input.equals("q")){
         switch(input){
            case "a":
               addEdge(s,graph);
               break;
            case "d":
               deleteEdge(s,graph);
               break;
            case "e":
               System.out.printf("Number of edges: %d\n",graph.edgeCount());
               break;
            case "v":
               System.out.printf("Number of vertices: %d\n",graph.vertexCount());
               break;
            case "p": 
               System.out.println("The graph is the following:");
               graph.print();
               break;
            case "t":
               printTopSort(graph);
               break;
            default: 
               System.out.println("Invalid input.");
               break;
         }

         input = s.next();
      }
   }

   private static void deleteEdge(Scanner s, DiGraph g){
      System.out.printf("Vertex from: ");
      int from = s.nextInt();
      System.out.printf("Vertex to: ");
      int to = s.nextInt();
      g.deleteEdge(from,to);
   }

   private static void addEdge(Scanner s,DiGraph g){
      System.out.printf("Vertex from: ");
      int from = s.nextInt();
      System.out.printf("Vertex to: ");
      int to = s.nextInt();
      g.addEdge(from,to);

   }

   private static void printTopSort(DiGraph g) throws Exception{
      int[] arr = g.topSort();
      for(int i = 0; i < arr.length-1; i++) {
         System.out.printf("%d, ", arr[i]+1);
      }
      System.out.printf("%d\n", arr[arr.length-1]+1);
   };

   private static void options(){
      System.out.println("Choose one of the following operations:");
      System.out.println("- add edge (enter a)");
      System.out.println("- delete edge (enter d)");
      System.out.println("- edge count (enter e)");
      System.out.println("- vertex count (enter v)");
      System.out.println("- print graph (enter p)");
      System.out.println("- print topological sort of graph (enter t)");
      System.out.println("- Quit (enter q)");
   }
}
