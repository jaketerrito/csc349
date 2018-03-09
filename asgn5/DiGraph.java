import java.util.*;

public class DiGraph{
   private ArrayList<LinkedList<Integer>> graph;
   
   public DiGraph(int n){
      this.graph = new ArrayList<>();
      for(int i = 0; i < n; i++) {
         this.graph.add(new LinkedList<Integer>());
      }
   }

   private int[] indegrees() {
      int[] arr = new int[graph.size()];
      for(int i = 0; i < graph.size(); i++) {
         for(int dest : graph.get(i)) {
            arr[dest]++;
         }
      }
      return arr;
   }

   public int[] topSort() throws Exception{
      int n = graph.size();
      int[] in = indegrees();
      int[] arr = new int[n];
      ArrayList<Integer> queue = new ArrayList<Integer>();
      for(int u = 0; u < n; u++) {
         if(in[u] == 0) {
            queue.add(u);
         }
      }
      int i = 0;
      while(queue.size() > 0) {
         int u = queue.remove(0);
         arr[i] = u;
         i++;
         for(int v : graph.get(u)) {
            in[v]--;
            if(in[v] == 0) {
               queue.add(v);
            }
         }
      }
      if(i != n) {
         throw new IllegalArgumentException();
      }
      return arr;
   }

   public void addEdge(int from, int to){
      if(graph.get(from-1).contains(to-1)){
         return;
      }
      graph.get(from-1).add(to-1);
   }

   public void deleteEdge(int from, int to){
      if(!graph.get(from-1).contains(to-1)){
         return;
      }
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
         LinkedList<Integer> vertex = graph.get(i);
         if(vertex.size() == 0) {
            System.out.printf("%d is connected to:\n",i+1);
            continue;
         }
         System.out.printf("%d is connected to:",i+1);
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
