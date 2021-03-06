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

   private class VertexInfo{
      int distance;
      int pred;
      public VertexInfo(int distance, int pred){
         this.distance = distance;
         this.pred = pred;
      }

      public void setDistance(int d){
         this.distance = d;
      }
      
      public void setPred(int p){
         this.pred = p;
      }
   }

   private ArrayList<VertexInfo> BFS(int s){
      ArrayList<VertexInfo> VA = new ArrayList<>();
      for(int u = 0; u < graph.size(); u ++){
         VA.add(new VertexInfo(-1,-1));
      }
      VA.get(s).setDistance(0);
      ArrayList<Integer> que = new ArrayList<>();
      que.add(s);
      while(que.size() > 0){
         int u = que.remove(0);
         for(int v : graph.get(u)){
            if(VA.get(v).distance == -1){
               VA.get(v).setDistance(VA.get(u).distance+1);
               VA.get(v).setPred(u);
               que.add(v);
            }
         }
      }
      return VA;
   }

   public boolean isTherePath(int from, int to){
      if(BFS(from-1).get(to-1).distance == -1){
         return false;
      }
      return true;
   }

   public int lengthOfPath(int from, int to){
      return BFS(from-1).get(to-1).distance;
   }

   public void printPath(int from, int to){
      ArrayList<VertexInfo> bfs = BFS(from-1);
      if(!isTherePath(from,to)){
         System.out.println("There is no path");
         return;
      }
      String output = "";
      while(from != to){
         output = "->" + to + output;
         to = bfs.get(to-1).pred + 1;
      }
      output = from + output;
      System.out.println(output);
   }

   private class TreeNode {
      int vert;
      LinkedList<TreeNode> children;

      public TreeNode(int vert) {
         this.vert = vert;
         children = new LinkedList<>();
      }
   }

   private TreeNode buildTree(int s) {
      ArrayList<VertexInfo> bfs = BFS(s-1);
      ArrayList<TreeNode> nodes = new ArrayList<>();
      for(int i = 0; i < graph.size(); i++) {
         nodes.add(new TreeNode(i));
      }
      for(int i = 0; i < bfs.size(); i++) {
         VertexInfo temp = bfs.get(i);
         if(temp.distance == -1 || temp.pred == -1){
            continue;
         }
         nodes.get(temp.pred).children.add(nodes.get(i));
      }
      return nodes.get(s-1);
   }

   public void printTree(int s){
      TreeNode root = buildTree(s);
      printNode(root,0);
   }

   private void printNode(TreeNode node,int depth){
      for(int i = 0; i < depth; i++){
         System.out.print("    ");
      }
      System.out.println(node.vert+1);
      for(TreeNode child: node.children){
         printNode(child,depth+1);
      }
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
