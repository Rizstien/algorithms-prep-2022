package pathindirectedgraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class PathInDirectedGraph {

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
		
		PathInDirectedGraph obj = new PathInDirectedGraph();
		System.out.println(obj.solve(5, A, 5, 1));

	}
	
	public int solve(int A, ArrayList<ArrayList<Integer>> B, int s, int d) {
        Graph g = new Graph(A);
        
        for(int i=0;i<B.size();i++){
            g.addEdge(B.get(i).get(0), B.get(i).get(1));
        }
        
        if(dfs(s, d, g.adjList)) return 1;
        return 0;
      
    }
    
    
    public boolean dfs(int s, int d, LinkedList<Integer> adjList[]){
    	if(s==d) return true;
    
        LinkedList<Integer> nodes = adjList[s];
        if(nodes !=null || nodes.size() > 0 ){
            for(Integer node : nodes){
            	return dfs(node, d, adjList);
            }
        }
    
        return false;
    }

}


class Graph {
    
    public int V;
    public LinkedList<Integer> adjList[];
    
    Graph(int v){
        V = v;
        adjList = new LinkedList[v+1];
        for(int i=1;i<=V;i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int s, int d){
        adjList[s].add(d);
    } 
}
