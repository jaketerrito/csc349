import java.util.*;

public class DiGraph{
   private ArrayList<LinkedList<Integer>> graph;
   
   public DiGraph(int i){
      this.graph = new ArrayList<LinkedList<Integer>>(i);
   }

   public void addEdge(int from, int to){
      graph.get(from-1).add(to-1);
   }

   public void deleteEdge(int to, int from){
      LinkedList<Integer> vertex = graph.get(from-1);
      int toRemove = vertex.indexOf(to-1);
      vertex.remove(toRemove);
   }

   public int edgeCount(){
      int total = 0;
      for(LinkedList<Integer> vertex :graph){
         total += vertex.size();
      }
      return total;
   }

   public int vertexCount(){
      return graph.size();
   }

   public void print(){
      for(int i = 0; i < graph.size(); i++){
         System.out.printf("%d is connected to:",i+1);
         LinkedList<Integer> vertex = graph.get(i);
         for(int j = 0; j < vertex.size();j++){
            if(j == vertex.size() -1){
               System.out.printf(" %d\n",vertex.get(j)+1);
               continue;
            }
            System.out.printf(" %d,",vertex.get(j)+1);
         }
      }
   }
}
