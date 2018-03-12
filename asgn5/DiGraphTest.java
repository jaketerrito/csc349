import java.io.*;
import java.util.*;

public class DiGraphTest{
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter number of vertices");
      int count = s.nextInt();
      s.nextLine();
      DiGraph graph = new DiGraph(count);
      options();
      String input = s.nextLine();
      while(!input.equals("q")){
         switch(input){
            case "a":
               addEdge(s,graph);
               break;
            case "d":
               deleteEdge(s,graph);
               break;
            case "e":
               System.out.printf("Number of edges is %d\n",graph.edgeCount());
               break;
            case "v":
               System.out.printf("Number of vertices is %d\n",graph.vertexCount());
               break;
            case "p": 
               System.out.println("The graph is the following:");
               graph.print();
               break;
            case "t":
               printTopSort(graph);
               break;
            case "i":
               checkForPath(s, graph);
               break;
            case "l":
               getLength(s, graph);
               break;
            case "s":
               printShortest(s, graph);
               break;
            default: 
               System.out.println("Invalid input.");
               break;
         }
         input = s.nextLine();
      }
      System.out.println("Good bye.");
   }

   private static void checkForPath(Scanner s, DiGraph g){
      int from = s.nextInt();
      int to = s.nextInt();
      s.nextLine();
      if(g.isTherePath(from,to)){
         System.out.printf("There is a path from %d to %d\n",from,to);
         return;
      }
      System.out.printf("There is no path from %d to %d\n",from,to);
   }

   private static void getLength(Scanner s, DiGraph g){
      int from = s.nextInt();
      int to = s.nextInt();
      s.nextLine();
      if(g.isTherePath(from,to)){
         System.out.printf("Length of path from %d to %d is %d\n",from,to,g.lengthOfPath(from,to));
         return;
      }
      System.out.printf("There is no path from %d to %d\n",from,to);
   }

   private static void printShortest(Scanner s, DiGraph g){
      int from = s.nextInt();
      int to = s.nextInt();
      s.nextLine();
      if(g.isTherePath(from,to)){
         System.out.printf("Shortest path from %d to %d is:\n",from,to);
         g.printPath(from,to);
         return;
      }
      System.out.printf("There is no path from %d to %d\n",from,to);
   }
   private static void deleteEdge(Scanner s, DiGraph g){
      int from = s.nextInt();
      int to = s.nextInt();
      s.nextLine();
      g.deleteEdge(from,to);
      System.out.printf("(%d,%d) edge is now deleted from the graph\n",from, to);
   }

   private static void addEdge(Scanner s,DiGraph g){
      int from = s.nextInt();
      int to = s.nextInt();
      s.nextLine();
      g.addEdge(from,to);
      System.out.printf("(%d,%d) edge is now added to the graph\n",from, to);
   }

   private static void printTopSort(DiGraph g){
      int[] arr;
      try{
         arr = g.topSort();
      }catch(Exception e){
         System.out.println("Can't run topological sort on cyclic graph.");
         return;
      }
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
      System.out.println("- check for path (enter i)");
      System.out.println("- find length of path (enter l)");
      System.out.println("- print shortest path (enter s)");
      System.out.println("- Quit (enter q)");
   }
}
