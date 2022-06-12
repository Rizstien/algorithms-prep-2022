package cycleindirectedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CycleInDirectedGraph {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		
		Integer[] array = {1, 2};
		ArrayList<Integer> Asub = new ArrayList<Integer>(Arrays.asList(array));
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(4);Asub.add(1);
		A.add(Asub);

		Asub = new ArrayList<Integer>();
		Asub.add(2);Asub.add(4);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(3);Asub.add(4);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(5);Asub.add(2);
		A.add(Asub);
		
		Asub = new ArrayList<Integer>();
		Asub.add(1);Asub.add(3);
		A.add(Asub);
	
		CycleInDirectedGraph obj = new CycleInDirectedGraph();
		System.out.println(obj.solve(5, A));

	}
	
    boolean[] visited;
    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        
        if(B.size()==1) return 0;
    
        visited = new boolean[A+1];
        Graph graph = new Graph(A);
        
        for(int i=0;i<B.size();i++){
            graph.addEdge(B.get(i).get(0), B.get(i).get(1));            
        }
        
        if(dfs(B.get(0).get(0), graph.adjList)) return 1;
        
        return 0;
    }
   
    
    public boolean dfs(int s, LinkedList<Integer> adjList[]){
        if(visited[s]) return true;
        
        visited[s] = true;
        LinkedList<Integer> nodes = adjList[s];
        if(nodes !=null || nodes.size() > 0 ){
            for(Integer node : nodes){
            	return dfs(node, adjList);
            }
        }
    
        return false;
    }

}


class Graph {
    
    int V;
    public LinkedList<Integer> adjList[];
    
    Graph(int v){
        V = v;
        adjList = new LinkedList[v+1];
        for(int i=1;i<=v;i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge (int source, int destination){
        adjList[source].add(destination);
    }
    
}

